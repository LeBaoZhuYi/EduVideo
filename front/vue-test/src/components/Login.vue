<template>
  <div class="">
    <el-form :inline="true" :model="ruleForm" :rules="rules" ref="ruleForm" class="demo-ruleForm">
      <el-form-item prop="loginName">
        <el-input v-model="ruleForm.loginName" placeholder="学员登录"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input type="password" placeholder="密码" v-model="ruleForm.password"
                  @keyup.enter.native="submitForm('ruleForm')"></el-input>
      </el-form-item>
      <el-form-item>
        <div class="login-btn">
          <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
        </div>
      </el-form-item>
    </el-form>
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
        loginUrl: '/api/user/login'
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
              this.setCookie('token', response.data.data, 1);
              window.location.href = "/home";
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

  .demo-ruleForm {
    position: absolute;
    right: 1%;
    top: 27%;
  }

  .el-form-item {
    width: 30%;
  }

  .login-btn {
    text-align: center;
  }

  .login-btn {
    width: 30%;
  }
</style>
