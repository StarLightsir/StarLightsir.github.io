import request from '@/utils/request';
// list
export const lepuleibieList = (params) => {
    return request({
        url: '/lepuleibie/page',
        method: 'post',
        data: params,
    })
};
export const lepuleibieDetail = (id) => {
    return request({
        url: '/lepuleibie/'+id,
        method: 'get',
    })
};
// add
export const lepuleibieSave = (params) => {
    return request({
        url: '/lepuleibie',
        method: 'post',
        data: params,
    })
};
// updt
export const lepuleibieEdit = (params) => {
    return request({
        url: '/lepuleibie',
        method: 'put',
        data: params,
    })
};
// delete
export const lepuleibieDelete = (id) => {
    return request({
        url: '/lepuleibie/'+id,
        method: 'delete',
    })
};
// pldel
export const lepuleibieDeleteList = (lepuleibies) => {
    return request({
        url: '/lepuleibie/deleteList',
        data:{list:lepuleibies},
        method: 'post',
    })
};
// all
export const lepuleibieAllList = () => {
    return request({
        url: '/lepuleibie',
        method: 'get',
    })
};

