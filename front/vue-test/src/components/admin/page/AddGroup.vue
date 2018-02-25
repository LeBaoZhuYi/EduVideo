<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item><i class="el-icon-date"></i> 添加</el-breadcrumb-item>
        <el-breadcrumb-item>添加分组</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="form-box">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="分组名">
          <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="描述">
          <el-input v-model="form.remark"></el-input>
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
          name: "",
          remark: ""
        },
        createUrl: '/api/admin/studentGroup/create'
      }
    },
    methods: {
      create() {
        let postData = qs.stringify(this.form)
        this.$http.post(this.createUrl, postData).then((response) => {
          if(response.data.status == 0){
            self.$confirm('添加成功，是否跳转到列表', '提示', {
              confirmButtonText: '确定',
              cancelButtonText: '留在此处',
              type: 'warning'
            }).then(() => {
              window.location.href = "/admin/group-table";
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
