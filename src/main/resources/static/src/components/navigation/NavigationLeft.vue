<template>
  <div>
    <div class="container">
      <div class="panel-heading align-items-center">
        <div class="row">
          <div class="col-6">
            <!--<a href="#" >Login</a>-->
            <a class="active" id="login-form-link" v-on:click="loginFormLink"
               href="#">Login</a>
          </div>
          <div class="col-6">
            <a href="#" id="register-form-link" class="active" v-on:click="registerFormLink">Register</a>
          </div>
        </div>
      </div>


    </div>
    <div>
      <transition name="slide-fade">
        <div v-show="showRegistration" id="register-form">
          <registration></registration>
        </div>
      </transition>
        <!--</transition>-->
        <!---->
        <!--<transition name="slide-fade2">-->
        <transition name="slide-fade">
        <div v-show="!showRegistration" id="login-form">
          <login></login>
        </div>
      </transition>
      <news></news>
    </div>


  </div>
</template>

<script>

  import News from './navigationcomponents/News.vue'
  import Registration from './navigationcomponents/Registration.vue'
  import Login from './navigationcomponents/Login.vue'

  export default {
    data() {
      return {
        showRegistration: true,
        allMessages: '',
      }
    },
    computed: {
      reversedMessage: function () {
        // `this` указывает на экземпляр vm
        return this.message.split('').reverse().join('')
      }
    },
    components: {
      News,
      Registration,
      Login
    },
    methods: {
      loginFormLink: function (event) {
        this.showRegistration = false;
//        document.getElementById('login-form')
      },
      registerFormLink: function (event) {
        this.showRegistration = true;
      }
    }
  }
</script>

<style lang="scss">


  .slide-fade-enter-active {
    transition: all .8s cubic-bezier(1.0, 0.5, 0.8, 1.0);

  }

  .slide-fade-leave-active {
    transition: all .0s ease;
  }

  .slide-fade-enter, .slide-fade-leave-to
    /* .slide-fade-leave-active до версии 2.1.8 */
  {
    transform: translateX(10px);
    opacity: 0;
  }

  /*.slide-fade2-enter-active {*/
    /*transition: all .8s cubic-bezier(1.0, 0.5, 0.8, 1.0);*/
  /*}*/

  /*.slide-fade2-leave-active {*/
    /*transition: all .0s ease;*/
  /*}*/

  /*.slide-fade2-enter, .slide-fade2-leave-to*/
    /*!* .slide-fade-leave-active до версии 2.1.8 *!*/
  /*{*/
    /*transform: translateX(10px);*/
    /*opacity: 0;*/
  /*}*/

  /*.panel-login {*/
    /*border-color: #ccc;*/
    /*-webkit-box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);*/
    /*-moz-box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);*/
    /*box-shadow: 0px 2px 3px 0px rgba(0, 0, 0, 0.2);*/
  /*}*/

  /*.panel-login > .panel-heading {*/
    /*color: #00415d;*/
    /*background-color: #fff;*/
    /*border-color: #fff;*/
    /*text-align: center;*/
  /*}*/

  /*.panel-login > .panel-heading a {*/
    /*text-decoration: none;*/
    /*color: #666;*/
    /*font-weight: bold;*/
    /*font-size: 15px;*/
    /*!*-webkit-transition: all 0.1s linear;*!*/
    /*!*-moz-transition: all 0.1s linear;*!*/
    /*!*transition: all 0.1s linear;*!*/
  /*}*/

  /*.panel-login > .panel-heading a.active {*/
    /*color: #029f5b;*/
    /*font-size: 18px;*/
  /*}*/

  /*.panel-login > .panel-heading hr {*/
    /*margin-top: 10px;*/
    /*margin-bottom: 0px;*/
    /*clear: both;*/
    /*border: 0;*/
    /*height: 1px;*/
    /*background-image: -webkit-linear-gradient(left, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.15), rgba(0, 0, 0, 0));*/
    /*background-image: -moz-linear-gradient(left, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.15), rgba(0, 0, 0, 0));*/
    /*background-image: -ms-linear-gradient(left, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.15), rgba(0, 0, 0, 0));*/
    /*background-image: -o-linear-gradient(left, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.15), rgba(0, 0, 0, 0));*/
  /*}*/

  /*.panel-login input[type="text"], .panel-login input[type="email"], .panel-login input[type="password"] {*/
  /*height: 45px;*/
  /*border: 1px solid #ddd;*/
  /*font-size: 16px;*/
  /*-webkit-transition: all 0.1s linear;*/
  /*-moz-transition: all 0.1s linear;*/
  /*transition: all 0.1s linear;*/
  /*}*/

  /*.panel-login input:hover,*/
  /*.panel-login input:focus {*/
  /*outline: none;*/
  /*-webkit-box-shadow: none;*/
  /*-moz-box-shadow: none;*/
  /*box-shadow: none;*/
  /*border-color: #ccc;*/
  /*}*/

  /*.btn-login {*/
  /*background-color: #59B2E0;*/
  /*outline: none;*/
  /*color: #fff;*/
  /*font-size: 14px;*/
  /*height: auto;*/
  /*font-weight: normal;*/
  /*padding: 14px 0;*/
  /*text-transform: uppercase;*/
  /*border-color: #59B2E6;*/
  /*}*/

  /*.btn-login:hover,*/
  /*.btn-login:focus {*/
  /*color: #fff;*/
  /*background-color: #53A3CD;*/
  /*border-color: #53A3CD;*/
  /*}*/

  /*.forgot-password {*/
  /*text-decoration: underline;*/
  /*color: #888;*/
  /*}*/

  /*.forgot-password:hover,*/
  /*.forgot-password:focus {*/
  /*text-decoration: underline;*/
  /*color: #666;*/
  /*}*/

  /*.btn-register {*/
  /*background-color: #1CB94E;*/
  /*outline: none;*/
  /*color: #fff;*/
  /*font-size: 14px;*/
  /*height: auto;*/
  /*font-weight: normal;*/
  /*padding: 14px 0;*/
  /*text-transform: uppercase;*/
  /*border-color: #1CB94A;*/
  /*}*/

  /*.btn-register:hover,*/
  /*.btn-register:focus {*/
  /*color: #fff;*/
  /*background-color: #1CA347;*/
  /*border-color: #1CA347;*/
  /*}*/


</style>
