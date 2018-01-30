<template>
  <div>
  <el-header><h2>测试视频A——朗诵</h2></el-header>
  <el-main>
    <el-button @click="show2 = !show2;show1=!show1">Click Me</el-button>
    <transition name="el-zoom-in-center">
      <div v-show="show1" class="grid-content bg-purple-light">
        <div class="vvv" style="background-color: #2a88bd;height: 100%;width: 100%">
        </div>
      </div>
    </transition>
    <transition name="el-zoom-in-center">
    <div v-show="show2" class="grid-content bg-purple-light">
      <div class="video">
        <div id="id_test_video"></div>
      </div>
    </div>
    </transition>

  </el-main>
  </div>
</template>
<style>
  .video {
    position: relative;
    width: 100%;
    height: 100%;
  }

  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    /*min-height: 36px;*/
    height: 500px;
  }
</style>
<script>
  import vStar from './topic/Star.vue'
  import vCommon from './topic/Common.vue'
  import vArt from './topic/Art.vue'
  import vHeader from "./Header.vue"

  export default {
    name: 'homeVideo',
    data() {
      return {
        title: '',
        teacherName: '',
        show2: true,
        show1: false
      }
    },
    mounted: function () {
      if (localStorage.getItem("isLogined") == "false") {
        return;
      }
      let fileId = "";
      // let url = "http://localhost:8081/video/today?userId=" + userId
      let url = "/static/Video.json"
      this.$http.get(url, {}).then((response) => {
        if (response.data.status == 0) {
          fileId = response.data.data.route;
          this.title = response.data.data.title;
//           let player = new TcPlayer('id_test_video', {
//             "m3u8": "http://1255600123.vod2.myqcloud.com/80822400vodtransgzp1255600123/c073d9154564972819133100100/v.f20.mp4", //请替换成实际可用的播放地址
//             "autoplay" : true,      //iOS下safari浏览器，以及大部分移动端浏览器是不开放视频自动播放这个能力的
//           });
          let player = new qcVideo.Player('id_test_video', {
            "auto_play": "0",
            "file_id": fileId,
            "stretch_full": 0,
            "app_id": "1255600123",
            "https": 1
          });
        } else if (response.data.status > 0) {
          this.$message.error('获取今日课程失败！' + response.data.msg);
          return;
        } else {
          this.$message.error('获取今日课程失败！请稍后再试或联系管理员');
          return;
        }
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
      getTopic: function (msg) {
        this.topic1 = false;
        this.topic2 = false;
        this.topic3 = false;
        if (msg == "1") {
          this.topic1 = true;
        } else if (msg == "2") {
          this.topic2 = true;
        } else if (msg == "3") {
          this.topic3 = true;
        }
      }
    }
  }
</script>
