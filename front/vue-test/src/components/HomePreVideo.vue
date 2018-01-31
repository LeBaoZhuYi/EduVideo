<template>
  <div class="pre-video">
    <div class="clock" v-show="!over">
      <div v-show="!nowStart">
        <img src="/static/img/last-time.png"/>
        <br/>
        <img :src="hour1"/>
        <img :src="hour2"/>
        <img :src="mao"/>
        <img :src="min1"/>
        <img :src="min2"/>
        <img :src="mao"/>
        <img :src="sec1"/>
        <img :src="sec2"/>
      </div>
      <a style="cursor: pointer" v-show="nowStart" @click="startPlay()"><img src="/static/img/now-start.png"/></a>
    </div>
    <div class="over" v-show="over">
      <img src="/static/img/over.png"/>
      <img src="/static/img/review.png"/>
    </div>
  </div>
</template>
<style>
  .pre-video {
    background-image: url("../assets/img/pre-video.jpg");
    background-repeat: no-repeat;
    background-size: contain;
    height: 100%;
    width: 100%
  }

  .clock, .over {
    position: relative;
    top: 20%;
  }
</style>
<script>
  export default {
    name: 'homePreVideo',
    data: function () {
      return {
        over: false,
        nowStart: false,
        timer: null,
        todayClassStartTime: Date.parse(new Date()) + 1000 * 30,
        todayClassEndTime: Date.parse(new Date()) + 1000 * 30 * 3,
        mao: "/static/img/tm.png",
        hour1: "/static/img/t0.png",
        hour2: "/static/img/t0.png",
        min1: "/static/img/t0.png",
        min2: "/static/img/t0.png",
        sec1: "/static/img/t0.png",
        sec2: "/static/img/t0.png"
      }
    },
    mounted: function () {
      let now = Date.parse(new Date());
      if (now < this.todayClassStartTime) {
        this.over = false;
        this.timer = setInterval(this.checkTime, 1000);
      } else if (now > this.todayClassEndTime){
        this.over = true;
      } else{
        this.nowStart = true;
      }
    },
    methods: {
      checkTime() {
        let now = Date.parse(new Date());
        let sub = parseInt((this.todayClassStartTime - now) / 1000);
        if (sub <= 0){
          clearInterval(this.timer);
          this.nowStart = true;
          return;
        }
        let hour = parseInt(sub / 3600);
        let min = parseInt((sub - hour * 3600) / 60);
        let sec = parseInt((sub - hour * 3600 - min * 60));
        this.hour1 = "/static/img/t" + parseInt(hour / 10) + ".png";
        this.hour2 = "/static/img/t" + hour % 10 + ".png";
        this.min1 = "/static/img/t" + parseInt(min / 10) + ".png";
        this.min2 = "/static/img/t" + min % 10 + ".png";
        this.sec1 = "/static/img/t" + parseInt(sec / 10) + ".png";
        this.sec2 = "/static/img/t" + sec % 10 + ".png";
      },
      startPlay(){
        this.$emit("startPlay");
      }
    }
  }
</script>
