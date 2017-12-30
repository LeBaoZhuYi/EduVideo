<template>
  <div>
    <div class="cl_login_box">

      <p id="errorMsg"></p>

      <div class="cl_login_head clearfix">

        <span>用户登录</span>

        <span class="quick_reg"><a data="/index/demoLogin" class="collectInfo" href="#">管理员登录</a></span>

      </div>

      <div class="cl_login_fill" id="divLogin">

        <input id="txtUserName" name="txtUserName" class="u_name" type="text" autocomplete="off" placeholder="用户名">

        <input id="txtPassword" name="txtPassword" class="u_pwd" type="password" autocomplete="off" placeholder="请输入密码">

        <div class="pwd_remember mt10 clearfix">

          <div class="lost_pwd fr"><a data="/index/forgetPasswd" class="collectInfo" href="javascript:void(0);" id="forget_password">忘记密码？</a></div>

        </div>

      </div>

      <div class="verified_name" id="divName" style="display: none">

        <input id="txtName" name="txtName" type="text" autocomplete="off" placeholder="请输入您的真实姓名">

        <p>您的密码为初始密码，为防止他人恶意操作，需要姓名验证！</p>

        <a href="javascript:void(0);" class="btnReturn">&lt;&lt;返回</a>

      </div>

      <a href="javascript:void(0);" id="signup_button">登 录</a>

      <br>
      <br>
      <br>

    </div>
  </div>
</template>

<style>
  @import url("../assets/css/container_login.css");
</style>

<script>
  export default{
    name: 'login',
    data(){
      return{
        showLogin: true,
        showRegister: false,
        showTishi: false,
        tishi: '',
        username: '',
        password: '',
        newUsername: '',
        newPassword: ''
      }
    }
  }
</script>
