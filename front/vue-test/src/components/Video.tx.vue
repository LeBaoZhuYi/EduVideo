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
        <div id="id_test_video" style="width:100%; height:100%;"></div>
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
    height: 50px;
    width: 100%;
    margin-bottom: 7%;
    display: inline-block;
    color: #3586fe;
  }

  .video-title{
    text-align: center;
    font-size: 22px;
  }
  .video {
    width: 100%;
    height: 100%;
  }

  .video-main {
    z-index:999;
    margin-top: -45%;
    margin-left: 30%;
    width: 40%;
    height: 50%;
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
        topic1: false,
        topic2: true,
        topic3: false,
        videoName: '',
        teacherName: ''
      }
    },
    mounted: function() {
      // this.$http.get('http://localhost:8081/video/today', {
      // }).then((response) => {
      //   if(response.data.code == 1){
      //   }
      // }, (response) =>{});
      let player = new TcPlayer('id_test_video', {
        "m3u8": "http://2157.liveplay.myqcloud.com/2157_358535a.m3u8", //请替换成实际可用的播放地址
        "autoplay" : true,      //iOS下safari浏览器，以及大部分移动端浏览器是不开放视频自动播放这个能力的
        "coverpic" : "http://www.test.com/myimage.jpg",
        "width" :  '480',//视频的显示宽度，请尽量使用视频分辨率宽度
        "height" : '320'//视频的显示高度，请尽量使用视频分辨率高度
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
