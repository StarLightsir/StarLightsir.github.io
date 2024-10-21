
<template>
    <div class="order" style="height: 600px;">
        <div class="order-header">
            <div class="order-header-content">
                <p>
                    <i class="el-icon-s-order" style="font-size: 30px;color: #ff6700;"></i>
                    帖子
                </p>
            </div>
        </div>

        <div class="order-content">
            <div class="content">
                <el-form :inline="true" :model="formInline" class="user-search">
                    <el-form-item style="display: none"  label=""><el-input size="small" v-model="formInline.suoshubankuai" placeholder="输入所属版块"></el-input></el-form-item>
                    <el-form-item label=""><el-input size="small" v-model="formInline.biaoti" placeholder="输入标题"></el-input></el-form-item>
                    <el-form-item style="display: none" label=""><el-input size="small" v-model="formInline.fid" placeholder=""></el-input></el-form-item>

                    <el-form-item>
                        <el-button size="small" type="primary" icon="el-icon-search" @click="search">搜索</el-button>
                        <el-button size="small" type="primary" icon="el-icon-search"  @click="handleEdit()">发布新帖</el-button>
                    </el-form-item>
                </el-form>





<!--                <ul>-->

<!--                    <li class="header">-->
<!--                        <div class='pro-img'> 所属版块</div>-->
<!--                        <div class='pro-img'> 标题</div>-->

<!--                        <div class='pro-img'> 类型</div>-->
<!--                        <div class='pro-img'> 附件</div>-->
<!--                        <div class='pro-img'> 发帖人</div>-->



<!--                    </li>-->

<!--                    <li class="product-list" v-for="item in tiezi" :key="item.id">-->
<!--                        <router-link :to="`/tiezidetail/`+item.id" >-->
<!--                            <div class='pro-img'>{{item.suoshubankuai}}</div>-->
<!--                            <div class='pro-img'>{{item.biaoti}}</div>-->
<!--                            <div class='pro-img'>{{item.neirong}}</div>-->
<!--                            <div class='pro-img'>{{item.leixing}}</div>-->
<!--                            <div class='pro-img'>{{item.fujian}}</div>-->




<!--                        </router-link>-->
<!--                    </li>-->
<!--                </ul>-->
                <div class="order-bar">
                    <table width="100%" border="0"  align="center" cellpadding="3" cellspacing="1" class="newsline">
                        <thead>
                        <tr>
                            <th align="left">ID</th>
<!--                            <th align="left" >所属版块</th>-->
                            <th align="left" >标题</th>
                            <th align="left" >类型</th>
                            <th align="left" >发帖人</th>
                            <th align="left" >附件</th>
                            <th align="left">操作</th>
                        </tr>
                        </thead>
                        <tbody v-for="item in tiezi" :key="item.id">
                        <tr style="height: 50px;">
                            <td align="left">{{item.id}}</td>
<!--                            <td align="left">{{item.suoshubankuai}}</td>-->
                            <td align="left">{{item.biaoti}}</td>
                            <td align="left"><img width='30' height='30' src="../assets/bbs/jiaji.gif" border=0 v-if="item.leixing=='jiaji'" />
                                <img width='30' height='30' src="../assets/bbs/putong.gif" border=0 v-if="item.leixing=='putong'" />
                                <img width='30' height='30' src="../assets/bbs/qiuzhu.gif" border=0 v-if="item.leixing=='qiuzhu'" />
                                <img width='30' height='30' src="../assets/bbs/tuijian.gif" border=0 v-if="item.leixing=='tuijian'" />                            </td>
                            <td align="left">{{item.fatieren}}</td>
                            <td align="left"><el-button size='small' @click="download(item.fujian)" v-if="item.fujian">点此下载</el-button></td>

                            <td align="left">
                                <router-link :to="`/tiezidetail/`+item.id" >详细</router-link>                          </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <el-dialog :title="title" :visible.sync="editFormVisible" width="30%">
                    <el-form label-width="120px" :model="editForm" :rules="rules" ref="editForm">
                        <el-form-item style="display: none"  label="所属版块" prop="suoshubankuai"><el-input size="small" v-model="editForm.suoshubankuai" auto-complete="off" placeholder="请输入所属版块" style='width:50%'></el-input></el-form-item>
                        <el-form-item  label="标题" prop="biaoti"><el-input size="small" v-model="editForm.biaoti" auto-complete="off" placeholder="请输入标题" style='width:100%'></el-input></el-form-item>
                        <el-form-item  label="内容" prop="neirong"><el-input type="textarea" size="small" v-model="editForm.neirong" auto-complete="off" placeholder="请输入内容" style='width:100%'></el-input></el-form-item>
                        <el-form-item prop="leixing"  label="类型">
                            <el-radio v-model='editForm.leixing' label='putong'>普通</el-radio>
                            <el-radio v-model='editForm.leixing' label='jiaji'>加急</el-radio>
                            <el-radio v-model='editForm.leixing' label='qiuzhu'>求助</el-radio>
                            <el-radio v-model='editForm.leixing' label='tuijian'>推荐</el-radio>


                        </el-form-item>
<!--                        <el-form-item  label="类型" prop="leixing">-->

<!--                            <el-input size="small" v-model="editForm.leixing" auto-complete="off" placeholder="请输入类型" style='width:50%'></el-input></el-form-item>-->
                        <el-form-item label='附件' prop='fujian'><el-upload class='avatar-uploader' action='/api/files/front/uploadwenjian' :headers='headers' :show-file-list='false' :on-success='handleFujianSuccess' ><el-button>上传</el-button></el-upload></el-form-item>
                        <el-form-item  label="发帖人" prop="fatieren"><el-input size="small" v-model="editForm.fatieren" auto-complete="off" placeholder="请输入发帖人" style='width:50%' disabled></el-input></el-form-item>
                        <el-form-item style="display: none" label="fid" prop="fid"><el-input size="small" v-model="editForm.fid" auto-complete="off" placeholder="请输入fid" style='width:50%'></el-input></el-form-item>


                    </el-form>
                    <div slot="footer" class="dialog-footer">
                        <el-button size="small" @click="closeDialog">取消</el-button>
                        <el-button size="small" type="primary" :loading="loading" class="title" @click="submitForm('editForm')">保存</el-button>
                    </div>
                </el-dialog>

            </div>
            <div style="margin-top:-40px;"></div>
        </div>



    </div>
</template>

<script>
    export default {
        data() {
            return {
                tiezi: "", // 数据列表
                userInfo:{},
                total: 0, // 商品总量
                currentPage:0,
                currentNum: 10, // 每页显示的商品数量
                current: 1, //当前页码
                activeName: "-1", // 分类列表当前选中的id
                formInline: {
                    page: 1,
                    limit: 10,
                },
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
            '$route'(to, from) {
                this.$router.go(0)
            },
        },
        created() {
            if (localStorage.getItem("user")) {
                // 如果已经登录，设置vuex登录状态
                //  this.setUser(JSON.parse(localStorage.getItem("user")));
                this.username=localStorage.getItem("username");
                this.cx=localStorage.getItem("cx");
            }
            this.id= this.$route.params.id;
            this.formInline.suoshubankuai= this.id;
            this.formInline.fid= "0";
            this.gettiezi(this.formInline);
        },
        activated() {
            this.activeName = "-1"; // 初始化分类列表当前选中的id为-1
            this.total = 0; // 初始化商品总量为0
            this.current = 1; //初始化当前页码为1
        },

        methods: {
            // 页码变化调用currentChange方法
            currentChange(current) {
                this.current = current;
                if (this.productName != "") {
                    this.getProductBySearch();
                } else {
                    this.getData();
                }
                this.backtop();
            },
            search() {
                this.gettiezi(this.formInline)
            },
            download(xx){location.href = "http://localhost:9999/"+xx;},
            // 向后端请求分类列表数据
            gettiezi(parameter) {
                this.$axios
                    .post("/api/front/tiezi", {...parameter})
                    .then(res => {

                        this.tiezi = res.data.data.list;
                        this.currentPage = this.formInline.current
                        this.pageSize = this.formInline.currentNum
                        this.total = res.data.data.total
                    })
                    .catch(err => {
                        return Promise.reject(err);
                    });
            },
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
            // download(data){
            //     location.href = data.fujian;
            // },
            submitForm(editData) {
                this.$refs[editData].validate(valid => {
                    if (valid) {
                        if(this.editForm.id){
                        }else {
                            // debugger
                            console.log(this.editForm, "sdsad");
                            this.$axios
                                .post("/api/front/posttiezi/",this.editForm)
                                .then(res => {
                                    if (res.data.code == '0') {



                                        this.$message({
                                            type: 'success',
                                            message: '添加成功！'
                                        });
                                        this.editFormVisible = false;
                                        this.gettiezi(this.formInline);
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

                this.title = '发布新帖'
                this.editForm = { leixing: 'putong',}
                this.editForm.fatieren=this.username;
                this.editForm.fid=0;
                this.editForm.suoshubankuai=this.id;

                //zixdonxgbianxhao1

            },
            closeDialog() {
                //this.getdata(this.formInline)
                this.editFormVisible = false
            },



        }
    };
</script>
<style scoped>
    * {
        background: #fff;
        color: #444;
        font-family: "Open Sans", sans-serif;
    }
    .order {
        background-color: #f5f5f5;
        padding-bottom: 20px;
    }
    /* 我的订单头部CSS */
    .order .order-header {
        height: 64px;
        border-bottom: 2px solid #ff6700;
        background-color: #fff;
        margin-bottom: 20px;
    }
    .order .order-header .order-header-content {
        width: 1225px;
        margin: 0 auto;
    }
    .order .order-header p {
        font-size: 28px;
        line-height: 58px;
        float: left;
        font-weight: normal;
        color: #424242;
    }
    /* 我的订单头部CSS END */
    .order .content {
        width: 1225px;
        margin: 0 auto;
        background-color: #fff;
        margin-bottom: 50px;
    }

    .order .content ul {
        background-color: #fff;
        color: #424242;
        line-height: 85px;
    }
    /* 我的订单表头CSS */
    .order .content ul .order-info {
        height: 60px;
        line-height: 60px;
        padding: 0 26px;
        color: #424242;
        border-bottom: 1px solid #ff6700;
    }
    .order .content ul .order-info .order-id {
        float: left;
        color: #ff6700;
    }
    .order .content ul .order-info .order-time {
        float: right;
    }

    .order .content ul .header {
        height: 85px;
        padding-right: 26px;
        color: #424242;
    }
    /* 我的订单表头CSS END */

    /* 订单列表CSS */
    .order .content ul .product-list {
        height: 85px;
        padding: 15px 26px 15px 0;
        border-top: 1px solid #e0e0e0;
    }
    .order .content ul .pro-img {
        float: left;
        height: 45px;
        width: 120px;
        padding-left: 80px;
    }
    .order .content ul .pro-img img {
        height: 80px;
        width: 80px;
    }
    .order .content ul .pro-name {
        float: left;
        width: 380px;
    }
    .order .content ul .pro-name a {
        color: #424242;
    }
    .order .content ul .pro-name a:hover {
        color: #ff6700;
    }
    .order .content ul .pro-price {
        float: left;
        width: 160px;
        padding-right: 18px;
        text-align: center;
    }
    .order .content ul .pro-num {
        float: left;
        width: 190px;
        text-align: center;
    }
    .order .content ul .pro-total {
        float: left;
        width: 160px;
        padding-right: 81px;
        text-align: right;
    }
    .order .content ul .pro-total-in {
        color: #ff6700;
    }

    .order .order-bar {
        width: 1185px;
        padding: 0 20px;
        border-top: 1px solid #ff6700;
        height: 50px;
        line-height: 50px;
        background-color: #fff;
    }
    .order .order-bar .order-bar-left {
        float: left;
    }
    .order .order-bar .order-bar-left .order-total {
        color: #757575;
    }
    .order .order-bar .order-bar-left .order-total-num {
        color: #ff6700;
    }
    .order .order-bar .order-bar-right {
        float: right;
    }
    .order .order-bar .order-bar-right .total-price-title {
        color: #ff6700;
        font-size: 14px;
    }
    .order .order-bar .order-bar-right .total-price {
        color: #ff6700;
        font-size: 30px;
    }
    /* 订单列表CSS END */

    /* 订单为空的时候显示的内容CSS */
    .order .order-empty {
        width: 1225px;
        margin: 0 auto;
    }
    .order .order-empty .empty {
        height: 300px;
        padding: 0 0 130px 558px;
        margin: 65px 0 0;
        background: url(../assets/imgs/cart-empty.png) no-repeat 124px 0;
        color: #b0b0b0;
        overflow: hidden;
    }
    .order .order-empty .empty h2 {
        margin: 70px 0 15px;
        font-size: 36px;
    }
    .order .order-empty .empty p {
        margin: 0 0 20px;
        font-size: 20px;
    }
    /* 订单为空的时候显示的内容CSS END */
</style>
