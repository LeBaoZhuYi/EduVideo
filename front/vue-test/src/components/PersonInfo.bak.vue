<template>
  <div id="person-info">

    <div id="header">
      <span id="my_name">{{stuName}}的主页</span>
    </div>
    <div id="content">
      <div class="scroll">
        <div class="scrollContainer" id="scrollContainer">
          <el-carousel :autoplay=false trigger="click">
            <el-carousel-item v-for="item in 5" :key="item">
              <div class="panel" v-show="item == 1" style="font-size: 20px">
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
              <div class="panel hide" v-show="item == 2" style="font-size: 20px">
                <h1>个人信息</h1>
                <div class="col_300 float_l"><p><em>我的名字：{{stuName}}</em></p>
                  <p><em>我是个：{{sex}}</em></p>
                  <p><em>破壳日：{{birthday}}</em></p>
                  <p><em>联系方式：{{phone}}</em></p></div>
                <div class="col_550 float_r"><p><em>我爱吃：{{food}}</em></p>
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
              <div class="panel hide" v-show="item == 3" style="font-size: 20px">
                <h1>课程情况</h1>
                <div class="image_wrapper image_fl"><img src="../assets/temp/images/video_class.jpg"
                                                         alt="Image 5" style="width: 230px;height: 100px"/></div>
                <p><em>今日课程：{{videoTitle}}</em></p>
                <p><em>是否已看：{{isWatched}}</em></p>
                <p><em>我已在线完成：{{classTimes}}次课程</em></p>
                <p><em>我已在线完成：{{watchTimes}}次视频观看</em></p>
                <div class="cleaner_h30"></div>
                <div class="col_300 float_l"><h1>作业与成绩</h1>
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
              <div class="panel hide" v-show="item == 4">
              <h1>基本信息修改</h1>
              <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="我的名字">
                  <el-input v-model="form.studyName"></el-input>
                </el-form-item>
                <el-form-item label="我的性别">
                  <el-input v-model="form.sex"></el-input>
                </el-form-item>
                <el-form-item label="我的生日">
                  <el-input v-model="form.birthday"></el-input>
                </el-form-item>
                <el-form-item label="个人简介">
                  <el-input v-model="form.studyIntro"></el-input>
                </el-form-item>
                <el-form-item>
                  <el-button type="primary" @click="onSubmit">提交</el-button>
                </el-form-item>
              </el-form>
            </div>
            <div class="panel hide" v-show="item == 5">
              <h1>其它信息修改</h1>
              <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="我的爱好">
                  <el-input v-model="form.interest"></el-input>
                </el-form-item>
                <el-form-item label="我的理想">
                  <el-input v-model="form.ideal"></el-input>
                </el-form-item>
                <el-form-item label="我不喜欢">
                  <el-input v-model="form.studyIntro"></el-input>
                </el-form-item>
                <el-form-item label="家长评价">
                  <el-input v-model="form.parentWords"></el-input>
                </el-form-item>
                <el-form-item>
                  <el-button type="primary" @click="onSubmit">提交</el-button>
                </el-form-item>
              </el-form>
            </div>
            </el-carousel-item>
          </el-carousel>
        </div>
      </div>
    </div>
    <div id="menu">
    </div>
    <div id="footer">
    </div>

  </div>
</template>
<style>
  @import url('../assets/temp/templatemo_style.css');

  #person-info {
    position: relative;
    width: 980px;
    margin: 0 auto;
    margin-top: 45px;
    font-family: fengbi;
  }

  em, .el-form-item__label {
    color: #d1e050;
  }

  el-form-item__label {
    font-size: 22px;
    font-weight: normal;
    margin: 0 0 15px 0;
    font-weight: normal;
  }

  #header {
    background: url("../assets/temp/images/templatemo-content-top.png") no-repeat;
    width: 980px;
    height: 60px;
    padding: 35px 0 0 0;
    text-align: center;
  }

  #my_name {
    border: none;
    border-bottom: 3px solid #ffffff;
    font-size: 50px;
    color: #ffffff;
  }

  #header a.header_menu {
    float: left;
    display: block;
    margin-right: 40px;
  }

  #content {
    background: url("../assets/temp/images/templatemo-content-middle.png") no-repeat;
    width: 860px;
    height: 415px;
    padding: 0 60px
  }

  #menu {
    background: url("../assets/temp/images/templatemo-menu.png") no-repeat;
    width: 980px;
    height: 105px;
  }

  #footer {
    background: url("../assets/temp/images/templatemo-footer.jpg") no-repeat;
    height: 52px;
    width: 980px;
    padding: 20px 0;
    text-align: center;
  }

  .scroll {
    height: 415px;
    width: 860px;
    overflow: hidden;
    position: relative;
    clear: left;
  }

  .scrollContainer {
    height: 380px;
    width: 800px;
    padding: 35px 30px 0 30px;
  }

  .el-carousel {
    position: relative;
    width: 100%;
    height: 100%;
  }

  .el-carousel__container {
    height: 100%;
  }
</style>
<script>

  export default {
    name: "personCenter",
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
        classTimes: "",
        watchTimes: "",
        isFinishedHomework: "",
        lastScore: "",
        avgScore: "",
        maxScore: "",
        teacherHomeworkComment: "",
        form: {
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
          ideal: ""
        }
      }
    },
    mounted: function () {
      this.$http.get("/static/Person.json").then((response) => {
        this.stuName = response.data.data.stuName;
        this.stuIntro = response.data.data.stuIntro;
        this.remark = response.data.data.remark;
        this.parentWords = response.data.data.parentWords;
        this.phone = response.data.data.phone;
        this.sex = response.data.data.sex == "m" ? "可爱的小女孩" : "帅气的小男孩";
        this.food = response.data.data.food;
        this.interest = response.data.data.interest;
        this.disagree = response.data.data.disagree;
        this.ideal = response.data.data.ideal;
        this.videoTitle = response.data.data.videoTitle;
        this.isWatched = response.data.data.isWatched ? "是" : "否";
        this.classTimes = response.data.data.classTimes;
        this.watchTimes = response.data.data.watchTimes;
        this.isFinishedHomework = response.data.data.isFinishedHomework ? "已完成" : "未完成";
        this.lastScore = response.data.data.lastScore;
        this.avgScore = response.data.data.avgScore;
        this.maxScore = response.data.data.maxScore;
        this.teacherHomeworkComment = response.data.data.teacherHomeworkComment;
      })
    }
  }
</script>
