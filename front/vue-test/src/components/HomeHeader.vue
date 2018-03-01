<template>
  <div>
    <el-header>
      <img class="logo" src="../assets/img/logo.png"/>
      <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal">
        <el-menu-item index="1" @click="open('/');">主页</el-menu-item>
        <el-menu-item index="2" @click="open('/home');">今日课程</el-menu-item>
        <el-menu-item index="3" @click="open('/person');">个人中心</el-menu-item>
        <el-menu-item index="4" @click="open('/updatePassword');">修改密码</el-menu-item>
        <el-menu-item index="4" @click="logout();">退出登录</el-menu-item>
      </el-menu>
    </el-header>
    <div class="header-line"></div>
  </div>
</template>
<style>
  .header-line {
    height: 5px;
    background-color: #00d1b2;
  }

  .logo {
    position: relative;
    margin-left: 5%;
    margin-right: 5%;
    float: left;
    z-index: 999;
  }

  .el-menu {;
    active-text-color: #00d1b2;
  }

  .el-menu-item {
    font-size: 25px;
  }

  .el-menu--horizontal > .el-menu-item.is-active, .el-menu--horizontal > .el-submenu.is-active .el-submenu__title {
    border-bottom: 0px;
  }
</style>
<script>
  export default {
    name: "homeHeader",
    props: {
      activeIndex: {
        type: String,
        require: false
      }
    },
    data() {
      return {
        logoutUrl: '/api/user/logout'
      };
    },
    methods: {
      open: function (path) {
//        window.open(path);
//        this.$router.push(path);
        window.location.href = path;
      },

      logout: function (path) {
        this.$confirm('是否确认退出?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          let token = this.getCookie("token");
          this.$http.get(this.logoutUrl, {
            params: {
              token: token
            }
          }).then((response) => {
            if (response.data.status == 0) {
              this.clearCookie('token');
              window.location.href = "/";
              return;
            } else if (response.data.status > 0) {
              this.$message.error('退出失败！' + response.data.msg);
            } else {
              this.$message.error('退出失败！请稍后再试或联系管理员');
            }
          });
        }).catch(() => {
        });
      }
    }
  }
</script>
