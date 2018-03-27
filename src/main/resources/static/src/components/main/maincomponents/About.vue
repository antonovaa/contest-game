<template>
  <div id="about">
    <img src="./images/vgif-ru-28923.gif"/>
    <i>About start</i>
    <button v-if="!show" id="addNew" style="width: 35px;height: 35px;color: red;float: right">
      Add_new_article
    </button>

    <addAboutComponent></addAboutComponent>
{{number}}
    <div v-if="send_request">
    <div v-for="article in articles">
      <div class="container">
        <div class="row">
          <div class="col-4">
            <div class="container">
              <div v-for="file in article.files" class="row">
                <!--<div>-->
                <div class="col-9">
                  <img :src="file.image" class="article-img float-left"/>
                </div>
                <div class="col-3">
                  <div>name {{file.name}}</div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-8">
            <div class="container">
              <div class="row">
                <div class="col-8"><label for="newDescription">Описание</label><textarea
                  id="newDescription" type="text">{{article.description}}</textarea></div>
                <div class="col-4"><label for="jotting">Краткое описание </label><textarea
                  id="jotting" type="text">{{article.jotting}}</textarea></div>
              </div>
            </div>
          </div>
        </div>
      </div>
      </div>
    </div>
  </div>
</template>

<script>

  import addAboutComponent from './About/AddAboutComponent.vue'

  export default {
    data() {
      return {
//        show:true,
        message: '',
        allMessages: '',
        newTitle: '',
        newImage: '',
        newDescription: '',
        articles: []
      }
    },
    props: ['number'],
    components: {
      addAboutComponent
    },
    computed: {
      show: function () {
        return this.$store.state.isAuthorised === 1;
      },

      send_request: function () {

        if (this.$store.state.isAuthorised === 1 && this.$store.state.currentViewNumber === 1) {

          axios.post('/testarray')
          .then((req) => {
            this.articles = req.data;
          })
          .catch((req) => {
            console.log("Error " + req.data)
          });
        }
        return (this.$store.state.isAuthorised === 1 && this.$store.state.currentViewNumber === 1);
      }
    }
  }
</script>

<style lang="scss">

  #about {
    border: 3px solid orangered;
    img {
      width: 30%;
    }
    #addNew {
      padding-right: 500px;
      /*margin: 500px;*/
    }
  }

  .article-img {
    width: 100%;
  }
</style>
