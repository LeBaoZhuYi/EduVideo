<template>
  <div class="login-wrap">
    <div class="begin">
      <el-button class="begin-button" @click="loginViewController()" type="text">开始</el-button>
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
        const self = this;
        let timeStamp = new  Date().getTime();
        self.$refs[formName].validate((valid) => {
          if (!valid) {
            this.$message.success('参数有错误！');
            return false;
          }
        });
        self.$router.push('/user/video');
        return;
        self.$http.get('/api/user/login?loginName=' + self.ruleForm.loginName + '&password=' + self.ruleForm.password + '&timeStamp=' + timeStamp)
          .then((response) => {
            if (response.data.code == 1) {
              //如果登录成功则保存登录状态并设置有效期
              let expireDays = 1000 * 60 * 60 * 24 * 15;
              self.setCookie('session', response.data.session, expireDays);
              localStorage.setItem('loginName', self.ruleForm.loginName);
              //跳转
              self.$router.push('/user/video');
            }
            else{
              this.$message.success('登录失败！');
            }
          }, (response) => {
            this.$message.success('登录失败！');
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
    width: 150px;
    height: 100px;
    margin: -240px 900px;
    background-image: url("../assets/img/begin.png");
  }

  @font-face {
    font-family: myFirstFont;
    src: url('../assets/temp/test.ttf')
  }

  .begin-button {
    position: relative;
    top: 19%;
    left: 29%;
    color: #00d1b2;
    font-size: 35px;
    font-family: myFirstFont;

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
