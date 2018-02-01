<template>
  <!--<div username="app">-->
    <!--<img src="./assets/logo.png">-->
    <!--<h1>{{ msg }}</h1>-->
    <!--<h2>Essential Links</h2>-->
    <!--<ul>-->
      <!--<li><a href="https://vuejs.org" target="_blank">Core Docs</a></li>-->
      <!--<li><a href="https://forum.vuejs.org" target="_blank">Forum</a></li>-->
      <!--<li><a href="https://chat.vuejs.org" target="_blank">Community Chat</a></li>-->
      <!--<li><a href="https://twitter.com/vuejs" target="_blank">Twitter</a></li>-->
    <!--</ul>-->
    <!--<h2>Ecosystem</h2>-->
    <!--<ul>-->
      <!--<li><a href="http://router.vuejs.org/" target="_blank">vue-router</a></li>-->
      <!--<li><a href="http://vuex.vuejs.org/" target="_blank">vuex</a></li>-->
      <!--<li><a href="http://vue-loader.vuejs.org/" target="_blank">vue-loader</a></li>-->
      <!--<li><a href="https://github.com/vuejs/awesome-vue" target="_blank">awesome-vue</a></li>-->
    <!--</ul>-->
  <!--</div>-->
<div username="app">
  <h1>{{ msg2 }}</h1>
  <div username="canvas" @mousemove="updateXY">
{{x}}         {{y}}
  </div>
</div>
</template>

<script>
  export default {
    name: 'app4',
    data() {
      return {
        x:0,
        y:0,
        msg2: 'Welcome to Your Vue.js App'
      }
    },
    methods:{
      updateXY:function (event) {
         this.x=event.offsetX;
         this.y=event.offsetY;
      }
    }
  }
</script>

<style lang="scss">

  #canvas{
    width: 600px;
    padding: 200px 20px;
    text-align: center;
    border: 1px solid #333;
  }


  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }

  body {
    font-size: 33px;
    color: #8ae00e;
    background-color: #121212;
    text-shadow: 0 0 5px #ff718c, 0 0 10px #66ffa1, 0 0 15px #caffe1, 0 0 20px #ff0000, 0 0 30px #49FF18, 0 0 40px #49FF18, 0 0 55px #49FF18, 0 0 75px #49ff18
  }

  h1, h2 {
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }
</style>
