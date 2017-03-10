import reqwest from '../utils/reqwest';
// async
export function fetch(page){
  return reqwest({
    method:'get',
    url:"/device",
    data:page,
    type:'json'
  });
}

export function addDevice(params) {
  return reqwest({
    method:'post',
    url:'/device',
    data:JSON.stringify(params),
    type: 'json',
    contentType: 'application/json'
  });
}

export function editIp(params){
  return reqwest({
    method: 'post',
    url: "/device/editIp",
    data: params,
    type: 'json'
  })
}

export function deleteDevice(id) {
  return reqwest({
    method: 'delete',
    url: "/device/"+id,
    type: 'json'
  })
}

export function editKey(params) {
  return reqwest({
    method: 'delete',
    url: "/device/editKey",
    data: params,
    type: 'json'
  })
}
