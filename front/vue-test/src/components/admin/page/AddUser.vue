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
          <el-input v-model="form.stuName"></el-input>
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
        <el-form-item>
          <el-button type="primary" @click="onSubmit">提交</el-button>
        </el-form-item>
      </el-form>
    </div>

  </div>
</template>

<script>
  export default {
    data: function () {
      return {
        form: {
          loginName: "",
          password: "",
          stuName: "",
          phone: "",
          sex: ""
        }
      }
    },
    methods: {
      onSubmit() {
        this.$message.success('提交成功！');
      }
    }
  }
</script>
