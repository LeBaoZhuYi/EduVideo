<template>
  <div class="personInfo">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <h2>本月视频点播</h2>
      </div>
      <div v-for="video in videoList" class="text item">
        <a href="javascript:void(0)" @click="playVideo(video.id)">{{video.title}}</a>
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
    name: "homePerson",
    data() {
      return {
        videoList: []
      }
    },
    mounted: function () {
      this.getVideoList();
    },
    methods: {
      getVideoList: function () {
        let userId = this.getLocalStorage("userId")
        if (userId == null) {
          this.$alert("获取用户信息失败！当前用户为空，请重新登录", "错误");
          this.$router.push('/');
          return;
        }
        this.$http.get("/static/VideoList.json", {params: {userId: userId}})
//        this.$http.get("/api/video/getAllowedVideoList", {params: {userId: userId}})
          .then((response) => {
            if (response.data.status == 0) {
              this.videoList = response.data.data.videoList;
            } else if (response.data.status > 0) {
              this.$alert("获取视频列表失败!" + response.data.msg, "错误");
            } else {
              this.$alert("获取视频列表失败！请稍后再试或联系管理员", "错误");
            }
          })
      },
      playVideo(videoId){
//        window.open("/home?id=" + videoId);
//        this.$router.push("/home?id=" + videoId);
        window.location.href = "/home?videoId=" + videoId;
      }
    }
  }
</script>
