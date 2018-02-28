<template>
  <div style="font-family: fengbi">
    <el-container>
      <home-header :activeIndex="'3'"></home-header>
      <el-main style="background: #d3dce6">
        <person-info></person-info>
      </el-main>
      <el-footer></el-footer>
    </el-container>
  </div>
</template>

<style>
</style>
<script>
  import HomeHeader from './HomeHeader.vue'
  import HomePerson from './HomePerson.vue'
  import HomeVideo from './HomeVideo.vue'
  import HomeVideoList from './HomeVideoList.vue'
  import PersonInfo from './PersonInfo.vue'
  import ElMain from "../../node_modules/element-ui/packages/main/src/main.vue";
  import ElFooter from "../../node_modules/element-ui/packages/footer/src/main.vue";

  export default {
    data() {
      return {
        checkLoginTimer: null
      }
    },
    components: {
      ElFooter,
      ElMain,
      HomeHeader,
      HomePerson,
      HomeVideo,
      HomeVideoList,
      PersonInfo
    },
    beforeMount() {
      let token = this.getCookie("token");
      if (token == null) {
        this.$alert("获取用户信息失败！当前用户为空，请重新登录", "错误");
        this.$router.push('/');
        return;
      }
      this.checkLoginTimer = setInterval(this.checkLogin, 5000)
    },
    methods: {
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
