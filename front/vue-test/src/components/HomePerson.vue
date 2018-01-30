<template>
  <div class="personInfo">
    <el-row class="bg-purple">
      <h2>小六的信息</h2>
      <p><em>我的学号：{{sex}}</em></p>
      <p><em>破壳日：{{birthday}}</em></p>
      <p><em>我的电话：{{phone}}</em></p>
    </el-row>
    <div class="line"></div>
    <el-row class="bg-purple">
      <h2>小六的课程</h2>
      <p><em>今日课程：{{videoTitle}}</em></p>
      <p><em>是否已看：{{isWatched}}</em></p>
      <p><em>已完成：{{classTimes}}次课程</em></p>
      <el-button type="primary" round>更多信息</el-button>
    </el-row>
  </div>
</template>

<style>
  .personInfo {
    text-align: center;
    line-height: 60px;
  }

  .bg-purple {
    background: #d3dce6;
  }

  .line {
    background: linear-gradient(to left, #efefef, #b6b6b6, #efefef);
    height: 2px;
  }
</style>
<script>
  export default {
    name: "homePerson",
    data() {
      return {
        name: "homePerson"
      }
    }
  }
</script>
