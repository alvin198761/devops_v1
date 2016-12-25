import reqwest from 'reqwest';

reqwest.ajaxSetup({
    dataFilter: function (res, type) {
        if (type == 'json') {
            if (res && res.indexOf('<!DOCTYPE html>') != -1) {
                this.$alert(
                    '会话已经失效，请重新登录！', '错误',
                    {
                        confirmButtonText: '确定'
                    }
                );
                location.href = "#/login";
            } else if (!res || res.length == 0) {
                return res;
            } else {
                var resData = JSON.parse(res);
                if (resData.code == 4301) {
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
