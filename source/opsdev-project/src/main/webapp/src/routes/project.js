import ProjectPage from '../components/project/ProjectPage.vue';
import AddProjectPage from '../components/project/AddProjectPage.vue';
import ListProjectPage from '../components/project/ListProjectPage.vue';
export default {
  path: '/project',
  component: ProjectPage,
  children: [
    {
      path: 'add',
      component: AddProjectPage,
      name: '添加项目'
    },
    {
      path: 'list',
      component: ListProjectPage,
      name:'项目列表'
    }
  ]
}
