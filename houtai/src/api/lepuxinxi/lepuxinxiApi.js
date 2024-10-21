import request from '@/utils/request';
// list
export const lepuxinxiList = (params) => {
    return request({
        url: '/lepuxinxi/page',
        method: 'post',
        data: params,
    })
};
export const lepuxinxiDetail = (id) => {
    return request({
        url: '/lepuxinxi/'+id,
        method: 'get',
    })
};
// add
export const lepuxinxiSave = (params) => {
    return request({
        url: '/lepuxinxi',
        method: 'post',
        data: params,
    })
};
// updt
export const lepuxinxiEdit = (params) => {
    return request({
        url: '/lepuxinxi',
        method: 'put',
        data: params,
    })
};
// delete
export const lepuxinxiDelete = (id) => {
    return request({
        url: '/lepuxinxi/'+id,
        method: 'delete',
    })
};
// pldel
export const lepuxinxiDeleteList = (lepuxinxis) => {
    return request({
        url: '/lepuxinxi/deleteList',
        data:{list:lepuxinxis},
        method: 'post',
    })
};
// all
export const lepuxinxiAllList = () => {
    return request({
        url: '/lepuxinxi',
        method: 'get',
    })
};

export const lepuxinxi_tj_lepufenlei = () => {return request({url: '/lepuxinxi/lepuxinxi_tj_lepufenlei',method: 'get',})};export const lepuxinxi_tj_chuangzuoren = () => {return request({url: '/lepuxinxi/lepuxinxi_tj_chuangzuoren',method: 'get',})};