import request from '@/utils/request';
// list
export const bankuaiList = (params) => {
    return request({
        url: '/bankuai/page',
        method: 'post',
        data: params,
    })
};
export const bankuaiDetail = (id) => {
    return request({
        url: '/bankuai/'+id,
        method: 'get',
    })
};
// add
export const bankuaiSave = (params) => {
    return request({
        url: '/bankuai',
        method: 'post',
        data: params,
    })
};
// updt
export const bankuaiEdit = (params) => {
    return request({
        url: '/bankuai',
        method: 'put',
        data: params,
    })
};
// delete
export const bankuaiDelete = (id) => {
    return request({
        url: '/bankuai/'+id,
        method: 'delete',
    })
};
// pldel
export const bankuaiDeleteList = (bankuais) => {
    return request({
        url: '/bankuai/deleteList',
        data:{list:bankuais},
        method: 'post',
    })
};
// all
export const bankuaiAllList = () => {
    return request({
        url: '/bankuai',
        method: 'get',
    })
};

