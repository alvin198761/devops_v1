import React, { PropTypes } from 'react';
import { Router, Route, IndexRoute, Link } from 'dva/router';
import IndexPage from './routes/IndexPage';
import DevicePage from './routes/DevicePage';
import AddDevice from './components/device/AddDevice';
import AuthKeyPage from './routes/AuthKeyPage';
import AddAuthKey from './components/key/AddAuthKey';


export default function({ history }) {
  return (
    <Router history={history}>
      <Route path="/"  components={IndexPage} title="首页" >
        <IndexRoute components={DevicePage} />
        <Route path="device" components={DevicePage} title="设备管理"/>
        <Route path="add-device" components={AddDevice} title="添加/编辑 设备"/>
        <Route path="key" components={AuthKeyPage} title="密码/秘钥 管理"/>
        <Route path="add-key" components={AddAuthKey} title="添加/编辑 秘钥"/>
        </Route>
    </Router>
  );
};
