<template>
  <div style="font-family: fengbi">
    <el-container>
      <home-header :activeIndex="'4'"></home-header>
      <el-main>
        <el-form v-model="form">
          <el-form-item label="确认登录名">
            <el-input v-model="form.loginName"></el-input>
          </el-form-item>
          <el-form-item label="旧密码">
            <el-input v-model="form.oldPassword"></el-input>
          </el-form-item>
          <el-form-item label="新密码">
            <el-input v-model="form.newPassword"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="updatePassword()">提交</el-button>
          </el-form-item>
        </el-form>
      </el-main>
      <el-footer></el-footer>
    </el-container>
  </div>
</template>

<style>
  .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }

</style>
<script>
  import HomeHeader from './HomeHeader.vue'
  import qs from 'qs';
  import ElMain from "../../node_modules/element-ui/packages/main/src/main.vue";
  import ElFooter from "../../node_modules/element-ui/packages/footer/src/main.vue";
  import ElInput from "../../node_modules/element-ui/packages/input/src/input.vue";

  export default {
    data() {
      return {
        updatePasswordUrl: '/api/user/updatePassword',
        form: {
          loginName: "",
          oldPassword: "",
          newPassword: "",
          token: ""
        },
        checkLoginTimer: null
      }
    },
    components: {
      ElInput,
      ElFooter,
      ElMain,
      HomeHeader
    },
    beforeMount() {
      let token = this.getCookie("token");
      if (token == null) {
        this.$alert("获取用户信息失败！当前用户为空，请重新登录", "错误");
        this.$router.push('/');
        return;
      }
      this.checkLoginTimer = setInterval(this.checkLogin, 5000)
      this.form.token = token;
    },
    methods: {
      updatePassword: function () {
        let postData = qs.stringify(this.form);
        this.$http.post(this.updatePasswordUrl, postData).then((response) => {
            if (response.data.status == 0) {
              this.$alert('修改成功！', '提示', {
                confirmButtonText: '确定',
                callback: action => {
                  this.clearCookie('token');
                  window.location.href = "/home";
                }
              });
            } else if (response.data.status > 0) {
              this.$message.error('修改失败！' + response.data.msg);
            } else {
              this.$message.error('修改失败！请稍后再试或联系管理员');
            }
          });
      },
      checkLogin(){
        let checkUrl = '/api/user/checkLogin';
        this.$http.get(checkUrl).then((response) => {
          if (response.data.status != 0) {
            this.$alert("您已被踢下线", "错误");
            clearInterval(this.checkLoginTimer);
            window.location.href = "/noAuth";
            return;
          }
        });
      }
    }
  }
</script>
