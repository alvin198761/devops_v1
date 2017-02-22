/**
 * Created by tangzhichao on 2017/2/21.
 */
import * as projectService from '../service/project';
const project = {
  id: 1,
  name: '',
  description: '',
  auth: ''
}

const attr = {
  icon: ''
}

const page = {
  number: 1,
  total: 0
}

export default  {
  state: {
    project: project,
    attr: attr,
    list: [],
    page: page,
    loading: false
  },
  getters: {
    ['project/_page'](state){
      return state.page;
    },
    ['project/_loading'](state){
      return state.loading;
    },
    ['project/_getList'](state){
      return state.list;
    }
  },
  mutations: {
    ['project/fetch'](state){
      projectService.fetch(state)
    },
    ['project/changePage'](state ,payload){
      state.page.number = payload.number;
      projectService.fetch(state)
    },
    ['project/add'](state,$router,payload){
      projectService.save(state,$router,payload);
    }
  },
  actions: {
    ['project/fetch'](content){
      content.commit('project/fetch');
    },
    ['project/changePage'](content,payload){
      content.commit('project/changePage',payload);
    },
    ['project/add'](content,$router,payload){
      content.commit('project/add',$router,payload);
    }
  }
}
