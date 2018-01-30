<template>
  <div class="header">
    <div class="logo">爱特熠星多元艺术(logo)</div>
    <div class="header-menu">
      <el-menu :default-active=activeIndex theme="dark" class="el-menu-demo" mode="horizontal" background-color="#412f42" text-color="#ffffff" active-text-color="#ffd04b">
        <el-menu-item index="1" @click="header('video')">今日课程</el-menu-item>
        <el-menu-item index="2" @click="header('person')">个人中心</el-menu-item>
        <el-submenu v-show="activeIndex=='1'" index="3">
          <template slot="title">主题选择</template>
          <el-menu-item index="2-1" @click="changeTopic('1')">星空护眼</el-menu-item>
          <el-menu-item index="2-2" @click="changeTopic('2')">简洁小站</el-menu-item>
          <el-menu-item index="2-3" @click="changeTopic('3')">小小课堂</el-menu-item>
        </el-submenu>
        <el-menu-item index="4" @click="header('logout')">退出</el-menu-item>
      </el-menu>
    </div>
  </div>
</template>
<script>
  export default {
    props: ['activeIndex'],
    data() {
      return {
        name: 'header',
        topic: "1"
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
      changeTopic(id){
        this.$emit("transferTopic", id);
      },

      header(type){
        if(type == "video"){
          window.open('/user/video');
        } else if(type == "person"){
          window.open('/user/person');
        } else if(type == "logout"){
          this.$router.push('/');
        }
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
    height: 60px;
    font-size: 22px;
    line-height: 50px;
    /*background: #324157;*/
    color: #fff;
  }
  .logo{
    float: left;
    width:300px;
    text-align: center;
    font-size:24px;
    font-family: fengbi;
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
