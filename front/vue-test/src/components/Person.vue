<template>

  <div class="row" style="font-family: fengbi">
    <v-header :activeIndex="2"></v-header>
    <div id="slider">

      <div id="header">
        <div id="sitetitle">
          <span id="my_name">{{stuName}}的主页</span>
        </div>
      </div>

      <div id="content">

        <div class="scroll">
          <div class="scrollContainer" id="scrollContainer">

            <div class="panel" id="1" style="font-size: 20px">
              <div class="col_550 float_l">
                <h1>学生简介</h1>

                <p><em>{{stuIntro}}</em></p>

                <div class="cleaner_h30"></div>
                <h2>老师寄语</h2>
                <div class="image_wrapper image_fl"><img src="../assets/temp/images/templatemo_image_01.jpg"
                                                         alt="Image 1"/></div>
                <p>{{remark}}</p>
              </div>

              <div class="col_300 float_r">
                <h2>家长的话</h2>
                <p><em>{{parentWords}}</em></p>

                <div class="cleaner_h30"></div>
              </div>
            </div> <!-- end of home -->

            <div class="panel hide" id="2" style="font-size: 20px">
              <h1>个人信息</h1>
              <div class="col_300 float_l"><p><em>我的名字：{{stuName}}</em></p>
                <p><em>我是个：{{sex}}</em></p>
                <p><em>破壳日：{{birthday}}</em></p>
                <p><em>联系方式：{{phone}}</em></p></div>
              <div class="col_600 float_r"><p><em>我爱吃：{{food}}</em></p>
                <p><em>我喜欢：{{interest}}</em></p>
                <p><em>我讨厌：{{disagree}}</em></p>
                <p><em>我想当：{{ideal}}</em></p></div>
              <div class="cleaner_h30"></div>

              <h1>我的风采</h1>
              <div class="image_wrapper image_fl"><img src="../assets/temp/images/fengcai1.jpg"
                                                       alt="Image 4" style="width: 230px;height: 100px"/></div>
              <div class="image_wrapper image_fl"><img src="../assets/temp/images/fengcai2.jpg"
                                                       alt="Image 4" style="width: 230px;height: 100px"/></div>
              <div class="image_wrapper image_fl"><img src="../assets/temp/images/fengcai3.jpg"
                                                       alt="Image 4" style="width: 230px;height: 100px"/></div>
            </div>

            <div class="panel hide" id="3" style="font-size: 20px">
              <h1>课程情况</h1>
              <div class="image_wrapper image_fl"><img src="../assets/temp/images/video_class.jpg"
                                                       alt="Image 5" style="width: 230px;height: 100px"/></div>
              <p><em>今日课程：{{videoTitle}}</em></p>
              <p><em>是否已看：{{isWatched}}</em></p>
              <p><em>我已在线完成：{{classTimes}}次课程</em></p>
              <p><em>我已在线完成：{{watchTimes}}次视频观看</em></p>
              <div class="cleaner_h30"></div>

              <div class="col_300 float_l"><h1>作业与成绩</h1>
                <!--<div class="image_wrapper image_fl"><img src="../assets/temp/images/templatemo_image_04.jpg"-->
                <!--alt="Image 4"/></div>-->
                <p><em>上一次作业状况：{{isFinishedHomework}}</em></p>
                <p><em>上一次课程成绩：{{lastScore}}</em></p>
                <p><em>课程平均成绩：{{avgScore}}</em></p>
                <p><em>历史最好成绩：{{maxScore}}</em></p>
              </div>
              <div class="col_550 float_r">
                <h2>老师评价</h2>
                <p><em>{{teacherHomeworkComment}}</em></p>
              </div>
            </div>
            <div class="panel hide" id="4">
              <span style="font-size: 80px;text-align: center;color: #e83a2e">施工中。。。</span>
            </div>
          </div>
        </div>

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
        stuName: "",
        stuIntro: "",
        remark: "",
        parentWords: "",
        phone: "",
        sex: "",
        birthday: "",
        food: "",
        interest: "",
        disagree: "",
        ideal: "",
        videoTitle: "",
        isWatched: "",
        classTimes:"",
        watchTimes:"",
        isFinishedHomework:"",
        lastScore: "",
        avgScore:"",
        maxScore:"",
        teacherHomeworkComment:""
      }
    },
    mounted: function () {
      this.$http.get("/static/Person.json").then((response) => {
        this.stuName = response.data.data.stuName;
        this.stuIntro = response.data.data.stuIntro;
        this.remark = response.data.data.remark;
        this.parentWords = response.data.data.parentWords;
        this.phone = response.data.data.phone;
        this.sex = response.data.data.sex == "m"?"可爱的小女孩":"帅气的小男孩";
        this.food = response.data.data.food;
        this.interest = response.data.data.interest;
        this.disagree = response.data.data.disagree;
        this.ideal = response.data.data.ideal;
        this.videoTitle = response.data.data.videoTitle;
        this.isWatched = response.data.data.isWatched?"是":"否";
        this.classTimes = response.data.data.classTimes;
        this.watchTimes = response.data.data.watchTimes;
        this.isFinishedHomework = response.data.data.isFinishedHomework?"已完成":"未完成";
        this.lastScore = response.data.data.lastScore;
        this.avgScore = response.data.data.avgScore;
        this.maxScore = response.data.data.maxScore;
        this.teacherHomeworkComment = response.data.data.teacherHomeworkComment;
      })
    },
    components: {
      'v-header': vHeader
    },
    methods: {
      changeScroll(id) {
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
