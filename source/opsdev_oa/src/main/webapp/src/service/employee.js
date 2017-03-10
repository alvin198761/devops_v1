/**
 * Created by Administrator on 2016/12/17.
 */
import reqwest from '../utils/reqwest';
// async
export function fetchDepartmentList(){
    return reqwest({
        method:'get',
        url:"/employee",
        type:'json'
    });
}

