import  reqwest from '../utils/reqwest'

export function  fetchAll() {
  return reqwest({
    url: 'appstore/fetch',
    method: 'get',
    type : 'json',
    data : {}
  });
}
export function  fetchList(page) {
  return reqwest({
    url: 'appstore/list',
    method: 'get',
    type : 'json',
    data : {page: page}
  });
}
