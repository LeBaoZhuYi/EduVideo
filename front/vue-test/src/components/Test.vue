<template>

  <div class="row">
    <v-header :activeIndex="2"></v-header>
    <div id="slider">

      <div id="header">
        <div id="sitetitle">
          <span id="my_name">{{stu_name}}的主页</span>
        </div>
      </div>

      <div id="content">

        <div class="scroll">
          <div class="scrollContainer" id="scrollContainer">

            <div class="panel" id="1">
              <div class="col_550 float_l">
                <h1>学生简介</h1>

                <p><em>{{stu_intro}}</em></p>

                <div class="cleaner_h30"></div>
                <h2>老师寄语</h2>
                <div class="image_wrapper image_fl"><img src="../assets/temp/images/templatemo_image_01.jpg" alt="Image 1" /></div>
                <p>{{remark}}</p>
              </div>

              <div class="col_300 float_r">
                <h2>家长的话</h2>
                <p><em>{{parent_words}}</em></p>

                <div class="cleaner_h30"></div>
              </div>
            </div> <!-- end of home -->

            <div class="panel hide" id="2">
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

            <div class="panel hide" id="3">
              <div class="col_700 float_l">
                <h1>课程历史</h1>
                <p><em>Nam at arcu libero, ut venenatis elit. Nulla eget risus turpis, non aliquet dui. Vivamus augue felis, ultricies elementum convallis non, ornare vitae urna. Morbi et nisi eros, ut venenatis ipsum. </em></p>
                <p>Sed eu libero quis neque laoreet cursus. Fusce elit metus, elementum nec consequat a, interdum vitae est. Aliquam sit amet odio vitae dui blandit elementum. Ut eu dolor nunc. Nam in nunc sed mi adipiscing lacinia suscipit eget tortor. Vivamus lacinia lectus in velit aliquet ac placerat magna euismod. In hac habitasse platea dictumst.  Mauris consectetur malesuada dolor.</p>
                <p>Integer eget nibh eu libero cursus ultricies. Nam ac eros erat. Integer varius pulvinar molestie. Vestibulum pellentesque felis eget nibh pulvinar accumsan. Etiam non urna at ipsum condimentum tempus at eu mauris. Vivamus eget ante augue. Phasellus ut sapien tellus, placerat cursus augue.</p>

              </div>
            </div>

            <div class="panel hide" id="4">
              <span style="font-size: 80px;text-align: center;color: #e83a2e">施工中。。。</span>
            </div>
          </div>
        </div>

        <!-- end of scroll -->
      </div>

      <div id="menu">
        <ul class="navigation">
          <li><a href="#" @click="changeScroll('1')">主页<span class="ui_icon home"></span></a></li>
          <li><a href="#" @click="changeScroll('2')">个人信息<span class="ui_icon info"></span></a></li>
          <li><a href="#" @click="changeScroll('3')">课程历史<span class="ui_icon history"></span></a></li>
          <li><a href="#" @click="changeScroll('4')">图表区<span class="ui_icon chart"></span></a></li>
        </ul>
      </div>

      <div id="footer">


      </div>

    </div>
  </div>
</template>
<style>
  @import url('../assets/temp/coda-slider.css');
  @import url('../assets/temp/templatemo_style.css');
</style>
<script>
  import vHeader from './Header.vue'
  export default {
    data() {
      return {
        stu_name: "",
        stu_intro: "",
        remark: "",
        parent_words: "",
        phone: "",
        email: "",
        sex: "",
        birthday: "",

      }
    },
    mounted: function(){
      this.$http.get("static/Person.json").then((res) => {
        this.stu_name = res.data.stu_name;
        this.stu_intro = res.data.stu_intro;
        this.remark = res.data.remark;
        this.parent_words = res.data.parent_words;
        this.phone = res.data.phone;
        this.email = res.data.email;
        this.sex = res.data.sex;
        this.birthday = res.data.birthday
      })
    },
    components:{
      'v-header': vHeader
    },
    methods:{
      changeScroll(id){
        document.getElementById("scrollContainer").style.marginLeft = (1 - parseInt(id)) * 800 + "px";
        document.getElementById("1").classList.add("hide");
        document.getElementById("2").classList.add("hide");
        document.getElementById("3").classList.add("hide");
        document.getElementById("4").classList.add("hide");
        document.getElementById(id).classList.remove("hide");
        return false;
      }
    }
  }
</script>
