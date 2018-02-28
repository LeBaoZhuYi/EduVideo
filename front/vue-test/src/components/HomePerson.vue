<template>
  <div class="personInfo">
    <el-row class="bg-purple">
      <h2>小六的信息</h2>
      <p><em>我的学号：{{info.studyId}}</em></p>
      <p><em>我的分组：{{info.groupName}}</em></p>
    </el-row>
    <div class="line"></div>
    <el-row class="bg-purple">
      <h2>今日课程</h2>
      <p><em>发布时间：{{info.videoTitle}}</em></p>
      <p><em>讲师：{{info.teacherName}}</em></p>
      <p><em>开始时间：{{startTime}}</em></p>
      <p><em>结束时间：{{endTime}}</em></p>
      <el-button type="primary" round @click="window.location.href = '/person';">更多信息</el-button>
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
    props: {
      info: {
        type: Object,
        require: true
      },
      todayClassStartTime: {
        type: Number,
        require: false
      },
      todayClassEndTime: {
        type: Number,
        require: false
      }
    },
    data() {
      return {
        startTime: "",
        endTime: ""
      }
    },
    mounted: function () {
      this.getTimeRange();
    },
    methods: {
      getTimeRange() {
        // 表示点播
        if (this.todayClassStartTime == 0) {
          this.startTime = "略";
          this.endTime = "略"
        } else {
          this.startTime = this.timestampToString(this.todayClassStartTime).split(' ')[1];
          this.endTime = this.timestampToString(this.todayClassEndTime).split(' ')[1];
        }
      }
    },
    watch: {
      todayClassStartTime(c, o) {
        this.startTime = this.timestampToString(c).split(' ')[1];
      },
      todayClassEndTime(c, o) {
        this.endTime = this.timestampToString(c).split(' ')[1];
      }
    }
  }
</script>
