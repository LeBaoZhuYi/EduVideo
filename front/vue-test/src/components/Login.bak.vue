<template>
  <div style="width:0px;height:100px;margin:0 auto;">
  <div id="container">
    <div class="welcome">
      <div class="login">学生登录</div>
      <div class="username-text">用户名:</div>
      <div class="password-text">密码:</div>
      <div class="username-field">
        <input type="text" name="username" placeholder="Username" :class="'log-input' + (loginName==''?' log-input-empty':'')" v-model="loginName">
        <!--<input type="text" name="username" value="azmind" />-->
      </div>
      <div class="password-field">
        <input type="password" name="password" placeholder="Password" :class="'log-input' + (password==''?' log-input-empty':'')" v-model="password">
        <!--<input type="password" name="password" value="azmind" />-->
      </div>
      <input type="checkbox" name="remember-me" id="remember-me" /><label for="remember-me">记住我</label>
      <div class="forgot-usr-pwd"><a href="#">忘记密码</a>?</div>
      <input type="submit" name="submit" value="GO" @click="login()" />
    </div>
  </div>
  </div>
</template>
<style>
  @import url("../assets/css/login.css");
</style>
<script>
  export default {
    name: 'Login',
    data() {
      return {
        isLoging: false,
        loginName: '',
        password: ''
      }
    },
    components: {
    },
    methods: {

      //登录逻辑
      login() {
        if (this.loginName != '' && this.password != '') {
          this.toLogin();
        }
        else{
          this.$alert('用户名或密码不能为空', '出错咯', {
            confirmButtonText: '确定'
          });
        }
      },//登录请求
      toLogin() {
        //一般要跟后端了解密码的加密规则
        //这里例子用的哈希算法来自./js/sha1.min.js
        let password_sha = '123456';//hex_sha1(hex_sha1(this.password));
        //需要想后端发送的登录参数
        let loginParam = {
          loginName: this.loginName,
          password: password_sha
        }
        //设置在登录状态
        this.isLoging = true;
        //请求后端
        this.$http.get('/api/user/login?loginName=' + loginParam.loginName + '&password=' + loginParam.password)
          .then((response) => {
          if(response.data.code == 1){
              //如果登录成功则保存登录状态并设置有效期
              let expireDays = 1000 * 60 * 60 * 24 * 15;
              this.setCookie('session', response.data.session, expireDays);
              //跳转
              this.$router.push('/user_info');
          }
        }, (response) =>{});
      }
    }
  }
</script>
