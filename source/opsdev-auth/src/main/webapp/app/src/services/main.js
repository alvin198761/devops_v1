import  reqwest from '../utils/reqwest'
import request from '../utils/request';

export function  doLogin(params) {
  console.log(params)
  return request({
    url: 'j_spring_security_check',
    method: 'post',
    type : 'json',
    data : params
  });
}

 
