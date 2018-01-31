<template>
  <div class="personInfo">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <h2>本月视频点播</h2>
      </div>
      <div v-for="o in 4" :key="o" class="text item">
        <a href="#">{{'测试视频 ' + o }}</a>
      </div>
    </el-card>
  </div>
</template>

<style>

  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }
  .personInfo {
    text-align: center;
    line-height: 60px;
  }
</style>
<script>
  export default {
    name: "homePerson"
  }
</script>
