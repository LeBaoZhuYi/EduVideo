<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item><i class="el-icon-date"></i> 管理</el-breadcrumb-item>
        <el-breadcrumb-item>视频添加</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="form-box">
      <el-form ref="video" :model="form" class="form-video" label-width="80px">
        <el-form-item label="视频名称">
          <el-input v-model="form.title"></el-input>
        </el-form-item>
        <el-form-item label="视频描述">
          <el-input type="textarea" v-model="form.comment"></el-input>
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
          <el-button type="primary" @click="create()">提交</el-button>
          <el-button>取消</el-button>
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
          title: "",
          comment: "",
          fileName: ""
        },
        createUrl: '/api/admin/video/create'
      }
    },
    methods: {
      create() {
        const self = this;
        let postData = qs.stringify(self.form);
        self.$http.post(self.createUrl, postData).then((response) => {
          if(response.data.status == 0){
            self.$confirm('添加成功，是否跳转到列表', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '留在此处',
              type: 'warning'
            }).then(() => {
              window.location.href = "/admin/video-table";
            });
          } else if(response.data.status > 0){
            self.$message.error("添加失败！" + response.data.msg);
          } else{
            self.$message.error("添加失败！请稍后重试或咨询管理员");
          }
        });
      },
      uploadExceed() {
        this.$message.warning("一次仅允许一个视频上传！更换视频请删掉并重新上传");
      },
      uploadSuccess(response, file, filseList){
        if(response.status == 0){
          this.form.fileName = response.data;
          this.$message.success(this.form.title + "上传临时区成功");
        } else if(response.status > 0){
          this.$message.error(response.msg);
        } else{
          this.$message.error(response.msg);
        }
      }
    }
  }
</script>
