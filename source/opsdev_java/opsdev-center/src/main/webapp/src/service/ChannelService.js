import reqwest from '../utils/reqwest'

export function saveOrUpdate(status,param){
    console.log(param)
    var url = status ==0 ?'add':'update';
    return reqwest({
        method:'post',
        url:'/channel/' + url,
        data:param,
        type:'json'
    });
}