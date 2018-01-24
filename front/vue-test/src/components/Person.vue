<template>

  <div class="row">
    <v-header :activeIndex="2"></v-header>
    <div id="slider">

      <div id="header">
        <div id="sitetitle">
          <span id="my_name">小六的主页</span>
        </div>
        <!--<a class="header_menu" href="#"><img src="../assets/temp/images/twitter_header.png" alt="Twitter" /></a>-->
        <!--<a class="header_menu" href="#"><img src="../assets/temp/images/contactus.png" alt="contact us" /></a>-->
      </div>

      <div id="content">

        <div class="scroll">
          <div class="scrollContainer">

            <div v-show="scroll1" class="panel" id="home">
              <div class="col_550 float_l">
                <h1>学生简介</h1>

                <p><em>我叫小六，今年十岁了，是一个活泼开朗，热爱学习和运动的小女孩。我特别喜欢我们的舞蹈老师，她跳的舞特别好看。我希望我也能像她一样，所以我要好好学习舞蹈。我的梦想是在一个非常大的舞台上，跳最美的舞蹈给大家看</em></p>

                <div class="cleaner_h30"></div>
                <h2>老师寄语</h2>
                <div class="image_wrapper image_fl"><img src="../assets/temp/images/templatemo_image_01.jpg" alt="Image 1" /></div>
                <p>小六是一个非常可爱听话，上课认真活跃的姑娘，老师们都很喜欢她，希望她能顺利实现自己的梦想，成为一名优秀的舞者。</p>
              </div>

              <div class="col_300 float_r">
                <h2>家长的话</h2>
                <p><em>Donec ac eros ac nunc blandit hendrerit. Vestibulum tincidunt, odio at ultricies sollicitudin.</em></p>
                <p>Mauris ligula tortor, congue laoreet rutrum eget, suscipit nec augue hendrerit velit adipiscing.</p>

                <div class="cleaner_h30"></div>
              </div>
            </div> <!-- end of home -->

            <div v-show="scroll2" class="panel" id="info">
              <h1>个人信息</h1>
              <div class="image_wrapper image_fl"><img src="../assets/temp/images/templatemo_image_04.jpg" alt="Image 4" /></div>
              <p><em>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse in lectus turpis. Vivamus cursus tortor quis leo ullamcorper auctor quis tincidunt metus.</em></p>
              <p>Vestibulum vitae lectus a leo commodo egestas. Sed et ligula mauris. Donec interdum iaculis eros, sed porttitor justo ornare ac. Suspendisse ultrices arcu auctor sapien malesuada dictum. Vivamus non ante sit amet ligula dignissim blandit ut sit amet purus. Sed tristique euismod lectus sed scelerisque. Curabitur convallis fringilla ante, eget eleifend magna iaculis eget. Praesent at nunc tellus. Sed sed auctor odio. Maecenas ut mauris eu ligula placerat tempor vel ac augue. Integer fermentum, ante eget sodales lacinia, nisl diam semper elit, non hendrerit nunc urna vitae erat. Etiam vel nisi risus.</p>
              <p>Vestibulum tempus porttitor ipsum, ut dictum metus molestie eu. Donec interdum, mi ut facilisis posuere, neque sapien lacinia urna, nec hendrerit dolor arcu sed justo. Aenean rhoncus porttitor dolor non posuere. Nulla eu mi id tellus vehicula pellentesque et vitae magna. </p>
              <div class="cleaner_h30"></div>
              <ul id="social_box">
                <li><a href="#"><img src="../assets/temp/images/facebook.png" alt="facebook" /></a></li>
                <li><a href="#"><img src="../assets/temp/images/twitter.png" alt="twitter" /></a></li>
                <li><a href="#"><img src="../assets/temp/images/linkedin.png" alt="linkin" /></a></li>
                <li><a href="#"><img src="../assets/temp/images/technorati.png" alt="technorati" /></a></li>
                <li><a href="#"><img src="../assets/temp/images/myspace.png" alt="myspace" /></a></li>
              </ul>
            </div>

            <div v-show="scroll3" class="panel" id="history">
              <div class="col_700 float_l">
                <h1>课程历史</h1>
                <p><em>Nam at arcu libero, ut venenatis elit. Nulla eget risus turpis, non aliquet dui. Vivamus augue felis, ultricies elementum convallis non, ornare vitae urna. Morbi et nisi eros, ut venenatis ipsum. </em></p>
                <p>Sed eu libero quis neque laoreet cursus. Fusce elit metus, elementum nec consequat a, interdum vitae est. Aliquam sit amet odio vitae dui blandit elementum. Ut eu dolor nunc. Nam in nunc sed mi adipiscing lacinia suscipit eget tortor. Vivamus lacinia lectus in velit aliquet ac placerat magna euismod. In hac habitasse platea dictumst.  Mauris consectetur malesuada dolor.</p>
                <p>Integer eget nibh eu libero cursus ultricies. Nam ac eros erat. Integer varius pulvinar molestie. Vestibulum pellentesque felis eget nibh pulvinar accumsan. Etiam non urna at ipsum condimentum tempus at eu mauris. Vivamus eget ante augue. Phasellus ut sapien tellus, placerat cursus augue.</p>

              </div>
            </div>

            <div v-show="scroll4" class="panel" id="chart">
              <span style="font-size: 80px;text-align: center;color: #e83a2e">施工中。。。</span>
            </div>
          </div>
        </div>

        <!-- end of scroll -->
      </div>

      <div id="menu">
        <ul class="navigation">
          <li><a href="#home" @click="changeScroll('1')">主页<span class="ui_icon home"></span></a></li>
          <li><a href="#info" @click="changeScroll('2')">个人信息<span class="ui_icon info"></span></a></li>
          <li><a href="#history" @click="changeScroll('3')">课程历史<span class="ui_icon history"></span></a></li>
          <li><a href="#chart" @click="changeScroll('4')">图表区<span class="ui_icon chart"></span></a></li>
        </ul>
      </div>

      <div id="footer">

        <!--Copyright © 2048 <a href="#">Your Company Name</a> | Template from <a href="http://www.cssmoban.com" target="_parent" title="网站模板">网站模板</a>-->

      </div>

    </div> <!-- end of slider -->
  </div>
</template>
<style>
  @import url('../assets/temp/coda-slider.css');
  @import url('../assets/temp/templatemo_style.css');
  .fade-in-active, .fade-out-active{
    transition: all 0.5s ease
  }
  .fade-in-enter, .fade-out-active{
    opacity: 0
  }
</style>
<script>
  import vHeader from './Header.vue'
  export default {
    data(){
      return {
        scroll1: true,
        scroll2: false,
        scroll3: false,
        scroll4: false,
        scroll5: false
      }
    },
    components:{
      'v-header': vHeader
    },
    methods:{
      changeScroll(id){
        this.scroll1 = false;
        this.scroll2 = false;
        this.scroll3 = false;
        this.scroll4 = false;
        this.scroll5 = false;
        if(id == '1'){
          this.scroll1 = true;
        }
        if(id == '2'){
          this.scroll2 = true;
        }
        if(id == '3'){
          this.scroll3 = true;
        }
        if(id == '4'){
          this.scroll4 = true;
        }
        if(id == '5'){
          this.scroll5 = true;
        }
      }
    }
  }
</script>
