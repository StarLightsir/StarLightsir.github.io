<template>
	<div>
		<el-form :inline="true" :model="formInline" class="user-search">
			<el-form-item label=""><el-input size="small" v-model="formInline.lepubianhao" placeholder="输入乐谱编号"></el-input></el-form-item>			<el-form-item label=""><el-input size="small" v-model="formInline.lepumingcheng" placeholder="输入乐谱名称"></el-input></el-form-item>			
			<el-form-item>
				<el-button size="small" type="primary" icon="el-icon-search" @click="search">搜索</el-button>
			</el-form-item>
		</el-form>
		<el-table size="small" :data="listData" highlight-current-row v-loading="loading" border element-loading-text="拼命加载中" @selection-change="handleSelectionChange">
			<el-table-column align="center" type="selection" width="60"></el-table-column>
			<el-table-column sortable prop="lepubianhao" label="乐谱编号"></el-table-column>			<el-table-column sortable prop="lepumingcheng" label="乐谱名称"></el-table-column>			<el-table-column sortable prop="lepuleibie" label="乐谱类别"></el-table-column>			<el-table-column sortable prop="jiage" label="价格"></el-table-column>			<el-table-column align='center' prop='leputu' label='乐谱图' width='120'><template slot-scope='scope'><el-image :src='scope.row.leputu' style='height:70px'  v-if="scope.row.leputu"/><img src="../../../static/images/guanli.jpg" style='height:70px' v-else/></template></el-table-column>			<el-table-column sortable prop="chuangzuoren" label="创作人"></el-table-column>			
			<el-table-column sortable prop="addtime" label="添加时间" width="160">
				<template slot-scope="scope">
					<div>{{scope.row.addtime|datePipe('yyyy-MM-dd hh:mm:ss')}}</div>
				</template>
			</el-table-column>
			
			<el-table-column align="center" label="操作" min-width="160">
				<template slot-scope="scope">
					<!--lianjie1-->
				</template>
			</el-table-column>
		</el-table>
		<Pagination v-bind:child-msg="pageparm" @callFather="callFather"></Pagination>
		
	</div>
</template>

<script>
import Pagination from "@/layout/pagination/Pagination";
import { lepuxinxiList, lepuxinxiSave, lepuxinxiDelete,lepuxinxiEdit,lepuxinxiDeleteList } from '@/api/lepuxinxi/lepuxinxiApi';
import {lepuleibieAllList} from "@/api/lepuleibie/lepuleibieApi";				

import {Session} from "@/utils/storage";
export default {
	name: 'user',
	data() {
		return {
			loading: false, //是显示加载
			title: '',
			editFormVisible: false, //控制编辑页面显示与隐藏
			
			editForm: {
			},
			user:[],
			username:'',
			cx:'',
			lepuleibies:[],				
			rules: {
				
			},
			
			formInline: {
				page: 1,
				limit: 10,
			},
			
			
			listData: [],
			lepuxinxis:[],
			checkmenu: [],
			pageparm: {
				currentPage: 1,
				pageSize: 10,
				total: 0
			}
		};
	},
	computed:{
		headers(){
			return {"token":Session.get("token")}
		}
	},
	watch: {
			'$route' (to, from) {
				// 路由发生变化页面刷新
				this.$router.go(0);
			}
		},
	components: {
		Pagination
	},
	created() {
		
		if (!Session.get('userInfo')) return false;
		this.userInfo = Session.get('userInfo');
		this.username=localStorage.getItem("username");
		this.cx=localStorage.getItem("cx");
		if(this.userInfo.roles[0] == 'aihaozhe'){this.formInline.chuangzuoren= this.username;}		
		this.getdata(this.formInline)
		this.getAlllepuleibie();				
	},
	methods: {
		getdata(parameter) {
			lepuxinxiList(parameter)
					.then(res => {
						this.loading = false
						if (res.success == false) {
							this.$message({
								type: 'info',
								message: res.msg
							})
						} else {
							this.listData = res.data.list
							
							// 分页赋值
							this.pageparm.currentPage = this.formInline.current
							this.pageparm.pageSize = this.formInline.currentNum
							this.pageparm.total = res.data.total
						}
					})
					.catch(err => {
						this.loading = false
						this.$message.error('菜单加载失败，请稍后再试！')
					})
		},
		//qixuzhijixsuan3
		// 分页插件事件
		callFather(parm) {
			this.formInline.current = parm.currentPage
			this.getdata(this.formInline)
		},
		//xia2sui1
		// 搜索事件
		search() {
			this.getdata(this.formInline)
		},
		//显示编辑界面
		
		addSalary(index,row){
				this.$router.push({
					name:'xmkuaixAdd',
					params:{
						id:row.id
					}
				})
			},
		// 编辑、增加页面保存方法
		
		// 删除公司
		
	
		
		
		getAlllepuleibie(){lepuleibieAllList().then(res=>{if(res.code == '0'){this.lepuleibies = res.data}})},				
		
		// 关闭编辑、增加弹出框
		
	},
};
</script>

<style scoped lang="scss">
	@import './index.scss';
</style>
