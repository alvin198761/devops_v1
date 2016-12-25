import reqwest from '../utils/reqwest';

export function fetchAll(page) {
    return reqwest({
        url: '/device/list',
        method: 'get',
        type: 'json',
        data: {page: page}
    });
}