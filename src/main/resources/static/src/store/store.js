import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
      count: 0,
      currentViewNumber:1
    },
    mutations: {
      increment2 (state) {
        state.count++
      },
      setNumber (state,data) {
        state.currentViewNumber=data;
      }
    },
    actions: {
      increment (context) {
        context.commit('increment2');
      },
      setCurrentView (context,data) {
        context.commit('setNumber',data);
        // console.log(data+' in store');

      }
    }
  })
