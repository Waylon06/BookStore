import axios from "./axios.js";
import qs from 'qs'

export const clickToSignInAPI = (params) => axios.post('/user/login', qs.parse(params));
export const clickToSignUpAPI = (params) => axios.post('/user/register', qs.parse(params));
export const getNoticeInfoAPI = () => axios.get('/notice/list');
export const getBooksInfoAPI = () => axios.get('/book/list');
export const getBookByNameAPI = (params) => axios.get('/book/getbook',{params})
export const getOrdersInfoAPI = (params) => axios.get('/order/list', {params})
export const clickToOrderAPI = (params) => axios.post('/order/add', qs.parse(params))
export const deleteOrderAPI = (params) => axios.delete('/order/del', {params})