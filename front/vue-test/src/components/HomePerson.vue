<template>
  <div class="personInfo">
    <el-row class="bg-purple">
      <h2>小六的信息</h2>
      <p><em>我的学号：{{studyId}}</em></p>
      <p><em>破壳日：{{birthday}}</em></p>
      <p><em>我的电话：{{phone}}</em></p>
    </el-row>
    <div class="line"></div>
    <el-row class="bg-purple">
      <h2>小六的课程</h2>
      <p><em>今日课程：{{videoTitle}}</em></p>
      <p><em>是否已看：{{isWatched}}</em></p>
      <p><em>已完成：{{classTimes}}次课程</em></p>
      <el-button type="primary" round @click="open('/person');">更多信息</el-button>
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
        studyId: "",
        birthday: "",
        phone: "",
        videoTitle: "",
        isWatched: "",
        classTimes: ""
      }
    },
    mounted: function (){
      this.getUserInfoAndClassInfo();
    },
    methods: {
      getUserInfoAndClassInfo: function () {
        let userId = this.getLocalStorage("userId");
        if (userId == null) {
          this.$alert("获取用户信息失败！当前用户为空，请重新登录", "错误");
          this.$router.push('/');
          return;
        }
        this.$http.get("/api/student/getBaseInfo", {params: {userId: userId}})
          .then((response) => {
            if (response.data.status == 0) {
                this.studyId= response.data.data.studyId;
                this.birthday= response.data.data.birthday;
                this.phone= response.data.data.phone;
            } else if (response.data.status > 0) {
              this.$alert("获取用户信息失败!" + response.data.msg, "错误");
            } else {
              this.$alert("获取用户信息失败！请稍后再试或联系管理员", "错误");
            }
        })
        this.$http.get("/api/videoClass/getClassInfo", {params: {userId: userId}})
          .then((response) => {
            if (response.data.status == 0) {
              this.videoTitle= response.data.data.videoTitle;
              this.isWatched= response.data.data.isWatched;
              this.classTimes= response.data.data.classTimes;
            } else if (response.data.status > 0) {
              this.$alert("获取课程信息失败!" + response.data.msg, "错误");
            } else {
              this.$alert("获取课程信息失败！请稍后再试或联系管理员", "错误");
            }
          })
      }
    }
  }
</script>
