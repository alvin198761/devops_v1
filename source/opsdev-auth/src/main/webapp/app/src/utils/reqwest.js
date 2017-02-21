import reqwest from 'reqwest';
import {Modal} from 'antd';

reqwest.ajaxSetup({
    dataFilter: function (res, type) {
      console.log(res)
        if (type == 'json') {
            if (res && res.indexOf('<!DOCTYPE html>') != -1) {
                Modal.warning({
                    title: '会话已经失效，请重新登录！',
                    onOk() {
                        location.href = "/auth";
                    }
                });
            } else if(!res || res.length == 0){
                return res;
            }else{
              var resData = JSON.parse(res);
              if(resData.code == 4301){
                location.href = resData.url;
              }
              return res
          }
        } else {
            return res
        }
    }
});

export default reqwest;
