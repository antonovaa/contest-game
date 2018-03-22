import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
      isAuthorised:0,
      count: 0,
      currentViewNumber:1
    },
    mutations: {
      setAuthorisedBool(state,data){
        state.isAuthorised=data;
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
      },
      setAuthorised(context,data){
        context.commit('setAuthorisedBool',data);
      }
    }
  })
