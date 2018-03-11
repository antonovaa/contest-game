<template>
  <div id="general">
    <h1 style="color:red">general</h1>
    <component v-bind:is="this.currentView">
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
        allMessages: ''
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
        if (this.$store.state.currentViewNumber == 1) {return 'about';}
        if (this.$store.state.currentViewNumber == 2) {return 'conquest';}
        if (this.$store.state.currentViewNumber == 3) {return 'review';}
        if (this.$store.state.currentViewNumber == 4) {return 'news';}
        if (this.$store.state.currentViewNumber == 5) {return 'battle';}
      }
    }
  }
</script>

<style>
  #general img {
    width: 1000px;
  }
</style>
