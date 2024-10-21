import request from '@/utils/request';

export function useMenuApi() {
	return {
		getMenuGuanliyuan: (params) => {
			// 本地数据，路径：`/public/xxx.json`
			return request({
				url: './guanliyuan.json',
				method: 'get',
				params,
			});

		},
		getMenuAihaozhe: (params) => {
			return request({
				url: './aihaozhe.json',
				method: 'get',
				params,
			});
		},getMenuChuangzuozhe: (params) => {
			return request({
				url: './chuangzuozhe.json',
				method: 'get',
				params,
			});
		},
		
	};
}
