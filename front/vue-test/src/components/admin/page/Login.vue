<template>
  <div class="login-wrap">
    <div class="ms-title">后台管理系统</div>
    <div class="ms-login">
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
        <p style="font-size:12px;line-height:30px;color:#999;">Tips : 用户名和密码随便填。</p>
      </el-form>
    </div>
  </div>
</template>

<script>
  import crypto from 'crypto'

  export default {
    data: function () {
      return {
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
        },
        loginUrl: '/api/admin/user/login'
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
        // let url = "";
        // let url = "?loginName=" + this.ruleForm.loginName + "&token=" + token + "&timeStamp=" + timeStamp
        // if (this.ruleForm.loginName != "test") {
        //   url = "/static/ErrorLoginName.json"
        // } else if (this.ruleForm.password != "123456") {
        //   url = "/static/ErrorPassword.json"
        // } else {
        //   url = "/static/Login.json"
        // }
        this.$http.get(this.loginUrl, {
          params: {
            loginName: this.ruleForm.loginName,
            token: token,
            timeStamp: timeStamp
          }
        })
          .then((response) => {
            if (response.data.status == 0) {
              this.setCookie('adminToken', response.data.data, 1);
              window.location.href = "/admin/home";
            } else if (response.data.status > 0) {
              this.$message.error('登录失败！' + response.data.msg);
            } else {
              this.$message.error('登录失败！请稍后再试或联系管理员');
            }
          });
      }
    }
  }
</script>

<style scoped>
  .login-wrap {
    position: relative;
    width: 100%;
    height: 100%;
  }

  .ms-title {
    position: absolute;
    top: 50%;
    width: 100%;
    margin-top: -230px;
    text-align: center;
    font-size: 30px;
    color: #fff;

  }

  .ms-login {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 300px;
    height: 160px;
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
