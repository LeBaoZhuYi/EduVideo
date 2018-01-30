<template>
  <div class="login-wrap">
    <div class="begin">
      <el-button class="begin-button" @click="loginViewController()" type="text">点击登录</el-button>
    </div>
    <div v-show="loginShow" class="ms-login">
      <div class="login-bg"></div>
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="0px" class="demo-ruleForm">
        <el-form-item prop="loginName">
          <el-input v-model="ruleForm.loginName" placeholder="loginName"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input type="password" placeholder="password" v-model="ruleForm.password"
                    @keyup.enter.native="submitForm('ruleForm')"></el-input>
        </el-form-item>
        <div class="login-btn">
          <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
        </div>
        <p style="font-size:12px;line-height:30px;color:#999;">Tips : 填写学生登录名和密码。</p>
      </el-form>
    </div>
  </div>
</template>

<script>
  import crypto from 'crypto'

  export default {
    data: function () {
      return {
        loginShow: false,
        ruleForm: {
          loginName: '',
          password: ''
        },
        rules: {
          loginName: [
            {required: true, message: '请输入用户名', trigger: 'blur'}
          ],
          password: [
            {required: true, message: '请输入密码', trigger: 'blur'}
          ]
        }
      }
    },
    methods: {
      submitForm(formName) {
        let timeStamp = new Date().getTime();
        this.$refs[formName].validate((valid) => {
          if (!valid) {
            this.$message.success('参数有错误！');
            return false;
          }
        });
        let passwd = crypto.createHash("md5").update(this.ruleForm.password).digest("hex");
        let token = crypto.createHash("md5").update(passwd + String(timeStamp)).digest("hex");
        let url = "";
        // let url = "/api/user/login?loginName=" + this.ruleForm.loginName + "&token=" + token + "&timeStamp=" + timeStamp
        if (this.ruleForm.loginName != "test") {
          url = "/static/ErrorLoginName.json"
        } else if (this.ruleForm.password != "123456") {
          url = "/static/ErrorPassword.json"
        } else {
          url = "/static/Login.json"
        }
        this.$http.get(url)
          .then((response) => {
            if (response.data.status == 0) {
              this.setLocalStorage('loginName', response.data.data.loginName);
              this.setLocalStorage('userId', response.data.data.id);
              localStorage.setItem("isLogined", "true");
              this.$router.push('/user/video');
            } else if (response.data.status > 0) {
              this.$message.error('登录失败！' + response.data.msg);
            } else {
              this.$message.error('登录失败！请稍后再试或联系管理员');
            }
          });
      },
      loginViewController() {
        this.loginShow = !(this.loginShow);
      }
    }
  }
</script>

<style scoped>
  .begin {
    position: absolute;
    width: 200px;
    height: 180px;
    margin: -15% 80%;
    background-image: url("../assets/img/begin.png");
    background-size: contain;
    background-repeat: no-repeat;
  }

  .begin-button {
    position: relative;
    top: 19%;
    left: 19%;
    color: #00d1b2;
    font-size: 35px;
    font-family: fengbi;

  }

  .login-wrap {
    position: relative;
    margin-top: 25%;
    width: 100%;
    height: 100%;
    filter: alpha(Opacity=80);
    -moz-opacity: 0.8;
    opacity: 0.8;
  }

  .login-bg {
    position: relative;
    top: -15%;
    width: 100%;
    height: 40%;
    background-image: url("../assets/img/logo.jpg");
    background-repeat: no-repeat;

  }

  .ms-login {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 300px;
    height: 250px;
    margin: -150px 0 0 -190px;
    padding: 40px;
    border-radius: 5px;
    background: #fff;
  }

  .login-btn {
    text-align: center;
  }

  .login-btn button {
    width: 100%;
    height: 36px;
  }
</style>
