<template>
  <div id="header">
    <form role="form">
      <div class="form-group">
        <input type="text" name="username" v-model="username" id="username" tabindex="1"
               class="form-control"
               placeholder="Username" value="">
      </div>
      <div class="form-group">
        <input type="password" name="password" v-model="password" id="password" tabindex="2"
               class="form-control"
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
              <a v-on:click='alert("Мне насрать!!!")'>Forgot Password?</a>
            </div>
          </div>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
  //  import axios from 'axios'
  //  import { bus } from '../../../main.js'
  function getRandomArbitrary(min, max) {
    return Math.floor(Math.random() * (max - min) + min);
  }

  var newText = function (text) {
    var x_pos = getRandomArbitrary(0, document.body.clientWidth),
      y_pos = getRandomArbitrary(0, 333);
    var dx = getRandomArbitrary(1, 11) - 6;
    var dy = getRandomArbitrary(5, 15);
    var d = document.createElement('div');
    d.innerHTML = "Мне насрать";
    document.body.appendChild(d);
    var timerId = setInterval(function () {
      d.style.position = "absolute";
      d.style.left = x_pos + 'px';
      d.style.zIndex = 31;
      d.style.top = y_pos + 'px';
      d.style.fontSize = getRandomArbitrary(12, 35) + 'px';
      d.style.color = "#" + getRandomArbitrary(1, 255).toString(16) + getRandomArbitrary(1,
        255).toString(16) + getRandomArbitrary(1, 255).toString(16);
      y_pos += dy;
      x_pos += dx;
    }, 100);

// через 5 сек остановить повторы
    setTimeout(function () {
      clearInterval(timerId);
      d.remove();
    }, 5000);

  };

  export default {
    data() {
      return {
        password: '',
        username: ''
      }
    },
    methods: {
      alert(data) {
        for (let i = 0; i < 33; i++) {
          newText(data);
        }
      },
      testPost: function () {

        axios.post('/UserLogin', {
            username: this.username,
            password: this.password
          },
          {
            headers: {
              'Content-Type': 'application/json;charset=UTF-8'
            }
          })
        .then((data) => {
          console.log(data);
        })
        .catch((data) => {
          this.$store.dispatch('authorised', 'qwe');
        });
      }
    }
  }
</script>

<style>


</style>
