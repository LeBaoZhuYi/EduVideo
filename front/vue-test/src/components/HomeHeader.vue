<template>
  <div>
    <el-header>
      <img class="logo" src="../assets/img/logo.png"/>
      <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal">
        <el-menu-item index="1" @click="open('/home');">主页</el-menu-item>
        <el-menu-item index="2" @click="open('/person');">个人中心</el-menu-item>
      </el-menu>
    </el-header>
    <div class="header-line"></div>
  </div>
</template>
<style>
  .header-line{
    height: 5px;
    background-color: #00d1b2;
  }
  .logo{
    position: relative;
    margin-left: 5%;
    margin-right: 5%;
    float: left;
    z-index: 999;
  }
  .el-menu{;
    active-text-color: #00d1b2;
  }
  .el-menu-item{
    font-size: 25px;
  }
  .el-menu--horizontal>.el-menu-item.is-active, .el-menu--horizontal>.el-submenu.is-active .el-submenu__title{
    border-bottom: 0px;
  }
</style>
<script>
  export default {
    name: "homeHeader",
    data() {
      return {
        activeIndex: '1'
      };
    },
    methods: {
      open: function(path){
        window.open(path);
      }
    }
  }
</script>
