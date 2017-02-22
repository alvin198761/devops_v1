/**
 * Created by tangzhichao on 2017/2/21.
 */
import http from '../../plugins/http';
import {Message} from 'element-ui';

export function fetch(state) {
  state.loading = true;
  http.get('/api/project/list/' + state.page.number).then(function (res) {
    state.list = res.data.items;
    state.page = {
      number: state.page.number,
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

export function save(state,$router,project) {
  state.loading = true;
  http.put('/api/project/', project).then(function (res) {
    state.loading = false;
    $router.push("/project/list");
  }).catch(function (res) {
    Message.error({
      message: '添加项目失败'
    });
    state.loading = false;
  });
}
