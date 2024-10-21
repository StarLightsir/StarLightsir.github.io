import request from '@/utils/request';

export const login =(params) => {
	if(params.role == '管理员'){return request({url: '/guanliyuan/login',method: 'post',data: {yonghuming:params.username,mima:params.password},});}
	else if(params.role == '爱好者'){return request({url: '/aihaozhe/login',method: 'post',data: {yonghuming:params.username,mima:params.password},});}else if(params.role == '创作者'){return request({url: '/chuangzuozhe/login',method: 'post',data: {zhanghao:params.username,mima:params.password},});}
	
	
}
export const register =(params) => {return request({url: '/chuangzuozhe/register',method: 'post',data: {zhanghao:params.username,mima:params.password},})}