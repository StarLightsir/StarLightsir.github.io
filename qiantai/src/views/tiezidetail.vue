<template>
  <div id="details">
    <!-- 头部 -->
    <div class="page-header">
      <div class="title" style="font-size: 14px;">
        <p>首页>> 帖子列表 >> 帖子详细 </p>
      </div>
    </div>
    <div class="main">

      <div class="content">
<!--<table width="100%" border="0"  align="center" cellpadding="3" cellspacing="1"  style="border-bottom: #c9c9c9 1px dashed; ">-->
<!--								<tr>-->
<!--        <td width='11%'  height='60px;'>所属版块：</td><td width='39%'  height='60px;'>{{tiezidetail.suoshubankuai}}</td>-->
<!--     <td width='11%'  height='60px;'>标题：</td><td width='39%'  height='60px;'>{{tiezidetail.biaoti}}</td></tr><tr>-->
<!--     <td width='11%'  height='60px;'>内容：</td><td width='39%'  height='60px;'>{{tiezidetail.neirong}}</td>-->
<!--     <td width='11%'  height='60px;'>类型：</td><td width='39%'  height='60px;'>{{tiezidetail.leixing}}</td></tr><tr>-->
<!--     <td width='11%'>附件：</td><td width='39%'><el-button size='small' @click="download(tiezidetail.fujian)">点此下载</el-button></td>-->
<!--     <td width='11%'  height='60px;'>发帖人：</td><td width='39%'  height='60px;'>{{tiezidetail.fatieren}}</td></tr><tr>-->
<!--     <td width='11%'  height='60px;'>fid：</td><td width='39%'  height='60px;'>{{tiezidetail.fid}}</td></tr>-->

<!--</table>-->

          <table width="100%" border="1"  align="center" cellpadding="3" cellspacing="1" bordercolor="#CC6666" >
              <tr>
                  <td width='7%' height="35">标题：</td>
                  <td width='46%'><img width='30' height='30' src="../assets/bbs/jiaji.gif" border=0 v-if="tiezidetail.leixing=='jiaji'" />
                      <img width='30' height='30' src="../assets/bbs/putong.gif" border=0 v-if="tiezidetail.leixing=='putong'" />
                      <img width='30' height='30' src="../assets/bbs/qiuzhu.gif" border=0 v-if="tiezidetail.leixing=='qiuzhu'" />
                      <img width='30' height='30' src="../assets/bbs/tuijian.gif" border=0 v-if="tiezidetail.leixing=='tuijian'" />
                      {{tiezidetail.biaoti}} </td>
                  <td width='47%'>附件：<el-button size='small' @click="download(tiezidetail.fujian)" v-if="tiezidetail.fujian">点此下载</el-button></td>
              </tr>
              <tr>
                  <td width='7%' height="86">内容：</td>
                  <td width='93%' colspan="2">{{tiezidetail.neirong}}</td>
              </tr><tr>
              <td height="32" colspan="3">发布人：{{tiezidetail.fatieren}}  所属版块：{{tiezidetail.suoshubankuai}} &nbsp;&nbsp;点赞数:<a @click="dianzan_d_click()"><img src="../assets/bbs/ding.gif" width="40" height="40" /> {{tiezidetail.dianzan}} </a> </td>
          </tr>
          
          </table>

          <table width="100%" border="0"  align="center" cellpadding="3" cellspacing="1"   style="border-bottom: #c9c9c9 1px dashed; ">
              <tr>
                  <td colspan="2">已有回帖如下：</td>
              </tr>
              <tr v-for="item in huitie"  style="border-bottom: #c9c9c9 1px dashed; ">
                  <td width="23%"><p>回复人:{{item.fatieren}} </p>
                      <p>回复时间:{{item.addtime}}</p>
                  </td>
                  <td width="77%" height="75">{{item.neirong}}</td>
              </tr>

              <tr>
                  <td width="13%"></td>
                  <td colspan="2" align="center">
                      <el-button class="shop-cart" @click="handleEdit()">我也来回复一个</el-button>                  </td>
              </tr>
          </table>



          <div class="button">
<!--          <el-button class="shop-cart" :disabled="dis" @click="addShoppingCart">加入购物车</el-button>-->
<!--          <el-button class="shop-cart" @click="addCollect">喜欢</el-button>-->
        </div>


                  <el-dialog :title="title" :visible.sync="editFormVisible" width="30%">
                      <el-form label-width="120px" :model="editForm" :rules="rules" ref="editForm">
                          <el-form-item style="display: none"  label="所属版块" prop="suoshubankuai"><el-input size="small" v-model="editForm.suoshubankuai" auto-complete="off" placeholder="请输入所属版块" style='width:50%'></el-input></el-form-item>
                          <el-form-item style="display: none" label="标题" prop="biaoti"><el-input size="small" v-model="editForm.biaoti" auto-complete="off" placeholder="请输入标题" style='width:100%'></el-input></el-form-item>
                          <el-form-item  label="内容" prop="neirong"><el-input type="textarea" size="small" v-model="editForm.neirong" auto-complete="off" placeholder="请输入内容" style='width:100%'></el-input></el-form-item>
                          <el-form-item style="display: none" label="类型" prop="leixing"><el-input size="small" v-model="editForm.leixing" auto-complete="off" placeholder="请输入类型" style='width:50%'></el-input></el-form-item>
                          <el-form-item  style="display: none" label='附件' prop='fujian'><el-upload class='avatar-uploader' action='http://localhost:9999/files/uploadwenjian' :headers='headers' :show-file-list='false' :on-success='handleFujianSuccess' ><el-button>上传</el-button></el-upload></el-form-item>
                          <el-form-item  label="回帖人" prop="fatieren"><el-input size="small" v-model="editForm.fatieren" auto-complete="off" placeholder="请输入发帖人" style='width:50%' disabled></el-input></el-form-item>
                          <el-form-item style="display: none" label="fid" prop="fid"><el-input size="small" v-model="editForm.fid" auto-complete="off" placeholder="请输入fid" style='width:50%'></el-input></el-form-item>


                      </el-form>
                      <div slot="footer" class="dialog-footer">
                          <el-button size="small" @click="closeDialog">取消</el-button>
                          <el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">保存</el-button>
                      </div>
                  </el-dialog>



      </div>
    </div>
  </div>
</template>
<script>

  export default {
    data() {
      return {
        dis: false, // 控制“加入购物车按钮是否可用”
        tieziID:'',
        tiezidetail: "", // 商品详细信息
        huitie:[],
          bk:'',
        editFormVisible: false,
          editForm: {
          },
          user:[],
          username:'',
          cx:'',
      };
    },
    watch: {
      '$route' (to, from) {
        // 路由发生变化页面刷新
        this.$router.go(0);
      }
    },
    created() {
      this.tieziID= this.$route.params.id;
      let id = this.$route.params.id;
      this.id = id;
        console.log(id, "id");
      this.getDetails(id);
      this.loadHuitie(id);
        if (localStorage.getItem("user")) {
            // 如果已经登录，设置vuex登录状态
          //  this.setUser(JSON.parse(localStorage.getItem("user")));
            this.username=localStorage.getItem("username");
            this.cx=localStorage.getItem("cx");
        }
    },
    methods: {
		download(xx){location.href = "http://localhost:9999/"+xx;},
      // 获取商品详细信息
      getDetails(val) {
        this.$axios
                .get("/api/front/gettiezidetail/"+val)
                .then(res => {
                    console.log("detail", res.data.data);
                  this.tiezidetail = res.data.data;
                  this.bk=this.tiezidetail.suoshubankuai;
                })
                .catch(err => {
                  return Promise.reject(err);
                });
      },
        dianzan_d_click() {

            this.$axios.put('/api/front/tiezi', {id: this.tieziID, dianzan: this.tiezidetail.dianzan+1}).then(res => {
                if (res.data.code === '0') {
                    this.$message({
                        type: 'success',
                        message: '点赞成功！'
                    })
                    this.getDetails(this.tieziID);
                }
            })
        },
        submitForm(editData) {
            this.$refs[editData].validate(valid => {
                if (valid) {
                    if(this.editForm.id){
                    }else {
                        this.$axios
                            .post("/api/front/posttiezi/",this.editForm)
                            .then(res => {
                                if (res.data.code == '0') {
                                    this.$message({
                                        type: 'success',
                                        message: '添加成功！'
                                    });
                                    this.editFormVisible = false;
                                    this.loadHuitie(this.tieziID);
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

        handleEdit: function (index, row) {
            if (!this.$store.getters.getUser) {
                this.$store.dispatch("setShowLogin", true);
                return;
            }
            this.editFormVisible = true

                this.title = '我来回帖'
                this.editForm = {}
                this.editForm.fatieren=this.username;
                this.editForm.fid=this.tieziID;
            this.editForm.suoshubankuai=this.bk;

                //zixdonxgbianxhao1

        },
        closeDialog() {
            //this.getdata(this.formInline)
            this.editFormVisible = false
        },

        // openModel() {
        //     // if(this.user.level+"" == 'undefined'){
        //     //     alert("请先登录");
        //     //     return;
        //     // }
        //     //this.tieziInfo.tieziid = this.tieziid;
        //   //  this.huitieInfo.neirong = '';
        //     //$('#huitieModal').modal('show');
        // },

        loadHuitie(val) {
            this.$axios
                .get("/api/front/tiezi", {})

                .then(res => {

                    let data = res.data.data;
                    let filteredData = []; // 用于存储满足条件的数据
                   // let tt=0
                    // 遍历data数组
                    data.forEach(item => {
                       if (item.fid === val) {


                             filteredData.push(item);

                       }
                    });
                    this.huitie = filteredData;
                })
                .catch(err => {
                    return Promise.reject(err);
                });
        },
      // 加入购物车

      addCollect() {
        // 判断是否登录,没有登录则显示登录组件
        if (!this.$store.getters.getUser) {
          this.$store.dispatch("setShowLogin", true);
          return;
        }
        debugger
        this.$axios
                .post("/api/front/addCollect", {
                  userId: this.$store.getters.getUser.id,
                  shangpinxinxiID: this.tieziID
                })
                .then(res => {
                  if (res.data.code == "0") {
                    this.notifySucceed(res.data.msg);
                  } else {
                    this.notifyError(res.data.msg);
                  }
                })
                .catch(err => {
                  return Promise.reject(err);
                });
      }
    }
  };
</script>
<style>
  @import "../assets/css/index.scss";
  /* 头部CSS */
  #details .page-header {
    height: 64px;
    margin-top: -20px;
    z-index: 4;
    background: #fff;
    border-bottom: 1px solid #e0e0e0;
    -webkit-box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.07);
    box-shadow: 0px 5px 5px rgba(0, 0, 0, 0.07);
  }
  #details .page-header .title {
    width: 1225px;
    height: 64px;
    line-height: 64px;
    font-size: 18px;
    font-weight: 400;
    color: #212121;
    margin: 0 auto;
  }
  #details .page-header .title p {
    float: left;
  }
  #details .page-header .title .list {
    height: 64px;
    float: right;
  }
  #details .page-header .title .list li {
    float: left;
    margin-left: 20px;
  }
  #details .page-header .title .list li a {
    font-size: 14px;
    color: #616161;
  }
  #details .page-header .title .list li a:hover {
    font-size: 14px;
    color: #ff6700;
  }
  /* 头部CSS END */

  /* 主要内容CSS */
  #details .main {
    width: 1225px;
    height: 560px;
    padding-top: 30px;
    margin: 0 auto;
  }
  #details .main .block {
    float: left;
    width: 560px;
    height: 560px;
  }
  #details .el-carousel .el-carousel__indicator .el-carousel__button {
    background-color: rgba(163, 163, 163, 0.8);
  }
  #details .main .content {
    float: left;
    margin-left: 25px;
    width: 100%;
  }
  #details .main .content .name {
    height: 30px;
    line-height: 30px;
    font-size: 24px;
    font-weight: normal;
    color: #212121;
  }
  #details .main .content .intro {
    color: #b0b0b0;
    padding-top: 10px;
  }
  #details .main .content .store {
    color: #ff6700;
    padding-top: 10px;
  }
  #details .main .content .price {
    display: block;
    font-size: 18px;
    color: #ff6700;
    border-bottom: 1px solid #e0e0e0;
    padding: 25px 0 25px;
  }
  #details .main .content .price .del {
    font-size: 14px;
    margin-left: 10px;
    color: #b0b0b0;
    text-decoration: line-through;
  }
  #details .main .content .pro-list {
    background: #f9f9fa;
    padding: 30px 60px;
    margin: 50px 0 50px;
  }
  #details .main .content .pro-list span {
    line-height: 30px;
    color: #616161;
  }
  #details .main .content .pro-list .pro-price {
    float: right;
  }
  #details .main .content .pro-list .pro-price .pro-del {
    margin-left: 10px;
    text-decoration: line-through;
  }
  #details .main .content .pro-list .price-sum {
    color: #ff6700;
    font-size: 24px;
    padding-top: 20px;
  }
  #details .main .content .button {
    height: 55px;
    margin: 10px 0 20px 0;
  }
  #details .main .content .button .el-button {

    float: left;
    height: 55px;
    font-size: 16px;
    color: #fff;
    border: none;
    text-align: center;
  }
  #details .main .content .button .shop-cart {
    width: 340px;
    background-color: #ff6700;
  }
  #details .main .content .button .shop-cart:hover {
    background-color: #f25807;
  }

  #details .main .content .button .like {
    width: 260px;
    margin-left: 40px;
    background-color: #b0b0b0;
  }
  #details .main .content .button .like:hover {
    background-color: #757575;
  }
  #details .main .content .pro-policy li {
    float: left;
    margin-right: 20px;
    color: #b0b0b0;
  }
  /* 主要内容CSS END */
</style>
