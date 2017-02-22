/**
 * Created by tangzhichao on 2017/2/21.
 */
import http from '../../plugins/http';
import {Message} from 'element-ui';

export function fetch(state, payload) {
  state.loading = true;
  http.get('/api/project/list/' + payload.page).then(function (res) {
    state.list = res.data.items;
    state.page = {
      number: parseInt(payload.page),
      total: res.data.total
    };
    state.loading = false;
  }).catch(function (res) {
    Message.error({
      message: '获取项目列表失败'
    });
    state.loading = false;
  });
}
export function detail(state, payload) {
  state.loading = true;
  http.get('/api/project/' + payload.id).then(function (res) {
    state.project = res.data;
    state.loading = false;
    console.log(state.project)
    payload.$router.push("/project/setting/" + payload.id)
  }).catch(function (res) {
    Message.error({
      message: '获取项目失败'
    });
    state.loading = false;
  });
}

export function save(state, $router, project) {
  state.loading = true;
  http.put('/api/project/', JSON.stringify(project)).then(function (res) {
    state.loading = false;
    $router.push("/project/list/1");
    Message.success({
      message: '添加项目成功'
    });
  }).catch(function (res) {
    Message.error({
      message: '添加项目失败'
    });
    state.loading = false;
  });
}

export function setting(state) {
  state.loading = true;
  http.put('/api/project/', JSON.stringify(project)).then(function (res) {
    state.loading = false;
    Message.success({
      message: '修改项目成功'
    });
  }).catch(function (res) {
    Message.error({
      message: '修改项目失败'
    });
    state.loading = false;
  });
}
