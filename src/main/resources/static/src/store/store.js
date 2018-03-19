import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
      isAuthorised:false,
      count: 0,
      currentViewNumber:1
    },
    mutations: {
      setAuthorised(state,data){
        state.isAuthorised=true;
      },
      increment2 (state) {
        state.count++
      },
      setNumber (state,data) {
        state.currentViewNumber=data;
      }
    },
    actions: {
      incremen3t (context) {
        context.commit('increment2');
      },
      setCurrentView (context,data) {
        context.commit('setNumber',data);
        // console.log(data+' in store');
      },
      authorised(context,data){
        context.commit('setAuthorised',data);
      }
    }
  })
