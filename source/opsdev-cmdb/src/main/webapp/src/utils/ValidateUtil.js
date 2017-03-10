/**
 * Created by Administrator on 2016/11/27.
 */
import {keyNameExist} from '../services/authkey';
export function checkIp(ip) {
    return /^([0-9]|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.([0-9]|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.([0-9]|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.([0-9]|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])$/.test(ip);
}

export function checkIpValidator(rule, value, callback)  {
    if(checkIp(value)){
      callback();
      return ;
    }
    callback("IP 格式不正确");
}

export function checkKeyNameExist(rule,value,callback) {
  keyNameExist(value).then(res => {
    if(res != 0){
      callback("名称已经存在");
    }
  }).fail(res => {
    callback("检查名称失败");
  });

}
