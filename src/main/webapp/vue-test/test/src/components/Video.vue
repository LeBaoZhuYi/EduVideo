<template>
  <div class="row">
    <v-header></v-header>
    <v-star v-if="topic === '1'"></v-star>
    <v-common v-if="topic === '2'"></v-common>
    <div class="main">
      <div class="label ">
        <p class="title">第一课：XXXXX视频课程名字</p>
        <p style="text-align: center;font-size: 15px">
          讲师：XXX</p>
      </div>
      <!--<div class="left">-->
        <div class="video">
          <ali-player :source="aplayer.source" :height="aplayer.height" :vid="aplayer.vid" :playauth="aplayer.playauth" ref="player">
          </ali-player>
          <!--<button @click="play">播放</button>-->
          <!--<button @click="pause">暂停</button>-->
          <!--<button @click="replay">重播</button>-->
        </div>
      <!--</div>-->
      <!--<div class="right"><span>12312312312321</span></div>-->
    </div>
  </div>
</template>
<style>
  .row{
    height: 100%;
    width: 100%;
  }
  .label{
    height: 50px;
    width: 100%;
    margin-bottom: 1%;
    display: inline-block;
  }

  .title{
    text-align: center;
    font-size: 22px;
  }
  .video {
    width: 100%;
    height: 100%;
  }

  .main {
    z-index:999;
    margin-top: -560px;
    margin-left: 20%;
    width: 63%;
    height: 400px;
    text-align: left;
    font-family: Verdana, Arial;
    font-weight: normal;
    font-size: 12px;
    color: #ffffff;
  }
</style>
<script>
  import VueAliplayer from 'vue-aliplayer'
  import vStar from './topic/Star.vue'
  import vCommon from './topic/Common.vue'
  import vHeader from "./Header.vue";
  import VCommon from "./topic/Common";
  export default {
    data(){
      return {
        topic: "1",
        aplayer: {
          height: "100%",
          source: "",
          vid: "",
          playauth: ""
        }
      }
    },
    components: {
      VCommon,
      'ali-player': VueAliplayer,
      'v-star': vStar,
      'v-common': vCommon,
      'v-header': vHeader
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
