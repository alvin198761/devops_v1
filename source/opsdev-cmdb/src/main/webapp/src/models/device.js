import  {fetch} from '../services/device';


export default {

  namespace: 'device',

  state: {
    loading:true,
    devices :[],
    page: 1
  },

  subscriptions: {
    setup({ dispatch, history }) {
    },
  },

  effects: {
    *fetchRemote({ payload }, { call, put }) {
      const data = yield call(fetch ,payload);
      if(data){
        yield put({
          type:'fetch',
          payload:data
        });
      }
    },
  },

  reducers: {
    fetch(state, action) {
      return { ...state,devices:action.payload,page:action.payload.number +1,loading:false };
    },
  },

}
