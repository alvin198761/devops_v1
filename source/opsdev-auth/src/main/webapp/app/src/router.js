import React, {PropTypes} from 'react';
import {Router, Route, IndexRoute, Link} from 'dva/router';
import IndexPage from './routes/IndexPage';
import SettingPage from './routes/SettingPage';
import AppStore from './routes/AppStore';
import AppPage from './components/app/AppPage';
import AddAppPage from './components/app/AddAppPage';


export default function ({history}) {
  return (
    <Router history={history}>
      <Route path="/" component={IndexPage} title="首页">
        <Route path="setting" component={SettingPage} title="后台管理">
          <Route path="applist" component={AppPage} title="APP 管理"></Route>
          <Route path="addapp" component={AddAppPage} title="添加 APP"></Route>
        </Route>
        <Route path="appstore" component={AppStore} title="应用中心"></Route>
      </Route>
    </Router>
  );
};
