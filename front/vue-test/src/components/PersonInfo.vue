<template>
  <div id="person-info">

    <div id="header">
      <span id="my_name">{{studyName}}的主页</span>
    </div>
    <div id="content">
      <div class="scroll">
        <div class="scrollContainer" id="scrollContainer">
          <el-carousel :autoplay=false trigger="click">
            <el-carousel-item v-for="item in 4" :key="item">
              <div class="panel" v-show="item == 1" style="font-size: 20px">
                <div class="col_550 float_l">
                  <h1>学生简介</h1>
                  <p><em>{{studyIntro}}</em></p>
                  <div class="cleaner_h30"></div>
                  <h2>老师寄语</h2>
                  <div class="image_wrapper image_fl"><img src="../assets/temp/images/templatemo_image_01.jpg"
                                                           alt="Image 1"/></div>
                  <p>{{teacherRemark}}</p>
                </div>

                <div class="col_300 float_r">
                  <h2>家长的话</h2>
                  <p><em>{{parentWords}}</em></p>

                  <div class="cleaner_h30"></div>
                </div>
              </div> <!-- end of home -->
              <div class="panel hide" v-show="item == 2" style="font-size: 20px">
                <h1>个人信息</h1>
                <div class="col_300 float_l">
                  <p><em>我的名字：{{studyName}}</em></p>
                  <p><em>我是个：{{sex}}</em></p>
                  <p><em>我的分组：{{groupName}}</em></p>
                  <p><em>联系方式：{{phone}}</em></p></div>
                <div class="col_550 float_r">
                  <p><em>破壳日：{{birthday}}</em></p>
                  <p><em>我喜欢：{{interest}}</em></p>
                  <p><em>我不喜欢：{{disagree}}</em></p>
                  <p><em>我的理想：{{ideal}}</em></p></div>
                <div class="cleaner_h30"></div>

                <h1>课程情况</h1>
                <div class="image_wrapper image_fl"><img src="../assets/temp/images/video_class.jpg"
                                                         alt="Image 5" style="width: 230px;height: 100px"/></div>
                <p><em>今日课程：{{videoTitle}}</em></p>
                <p><em>是否已看：{{isWatched}}</em></p>
                <p><em>我已在线完成：{{classTimes}}次课程</em></p>
              </div>
              <div class="panel hide" v-show="item == 3">
                <h1>基本信息修改</h1>
                <el-form ref="form" :model="form" label-width="80px">
                  <el-form-item label="我的名字">
                    <el-input v-model="form.studyName"></el-input>
                  </el-form-item>
                  <el-form-item label="我的生日">
                    <el-col :span="11">
                      <el-date-picker type="date" placeholder="选择日期" v-model="form.birthday" style="width: 100%;"></el-date-picker>
                    </el-col>
                  </el-form-item>
                  <el-form-item label="我的性别">
                    <el-radio-group v-model="form.sex">
                      <el-radio label="男孩"></el-radio>
                      <el-radio label="女孩"></el-radio>
                    </el-radio-group>
                  </el-form-item>
                  <el-form-item label="个人简介">
                    <el-input v-model="form.studyIntro"></el-input>
                  </el-form-item>
                  <el-form-item>
                    <el-button type="primary" @click="update()">提交</el-button>
                  </el-form-item>
                </el-form>
              </div>
              <div class="panel hide" v-show="item == 4">
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
                    <el-button type="primary" @click="update()">提交</el-button>
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
        getStudentInfoUrl: '/api/student/myInfo',
        getTodayClassInfoUrl: '/api/videoClass/today',
        updateStudentInfoUrl: '/api/student/update',
        studyName: "",
        groupName: "",
        studyIntro: "",
        teacherRemark: "",
        parentWords: "",
        phone: "",
        sex: "",
        birthday: "",
        interest: "",
        disagree: "",
        ideal: "",
        videoTitle: "",
        isWatched: "",
        classTimes: "",
        form: {
          studyName: "",
          studyIntro: "",
          parentWords: "",
          phone: "",
          birthday: "",
          interest: "",
          disagree: "",
          ideal: ""
        }
      }
    },
    mounted: function () {
      let token = this.getCookie("token");
      this.getUserInfoAndClassInfo(token);
    },
    methods: {
      getUserInfoAndClassInfo: function (token) {
        this.$http.get("/static/Person.json", {params: {token: token}})
        //        this.$http.get("/api/student/info", {params: {userId: userId}})
          .then((response) => {
            if (response.data.status == 0) {
              this.studyName = response.data.data.stuName;
              this.groupName = "分组一";
              this.studyIntro = response.data.data.stuIntro;
              this.teacherRemark = response.data.data.remark;
              this.parentWords = response.data.data.parentWords;
              this.phone = response.data.data.phone;
              this.sex = response.data.data.sex == "女孩" ? "可爱的小女孩" : "帅气的小男孩";
              this.interest = response.data.data.interest;
              this.disagree = response.data.data.disagree;
              this.ideal = response.data.data.ideal;
              this.form.studyName = response.data.data.stuName;
              this.form.studyIntro = response.data.data.stuIntro;
              this.form.teacherRemark = response.data.data.remark;
              this.form.sex = "男孩";
              this.form.birthday = response.data.data.birthday;
              this.form.parentWords = response.data.data.parentWords;
              this.form.phone = response.data.data.phone;
              this.form.interest = response.data.data.interest;
              this.form.disagree = response.data.data.disagree;
              this.form.ideal = response.data.data.ideal;

            } else if (response.data.status > 0) {
              this.$alert("获取用户信息失败!" + response.data.msg, "错误");
            } else {
              this.$alert("获取用户信息失败！请稍后再试或联系管理员", "错误");
            }
          });
        this.$http.get("/static/Person.json", {params: {token: token}})
        //        this.$http.get("/api/videoClass/today", {params: {userId: userId}})
          .then((response) => {
            if (response.data.status == 0) {
              this.videoTitle = response.data.data.videoTitle;
              this.isWatched = response.data.data.isWatched ? "是" : "否";
              this.classTimes = response.data.data.classTimes;
            } else if (response.data.status > 0) {
              this.$alert("获取课程信息失败!" + response.data.msg, "错误");
            } else {
              this.$alert("获取课程信息失败！请稍后再试或联系管理员", "错误");
            }
          });
      },
      update(){

      }
    }
  }
</script>
