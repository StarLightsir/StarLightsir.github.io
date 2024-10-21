<template>
	<div>
		<el-form :inline="true" :model="formInline" class="user-search">
<!--			<el-form-item label=""><el-input size="small" v-model="formInline.lepubianhao" placeholder="输入乐谱编号"></el-input></el-form-item>-->
			<el-form-item label=""><el-input size="small" v-model="formInline.lepumingcheng" placeholder="输入乐谱名称"></el-input></el-form-item>
			
			<el-form-item>
				<el-button size="small" type="warning" icon="el-icon-search" @click="search">搜索</el-button>
				
				<el-button size="small" type="success" icon="el-icon-s-data" @click="daochu()" v-if="userInfo.roles[0] == 'guanliyuan'">导出</el-button>
				<el-button size="small" type="danger" icon="el-icon-delete" @click="handleDeleteList()" v-if="userInfo.roles[0] == 'guanliyuan'">批量删除</el-button>
				<el-button size="small" type="warning" icon="el-icon-finished" @click="handleShenheList()" v-if="userInfo.roles[0] == 'guanliyuan'">批量审核</el-button>
			</el-form-item>
			<el-form-item>
				<el-upload class="upload-demo" style="float: left; padding-right: 10px;" action='http://localhost:9999/goumai/upload' :headers='headers' :show-file-list='false' :on-success='handleDaoruSuccess' :before-upload='beforeDaoruUpload' ><el-button size="small" type="info" icon="el-icon-sell" @click="daoru()" v-if="userInfo.roles[0] == 'guanliyuan'">导入</el-button></el-upload>
			</el-form-item>
		</el-form>
		
		<el-table size="small" :data="listData" highlight-current-row v-loading="loading" border element-loading-text="拼命加载中" @selection-change="handleSelectionChange">
			<el-table-column align="center" type="selection" width="60"></el-table-column>
			<el-table-column sortable prop="lepubianhao" label="乐谱编号"></el-table-column>
			<el-table-column sortable prop="lepumingcheng" label="乐谱名称"></el-table-column>
			<el-table-column sortable prop="lepuleibie" label="乐谱分类"></el-table-column>
			<el-table-column sortable prop="jiage" label="价格"></el-table-column>
			<el-table-column sortable prop="chuangzuoren" label="创作人"></el-table-column>
			<el-table-column sortable prop="goumairen" label="购买人"></el-table-column>
			<el-table-column sortable prop="iszf" label="是否支付"></el-table-column>
			<el-table-column v-if="userInfo.roles[0] == 'guanliyuan'" align="center" sortable prop="issh" label="是否审核" >
				<template slot-scope="scope" >
					<el-switch   v-model="scope.row.issh ? true : false" active-color="#13ce66" active-text="是" inactive-text="否" inactive-color="#ff4949" @change="editissh(scope.$index, scope.row)" ></el-switch>
				</template>
			</el-table-column>
			<el-table-column v-else align="center" sortable prop="issh" label="是否审核" >
				<template slot-scope="scope" >
					<el-switch  disabled="disabled"  v-model="scope.row.issh ? true : false" active-color="#13ce66" active-text="是" inactive-text="否" inactive-color="#ff4949" @change="editissh(scope.$index, scope.row)" ></el-switch>
				</template>
			</el-table-column>
			
			<el-table-column sortable prop="addtime" label="添加时间" width="160">
				<template slot-scope="scope">
					<div>{{scope.row.addtime|datePipe('yyyy-MM-dd hh:mm:ss')}}</div>
				</template>
			</el-table-column>
			
			<el-table-column align="center" label="操作" min-width="160">
				<template slot-scope="scope">
					
					<!--liangbuan-->
					<el-button size="mini" type="success" @click="dd(scope.$index, scope.row)" v-if=" userInfo.roles[0] == 'chuangzuozhe'&& scope.row.iszf =='是' ">发送乐谱</el-button>
					<el-button size="mini" type="danger" @click="deleteGoumai(scope.$index, scope.row)" v-if="userInfo.roles[0] == 'guanliyuan'  || userInfo.roles[0] == 'chuangzuozhe' || userInfo.roles[0] == 'aihaozhe'">删除</el-button>
					<el-button size='mini' type='primary' @click="handleDetail(scope.$index, scope.row)">详细</el-button>
					<el-button size="mini" type="success" @click="payEditlb(scope.$index, scope.row)" v-if="userInfo.roles[0] == 'aihaozhe'">支付</el-button>
					
				</template>
			</el-table-column>
		</el-table>
		<Pagination v-bind:child-msg="pageparm" @callFather="callFather"></Pagination>
		
		<el-dialog :title="title" :visible.sync="editFormVisible" width="30%" @click="closeDialog">
			<el-form label-width="120px" :model="editForm" :rules="rules" ref="editForm">
				<el-form-item  label="乐谱编号" prop="lepubianhao"><el-input size="small" v-model="editForm.lepubianhao" auto-complete="off" placeholder="请输入乐谱编号" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="乐谱名称" prop="lepumingcheng"><el-input size="small" v-model="editForm.lepumingcheng" auto-complete="off" placeholder="请输入乐谱名称" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="乐谱分类" prop="lepuleibie"><el-input size="small" v-model="editForm.lepuleibie" auto-complete="off" placeholder="请输入乐谱类别" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="价格" prop="jiage"><el-input size="small" v-model="editForm.jiage" auto-complete="off" placeholder="请输入价格" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="创作人" prop="chuangzuoren"><el-input size="small" v-model="editForm.chuangzuoren" auto-complete="off" placeholder="请输入创作人" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="购买人" prop="goumairen"><el-input size="small" v-model="editForm.goumairen" auto-complete="off" placeholder="请输入购买人" style='width:50%' disabled></el-input></el-form-item>
		
				
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button size="small" @click="closeDialog">取消</el-button>
				<el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">保存</el-button>
			</div>
		</el-dialog>
			
			
			<!--xiangxidhk-->
			 <el-dialog :title="title" :visible.sync="payVisible" width="25%" @click="closeDialog">
      <div style="text-align: center">
        <el-input size="small" v-model="dingdanbianhao1" auto-complete="off" placeholder="请输入订单编号" v-if="false"></el-input>
        <el-radio v-model="radio" label="1" style="margin: 10px"><img src="./img/BOC_OUT.gif"></el-radio>
        <el-radio v-model="radio" label="2" style="margin: 10px"><img src="./img/CITIC_OUT.gif"></el-radio>
        <el-radio v-model="radio" label="3" style="margin: 10px"><img src="./img/CCB_OUT.gif"></el-radio>
        <el-radio v-model="radio" label="4" style="margin: 10px"><img src="./img/CMBC_OUT.gif"></el-radio>
        <el-radio v-model="radio" label="5" style="margin: 10px"><img src="./img/COMM_OUT.gif"></el-radio>
        <el-radio v-model="radio" label="6" style="margin: 10px"><img src="./img/ICBC_OUT.gif"></el-radio>
        <el-radio v-model="radio" label="7" style="margin: 10px"><img src="./img/PSBC_OUT.gif"></el-radio>
        <el-radio v-model="radio" label="8" style="margin: 10px"><img src="./img/SPDB_OUT.gif"></el-radio>
        <el-radio v-model="radio" label="9" style="margin: 10px"><img src="./img/ABC_OUT.gif"></el-radio>
      </div>
      <div slot="footer" class="dialog-footer">
        <el-button size="small" type="primary" :loading="loading" class="title" @click="pay()">支付</el-button>
      </div>
    </el-dialog>
	</div>
</template>

<script>
import Pagination from "@/layout/pagination/Pagination";
import { goumaiList, goumaiSave, goumaiDelete,goumaiEdit,goumaiDeleteList } from '@/api/goumai/goumaiApi';


import {Session} from "@/utils/storage";
import axios from 'axios';
export default {
	name: 'user',
	data() {
		return {
			loading: false, //是显示加载
			title: '',
			
			editFormVisible: false, //控制编辑页面显示与隐藏
			payVisible: false,
			tempdingdanxinxi: '',
			id: '',
			radio: '',
			//detaitFormVsisisble
			
			
			
			editForm: {
			},
			user:[],
			username:'',
			cx:'',
			
			rules: {
				
			},
			
			formInline: {
				page: 1,
				limit: 10,
			},
			
			
			listData: [],
			goumais:[],
			
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
		if(this.userInfo.roles[0] == 'chuangzuozhe'){this.formInline.chuangzuoren= this.username;}
		if(this.userInfo.roles[0] == 'chuangzuozhe'){this.formInline.issh= 0;}
		if(this.userInfo.roles[0] == 'aihaozhe'){this.formInline.goumairen= this.username;}
		if(this.userInfo.roles[0] == 'aihaozhe'){this.formInline.issh= 0;}

		this.getdata(this.formInline)
		
	},
	methods: {
		
		 pay() {
      if (this.tempdingdanxinxi.iszf == "是") {
        this.$message.warning("订单已支付");
        return;
      }
      if (this.radio != "") {
        goumaiEdit({id: this.id, iszf: "是"}).then(res => {
          console.log(res)
          if (res.code == "0") {
            this.$message.success("支付成功!");
            this.payVisible = false;
            this.$router.go(0);
          } else {
            this.$message.error("支付失败!");
          }
        });
      } else {
        this.$message.error("请选择支付方式！");
      }
    },







		dd(index,row){
			this.$router.push({
				name:'fasonglepuAdd',
				params:{
					id:row.id
				}
			})
		},
	payEditlb: function (index, row) {
      this.payVisible = true;
      if (row != undefined && row != 'undefined') {
        this.title = '支付';
        this.id = row.id
        this.tempdingdanxinxi = row;
      }

    },
		handleShenheList(){
				const goumais = this.goumais;
				if(goumais.length == 0){
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
						goumais.forEach(item=> {
							let data = {...item, issh: 1}
							goumaiEdit(data).then(res => {})
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
			goumaiList(parameter)
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
				this.title = '修改购买'
				this.editForm = row
			} else {
				this.title = '添加购买'
				this.editForm = {}
				this.editForm.goumairen= this.username;
				
				//zixdonxgbianxhao1
			}
		},
		daochu(){
			axios.get('/goumai/getExcel', {
				responseType: 'blob',
				headers: { token: Session.get("token"), 'Content-Type': 'application/x-download' }
			}).then((res) => {
				if (res.status === 200) {
					var a = document.createElement('a')
					var blob = new Blob([res.data], { type: 'application/vnd.ms-excel' })
					var href = window.URL.createObjectURL(blob)
					a.href = href
					a.download = '购买.xlsx'
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
		
		handleDetail(index, row) {const w = window.open("about:blank");w.location.href = 'http://localhost:8080/#/goumaidetail/'+row.id;},
		//liangbuedit
		// 编辑、增加页面保存方法
		submitForm(editData) {
			
			this.$refs[editData].validate(valid => {
				if (valid) {
					if(this.editForm.id){
						goumaiEdit(this.editForm).then(res => {
							this.editFormVisible = false
							
							this.loading = false
							if (res.code == '0') {
								this.getdata(this.formInline)
								this.$message({
									type: 'success',
									message: '购买修改成功！'
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
						goumaiSave(this.editForm).then(res => {
							this.editFormVisible = false
							this.loading = false
							if (res.code == '0') {
								
								this.getdata(this.formInline)
								this.$message({
									type: 'success',
									message: '购买添加成功！'
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
		deleteGoumai(index, row) {
			this.$confirm('确定要删除吗?', '信息', {
				confirmButtonText: '确定',
				cancelButtonText: '取消',
				type: 'warning'
			}).then(() => {
				goumaiDelete(row.id).then(res => {
					if (res.code == '0') {
						this.$message({
								type: 'success',
							message: '购买已删除!'
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
			this.goumais = val;
		},
		handleDeleteList(){
			const goumais = this.goumais;
			if(goumais.length == 0){
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
					goumaiDeleteList(goumais).then(res => {
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
		
		editissh(index,row){
				let data = {...row,issh:!row.issh}
				goumaiEdit(data).then(res => {
					this.editFormVisible = false
					this.loading = false
					if (res.code == '0') {
						this.getdata(this.formInline)
						this.$message({
							type: 'success',
							message: '审核状态修改成功！'
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
			},
		
		
		//youscwexnjiaxn
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
