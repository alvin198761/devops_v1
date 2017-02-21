import {doLogin, getLoginStatus} from '../services/main';
import {message} from 'antd';
import {Link, browserHistory} from 'dva/router';
export default {

  namespace: 'main',

  state: {
    form: {
      user: '',
      password: '',
      remember: true,
      code: ''
    }
  },

  subscriptions: {
    setup({dispatch, history}) {
    },
  },

  effects: {
    *login({payload}, {call, put}) {
      const data = yield call(doLogin, payload)
      if (data) {
        const loginInfo = yield call(getLoginStatus);
        if (!loginInfo) {
          message.error('登录出错');
          yield put({type: 'loginFailed', payload: payload});
          return;
        }
        yield put({type: 'loginSuccess', payload: loginInfo});
        if (loginInfo.role=="ROOT") {
          location.href="/#/setting/applist"
          //browserHistory.push("/#/setting")
        } else {
          location.href = "/#/appstore";
          // browserHistory.push("/#/appstore");
        }
      } else {
        message.error('登录出错');
        yield put({type: 'loginFailed', payload: payload})
      }
    },
  },

  reducers: {
    loginSuccess(state, action) {
      return {...state, loginStatues: true, isRoot: action.payload.role == "ROOT", form: {user: action.payload.user}};
    },
    loginFailed(state, action){
      const form = {
        user: action.payload.j_username,
        password: '',
        remember: action.payload.remember
      }
      return {...state, form: form, loginStatues: false};
    }
  },

}
