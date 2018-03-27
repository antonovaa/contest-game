<template>
  <div id="general">
    <h1 style="color:red">general3</h1>
    <component v-bind:is="this.currentView" >
      <slot :number="svn"></slot>
      <!-- изменяя vm.currentView можно переключаться между компонентами -->
    </component>
<i>{{currentView}}</i>
  </div>
</template>

<script>
  import News from './maincomponents/News.vue'
  import About from './maincomponents/About.vue'
  import Conquest from './maincomponents/Conquest.vue'
  import Review from './maincomponents/Review.vue'
  import Battle from './maincomponents/Battle.vue'

  export default {
    data() {
      return {
        message: '',
        allMessages: '',
        cvn:''
      }
    },
    components: {
      'news':News,
      'about':About,
      'conquest':Conquest,
      'review':Review,
      'battle':Battle
    },
    computed:{
      currentView:function() {
        this.svn=this.$store.state.currentViewNumber;
        if (this.cvn == 1) {return 'about';}
        if (this.cvn == 2) {return 'conquest';}
        if (this.cvn == 3) {return 'review';}
        if (this.cvn == 4) {return 'news';}
        if (this.cvn == 5) {return 'battle';}
      }
    }
  }
</script>

<style>
  #general {
    /*width: 1000px;*/

  }
</style>
