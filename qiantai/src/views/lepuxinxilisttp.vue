<template>
  <div class="goods" id="goods" name="goods">
    <div class="breadcrumb">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item to="/">首页</el-breadcrumb-item>
        <el-breadcrumb-item>乐谱信息</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="main">
      <div class="list">
        <el-form :inline="true" :model="formInline" class="user-search">
<!--          <el-form-item label=""><el-input size="small" v-model="formInline.lepubianhao" placeholder="输入乐谱编号"></el-input></el-form-item>-->
            <el-form-item   prop="lepufenlei"><el-select size="small" v-model="formInline.lepufenlei" placeholder="请选择乐谱分类"><el-option selected label="请选择乐谱分类" value=""></el-option><el-option label="五线谱" value="五线谱"></el-option><el-option label="六线谱" value="六线谱"></el-option><el-option label="简谱" value="简谱"></el-option></el-select></el-form-item>
            <el-form-item   prop="leqi"><el-select size="small" v-model="formInline.leqi" placeholder="请选择乐器"><el-option selected label="请选择乐器" value=""></el-option><el-option label="钢琴" value="钢琴"></el-option><el-option label="电子琴" value="电子琴"></el-option><el-option label="手风琴" value="手风琴"></el-option><el-option label="萨克斯" value="萨克斯"></el-option><el-option label="长笛" value="长笛"></el-option><el-option label="铜管" value="铜管"></el-option><el-option label="吉他" value="吉他"></el-option><el-option label="古筝" value="古筝"></el-option><el-option label="葫芦丝" value="葫芦丝"></el-option><el-option label="胡琴" value="胡琴"></el-option><el-option label="琵琶" value="琵琶"></el-option><el-option label="口琴" value="口琴"></el-option></el-select></el-form-item>
            <el-form-item>
            <el-button size="small" type="primary" icon="el-icon-search" @click="search">搜索</el-button>
          </el-form-item>
        </el-form>
        <lepuxinxilisttp :list="lepuxinxi" v-if="lepuxinxi.length>0"></lepuxinxilisttp>
          <div v-else class="none-product">抱歉没有找到相关的数据</div>
      </div>
      <div class="pagination">
        <el-pagination background  layout="prev, pager, next"  :current-page="currentPage"  :page-size="currentNum"  :total="total"  @current-change="currentChange"></el-pagination>
      </div>
    </div>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        lepuxinxi: "", // 商品列表
        total: 0, // 商品总量
        currentPage:0,
        currentNum: 10, // 每页显示的商品数量
        current: 1, //当前页码
        activeName: "-1", // 分类列表当前选中的id
        formInline: {
          page: 1,
          limit: 10,
        },
      };
    },
    created() {
      this.getlepuxinxi();
    },
    activated() {
    },
    methods: {
      currentChange(val) {
        this.formInline.current = val
        this.getlepuxinxi(this.formInline)
      },
      search() {
        this.getlepuxinxi(this.formInline)
      },
      getlepuxinxi(parameter) {
        this.$axios
                .post("/api/front/lepuxinxi", {...parameter})
                .then(res => {
                  this.lepuxinxi = res.data.data.list;
                  this.currentPage = this.formInline.current
                  this.pageSize = this.formInline.currentNum
                  this.total = res.data.data.total
                })
                .catch(err => {
                  return Promise.reject(err);
                });
      },
    },
  };
</script>
<style scoped>
  .goods {
    background-color: #f5f5f5;
  }
  .el-tabs--card .el-tabs__header {
    border-bottom: none;
  }
  .goods .breadcrumb {
    height: 50px;
    background-color: white;
  }
  .goods .breadcrumb .el-breadcrumb {
    width: 1225px;
    line-height: 30px;
    font-size: 16px;
    margin: 0 auto;
  }
  .goods .nav {
    background-color: white;
  }
  .goods .nav .product-nav {
    width: 1225px;
    height: 40px;
    line-height: 40px;
    margin: 0 auto;
  }
  .nav .product-nav .title {
    width: 50px;
    font-size: 16px;
    font-weight: 700;
    float: left;
  }
  .goods .main {
    margin: 0 auto;
    max-width: 1225px;
  }
  .goods .main .list {
    min-height: 650px;
    padding-top: 14.5px;
    margin-left: -13.7px;
    overflow: auto;
  }
  .goods .main .pagination {
    height: 50px;
    text-align: center;
  }
  .goods .main .none-product {
    color: #333;
    margin-left: 13.7px;
  }
</style>