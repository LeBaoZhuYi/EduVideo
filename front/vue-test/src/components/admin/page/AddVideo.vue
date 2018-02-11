<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item><i class="el-icon-date"></i> 管理</el-breadcrumb-item>
        <el-breadcrumb-item>视频添加</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="form-box">
      <el-form ref="video" :model="video" class="form-video" label-width="80px">
        <el-form-item label="视频名称">
          <el-input v-model="video.title"></el-input>
        </el-form-item>
        <el-form-item label="讲师">
          <el-input v-model="video.teacherName"></el-input>
        </el-form-item>
        <el-form-item label="视频描述">
          <el-input type="textarea" v-model="video.comment"></el-input>
        </el-form-item>
        <el-form-item label="文件上传">
          <el-upload
            class="upload-demo"
            ref="upload"
            drag
            action="/api/admin/video/upload"
            :on-success="uploadSuccess"
            :auto-upload="true"
            :limit="1"
            :on-exceed="uploadExceed"
          >
            <i class="el-icon-upload"></i>
            <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
            <!--<div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>-->
          </el-upload>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">提交</el-button>
          <el-button>取消</el-button>
        </el-form-item>
      </el-form>
    </div>

  </div>
</template>

<script>
  export default {
    data: function () {
      return {
        video: {
          title: "",
          teachName: "",
          comment: "",
          fileName: ""
        },
        url: ""
      }
    },
    methods: {
      onSubmit() {
        this.$http.post(this.url, this.video).then((response) => {
          if(response.data.status == 0){
            this.$alert("提交成功", "成功");
            window.location.href = "/admin/video-table";
          } else if(response.data.status > 0){
            this.$alert("提交失败！" + response.data.msg, "错误");
          } else{
            this.$alert("提交失败！请稍后重试或咨询管理员", "错误");
          }
        });
      },
      uploadExceed() {
        this.$message.warning("一次仅允许一个视频上传！更换视频请删掉并重新上传");
      },
      uploadSuccess(response, file, filseList){
        if(response.status == 0){
          this.video.fileName = response.data;
          this.$message.success(this.video.title + "上传临时区成功");
        } else if(response.status > 0){
          this.$message.warning(response.data.msg);
        } else{
          this.$message.error(response.data.msg);
        }
      }
    }
  }
</script>
