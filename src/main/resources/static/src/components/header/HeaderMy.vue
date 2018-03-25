<template>
  <div id="header">

    <nav class="navbar navbar-inverse bg-inverse">
     <div class="container-fluid">
       <div>
         <i v-if="show">About me -- {{myName}} ))</i>
       </div>
       <div>
      <form class="form-inline">
        <button class="btn btn-sm align-middle btn-outline-secondary" v-on:click="clickForTest(1)" type="button">About</button>
        <button class="btn btn-sm align-middle btn-outline-secondary" v-on:click="clickForTest(2)" type="button">Conquest</button>
        <button class="btn btn-sm align-middle btn-outline-secondary" v-on:click="clickForTest(3)" type="button">Review</button>
        <button class="btn btn-sm align-middle btn-outline-secondary" v-on:click="clickForTest(4)" type="button"> -- {{countTest}}--News</button>
        <button v-if="show" class="btn btn-sm align-middle btn-outline-secondary" v-on:click="clickForTest(5)" type="button">Buttle</button>
      </form>
     </div>
      <div>
      <form class="form-inline">
        <input class="form-control mr-sm-2" type="text" placeholder="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
      </div>
     </div>
    </nav>

  </div>
</template>

<script>
//  import { bus } from '../../main.js'

  export default {
    data() {
      return {
        message: '',
        allMessages: ''
      }
    },
//    created(){
//      bus.$on('show-param',data=>{
//        console.log(data);
//        this.show=true;
//      })
//    },
    methods: {
      clickForTest:function(a){
        console.log(a);
        this.$store.dispatch('setCurrentView',a);
      }
    },
    computed:{
      countTest:function () {
        return this.$store.state.count;
      },
      show:function () {
        return this.$store.state.isAuthorised===1;
      },
      myName:function () {
        return this.$store.state.name;
      }
    }
  }
</script>

<style>
#header{
  margin: 0px;
  padding: 0px;

}

</style>
