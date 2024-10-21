<template>
	<div class="personal">
		<el-form label-width="100px" ref="editForm" :model="editForm" :rules="rules">
			<el-form-item  label="乐谱编号" prop="lepubianhao"><el-input size="small" v-model="editForm.lepubianhao" auto-complete="off" placeholder="请输入乐谱编号" style='width:50%' disabled></el-input></el-form-item>		<el-form-item  label="乐谱名称" prop="lepumingcheng"><el-input size="small" v-model="editForm.lepumingcheng" auto-complete="off" placeholder="请输入乐谱名称" style='width:50%' disabled></el-input></el-form-item>		<el-form-item  label="乐谱类别" prop="lepuleibie"><el-input size="small" v-model="editForm.lepuleibie" auto-complete="off" placeholder="请输入乐谱类别" style='width:50%' disabled></el-input></el-form-item>		<el-form-item  label="价格" prop="jiage"><el-input size="small" v-model="editForm.jiage" auto-complete="off" placeholder="请输入价格" style='width:50%' disabled></el-input></el-form-item>		<el-form-item  label="创作人" prop="chuangzuoren"><el-input size="small" v-model="editForm.chuangzuoren" auto-complete="off" placeholder="请输入创作人" style='width:50%' disabled></el-input></el-form-item>		<el-form-item  label="购买人" prop="goumairen"><el-input size="small" v-model="editForm.goumairen" auto-complete="off" placeholder="请输入购买人" style='width:50%' disabled></el-input></el-form-item>		
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">添加</el-button>
		</div>
	</div>
</template>

<script>
	import {goumaiEdit, goumaiSave,goumaiDetail} from "@/api/goumai/goumaiApi";
	import {Session} from "@/utils/storage";
import {lepuxinxiDetail,lepuxinxiEdit} from "../../api/lepuxinxi/lepuxinxiApi";
//xiabiaoduan1
export default {
	name: 'personal',
	data() {
		return {
			rules: {
				//yztssssss1
			},
			editForm: {
				avater:'',
				lepubianhao:'',				lepumingcheng:'',				lepuleibie:'',				jiage:'',				chuangzuoren:'',				
			},
			username:'',
			cx:'',
			//xiabiaoduan2
		};
	},
	created() {
		if (!Session.get('userInfo')) return false;
		this.userInfo = Session.get('userInfo');
		this.username=localStorage.getItem("username");
		this.cx=localStorage.getItem("cx");
		let id = this.$route.params.id;
		//xiabiaoduan3
		this.getUserInfo(id);
	},
	computed: {
		headers(){
			return {"token":Session.get("token")}
		},
	},
	methods:{
		getUserInfo(id){
			lepuxinxiDetail(id).then(res=>{
				if(res.code == '0'){
					this.lepuxinxi = res.data
					this.editForm.lepubianhao = this.lepuxinxi.lepubianhao;					this.editForm.lepumingcheng = this.lepuxinxi.lepumingcheng;					this.editForm.lepuleibie = this.lepuxinxi.lepuleibie;					this.editForm.jiage = this.lepuxinxi.jiage;					this.editForm.chuangzuoren = this.lepuxinxi.chuangzuoren;				
					this.editForm.goumairen= this.userInfo.yonghuming;
					
					
				}
			})
		},
		
		//qixuzhijixsuan3
		//xia2sui1
		// 编辑、增加页面保存方法
		submitForm(editData) {
			
			this.$refs[editData].validate(valid => {
				if (valid) {
					if(this.editForm.id){
						
					}else {
						goumaiSave(this.editForm).then(res => {
							if (res.code == '0') {
								
								this.$message({
									type: 'success',
									message: '添加成功！'
								})
							} else {
								this.$message({
									type: 'info',
									message: res.msg
								})
							}
						}).catch(err => {
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
		
		//youscwexnjiaxn
		//xiabiaoduan4
	}
};
</script>

<style scoped lang="scss">
	@import './index.scss';
</style>
