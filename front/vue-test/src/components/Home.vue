<template>
  <div style="font-family: fengbi">
    <el-container>
      <home-header :activeIndex="'2'"></home-header>
      <el-main>
        <el-row :gutter="20">
          <el-col :span="5">
            <home-person :info="info" :todayClassEndTime="todayClassEndTime"
                         :todayClassStartTime="todayClassStartTime"></home-person>
          </el-col>
          <el-col :span="14">
            <home-video :videoClassId="videoClassId" :todayClassEndTime="todayClassEndTime"
                        :todayClassStartTime="todayClassStartTime"></home-video>
          </el-col>
          <el-col :span="5">
            <home-video-list></home-video-list>
          </el-col>
        </el-row>
      </el-main>
      <el-footer></el-footer>
    </el-container>
  </div>
</template>

<style>
  .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }

</style>
<script>
  import HomeHeader from './HomeHeader.vue'
  import HomePerson from './HomePerson.vue'
  import HomeVideo from './HomeVideo.vue'
  import HomeVideoList from './HomeVideoList.vue'
  import ElMain from "../../node_modules/element-ui/packages/main/src/main.vue";
  import ElFooter from "../../node_modules/element-ui/packages/footer/src/main.vue";

  export default {
    data() {
      return {
        videoClassId: "",
        getStudentInfoUrl: '/api/student/info',
        getTodayClassInfoUrl: '/api/videoClass/today',
        info: {
          studyName: "",
          studyId: "",
          teacherName: "",
          groupName: "",
          videoTitle: "",
          isWatched: "",
          classTimes: ""
        },
        todayClassStartTime: 0,
        todayClassEndTime: 0
      }
    },
    components: {
      ElFooter,
      ElMain,
      HomeHeader,
      HomePerson,
      HomeVideo,
      HomeVideoList
    },
    beforeMount() {
      let userId = this.getLocalStorage("userId");
      if (userId == null) {
        this.$alert("获取用户信息失败！当前用户为空，请重新登录", "错误");
        this.$router.push('/');
        return;
      }
      this.getUserInfoAndClassInfo(userId);
    },
    methods: {
      getUserInfoAndClassInfo: function (userId) {
        // this.$http.get("/static/Person.json", {params: {userId: userId}})
        const videoClassId = this.$router.history.current.query.videoClassId;
        this.$http.get(this.getStudentInfoUrl, {params: {userId: userId}})
          .then((response) => {
            if (response.data.status == 0) {
              this.info.studyName = response.data.data.stuName;
              this.info.studyId = response.data.data.studyId;
              this.info.groupName = response.data.data.groupName;
            } else if (response.data.status > 0) {
              this.$alert("获取用户信息失败!" + response.data.msg, "错误");
            } else {
              this.$alert("获取用户信息失败！请稍后再试或联系管理员", "错误");
            }
          });
        // this.$http.get("/static/Person.json", {params: {userId: userId}})
        if (videoClassId != null) {
          this.$http.get(this.getTodayClassInfoUrl, {params: {userId: userId}})
            .then((response) => {
              if (response.data.status == 0) {
                this.info.videoTitle = response.data.data.videoTitle;
                this.info.isWatched = response.data.data.isWatched;
                this.info.teacherName = response.data.data.teacherName;
                this.info.classTimes = response.data.data.classTimes;
                this.todayClassStartTime = response.data.data.todayClassStartTime;
                this.todayClassEndTime = response.data.data.todayClassEndTime;
              } else if (response.data.status == 1) {
                this.info.videoTitle = "今日没有课程";
                this.info.isWatched = "略";
                this.info.teacherName = "略";
                this.info.classTimes = "略";
                this.todayClassStartTime = 0;
                this.todayClassEndTime = 0;
              } else if (response.data.status > 0) {
                this.$alert("获取课程信息失败!" + response.data.msg, "错误");
              } else {
                this.$alert("获取课程信息失败！请稍后再试或联系管理员", "错误");
              }
            });
        }
        if (videoClassId != null) {
          this.videoClassId = videoClassId;
          this.info.videoTitle = "略";
          this.info.isWatched = "略";
          this.info.teacherName = "略";
          this.info.classTimes = "略";
          this.todayClassStartTime = 0;
          this.todayClassEndTime = Date.parse(new Date()) + 1000 * 60 * 60 * 60;
        }
      }
    }
  }
</script>
