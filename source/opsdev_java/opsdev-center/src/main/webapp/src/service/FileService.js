import reqwest from '../utils/reqwest'

export function addFileItem(params) {
    return reqwest({
        url:'/file',
        method:'post',
        type:'json',
        data:params
    });
}

export function fetchAll(page) {
    return reqwest({
        url:'/file/list',
        method:'get',
        type:'json',
        data:{
            page: page
        }
    });
}