import request from '@/utils/request';
// list
export const goumaiList = (params) => {
    return request({
        url: '/goumai/page',
        method: 'post',
        data: params,
    })
};
export const goumaiDetail = (id) => {
    return request({
        url: '/goumai/'+id,
        method: 'get',
    })
};
// add
export const goumaiSave = (params) => {
    return request({
        url: '/goumai',
        method: 'post',
        data: params,
    })
};
// updt
export const goumaiEdit = (params) => {
    return request({
        url: '/goumai',
        method: 'put',
        data: params,
    })
};
// delete
export const goumaiDelete = (id) => {
    return request({
        url: '/goumai/'+id,
        method: 'delete',
    })
};
// pldel
export const goumaiDeleteList = (goumais) => {
    return request({
        url: '/goumai/deleteList',
        data:{list:goumais},
        method: 'post',
    })
};
// all
export const goumaiAllList = () => {
    return request({
        url: '/goumai',
        method: 'get',
    })
};

