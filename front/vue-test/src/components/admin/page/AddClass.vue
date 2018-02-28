<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item><i class="el-icon-date"></i> 添加</el-breadcrumb-item>
        <el-breadcrumb-item>添加课程</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="form-box">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="课程名">
          <el-input v-model="form.className"></el-input>
        </el-form-item>
        <el-form-item label="课程视频">
          <el-select v-model="form.videoId" placeholder="请选择">
            <el-option v-for="video in videoList" :label="video.title" :value="video.id"
                       :key="video.id"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="学生分组">
          <el-select v-model="form.groupId" placeholder="请选择">
            <el-option v-for="group in groupList" :label="group.name" :value="group.id"
                       :key="group.id"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="讲师">
          <el-input v-model="form.teacherName"></el-input>
        </el-form-item>
        <el-form-item label="开始时间">
          <el-col :span="11">
            <el-date-picker type="date" placeholder="选择日期" v-model="form.startTime" style="width: 100%;"></el-date-picker>
          </el-col>
          <el-col class="line" :span="2">-</el-col>
          <el-col :span="11">
            <el-time-picker type="fixed-time" placeholder="选择时间" v-model="startHMSTime"
                            style="width: 100%;"></el-time-picker>
          </el-col>
        </el-form-item>
        <el-form-item label="结束时间">
          <el-col :span="11">
            <el-date-picker type="date" placeholder="选择日期" v-model="form.endTime" style="width: 100%;"></el-date-picker>
          </el-col>
          <el-col class="line" :span="2">-</el-col>
          <el-col :span="11">
            <el-time-picker type="fixed-time" placeholder="选择时间" v-model="endHMSTime"
                            style="width: 100%;"></el-time-picker>
          </el-col>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="create()">提交</el-button>
        </el-form-item>
      </el-form>
    </div>

  </div>
</template>

<script>
  import qs from 'qs';
  export default {
    data: function () {
      return {
        form: {
          className: "",
          teacherName: "",
          videoId: "",
          groupId: "",
          startTime: "",
          endTime: ""
        },
        startHMSTime: "",
        endHMSTime: "",
        groupList: [],
        videoList: [],
        createUrl: '/api/admin/videoClass/create',
        getNormalGroupListUrl: '/api/admin/studentGroup/getNormalList',
        getNormalVideoListUrl: '/api/admin/video/getNormalList',
      }
    },
    mounted: function() {
      this.getGroupList();
      this.getVideoList();
    },
    methods: {
      getVideoList() {
        const self = this;
        self.$http.get(self.getNormalVideoListUrl).then((response) => {
          if(response.data.status == 0){
            self.videoList = response.data.data;
          } else if(response.data.status > 0){
            self.$message.error("获取学生分组失败！" + response.data.msg);
          } else{
            self.$message.error("获取学生分组失败！请稍后重试或咨询管理员");
          }
        });
      },
      getGroupList() {
        const self = this;
        self.$http.get(self.getNormalGroupListUrl).then((response) => {
          if(response.data.status == 0){
            self.groupList = response.data.data;
          } else if(response.data.status > 0){
            self.$message.error("获取学生分组失败！" + response.data.msg);
          } else{
            self.$message.error("获取学生分组失败！请稍后重试或咨询管理员");
          }
        });
      },
      create() {
        let startTime = this.form.startTime;
        let endTime = this.form.endTime;
        startTime.setHours(this.startHMSTime.getHours());
        startTime.setMinutes(this.startHMSTime.getMinutes());
        startTime.setSeconds(this.startHMSTime.getSeconds());
        endTime.setHours(this.endHMSTime.getHours());
        endTime.setMinutes(this.endHMSTime.getMinutes());
        endTime.setSeconds(this.endHMSTime.getSeconds());
        this.form.startTime = this.dateToString(startTime);
        this.form.endTime = this.dateToString(endTime);
        let postData = qs.stringify(this.form);
        this.$http.post(this.createUrl, postData).then((response) => {
          if(response.data.status == 0){
            this.$confirm('添加成功，是否跳转到列表', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '留在此处',
              type: 'warning'
            }).then(() => {
              window.location.href = "/admin/class-table";
            });
          } else if(response.data.status > 0){
            this.$message.error("添加失败！" + response.data.msg);
          } else{
            this.$message.error("添加失败！请稍后重试或咨询管理员");
          }
        });
      }
    }
  }
</script>
