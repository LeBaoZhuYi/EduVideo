<template>
  <div style="margin-top: 10%">
    <el-row>
      <div class="trans_box">
        <div id="transImageBox1" class="trans_image_box" @mouseenter="change('1')" @mouseleave="unChange('1')">
          <img class="trans_image" src="http://image.zhangxinxu.com/image/study/p/s500/ps1.jpg"/>
          <img class="trans_image" src="http://image.zhangxinxu.com/image/study/p/s500/ps2.jpg"/>
        </div>
      </div>
      <div class="trans_box">
        <div id="transImageBox2" class="trans_image_box" @mouseenter="change('2')" @mouseleave="unChange('2')">
          <img class="trans_image" src="http://image.zhangxinxu.com/image/study/p/s500/ps1.jpg"/>
          <img class="trans_image" src="http://image.zhangxinxu.com/image/study/p/s500/ps2.jpg"/>
        </div>
      </div>
      <div class="trans_box">
        <div id="transImageBox3" class="trans_image_box" @mouseenter="change('3')" @mouseleave="unChange('3')">
          <img class="trans_image" src="http://image.zhangxinxu.com/image/study/p/s500/ps1.jpg"/>
          <img class="trans_image" src="http://image.zhangxinxu.com/image/study/p/s500/ps2.jpg"/>
        </div>
      </div>
    </el-row>
    <el-row>
      <div class="trans_box">
        <div id="transImageBox4" class="trans_image_box" @mouseenter="change('4')" @mouseleave="unChange('4')">
          <img class="trans_image" src="http://image.zhangxinxu.com/image/study/p/s500/ps1.jpg"/>
          <img class="trans_image" src="http://image.zhangxinxu.com/image/study/p/s500/ps2.jpg"/>
        </div>
      </div>
      <div class="trans_box">
        <div id="transImageBox5" class="trans_image_box" @mouseenter="change('5')" @mouseleave="unChange('5')">
          <img class="trans_image" src="http://image.zhangxinxu.com/image/study/p/s500/ps1.jpg"/>
          <img class="trans_image" src="http://image.zhangxinxu.com/image/study/p/s500/ps2.jpg"/>
        </div>
      </div>
      <div class="trans_box">
        <div id="transImageBox6" class="trans_image_box" @mouseenter="change('6')" @mouseleave="unChange('6')">
          <img class="trans_image" src="http://image.zhangxinxu.com/image/study/p/s500/ps1.jpg"/>
          <img class="trans_image" src="http://image.zhangxinxu.com/image/study/p/s500/ps2.jpg"/>
        </div>
      </div>
    </el-row>
  </div>
</template>
<style>
  .trans_box {
    width: 20%;
    height: 10%;
    margin-left: 10%;
    margin-top: 3%;
    float: left;
    overflow: hidden;
  }

  .trans_image_box {
    width: 200%;
    -webkit-transition: all 0.5s ease-in-out;
    -moz-transition: all 0.5s ease-in-out;
    -o-transition: all 0.5s ease-in-out;
    transition: all 0.5s ease-in-out;
  }

  .trans_image {
    width: 50%;
    float: left;
  }
</style>
<script>
  export default {
    data() {
      return {
        name: 'index4'
      }
    },
    methods: {
      change(id) {
        let index = 2;
        let width = document.getElementById('transImageBox' + id).clientWidth / 2;
        document.getElementById('transImageBox' + id).style.marginLeft = (1 - index) * width + "px";
        return false;
      },
      unChange(id) {
        let index = 1;
        let width = document.getElementById('transImageBox' + id).clientWidth / 2;
        document.getElementById('transImageBox' + id).style.marginLeft = (1 - index) * width + "px";
        return false;
      },
    }
  }
</script>
