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
    components: {
      ElFooter,
      ElMain,
      HomeHeader,
      HomePerson,
      HomeVideo,
      HomeVideoList,
      PersonInfo
    },
    methods: {
      header(path){

      }
    }
  }
</script>
