<template>
  <div>
  <el-header class="video-title"><h2>{{title}}</h2></el-header>
  <el-main>
    <transition name="el-zoom-in-center">
      <div v-show="show1" class="grid-content bg-purple-light">
        <home-pre-video @startPlay="start" @endPlay="end" :todayClassEndTime="todayClassEndTime" :todayClassStartTime="todayClassStartTime"></home-pre-video>
      </div>
    </transition>
    <transition name="el-zoom-in-center">
    <div v-show="show2" class="grid-content bg-purple-light">
      <div class="video">
        <div id="id_test_video"></div>
      </div>
    </div>
    </transition>
    <!--<el-button @click="show2 = !show2;show1=!show1">Click Me</el-button>-->
  </el-main>
  </div>
</template>
<style>
  .video {
    position: relative;
    width: 100%;
    height: 100%;
  }
  .video-title{
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }
  .pre-video{
    background-image: url("../assets/img/index2.jpg");
    background-repeat: no-repeat;
    background-size: contain;
    height: 100%;
    width: 100%
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    /*min-height: 36px;*/
    height: 500px;
  }

  #id_test_video{
    height: 100%;
    width: 100%;
  }
</style>
<script>
  import HomePreVideo from './HomePreVideo.vue'

  export default {
    name: 'homeVideo',
    props:{
      videoClassId:{
        type: String,
        require: false
      },
      todayClassStartTime:{
        type: Number,
        require: false
      },
      todayClassEndTime:{
        type: Number,
        require: false
      }
    },
    data() {
      return {
        title: '',
        show2: false,
        show1: true,
        getVideoUrl: '/api/video/play'
      }
    },
    components: {
      HomePreVideo
    },
    methods: {
      play: function () {
        const player = this.$refs.player.instance;
        player && player.play()
      },
      pause: function () {
        const player = this.$refs.player.instance;
        player && player.pause()
      },
      replay: function () {
        const player = this.$refs.player.instance;
        player && player.replay()
      },
      start: function () {
        let videoClassId = -1;
        let token = this.getCookie("token");
        if (this.videoClassId != ""){
          videoClassId = this.videoClassId;
        }
        this.$http.get(this.getVideoUrl, {params: {token: token, videoClassId: videoClassId}}).then((response) => {
          if (response.data.status == 0) {
            let fileId = response.data.data.fileId;
            let sd = response.data.data.sd;
            let od = response.data.data.od;
            let hd = response.data.data.hd;
            this.title = response.data.data.title;
            let playerData = {
              "autoplay" : false,
              "height": "100%",
              "width": "100%",
              "clarity": "sd",
              "clarityLabel":{
              }
            };
            // if (od != null || od != ""){
            //   playerData["m3u8"] = od;
            //   playerData["clarityLabel"]["od"] = "原画";
            // }
            if (sd != null || sd != ""){
              playerData["m3u8_sd"] = sd;
              playerData["clarityLabel"]["sd"] = "标清";
            }
            if (hd != null || hd != ""){
              playerData["m3u8_hd"] = hd;
              playerData["clarityLabel"]["hd"] = "高清";
            }
            let player = new TcPlayer('id_test_video', playerData);
//           let player = new qcVideo.Player('id_test_video', {
//             "auto_play": "0",
//             "file_id": fileId,
//             "stretch_full": 0,
//             "app_id": "1255600123",
//             "https": 1
//           });
          } else if (response.data.status == 1){
            this.title = "今日没有课程";
          } else if (response.data.status > 0) {
            this.$message.error('获取今日课程失败！' + response.data.msg);
            return;
          } else {
            this.$message.error('获取今日课程失败！请稍后再试或联系管理员');
            return;
          }
        });
        this.show1 = false;
        this.show2 = true;
      },
      end: function(){
        let videoDiv = document.getElementById('id_test_video');
        videoDiv.parentNode.removeChild(videoDiv);
        this.show1 = true;
        this.show2 = false;
      }
    }
  }
</script>
