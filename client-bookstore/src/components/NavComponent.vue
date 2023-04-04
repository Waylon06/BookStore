<template>
  <div class="w">
    <el-row>
      <el-col :span="12">
        <div class="grid-content">
          <div class="logo">
            <img src="../assets/logo.png" />
          </div>
        </div>
      </el-col>
      <el-col :span="12">
        <div class="grid-content">
          <el-menu
            :default-active="$route.path"
            class="el-menu-demo"
            mode="horizontal"
            @select="handleSelect"
            background-color="#567487"
            text-color="#fff"
            active-text-color="#ffd04b"
            router
          >
            <el-menu-item index="/home"
              >首页</el-menu-item
            >
            <!-- <el-submenu index="2" disabled>
              <template slot="title">我的工作台</template>
              <el-menu-item index="2-1">选项1</el-menu-item>
              <el-menu-item index="2-2">选项2</el-menu-item>
              <el-menu-item index="2-3">选项3</el-menu-item>
              <el-submenu index="2-4">
                <template slot="title">选项4</template>
                <el-menu-item index="2-4-1">选项1</el-menu-item>
                <el-menu-item index="2-4-2">选项2</el-menu-item>
                <el-menu-item index="2-4-3">选项3</el-menu-item>
              </el-submenu>
            </el-submenu> -->
            <el-menu-item index="/notice"
              >公告栏</el-menu-item
            >
            <el-menu-item index="/cart" 
              >购物车</el-menu-item
            >
            <el-menu-item index="/order">我的订单</el-menu-item>
            <div class="login">
              <router-link to="/login" v-show="!isLogined">登录</router-link>
              <div v-show="isLogined">{{userInfo.username}} <el-button icon="el-icon-close" size="mini" type="danger" circle @click="logout"></el-button> </div>
            </div>
          </el-menu>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { mapState, mapMutations } from "vuex";
export default {
  data() {
    return {
      activeIndex: "1",
      activeIndex2: "1",
    };
  },
  mounted() {
    if(sessionStorage.getItem("userInfo")) {
      let res = sessionStorage.getItem("userInfo")
      this.changeUserInfo(JSON.parse(res))
    }
  },
  methods: {
    ...mapMutations(["changeUserInfo"]),
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
    logout() {
      sessionStorage.removeItem("userInfo")
      this.$router.go(0)
    }
  },
   computed: {
      ...mapState(["isLogined", "userInfo"])
    },
};
</script>

<style lang="less" scoped>
.el-row {
  // background-color: #999999;
  // background-color: rgb(28, 45, 37);
  // background-color: #426666;
  background-color: #567487;
}
.logo {
  padding-left: 40px;
  height: 60px;
  width: 160px;
  img {
    width: 100%;
    height: 100%;
  }
}

.login {
  color: #fff;
  line-height: 60px;
  font-size: 14px;
}
</style>