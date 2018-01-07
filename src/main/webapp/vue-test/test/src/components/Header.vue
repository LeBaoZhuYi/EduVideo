<template>
  <div class="header">
    <div class="logo">爱特熠星多元艺术(logo)</div>
    <div class="header-menu">
      <el-menu :default-active=activeIndex class="el-menu-demo" mode="horizontal" background-color="#42f42" text-color="#ffffff" active-text-color="#ffd04b">
        <el-menu-item index="1">今日课程</el-menu-item>
        <el-menu-item index="2">个人中心</el-menu-item>
        <el-submenu index="3">
          <template slot="title">主题选择</template>
          <el-menu-item index="2-1"></el-menu-item>
          <el-menu-item index="2-2">选项2</el-menu-item>
          <el-menu-item index="2-3">选项3</el-menu-item>
        </el-submenu>
        <el-menu-item index="4">退出</el-menu-item>
      </el-menu>
    </div>
  </div>
</template>
<script>
  export default {
    data() {
      return {
        name: 'adminHeader',
        activeIndex: "1"
      }
    },
    computed:{
      username(){
        let username = localStorage.getItem('ms_username');
        return username ? username : this.name;
      }
    },
    methods:{
      handleCommand(command) {
        if(command == 'loginout'){
          localStorage.removeItem('ms_username')
          this.$router.push('/login');
        }
      },
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      }
    }
  }
</script>
<style scoped>
  .header {
    position: relative;
    z-index:999;
    box-sizing: border-box;
    width: 100%;
    height: 50px;
    font-size: 22px;
    line-height: 50px;
    color: #fff;
  }
  .header .logo{
    float: left;
    width:250px;
    text-align: center;
  }
  .header-menu {
    float: right;
    padding-right: 50px;
    font-size: 16px;
    position: relative;
    display: inline-block;
    padding-left: 50px;
    color: #fff;
    cursor: pointer;
    vertical-align: middle;
  }
</style>
