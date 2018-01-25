<template>
  <div class="star">
    <div class="landscape"></div>
    <div class="filter"></div>
    <canvas id="canvas"></canvas>
  </div>
</template>
<style>
  .star {
    margin:0;
    width:100%;
    height:100%;
    /*background:black;*/
    overflow: hidden;
    background:linear-gradient(to bottom,#000000 0%,#5788fe 100%);
  }
  .filter {
    width:100%;
    height:100%;
    position:absolute;
    cursor:none;
    top:0;
    left:0;
    animation-fill-mode:both;
    mix-blend-mode:overlay;
  }
  .landscape {
     position:absolute;
     bottom:0px;
     left:0;
     width:100%;
     height:100%;
     /*background-image:url('http://www.jq22.com/css/img/xkbg.png');*/
     /*background-size:1000px 250px;*/
     /*background-repeat:repeat-x;*/
     /*background-position:center bottom;*/
   }
</style>
<script>
  import Test from '../../js/star.js';
  export default {
    data() {
      return {}
    },
    mounted() {
      let canvas = document.getElementById('canvas');
      let ctx = canvas.getContext('2d');
      Test.setBackground(canvas, ctx);
    }
  }
</script>
