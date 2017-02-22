/**
 * Created by tangzhichao on 2017/2/21.
 */
export default {
  state: {
    mode: 'dev',
    user: {
      name : 'alvin'
    },
    projectId: 0
  },
  getters: {
    ['app/_getUserName'](state){
      return state.user.name;
    },
    ['app/_navPath'](state,getters,rootState){
      return rootState.route.fullPath;
    },
    ['app/_sizeMapPath'](state,getters,rootState){
      console.log(rootState.route)
      return rootState.route;
    }
  },
  mutations: {
    ['app/changeMode'] (state, payload){
      state.mode = payload.mode;
    },
    ['app/changeNavPath'](state, payload){
      state.navPath = payload.navPath;
    }
  },
  actions: {
    ['app/changeMode']({commit}, paylod){
      commit("changeMode", paylod);
    },
    ['app/changeNavPath'](context, payload){
      content.commit("app/changeNavPath", paylod)
    }
  }
};
