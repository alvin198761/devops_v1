import reqwest from '../utils/reqwest';

export function fetch(params) {
  return reqwest({
    method:'get',
    url:'/key/list',
    data:params,
    type: 'json'
  });
}

export function keyNameExist(name) {
  return reqwest({
    method :'get',
    url:'/key/exist',
    data: {name:name},
    type:'json'
  });
}

export function addAuthKey(params) {
  console.log(params)
  return reqwest({
    method :'post',
    url:'/key',
    data: JSON.stringify(params),
    type:'json',
    contentType:'application/json'
  });
}

export function fetchPage(page) {
  return reqwest({
    method:'get',
    url:'/key',
    data:{page:page},
    type: 'json'
  });
}
