import { createStore } from 'vuex'

// Create a new store instance.
const store = createStore({
  state () {
    return {
      isLogin: false,
    }
  },
  getters: {
      isLogin: state => state.isLogin,
  },
  mutations: {
      userStatus(state, flag) {
          state.isLogin = flag;
      }
  },
  actions: {
    userLogin({commit}, flag) {
        commit("userStatus", flag)
      },
  }
})
