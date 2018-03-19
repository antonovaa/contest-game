// import axios from 'axios'
// import BootstrapVue from "bootstrap-vue"
import Vue from 'vue'
import App from './App.vue'
import store from './store/store'
// import "jquery/dist/jquery.min";
// // import "bootstrap/dist/js/bootstrap.min"
// import "bootstrap/dist/css/bootstrap.min.css"
// import "bootstrap-vue/dist/bootstrap-vue.css"
import VueRouter from 'vue-router'
// import axios from './store/store'

Vue.use(VueRouter);
// Vue.use(BootstrapVue);


// export const bus=new Vue();


new Vue({
  el: '#app',
  template: '<App/>',
  store,
  components: { App },
});
