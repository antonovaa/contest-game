<template>
  <div id="header">
    <form role="form" style="display: block;">
      <div class="form-group">
        <input type="text" name="username" v-model="username" id="usernamel" tabindex="1" class="form-control"
               placeholder="Username" value="">
      </div>
      <div class="form-group">
        <input type="password" name="password" v-model="password" id="passwordl" tabindex="2" class="form-control"
               placeholder="Password">
      </div>
      <div class="form-group text-center">
        <input type="checkbox" tabindex="3" class="" name="remember" id="remember">
        <label for="remember"> Remember Me</label>
      </div>
      <div class="form-group">
        <div class="row">
          <div class="col-sm-6 col-sm-offset-3">
            <input type="button" name="login-submit" id="login-submit" tabindex="4"
                   class="form-control btn btn-login" value="Log In" v-on:click="testPost">
          </div>
        </div>
      </div>
      <div class="form-group">
        <div class="row">
          <div class="col-lg-12">
            <div class="text-center">
              <a href="https://phpoll.com/recover" tabindex="5" class="forgot-password">Forgot Password?</a>
            </div>
          </div>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
  import axios from 'axios'
  import { bus } from '../../main.js'

  export default {
    data() {
      return {
        password:'',
        username:''
      }
    },
    methods: {
      testPost: function () {

        axios.post('/testformlog', {
          username: this.username,
          password: this.password
        })
          .then(function (response) {
            console.log(response);
          })
          .catch(function (error) {
            console.log(error);
            bus.$emit('show-param','123')
          });
      }
    }
  }
</script>

<style>


</style>
