<template>
  <div class="video-main">
      <div class="video-label">
        <p class="video-title">第一课：XXXXX视频课程名字</p>
        <p style="text-align: center;font-size: 15px">
          讲师：XXX</p>
      </div>
      <div class="video">
        <ali-player :source="aplayer.source" :height="aplayer.height" :vid="aplayer.vid" :playauth="aplayer.playauth" ref="player">
        </ali-player>
      </div>
  </div>
</template>
<style>
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
  import VueAliplayer from 'vue-aliplayer'
  export default {
    data(){
      return {
        aplayer: {
          height: "100%",
          source: "",
          vid: "",
          playauth: ""
        }
      }
    },
    components: {
      'ali-player': VueAliplayer
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
      }
    }
  }
</script>
