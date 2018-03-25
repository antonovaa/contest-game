<template>
  <div id="addAboutComponent">

    <!--UPLOAD-->
    <!--<form enctype="multipart/form-data" novalidate v-if="isInitial || isSaving">-->
    <h1>Выберите картинку игры для статьи</h1>
    <input type="file" multiple @change="onFileChange($event)">
    <div class="container">
      <div class="row">

        <div class="col-4">
          <div class="container">
            <div v-for="file in filesmain" class="row">
              <!--<div>-->
              <div class="col-9">
                <img :src="file.image" class="float-left"/>
              </div>

              <div class="col-3">
                <button @click="removeImage(file)">Remove image</button>
                <!--</form>-->

                <div>name {{file.name}}</div>
              </div>
              <!--</div>-->
            </div>
          </div>
        </div>

        <div v-if="filesmain[0]" class="col-8">
          <textarea id="textarea" type="text" v-model="newDescription"/>
        </div>


      </div>
    </div>
    <button @click="upload()">Отправить</button>
    <button @click="testarray()">testarray</button>
  </div>
</template>


<script>


  export default {
    data() {
      return {
//        show:true,
        message: '',
        allMessages: '',
        newTitle: '',
        newImage: '',
        newDescription: '',
        articles: [],
        filesmain:[]
      }

    },
    computed: {
      show: function () {
        return this.$store.state.isAuthorised === 1;
      }
    },
    methods: {
      onFileChange(e) {
        var files = e.target.files;
        if (!files.length) {
          return;
        }
        ;
        for (var i = 0; i < files.length; i++) {
          this.createImage(files[i]);
        }
      },
      createImage(file) {
        var reader = new FileReader();
        reader.onload = (e) => {
          this.filesmain.push({name:file.name, image:e.target.result});
        };
        reader.readAsDataURL(file);
      },
      removeImage: function (e) {
        this.filesmain.splice(this.filesmain.indexOf(e),1);
      },
      upload() {
        var jsonString = {
//          description: this.newDescription
          'filesmain': this.filesmain
        };

        axios.post('/upload',
          jsonString,
          {
            headers: {
              'Content-Type': 'application/json;charset=UTF-8;'
            }
          })
        .then((req) => {
          if (req.data.result == '0') {
            console.log("SuccessFull");
          }
        })
        .catch((req) => {
          console.log("Error "+ req.data)
        });
      },
      testarray() {


        var jsonString = {

          "key1":[

          {"modelNumber":"95000-8740","qty":"2"},

          {"modelNumber":"9500098740","qty":"5"}

        ],

          "key2":[

          {"modelNumber":"94100-0561","qty":"2"},

          {"modelNumber":"2941780060","qty":"3"}

        ]
        };

        axios.post('/testarray',
          jsonString,
          {
            headers: {
              'Content-Type': 'application/json;charset=UTF-8;'
            }
          })
        .then((req) => {
          if (req.data.result == '0') {
            console.log("SuccessFull");
          }
        })
        .catch((req) => {
          console.log("Error "+ req.data)
        });
      }
    }
  }
</script>

<style lang="scss">


  #textarea{
    height: inherit;
    width: 100%;
    overflow: auto;
    height: 200px;
  }

  .container {
    margin-left: 5px;
  }

  #addAboutComponent .container img {
    width: 100%;
    display: block;
    margin: auto auto 10px;
  }

  //.dropbox {
  /*outline: 2px dashed grey; !* the dash box *!*/
  /*outline-offset: -10px;*/
  /*background: lightcyan;*/
  /*color: dimgray;*/
  /*padding: 10px 10px;*/
  /*min-height: 200px; !* minimum height *!*/
  /*position: relative;*/
  /*cursor: pointer;*/
  /*}*/

  /*.input-file {*/
  /*opacity: 0; !* invisible but it's there! *!*/
  /*width: 100%;*/
  /*height: 200px;*/
  /*position: absolute;*/
  /*cursor: pointer;*/
  /*}*/

  /*.dropbox:hover {*/
  /*background: lightblue; !* when mouse over to the drop zone, change color *!*/
  /*}*/

  /*.dropbox p {*/
  /*font-size: 1.2em;*/
  /*text-align: center;*/
  /*padding: 50px 0;*/
  /*}*/
</style>
