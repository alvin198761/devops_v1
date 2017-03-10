import reqwest from '../utils/reqwest';
// async
export function fetchDepartmentList(){
    return reqwest({
        method:'get',
        url:"/dep",
        type:'json'
    });
}

export function checkName(name) {
    return reqwest({
        method:'get',
        url:'/dep',
        data:{
            name:name
        },
        type:'json'
    });
}

export function addDepartment(param) {
    return reqwest({
        method:'post',
        url:'/dep',
        data:param,
        type:'type'
    });
}