import request from '@/utils/request';
// list
export const chuangzuozheList = (params) => {
    return request({
        url: '/chuangzuozhe/page',
        method: 'post',
        data: params,
    })
};
export const chuangzuozheDetail = (id) => {
    return request({
        url: '/chuangzuozhe/'+id,
        method: 'get',
    })
};
// add
export const chuangzuozheSave = (params) => {
    return request({
        url: '/chuangzuozhe',
        method: 'post',
        data: params,
    })
};
// updt
export const chuangzuozheEdit = (params) => {
    return request({
        url: '/chuangzuozhe',
        method: 'put',
        data: params,
    })
};
// delete
export const chuangzuozheDelete = (id) => {
    return request({
        url: '/chuangzuozhe/'+id,
        method: 'delete',
    })
};
// pldel
export const chuangzuozheDeleteList = (chuangzuozhes) => {
    return request({
        url: '/chuangzuozhe/deleteList',
        data:{list:chuangzuozhes},
        method: 'post',
    })
};
// all
export const chuangzuozheAllList = () => {
    return request({
        url: '/chuangzuozhe',
        method: 'get',
    })
};
export const chuangzuozheUpdatePassword = (params) =>{ return request({ url: `/chuangzuozhe/updatePassword`, method: 'put',data: {...params,mima:params.password}, })};
