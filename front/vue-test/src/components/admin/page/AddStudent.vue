<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item><i class="el-icon-date"></i> 添加</el-breadcrumb-item>
        <el-breadcrumb-item>添加学生</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="form-box">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="登录名">
          <el-input v-model="form.loginName"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="form.password"></el-input>
        </el-form-item>
        <el-form-item label="学生姓名">
          <el-input v-model="form.studyName"></el-input>
        </el-form-item>
        <el-form-item label="学生学号">
          <el-input v-model="form.studyId"></el-input>
        </el-form-item>
        <el-form-item label="电话">
          <el-input v-model="form.phone"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-radio-group v-model="form.sex">
            <el-radio label="男孩"></el-radio>
            <el-radio label="女孩"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="学生分组">
          <el-select v-model="form.groupId" placeholder="请选择">
            <el-option v-for="group in groupList" :label="group.name" :value="group.id"
                                                                         :key="group.id"></el-option>
          </el-select>
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
  import crypto from 'crypto';
  export default {
    data: function () {
      return {
        form: {
          loginName: "",
          password: "",
          studyName: "",
          studyId: "",
          phone: "",
          sex: "",
          groupId: ""
        },
        groupList: [],
        createUrl: '/api/admin/student/create',
        getNormalGroupListUrl: '/api/admin/studentGroup/getNormalList',
      }
    },
    mounted: function() {
      this.getGroupList();
    },
    methods: {
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
        const self = this;
        let originPassword = self.form.password;
        self.form.password = crypto.createHash("md5").update(self.form.password).digest("hex");
        let postData = qs.stringify(self.form);
        self.$http.post(self.createUrl, postData).then((response) => {
          self.form.password = originPassword;
          if(response.data.status == 0){
            self.$confirm('添加成功，是否跳转到列表', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '留在此处',
              type: 'warning'
            }).then(() => {
              window.location.href = "/admin/student-table";
            });
          } else if(response.data.status > 0){
            self.$message.error("添加失败！" + response.data.msg);
          } else{
            self.$message.error("添加失败！请稍后重试或咨询管理员");
          }
        });
      }
    }
  }
</script>
