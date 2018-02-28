<template>
  <div>
    <label style="font-family: 'Helvetica Neue'">您尚未登录或已经下线，{{lastTime}}秒后跳转至首页</label>
    <br/>
    <el-button type="text" @click="jump()">立即跳转</el-button>
  </div>
</template>

<script>
  export default {
    data: function () {
      return {
        lastTime: 10,
        timer: null
      }
    },
    mounted() {
      this.timer = setInterval(this.checkTime, 1000);
    },
    methods: {
      jump() {
        clearInterval(this.timer);
        this.clearCookie("token");
        window.location.href = "/";
      },
      checkTime() {
        this.lastTime -= 1;
        if (this.lastTime <= 0){
          this.jump();
        }
      }
    }
  }
</script>
