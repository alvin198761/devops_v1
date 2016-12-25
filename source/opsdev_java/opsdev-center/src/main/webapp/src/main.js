import Vue from 'vue'
import App from './App'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-default/index.css'
import VueRouter from 'vue-router'
import 'nprogress/nprogress.css'

import Login from './components/Login.vue'
import Home from './components/Home.vue'
import Room from './components/resources/room/Room.vue'
import Project from './components/resources/project/Project.vue'
import Device from './components/resources/device/Device.vue'
import Cmd from './components/call/cmd/Cmd.vue'
import Task from './components/call/task/Task.vue'
import Control from './components/role/role/Control.vue'
import Sys from './components/role/sys/Sys.vue'
import Disk from './components/disk/Disk.vue'
import NProgress from 'nprogress'//页面顶部进度条
import TaskCmdDialog from './components/call/task/TaskItem.vue'

Vue.use(ElementUI)
Vue.use(VueRouter)


const routes = [
  { path: '/login', component: Login },
  {
    path: '/',
    component: Home,
    name: '资源管理',
    children: [
      { path: '/room', component: Room ,name:'机房管理'},
     { path: '/project', component: Project, name: '项目管理' },
     { path: '/device', component: Device, name: '设备管理' },
    ]
  },
  {
    path: '/',
    component: Home,
    name: '文件管理',
    children: [
      { path: '/files', component: Disk, name: '文件操作' },
    ]
  },
  {
    path: '/',
    component: Home,
    name: '远程调用',
    children: [
     { path: '/cmd', component: Cmd, name: '命令执行' },
     { path: '/task', component: Task, name: '执行任务' },
     { path: '/task-item', component: TaskCmdDialog, name: '添加任务项' }
    ]
  },
  {
    path: '/',
    component: Home,
    name: '用户和权限',
    children: [
      { path: '/user', component: Control, name: '用户/权限' },
      { path: '/sys', component: Sys, name: '系统设置' }
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
 // render: h => h(Login)
}).$mount('#app')

router.replace('/room')


