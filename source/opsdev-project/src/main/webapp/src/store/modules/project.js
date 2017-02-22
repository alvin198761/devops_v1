/**
 * Created by tangzhichao on 2017/2/21.
 */
import * as projectService from '../service/project';
const project = {
  id: 1,
  name: '',
  buildType: 1,
  versionControl: 1
}

const attr = {
  "id": 1,
  "icon": "el-icon-menu",
  "description": '',
  "optUser": '@',
  "optPassword": '',
  "mail": false,
  "mailUser": "",
  "projectStatus": "DEV"
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
    },
    ['project/_getProject'](state){
      return state.project;
    }
  },
  mutations: {
    ['project/fetch'](state,payload){
      projectService.fetch(state,payload)
    },
    ['project/changePage'](state, payload){
      state.page.number = payload.number;
      projectService.fetch(state)
    },
    ['project/add'](state, $router, payload){
      projectService.save(state, $router, payload);
    },
    ['project/saveBasicInfo'](state){
      projectService.setting(state);
    },
    ['project/detail'](state,payload){
      projectService.detail(state,payload);
    }
  },
  actions: {
    ['project/fetch'](content,payload){
      content.commit('project/fetch',payload);
    },
    ['project/changePage'](content, payload){
      content.commit('project/changePage', payload);
    },
    ['project/add'](content, $router, payload){
      content.commit('project/add', $router, payload);
    },
    ['project/saveBasicInfo'](content){
      content.commit('project/saveBasicInfo');
    },
    ['project/detail'](content,payload){
      content.commit('project/detail',payload)
    }
  }
}
