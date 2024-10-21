import request from '@/utils/request';
// list
export const fasonglepuList = (params) => {
    return request({
        url: '/fasonglepu/page',
        method: 'post',
        data: params,
    })
};
export const fasonglepuDetail = (id) => {
    return request({
        url: '/fasonglepu/'+id,
        method: 'get',
    })
};
// add
export const fasonglepuSave = (params) => {
    return request({
        url: '/fasonglepu',
        method: 'post',
        data: params,
    })
};
// updt
export const fasonglepuEdit = (params) => {
    return request({
        url: '/fasonglepu',
        method: 'put',
        data: params,
    })
};
// delete
export const fasonglepuDelete = (id) => {
    return request({
        url: '/fasonglepu/'+id,
        method: 'delete',
    })
};
// pldel
export const fasonglepuDeleteList = (fasonglepus) => {
    return request({
        url: '/fasonglepu/deleteList',
        data:{list:fasonglepus},
        method: 'post',
    })
};
// all
export const fasonglepuAllList = () => {
    return request({
        url: '/fasonglepu',
        method: 'get',
    })
};

