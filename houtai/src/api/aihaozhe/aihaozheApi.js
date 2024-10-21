import request from '@/utils/request';
// list
export const aihaozheList = (params) => {
    return request({
        url: '/aihaozhe/page',
        method: 'post',
        data: params,
    })
};
export const aihaozheDetail = (id) => {
    return request({
        url: '/aihaozhe/'+id,
        method: 'get',
    })
};
// add
export const aihaozheSave = (params) => {
    return request({
        url: '/aihaozhe',
        method: 'post',
        data: params,
    })
};
// updt
export const aihaozheEdit = (params) => {
    return request({
        url: '/aihaozhe',
        method: 'put',
        data: params,
    })
};
// delete
export const aihaozheDelete = (id) => {
    return request({
        url: '/aihaozhe/'+id,
        method: 'delete',
    })
};
// pldel
export const aihaozheDeleteList = (aihaozhes) => {
    return request({
        url: '/aihaozhe/deleteList',
        data:{list:aihaozhes},
        method: 'post',
    })
};
// all
export const aihaozheAllList = () => {
    return request({
        url: '/aihaozhe',
        method: 'get',
    })
};
export const aihaozheUpdatePassword = (params) =>{ return request({ url: `/aihaozhe/updatePassword`, method: 'put',data: {...params,mima:params.password}, })};
