import  {fetch,fetchPage} from '../services/authkey';
export default {

  namespace: 'authkey',

  state: {
    keys:[],
    pageKeys:[]
  },

  subscriptions: {
    setup({ dispatch, history }) {
    },
  },

  effects: {
    *fetchRemote({ payload }, { call, put }) {
      const data = yield call (fetch)
      if(data){
        yield  put({type:"fetch",payload:{keys:data}});
      }
    },
    *fetchPage({ payload }, { call, put }){
     const data = yield call (fetchPage)
    }
  },

  reducers: {
    fetch(state, action) {
      return { ...state, ...action.payload };
    },
  },

}
