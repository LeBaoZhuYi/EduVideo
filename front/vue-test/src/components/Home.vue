<template>
  <div style="font-family: fengbi">
  <el-container>
    <el-header><v-header></v-header></el-header>
    <el-main>
      <el-row :gutter="20">
        <el-col :span="5">
          <home-person></home-person>
        </el-col>
        <el-col :span="14"><home-video></home-video></el-col>
        <el-col :span="5"><home-video-list></home-video-list></el-col>
      </el-row></el-main>
    <el-footer></el-footer>
  </el-container>
  </div>
</template>

<style>
  .el-header, .el-footer {
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
  import vHeader from './Header.vue'
  import HomePerson from './HomePerson.vue'
  import HomeVideo from './HomeVideo.vue'
  import HomeVideoList from './HomeVideoList.vue'
  import ElMain from "../../node_modules/element-ui/packages/main/src/main.vue";
  import ElFooter from "../../node_modules/element-ui/packages/footer/src/main.vue";

  export default {
    components: {
      ElFooter,
      ElMain,
      'v-header': vHeader,
      HomePerson,
      HomeVideo,
      HomeVideoList
    }
  }
</script>
