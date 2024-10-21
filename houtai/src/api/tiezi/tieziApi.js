import request from '@/utils/request';
// list
export const tieziList = (params) => {
    return request({
        url: '/tiezi/page',
        method: 'post',
        data: params,
    })
};
export const tieziDetail = (id) => {
    return request({
        url: '/tiezi/'+id,
        method: 'get',
    })
};
// add
export const tieziSave = (params) => {
    return request({
        url: '/tiezi',
        method: 'post',
        data: params,
    })
};
// updt
export const tieziEdit = (params) => {
    return request({
        url: '/tiezi',
        method: 'put',
        data: params,
    })
};
// delete
export const tieziDelete = (id) => {
    return request({
        url: '/tiezi/'+id,
        method: 'delete',
    })
};
// pldel
export const tieziDeleteList = (tiezis) => {
    return request({
        url: '/tiezi/deleteList',
        data:{list:tiezis},
        method: 'post',
    })
};
// all
export const tieziAllList = () => {
    return request({
        url: '/tiezi',
        method: 'get',
    })
};

