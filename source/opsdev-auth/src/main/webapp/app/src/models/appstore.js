/**
 * Created by tangzhichao on 2016/12/22.
 */
import {fetchAll,fetchList} from '../services/appstore'
export default {

  namespace: 'appstore',

  state: {
    page:[],
    list : null,
    loading:true
  },

  subscriptions: {
    setup({dispatch, history}) {
    },
  },

  effects: {
    *fetchAll({payload}, {call, put}) {
      console.log("appstore/fetchAll")
      const data = yield call(fetchAll);
      console.log(data)
      if (data) {
        yield  put({type: 'fetch', payload: data});
      }
    },
    *fetchList({payload}, {call, put}) {
      console.log("appstore/fetchList")
      const data = yield  call(fetchList ,payload.page);
      console.log(data)
      if(data){
        yield put({type:'fetchListSuccess',payload:data})
      }
    }
  },

  reducers: {
    fetch(state, action) {
      return {...state, page: action.payload,loading:false};
    },
    fetchListSuccess(state,action){
      console.log(action)
      return {...state,list:action.payload,loading:false}
    }
  },

}
