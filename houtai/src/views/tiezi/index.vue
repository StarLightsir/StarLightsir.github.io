﻿<template>
	<div>
		<el-form :inline="true" :model="formInline" class="user-search">
			<el-form-item label=""><el-input size="small" v-model="formInline.suoshubankuai" placeholder="输入所属版块"></el-input></el-form-item>			<el-form-item label=""><el-input size="small" v-model="formInline.biaoti" placeholder="输入标题"></el-input></el-form-item>			
			<el-form-item>
				<el-button size="small" type="warning" icon="el-icon-search" @click="search">搜索</el-button>
				<el-button size="small" type="primary" icon="el-icon-plus" @click="handleEdit()" >添加</el-button>
				<el-button size="small" type="success" icon="el-icon-s-data" @click="daochu()" v-if="userInfo.roles[0] == 'guanliyuan'">导出</el-button>
				<el-button size="small" type="danger" icon="el-icon-delete" @click="handleDeleteList()" v-if="userInfo.roles[0] == 'guanliyuan'">批量删除</el-button>
				
			</el-form-item>
			<el-form-item>
				<el-upload class="upload-demo" style="float: left; padding-right: 10px;" action='http://localhost:9999/tiezi/upload' :headers='headers' :show-file-list='false' :on-success='handleDaoruSuccess' :before-upload='beforeDaoruUpload' ><el-button size="small" type="info" icon="el-icon-sell" @click="daoru()" v-if="userInfo.roles[0] == 'guanliyuan'">导入</el-button></el-upload>
			</el-form-item>
		</el-form>
		
		<el-table size="small" :data="listData" highlight-current-row v-loading="loading" border element-loading-text="拼命加载中" @selection-change="handleSelectionChange">
			<el-table-column align="center" type="selection" width="60"></el-table-column>
			<el-table-column sortable prop="suoshubankuai" label="所属版块"></el-table-column>			<el-table-column sortable prop="biaoti" label="标题"></el-table-column>			<el-table-column sortable prop="leixing" label="类型"></el-table-column>			<el-table-column align='center' sortable prop='fujian' label='附件' width='120'><template slot-scope='scope'><el-button @click="download(scope.row)">下载</el-button></template></el-table-column>			<el-table-column sortable prop="fatieren" label="发帖人"></el-table-column>			<el-table-column sortable prop="fid" label="fid"></el-table-column>			
			<el-table-column sortable prop="addtime" label="添加时间" width="160">
				<template slot-scope="scope">
					<div>{{scope.row.addtime|datePipe('yyyy-MM-dd hh:mm:ss')}}</div>
				</template>
			</el-table-column>
			
			<el-table-column align="center" label="操作" min-width="160">
				<template slot-scope="scope">
					
					<!--liangbuan-->
					<el-button size="mini" type="success" @click="handleEdit(scope.$index, scope.row)" v-if="userInfo.roles[0] == 'guanliyuan'  || userInfo.roles[0] == ''">编辑</el-button>
					<el-button size="mini" type="danger" @click="deleteTiezi(scope.$index, scope.row)" v-if="userInfo.roles[0] == 'guanliyuan'  || userInfo.roles[0] == ''">删除</el-button>
					<el-button size='mini' type='primary' @click="handleDetail(scope.$index, scope.row)">详细</el-button>
					
				</template>
			</el-table-column>
		</el-table>
		<Pagination v-bind:child-msg="pageparm" @callFather="callFather"></Pagination>
		
		<el-dialog :title="title" :visible.sync="editFormVisible" width="30%" @click="closeDialog">
			<el-form label-width="120px" :model="editForm" :rules="rules" ref="editForm">
				<el-form-item  label="所属版块" prop="suoshubankuai"><el-input size="small" v-model="editForm.suoshubankuai" auto-complete="off" placeholder="请输入所属版块" style='width:50%'></el-input></el-form-item>		<el-form-item  label="标题" prop="biaoti"><el-input size="small" v-model="editForm.biaoti" auto-complete="off" placeholder="请输入标题" style='width:100%'></el-input></el-form-item>		<el-form-item  label="内容" prop="neirong"><el-input type="textarea" size="small" v-model="editForm.neirong" auto-complete="off" placeholder="请输入内容" style='width:100%'></el-input></el-form-item>		<el-form-item  label="类型" prop="leixing"><el-input size="small" v-model="editForm.leixing" auto-complete="off" placeholder="请输入类型" style='width:50%'></el-input></el-form-item>		<el-form-item  label='附件' prop='fujian'><el-upload class='avatar-uploader' action='http://localhost:9999/files/uploadwenjian' :headers='headers' :show-file-list='false' :on-success='handleFujianSuccess' ><el-button>上传</el-button></el-upload></el-form-item>		<el-form-item  label="发帖人" prop="fatieren"><el-input size="small" v-model="editForm.fatieren" auto-complete="off" placeholder="请输入发帖人" style='width:50%' disabled></el-input></el-form-item>		<el-form-item  label="fid" prop="fid"><el-input size="small" v-model="editForm.fid" auto-complete="off" placeholder="请输入fid" style='width:50%'></el-input></el-form-item>		
				
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button size="small" @click="closeDialog">取消</el-button>
				<el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">保存</el-button>
			</div>
		</el-dialog>
			
			
			<!--xiangxidhk-->
	</div>
</template>

<script>
import Pagination from "@/layout/pagination/Pagination";
import { tieziList, tieziSave, tieziDelete,tieziEdit,tieziDeleteList } from '@/api/tiezi/tieziApi';


import {Session} from "@/utils/storage";
import axios from 'axios';
export default {
	name: 'user',
	data() {
		return {
			loading: false, //是显示加载
			title: '',
			
			editFormVisible: false, //控制编辑页面显示与隐藏
			//detaitFormVsisisble
			
			
			editForm: {
			},
			user:[],
			username:'',
			cx:'',
			
			rules: {
				suoshubankuai: [{ required: true, message: '请输入所属版块', trigger: 'blur' },				],				biaoti: [{ required: true, message: '请输入标题', trigger: 'blur' },				],				
			},
			
			formInline: {
				page: 1,
				limit: 10,
			},
			
			
			listData: [],
			tiezis:[],
			
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
		if(this.userInfo.roles[0] == ''){this.formInline.fatieren= this.username;}		
		this.getdata(this.formInline)
		
	},
	methods: {
		
		handleShenheList(){
				const tiezis = this.tiezis;
				if(tiezis.length == 0){
					this.$message({
						type: 'error',
						message: '请至少选择一项'
					})
				}else {
					this.$confirm('确定要批量审核吗?', '信息', {
						confirmButtonText: '确定',
						cancelButtonText: '取消',
						type: 'warning'
					}).then(() => {
						tiezis.forEach(item=> {
							let data = {...item, issh: 1}
							tieziEdit(data).then(res => {})
						})
						this.getdata(this.formInline)
						this.$message({
							type: 'success',
							message: '批量审核成功！'
						})
					}).catch(() => {
						this.$message({
							type: 'info',
							message: '已取消批量审核'
						})
					})
				}
			},
		getdata(parameter) {
			tieziList(parameter)
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
		
		// 分页插件事件
		callFather(parm) {
			this.formInline.current = parm.currentPage
			this.getdata(this.formInline)
		},
		
		// 搜索事件
		search() {
			this.getdata(this.formInline)
		},
		//显示编辑界面
		handleEdit: function (index, row) {
			this.editFormVisible = true
			if (row != undefined && row != 'undefined') {
				this.title = '修改帖子'
				this.editForm = row
			} else {
				this.title = '添加帖子'
				this.editForm = {}
				this.editForm.fatieren= this.username;
				
				//zixdonxgbianxhao1
			}
		},
		daochu(){
			axios.get('/tiezi/getExcel', {
				responseType: 'blob',
				headers: { token: Session.get("token"), 'Content-Type': 'application/x-download' }
			}).then((res) => {
				if (res.status === 200) {
					var a = document.createElement('a')
					var blob = new Blob([res.data], { type: 'application/vnd.ms-excel' })
					var href = window.URL.createObjectURL(blob)
					a.href = href
					a.download = '帖子.xlsx'
					document.body.appendChild(a)
					a.click() 
					document.body.removeChild(a) 
					window.URL.revokeObjectURL(href)
				}
			}).catch((err) => {
				console.log(err)
			})
		},
		handleDaoruSuccess(res, file) {
				if(res.code == "0") {
					this.$message({
						type: 'success',
						message: '导入成功!'
					})
					this.getdata(this.formInline);
				}
			},
		beforeDaoruUpload(file) {
			const isJPG = file.type === 'application/vnd.ms-excel';
			if (!isJPG) {
				this.$message.error('上传只能是 excel 格式!');
			}
			return isJPG;
		},
		//zixdonxgbianxhao2
		
		handleDetail(index, row) {const w = window.open("about:blank");w.location.href = 'http://localhost:8080/#/tiezidetail/'+row.id;},
		//liangbuedit
		// 编辑、增加页面保存方法
		submitForm(editData) {
			
			this.$refs[editData].validate(valid => {
				if (valid) {
					if(this.editForm.id){
						tieziEdit(this.editForm).then(res => {
							this.editFormVisible = false
							
							this.loading = false
							if (res.code == '0') {
								this.getdata(this.formInline)
								this.$message({
									type: 'success',
									message: '帖子修改成功！'
								})
							} else {
								this.$message({
									type: 'info',
									message: res.msg
								})
							}
						}).catch(err => {
							this.editFormVisible = false
							this.loading = false
							this.getdata(this.formInline)
						if(err){
								this.$message.error(err)
							}else {
								this.$message.error('操作失败，请稍后再试！')
							}
						})
					}else {
						tieziSave(this.editForm).then(res => {
							this.editFormVisible = false
							this.loading = false
							if (res.code == '0') {
								
								this.getdata(this.formInline)
								this.$message({
									type: 'success',
									message: '帖子添加成功！'
								})
							} else {
								this.$message({
									type: 'info',
									message: res.msg
								})
							}
						}).catch(err => {
							this.editFormVisible = false
							this.loading = false
						if(err){
								this.$message.error(err)
							}else {
								this.$message.error('操作失败，请稍后再试！')
							}
						})
					}
				} else {
					return false
				}
			})
		},
		// 删除公司
		deleteTiezi(index, row) {
			this.$confirm('确定要删除吗?', '信息', {
				confirmButtonText: '确定',
				cancelButtonText: '取消',
				type: 'warning'
			}).then(() => {
				tieziDelete(row.id).then(res => {
					if (res.code == '0') {
						this.$message({
								type: 'success',
							message: '帖子已删除!'
						})
						this.getdata(this.formInline)
					} else {
						this.$message({
							type: 'info',
							message: res.msg
						})
					}
				}).catch(err => {
					this.loading = false
					this.$message.error('操作失败，请稍后再试')
				})
			}).catch(() => {
				this.$message({
					type: 'info',
					message: '已取消删除'
				})
			})
		},
		handleSelectionChange(val){
			this.tiezis = val;
		},
		handleDeleteList(){
			const tiezis = this.tiezis;
			if(tiezis.length == 0){
				this.$message({
					type: 'error',
					message: '请至少选择一项进行删除'
				})
			}else {
				this.$confirm('确定要批量删除吗?', '信息', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					tieziDeleteList(tiezis).then(res => {
						if (res.code == '0') {
							this.$message({
								type: 'success',
								message: '批量删除成功!'
							})
							this.getdata(this.formInline)
						} else {
							this.$message({
								type: 'info',
								message: res.msg
							})
						}
					}).catch(err => {
						this.loading = false
						this.$message.error('操作失败，请稍后再试')
					})
				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消删除'
					})
				})
			}
		},
		//xuaxnzeshxifou
		
		
		
		
		handleFujianSuccess(res, file) {
				if(res.code == "0") {
					this.editForm.fujian = "/files/download/"+res.data.id
					this.$message({
						type: 'success',
						message: '文件上传成功！'
					})
				}
				else {
					this.$message({
						type: 'info',
						message: res.msg
					})
				}
			},
			download(data){
			location.href = data.fujian;
		},				//youscwexnjiaxn
		// 关闭编辑、增加弹出框
		closeDialog() {
			this.getdata(this.formInline)
			this.editFormVisible = false
		}
	},
};
</script>

<style scoped lang="scss">
	@import './index.scss';
</style>
