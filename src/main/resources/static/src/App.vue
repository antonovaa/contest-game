<template>
  <div class="wrapper">
        <div class="my-header">
          <header-my></header-my>
        </div>

        <div class="left-content-sidebar">
          <navigation-left></navigation-left>
        </div>

    <chat></chat>
    <general class="main-content"></general>
  </div>
</template>

<script>

  import HeaderMy from './components/header/HeaderMy.vue'
  import Chat from './components/chat/Chat.vue'
  import General from './components/main/general.vue'
  import NavigationLeft from './components/navigation/NavigationLeft.vue'

  export default {
    name: 'app',
    data() {
      return {
        msg: 'Welcome to Your Vue.js App',
        msg1: '3',
        msg2: 'Welcome to Your Vue.js App',
        msg3: 'Welcome to Your Vue.js App'
      }
    },
    components: {
      HeaderMy,
      Chat,
      General,
      NavigationLeft
    },
    created: function () {
      {

        axios.post('/IsAuth', {
          },
          {
            headers: {
              'Content-Type': 'application/json;charset=UTF-8'
            }
          })
        .then((req) => {
          if (req.data.result == '0') {
            this.$store.dispatch('setAuthorised', 1);
            this.$store.dispatch('setName', this.response.name);

          }
        })
        .catch((req) => {
          console.log(req.data)
        });
      }


      console.log('a is: ' + this.a)
    }
  }
</script>

<style lang="scss">
  $sidebar-width: 300px;
  $primary-color:#9cff07;
  .my-header {
    width: 100%;
    height: 100px;
    border: 3px solid $primary-color;
    position: fixed;
  }
  .wrapper{
    position:relative;
  }
  .left-content-sidebar{
    position: fixed;
    left:0;
    top:103px;
    width:  $sidebar-width;
  }
  .main-content{
    position: absolute;
    width: 100%;
    top:103px;
    left: $sidebar-width;
    z-index: -1;
  }
  #chat-form{
    position:fixed;
    bottom:0;
    left:$sidebar-width;
    width: 456px;
    z-index: 9;
  }


</style>
