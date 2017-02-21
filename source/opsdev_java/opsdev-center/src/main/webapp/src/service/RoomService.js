// import  reqwest from '../utils/reqwest'
import  axios from 'axios';

export function fetchAll() {
    return axios('/api/room/list');
}