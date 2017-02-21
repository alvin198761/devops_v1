import './login.html';
import './index.less';
import dva from 'dva';
import React, {PropTypes} from 'react';
import {Router, Route, IndexRoute, Link} from 'dva/router';
import LoginPage from './components/login/Login';

// 1. Initialize
const app = dva();

// 2. Plugins
// app.use({});

// 3. Model
//app.model(require('./models/example'));
app.model(require('./models/main'));
// app.model(require('./models/appstore'));

// 4. Router
app.router(function ({history}) {
  return (
    <Router history={history}>
      <Route path="/" component={LoginPage} title="登录"></Route>
    </Router>
  )
});

// 5. Start
app.start('#root');

// setInterval(function () {
//   heartbeat();
// },60*1000);
