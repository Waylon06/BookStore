import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    isLogined: sessionStorage.getItem('userInfo') ? true : false,
    userInfo: {
      username: '游客',
      password: '',
      email: '',
      uid: ''
    }
  },
  getters: {
  },
  mutations: {
    changeIsLogined(state, val) {
      state.isLogined = val
    },
    changeUserInfo(state, val) {
      state.userInfo = val
    }
  },
  actions: {
  },
  modules: {
  }
})
