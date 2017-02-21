import  reqwest from '../utils/reqwest'

export function  heartbeat() {
  return reqwest({
    url: '/heartbeat',
    method: 'get',
    type : 'json',
    data : {}
  });
}
