<template>
  <div id="about">
    <img src="./images/vgif-ru-28923.gif"/>
    <i>About start</i>
<button v-if="!show" id="addNew" style="width: 35px;height: 35px;color: red;float: right">Add_new_article</button>

   <addAboutComponent></addAboutComponent>

    <div v-for="article in articles">
      <!--<h1>article.description</h1>-->
      <!--<img v-bind:src="article.image"/>-->
      <!--<p>{{article.description}}</p>-->


    </div>

  </div>
</template>

<script>

  import addAboutComponent from './About/AddAboutComponent.vue'

  export default {
    data() {
      return {
//        show:true,
        message:'',
        allMessages:'',
        newTitle:'',
        newImage:'',
        newDescription:'',
        articles:[],
      }
    },
    components:{
      addAboutComponent
    },
    computed:{
      show:function () {
        return this.$store.state.isAuthorised===1;
      },
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
</style>
