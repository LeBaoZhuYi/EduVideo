<template>
  <div class="personInfo">
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <h2>本月视频点播</h2>
      </div>
      <div v-for="videoClass in videoClassList" class="text item">
        <a href="javascript:void(0)" @click="playVideo(videoClass.id)">{{videoClass.className}}</a>
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
        videoClassList: [],
        getVideoClassListUrl: '/api/videoClass/classList'
      }
    },
    mounted: function () {
      this.getVideoList();
    },
    methods: {
      getVideoList: function () {
        let token = this.getCookie("token");
        // this.$http.get("/static/VideoList.json", {params: {userId: userId}})
        this.$http.get(this.getVideoClassListUrl, {params: {token: token}})
          .then((response) => {
            if (response.data.status == 0) {
              this.videoClassList = response.data.data;
            } else if (response.data.status > 0) {
              this.$alert("获取视频列表失败!" + response.data.msg, "错误");
            } else {
              this.$alert("获取视频列表失败！请稍后再试或联系管理员", "错误");
            }
          })
      },
      playVideo(videoClassId) {
//        window.open("/home?id=" + videoClassId);
//        this.$router.push("/home?id=" + videoClassId);
        window.location.href = "/home?videoClassId=" + videoClassId;
      }
    }
  }
</script>
