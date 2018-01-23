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
                    <el-input v-model="video.name"></el-input>
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
                  :data="video"
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
        data: function(){
            return {
                video: {
                    name: '',
                    teachName: '',
                    comment: ''
                }
            }
        },
        methods: {
            onSubmit() {
//              this.$refs.upload.submit();
                this.$message.success('提交成功！');
            },

        }
    }
</script>
