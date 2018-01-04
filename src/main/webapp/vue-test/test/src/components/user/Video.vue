<template>
  <div class="a">
    <v-star></v-star>
    <div class="main"></div>
      <div class="video">
        <ali-player :source="视频url"
                    :vid="视频vid"
                    :playauth="播放鉴权"
                    ref="player"></ali-player>
        <button @click="play">播放</button>
        <button @click="pause">暂停</button>
        <button @click="replay">重播</button>
      </div>
    <!--</div>-->
  </div>
</template>
<style>
  .main {
    margin: auto;
    margin-top: -500px;
    width: 524px;
    height: 262px;
    text-align: left;
    background-color: #ffffff;
  }
  .video {
    margin: auto;
    /*margin-top: -500px;*/
    width: 80%;
    height: 80%;
    text-align: left;
    font-family: Verdana, Arial;
    font-weight: normal;
    font-size: 12px;
    color: #ffffff;
  }
</style>
<script>
  import VueAliplayer from 'vue-aliplayer'
  import vStar from './Star.vue'
  export default {
    components: {
      'ali-player': VueAliplayer,
      'v-star': vStar
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
