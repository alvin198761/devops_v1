import  reqwest from '../utils/reqwest'

export function fetchAll() {
    return reqwest({
        url: '/room/list',
        method: 'get',
        type: 'json'
    });
}