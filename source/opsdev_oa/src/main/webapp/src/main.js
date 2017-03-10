import Vue from 'vue'
import App from './App'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-default/index.css'
import VueRouter from 'vue-router'
import NProgress from 'nprogress'//页面顶部进度条
import 'nprogress/nprogress.css'

import Home from './components/Home.vue'
import Department from './components/department/Department.vue'
import Employee from './components/employee/Employee.vue'
import Account from './components/account/Account.vue'



Vue.use(ElementUI)
Vue.use(VueRouter)


const routes = [

  {
    path: '/',
    component: Home,
    name: '部门',
    children: [
      { path: '/department', component: Department ,name:'部门信息'},
      { path: '/employee', component: Employee ,name:'职员信息'},
      { path: '/account', component: Account ,name:'高级信息'},
    ]
  }
]

const router = new VueRouter({  routes})

router.beforeEach((to, from, next) => {  NProgress.start();  next()})

router.afterEach(transition => {  NProgress.done();});

new Vue({
  el: '#app',
  template: '<App/>',
  router,
  components: { App }
}).$mount('#app')

router.replace('/department')


