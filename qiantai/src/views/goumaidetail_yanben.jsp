<template>
  <div id="details">
    <!-- ͷ�� -->
    <div class="page-header">
      <div class="title" style="font-size: 14px;">
        <p>��ҳ>> �����б� >> ������ϸ </p>
      </div>
    </div>
    <div class="main">
      
      <div class="content">
<table width="100%" border="0"  align="center" cellpadding="3" cellspacing="1"  style="border-bottom: #c9c9c9 1px dashed; ">
								<tr>
        <td width='11%'  height='60px;'>���ױ�ţ�</td><td width='39%'  height='60px;'>{{goumaidetail.lepubianhao}}</td>     <td width='11%'  height='60px;'>�������ƣ�</td><td width='39%'  height='60px;'>{{goumaidetail.lepumingcheng}}</td></tr><tr>     <td width='11%'  height='60px;'>�������</td><td width='39%'  height='60px;'>{{goumaidetail.lepuleibie}}</td>     <td width='11%'  height='60px;'>�۸�</td><td width='39%'  height='60px;'>{{goumaidetail.jiage}}</td></tr><tr>     <td width='11%'  height='60px;'>�����ˣ�</td><td width='39%'  height='60px;'>{{goumaidetail.chuangzuoren}}</td>     <td width='11%'  height='60px;'>�����ˣ�</td><td width='39%'  height='60px;'>{{goumaidetail.goumairen}}</td></tr>     </tr>
</table>
        <div class="button">
<!--          <el-button class="shop-cart" :disabled="dis" @click="addShoppingCart">���빺�ﳵ</el-button>-->
          <el-button class="shop-cart" @click="addCollect">ϲ��</el-button>
        </div>

      </div>
    </div>
  </div>
</template>
<script>

  export default {
    data() {
      return {
        dis: false, // ���ơ����빺�ﳵ��ť�Ƿ���á�
        goumaiID:'',
        goumaidetail: "", // ��Ʒ��ϸ��Ϣ

      };
    },
    watch: {
      '$route' (to, from) {
        // ·�ɷ����仯ҳ��ˢ��
        this.$router.go(0);
      }
    },
    created() {
      this.goumaiID= this.$route.params.id;
      let id = this.$route.params.id;
      this.id = id;
      this.getDetails(id);
    },
    methods: {
		download(xx){location.href = "http://localhost:9999/"+xx;},
      // ��ȡ��Ʒ��ϸ��Ϣ
      getDetails(val) {
        this.$axios
                .get("/api/front/getgoumaidetail/"+val,)
                .then(res => {
                  debugger
                  this.goumaidetail = res.data.data;
                })
                .catch(err => {
                  return Promise.reject(err);
                });
      },
      // ���빺�ﳵ

      addCollect() {
        // �ж��Ƿ��¼,û�е�¼����ʾ��¼���
        if (!this.$store.getters.getUser) {
          this.$store.dispatch("setShowLogin", true);
          return;
        }
        debugger
        this.$axios
                .post("/api/front/addCollect", {
                  userId: this.$store.getters.getUser.id,
                  shangpinxinxiID: this.goumaiID
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
  /* ͷ��CSS */
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
  /* ͷ��CSS END */

  /* ��Ҫ����CSS */
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
  /* ��Ҫ����CSS END */
</style>

