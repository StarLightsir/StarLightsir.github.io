﻿<template>
  <div id="myLogin">
    <el-dialog title="登录" width="300px" center :visible.sync="isLogin">
      <el-form :model="LoginUser" :rules="rules" status-icon ref="ruleForm" class="demo-ruleForm">
        <el-form-item prop="name">
          <el-input prefix-icon="el-icon-user-solid" placeholder="请输入账号" v-model="LoginUser.name"></el-input>
        </el-form-item>
        <el-form-item prop="pass">
          <el-input
                  prefix-icon="el-icon-view"
                  type="password"
                  placeholder="请输入密码"
                  v-model="LoginUser.pass"
          ></el-input>
        </el-form-item>
        <el-form-item prop="role">
          
		  <el-radio v-model='LoginUser.role' label='爱好者'>爱好者</el-radio>
<el-radio v-model='LoginUser.role' label='创作者'>创作者</el-radio>


        </el-form-item>
        <el-form-item>
          <el-button size="medium" type="primary" @click="Login" style="width:100%;">登录</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>
<script>
  import { mapActions } from "vuex";

  export default {
    name: "MyLogin",
    data() {
      return {
        rules: {
          name: [
            {required: true, message: '请输入用户名', trigger: 'blur'}
          ],
          pass: [
            {required: true, message: '请输入用户名', trigger: 'blur'}
          ],
        },
        LoginUser: {
          name: "",
          pass: "",
		  role:"创作者"
        },
        // 用户信息校验规则,validator(校验方法),trigger(触发方式),blur为在组件 Input 失去焦点时触发
      };
    },
    computed: {
      // 获取vuex中的showLogin，控制登录组件是否显示
      isLogin: {
        get() {
          return this.$store.getters.getShowLogin;
        },
        set(val) {
          this.$refs["ruleForm"].resetFields();
          this.setShowLogin(val);
        }
      }
    },
    methods: {
      ...mapActions(["setUser", "setShowLogin"]),
      Login() {
	  	let username=this.LoginUser.name;
        // 通过element自定义表单校验规则，校验用户输入的用户信息
        this.$refs["ruleForm"].validate(valid => {
          //如果通过校验开始登录
          if (valid) {
		  
            if (this.LoginUser.role === '爱好者') {
              this.$axios.post("/api/front/loginaihaozhe", {
                yonghuming: this.LoginUser.name,
                mima: this.LoginUser.pass
              })
                      .then(res => {
                        if (res.data.code === "0") {
                          this.isLogin = false;
                          let user = JSON.stringify(res.data.data);
                          localStorage.setItem("user", user);
                          this.setUser(res.data.data.user);
						  localStorage.setItem("username",username);
                          localStorage.setItem("cx", this.LoginUser.role);
                          this.notifySucceed(res.data.msg);
                          this.$router.go(0)
                        } else {
                          this.$refs["ruleForm"].resetFields();
                          this.notifyError(res.data.msg);
                        }
                      })
                      .catch(err => {
                        return Promise.reject(err);
                      });
            }
if (this.LoginUser.role === '创作者') {
              this.$axios.post("/api/front/loginchuangzuozhe", {
                zhanghao: this.LoginUser.name,
                mima: this.LoginUser.pass
              })
                      .then(res => {
                        if (res.data.code === "0") {
                          this.isLogin = false;
                          let user = JSON.stringify(res.data.data);
                          localStorage.setItem("user", user);
                          this.setUser(res.data.data.user);
						  localStorage.setItem("username",username);
                          localStorage.setItem("cx", this.LoginUser.role);
                          this.notifySucceed(res.data.msg);
                          this.$router.go(0)
                        } else {
                          this.$refs["ruleForm"].resetFields();
                          this.notifyError(res.data.msg);
                        }
                      })
                      .catch(err => {
                        return Promise.reject(err);
                      });
            }

			

          } else {
            return false;
          }
        });
      }
    }
  };
</script>
<style>
</style>
