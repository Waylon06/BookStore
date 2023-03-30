<template>
  <div class="body">
    <div class="container">
      <div class="form-box" ref="form_box">
        <!-- 注册 -->
        <div :class="{ 'register-box': true, hidden: !isActive }">
          <h1>register</h1>
          <input type="text" placeholder="用户名" v-model="register.username" />
          <input type="email" placeholder="邮箱" v-model="register.email" />
          <input
            type="password"
            placeholder="密码"
            v-model="register.password"
          />
          <input type="password" placeholder="确认密码" />
          <button @click="clickRegister">注册</button>
        </div>
        <!-- 登录 -->
        <div :class="{ 'login-box': true, hidden: isActive }">
          <h1>login</h1>
          <input type="text" placeholder="用户名" v-model="login.username" />
          <input type="password" placeholder="密码" v-model="login.password" />
          <button @click="clickLogin">登录</button>
        </div>
      </div>
      <div class="con-box left">
        <h2>欢迎来到<span>畅悦书站</span></h2>
        <p>快来领取你的专属<span>知识</span>吧</p>
        <img src="@/assets/img/cat/1.png" alt="" />
        <p>已有账号</p>
        <button id="login" @click="goToLogin">去登录</button>
      </div>
      <div class="con-box right">
        <h2>欢迎来到<span>畅悦书站</span></h2>
        <p>快来看看你的丰富<span>图书</span>吧</p>
        <img src="@/assets/img/cat/2.png" alt="" />
        <p>没有账号？</p>
        <button id="register" @click="goToRegister">去注册</button>
      </div>
    </div>
  </div>
</template>

<script>
import { clickToSignInAPI, clickToSignUpAPI } from "@/api/data";
import { mapMutations } from "vuex";
export default {
  name: "LoginView",
  data() {
    return {
      login: {
        username: "",
        password: "",
      },
      register: {
        username: "",
        password: "",
        email: "",
      },
      isActive: false,
    };
  },
  methods: {
    ...mapMutations(["changeUserInfo", "changeIsLogined"]),
    goToRegister() {
      this.$refs.form_box.style.transform = "translateX(80%)";
      this.isActive = !this.isActive;
    },
    goToLogin() {
      this.$refs.form_box.style.transform = "translateX(0%)";
      this.isActive = !this.isActive;
    },
    async clickLogin() {
      if (this.login.username == "" || this.login.password == "") {
        alert("账号或者密码不能为空！");
      } else {
        let res = await clickToSignInAPI({
          username: this.login.username,
          password: this.login.password,
        });
        console.log(res);
        if (res.data.code == 200) {
          let userInfo = res.data.data
          sessionStorage.setItem("userInfo",JSON.stringify(userInfo) );
          this.changeUserInfo(userInfo);
          this.changeIsLogined(true)
          console.log(userInfo);
          this.$router.push("/");
        }
      }
    },
    async clickRegister() {
      if (
        this.register.username == "" ||
        this.register.password == "" ||
        this.register.email == ""
      ) {
        alert("账号或者密码以及邮箱不能为空！");
      } else {
        let userData = await clickToSignUpAPI({
          username: this.register.username,
          password: this.register.password,
          email: this.register.email,
        });
        console.log(userData);
        if (userData.data.code == 200) {
          sessionStorage.setItem("userInfo", userData.data.data);
          this.changeUserInfo(userData.data.data);
          this.$router.push("/");
        }
      }
    },
  },
};
</script>

<style lang="less" scoped>
* {
  /* 初始化 */
  margin: 0;
  padding: 0;
}
.body {
  /* 100%窗口高度 */
  height: 100vh;
  /* 弹性布局 水平+垂直居中 */
  display: flex;
  justify-content: center;
  align-items: center;
  /* 渐变背景 */
  background: linear-gradient(200deg, #bcbbbe, #3737a5);
}
.container {
  background-color: #fff;
  width: 650px;
  height: 415px;
  border-radius: 5px;
  /* 阴影 */
  box-shadow: 5px 5px 5px rgba(0, 0, 0, 0.1);
  /* 相对定位 */
  position: relative;
}
.form-box {
  /* 绝对定位 */
  position: absolute;
  top: -10%;
  left: 5%;
  background-color: #8b91ed;
  width: 320px;
  height: 500px;
  border-radius: 5px;
  box-shadow: 2px 0 10px rgba(0, 0, 0, 0.1);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 2;
  /* 动画过渡 加速后减速 */
  transition: 0.5s ease-in-out;
}
.register-box,
.login-box {
  /* 弹性布局 垂直排列 */
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
}
.hidden {
  display: none;
  transition: 0.5s;
}
h1 {
  text-align: center;
  margin-bottom: 25px;
  /* 大写 */
  text-transform: uppercase;
  color: #fff;
  /* 字间距 */
  letter-spacing: 5px;
}
input {
  background-color: transparent;
  width: 70%;
  color: #fff;
  border: none;
  /* 下边框样式 */
  border-bottom: 1px solid rgba(255, 255, 255, 0.4);
  padding: 10px 0;
  text-indent: 10px;
  margin: 8px 0;
  font-size: 14px;
  letter-spacing: 2px;
}
input::placeholder {
  color: #fff;
}
input:focus {
  color: #6b62ad;
  outline: none;
  border-bottom: 1px solid #7562ad80;
  transition: 0.5s;
}
input:focus::placeholder {
  opacity: 0;
}
.form-box button {
  width: 70%;
  margin-top: 35px;
  background-color: #f6f6f6;
  outline: none;
  border-radius: 8px;
  padding: 13px;
  color: #3e3ed8;
  letter-spacing: 2px;
  border: none;
  cursor: pointer;
}
.form-box button:hover {
  background-color: #423b8b;
  color: #f6f6f6;
  transition: background-color 0.5s ease;
}
.con-box {
  width: 50%;
  /* 弹性布局 垂直排列 居中 */
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  /* 绝对定位 居中 */
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
}
.con-box.left {
  left: -2%;
}
.con-box.right {
  right: -2%;
}
.con-box h2 {
  color: #8e9aaf;
  font-size: 25px;
  font-weight: bold;
  letter-spacing: 3px;
  text-align: center;
  margin-bottom: 4px;
}
.con-box p {
  font-size: 12px;
  letter-spacing: 2px;
  color: #8e9aaf;
  text-align: center;
}
.con-box span {
  color: #564ec6;
}
.con-box img {
  width: 150px;
  height: 150px;
  opacity: 0.9;
  margin: 40px 0;
}
.con-box button {
  margin-top: 3%;
  background-color: #fff;
  color: #7655cf;
  border: 1px solid #d3b7d8;
  padding: 6px 10px;
  border-radius: 5px;
  letter-spacing: 1px;
  outline: none;
  cursor: pointer;
}
.con-box button:hover {
  background-color: #30248c;
  color: #fff;
}
</style>