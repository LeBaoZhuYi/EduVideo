<template>
  <div class="row">
    <v-header :activeIndex="1" @transferTopic="getTopic"></v-header>
    <v-star v-show="topic1"></v-star>
    <v-common v-show="topic2"></v-common>
    <v-art v-show="topic3"></v-art>
    <div class="video-main">
      <div class="video-label">
        <p class="video-title">{{videoName}}</p>
        <p style="text-align: center;font-size: 15px">
          讲师：{{teacherName}}</p>
      </div>
      <div class="video">
        <div id="id_test_video"></div>
      </div>
    </div>
  </div>
</template>
<style>
  .row{
    height: 100%;
    width: 100%;
  }
  .video-label{
    height: 9%;
    width: 100%;
    margin-bottom: 7%;
    color: #3586fe;
  }

  .video-title{
    text-align: center;
    font-size: 40px;
    font-family: fengbi;
  }
  .video {
    width: 100%;
    height: 100%;
  }

  .video-main {
    position: absolute;
    z-index:999;
    top: 50%;
    left: 50%;
    width: 60%;
    height: 56%;
    margin-left: -30%;
    margin-top: -15%;
    text-align: center;
    font-family: Verdana, Arial;
    font-weight: normal;
    font-size: 12px;
  }
</style>
<script>
  import vStar from './topic/Star.vue'
  import vCommon from './topic/Common.vue'
  import vArt from './topic/Art.vue'
  import vHeader from "./Header.vue"
  export default {
    data(){
      return {
        topic1: true,
        topic2: false,
        topic3: false,
        videoName: '测试视频——朗诵一课',
        teacherName: '韩老师'
      }
    },
    mounted: function() {
      // this.$http.get('http://localhost:8081/video/today', {
      // }).then((response) => {
      //   if(response.data.code == 1){
      //   }
      // }, (response) =>{});
      // let player = new TcPlayer('id_test_video', {
      //   "m3u8": "http://1255600123.vod2.myqcloud.com/80822400vodtransgzp1255600123/c073d9154564972819133100100/v.f20.mp4", //请替换成实际可用的播放地址
      //   "autoplay" : true,      //iOS下safari浏览器，以及大部分移动端浏览器是不开放视频自动播放这个能力的
      //   "width" :  '480',//视频的显示宽度，请尽量使用视频分辨率宽度
      //   "height" : '320'//视频的显示高度，请尽量使用视频分辨率高度
      // });
      let player = new qcVideo.Player('id_test_video', {
        "auto_play":"0",
        "file_id":"4564972819148766178",
        "stretch_full": 0,
        "app_id":"1255600123",
        "https":1
      });
    },
    components: {
      'v-star': vStar,
      'v-common': vCommon,
      'v-header': vHeader,
      'v-art': vArt
    },
    methods: {
      play: function () {
        const player = this.$refs.player.instance
        player && player.play()
      },
      pause: function () {
        const player = this.$refs.player.instance
        player && player.pause()
      },
      replay: function () {
        const player = this.$refs.player.instance
        player && player.replay()
      },
      getTopic: function(msg){
        this.topic1 = false;
        this.topic2 = false;
        this.topic3 = false;
        if(msg == "1"){
          this.topic1 = true;
        } else if(msg == "2"){
          this.topic2 = true;
        } else if (msg == "3"){
          this.topic3 = true;
        }
      }
    }
  }
</script>
