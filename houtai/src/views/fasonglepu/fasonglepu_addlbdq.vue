<template>
	<div class="personal">
		<el-form label-width="100px" ref="editForm" :model="editForm" :rules="rules">
			<el-form-item  label="乐谱编号" prop="lepubianhao"><el-input size="small" v-model="editForm.lepubianhao" auto-complete="off" placeholder="请输入乐谱编号" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="乐谱名称" prop="lepumingcheng"><el-input size="small" v-model="editForm.lepumingcheng" auto-complete="off" placeholder="请输入乐谱名称" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="乐谱类别" prop="lepuleibie"><el-input size="small" v-model="editForm.lepuleibie" auto-complete="off" placeholder="请输入乐谱类别" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="创作人" prop="chuangzuoren"><el-input size="small" v-model="editForm.chuangzuoren" auto-complete="off" placeholder="请输入创作人" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label="购买人" prop="goumairen"><el-input size="small" v-model="editForm.goumairen" auto-complete="off" placeholder="请输入购买人" style='width:50%' disabled></el-input></el-form-item>
		<el-form-item  label='乐谱传送' prop='lepuchuansong'><el-upload class='avatar-uploader' action='http://localhost:9999/files/uploadwenjian' :headers='headers' :show-file-list='false' :on-success='handleLepuchuansongSuccess' ><el-button>上传</el-button></el-upload></el-form-item>
		
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">添加</el-button>
		</div>
	</div>
</template>

<script>
	import {fasonglepuEdit, fasonglepuSave,fasonglepuDetail} from "@/api/fasonglepu/fasonglepuApi";
	import {Session} from "@/utils/storage";
import {goumaiDetail,goumaiEdit} from "../../api/goumai/goumaiApi";
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
				lepubianhao:'',
				lepumingcheng:'',
				lepuleibie:'',
				chuangzuoren:'',
				goumairen:'',
				
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
			goumaiDetail(id).then(res=>{
				if(res.code == '0'){
					this.goumai = res.data
					this.editForm.lepubianhao = this.goumai.lepubianhao;
					this.editForm.lepumingcheng = this.goumai.lepumingcheng;
					this.editForm.lepuleibie = this.goumai.lepuleibie;
					this.editForm.chuangzuoren = this.goumai.chuangzuoren;
					this.editForm.goumairen = this.goumai.goumairen;
				
					this.editForm.chuangzuoren= this.userInfo.zhanghao;
					
					
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
						fasonglepuSave(this.editForm).then(res => {
							if (res.code == '0') {

								this.goumai.issh=1;
								goumaiEdit(this.goumai).then(res => {
									this.editFormVisible = false
									this.loading = false
									if (res.code == '0') {
										this.getdata(this.formInline)

									}
								})

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
		
		handleLepuchuansongSuccess(res, file) {
				if(res.code == "0") {
					this.editForm.lepuchuansong = "/files/download/"+res.data.id
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
			location.href = data.lepuchuansong;
		},
				//youscwexnjiaxn
		//xiabiaoduan4
	}
};
</script>

<style scoped lang="scss">
	@import './index.scss';
</style>
