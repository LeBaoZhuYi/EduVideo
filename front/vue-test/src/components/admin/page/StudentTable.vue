<template>
  <div class="table">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item><i class="el-icon-menu"></i> 表格</el-breadcrumb-item>
        <el-breadcrumb-item>学生列表</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="handle-box">
      <el-select v-model="select_cate" placeholder="筛选分组" class="handle-select mr10">
        <el-option v-for="group in groupList" :label="group.name" :value="group.name"
                   :key="group.id"></el-option>
      </el-select>
      <el-input v-model="select_word" placeholder="筛选关键词" class="handle-input mr10"></el-input>
      <el-button type="primary" icon="search" @click="search">搜索</el-button>
    </div>
    <div>
      <el-table :data="data" border style="width: 100%">
        <el-table-column type="expand">
          <template slot-scope="props">
            <el-form label-position="left" inline class="demo-table-expand">
              <el-form-item label="编号">
                <span>{{ props.row.id }}</span>
              </el-form-item>
              <el-form-item label="学号">
                <span>{{ props.row.studyId }}</span>
              </el-form-item>
              <el-form-item label="学生名">
                <span>{{ props.row.studyName }}</span>
              </el-form-item>
              <el-form-item label="创建时间">
                <span>{{ props.row.ctime }}</span>
              </el-form-item>
              <el-form-item label="分组">
                <span>{{ props.row.groupName }}</span>
              </el-form-item>
              <el-form-item label="学生简介">
                <span>{{ props.row.studyIntro }}</span>
              </el-form-item>
              <el-form-item label="老师评价">
                <span>{{ props.row.teacherRemark }}</span>
              </el-form-item>
              <el-form-item label="家长的话">
                <span>{{ props.row.parentWords }}</span>
              </el-form-item>
              <el-form-item label="联系方式">
                <span>{{ props.row.phone }}</span>
              </el-form-item>
              <el-form-item label="生日">
                <span>{{ props.row.birthday }}</span>
              </el-form-item>
              <el-form-item label="爱好">
                <span>{{ props.row.interest }}</span>
              </el-form-item>
              <el-form-item label="不喜欢">
                <span>{{ props.row.disagree }}</span>
              </el-form-item>
              <el-form-item label="理想">
                <span>{{ props.row.ideal }}</span>
              </el-form-item>
              <el-form-item label="登录账号">
                <span>{{ props.row.loginName }}</span>
              </el-form-item>
              <el-form-item label="用户状态">
                <span>{{ props.row.status }}</span>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column prop="id" label="学生编号" sortable width="120">
        </el-table-column>
        <el-table-column prop="studyId" label="学生学号" width="120">
        </el-table-column>
        <el-table-column prop="studyName" label="学生姓名" width="120">
        </el-table-column>
        <el-table-column prop="groupName" label="学生分组">
        </el-table-column>
        <el-table-column prop="ctime" label="创建时间">
        </el-table-column>
        <el-table-column label="操作" width="180">
          <template scope="scope">
            <el-button size="small"
                       @click="handleEdit(scope.$index, scope.row)">编辑
            </el-button>
            <el-button size="small" type="danger"
                       @click="handleDelete(scope.$index, scope.row)">删除
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <div class="pagination">
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-sizes="[5, 10, 20]"
          :page-size="5"
          layout="sizes, prev, pager, next"
          :total="total">
        </el-pagination>
      </div>
      <el-dialog title="修改学生信息" :visible.sync="dialogFormVisible">
        <el-form :model="selectTable">
          <el-form-item label="学生名称" label-width="100px">
            <el-input v-model="selectTable.studyName" auto-complete="off"></el-input>
          </el-form-item>
          <el-form-item label="学生简介" label-width="100px">
            <el-input v-model="selectTable.studyIntro"></el-input>
          </el-form-item>
          <el-form-item label="老师评语" label-width="100px">
            <el-input type="textarea" v-model="selectTable.teacherRemark"></el-input>
          </el-form-item>
          <el-form-item label="学生学号" label-width="100px">
            <el-input v-model="selectTable.studyId"></el-input>
          </el-form-item>
          <el-form-item label="登录账号" label-width="100px">
            <el-input v-model="selectTable.loginName">
            </el-input>
          </el-form-item>
          <el-form-item label="状态">
            <el-radio-group v-model="selectTable.status">
              <el-radio label="正常"></el-radio>
              <el-radio label="停用"></el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item>
          <el-alert
            title="select框中显示的当前值为选项的id而非选项名"
            type="info"
            close-text="了解">
          </el-alert>
          </el-form-item>
          <el-form-item label="学生分组id">
            <el-select v-model="selectTable.groupId" placeholder="请选择">
              <el-option v-for="group in groupList" :label="group.name" :value="group.id"
                         :key="group.id"></el-option>
            </el-select>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="update()">确 定</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>

<script>
  import qs from 'qs';
  export default {
    data() {
      return {
        tableUrl: '/api/admin/student/getList',
        updateUrl: '/api/admin/student/update',
        deleteUrl: '/api/admin/student/delete',
        total: 0,
        currentPage: 1,
        pageSize: 5,
        dialogFormVisible: false,
        selectTable: {},
        select_cate: '',
        select_word: '',
        is_search: false,
        tableData: [],
        allData: [],
        groupList: [],
        getNormalGroupListUrl: '/api/admin/studentGroup/getNormalList'
      }
    },
    mounted() {
      this.getGroupList();
      this.getData();
      // this.tableData = this.allData;
      this.handleCurrentChange(1);
    },
    computed: {
      data() {
        const self = this;
        self.filtedTableData = self.allData.filter(function (d) {
          let flag = false;
          self.formmatObjectData(d);
          if (d.groupName.indexOf(self.select_cate) > -1) {
            Object.values(d).forEach(v => {
              if (v.indexOf(self.select_word) > -1) {
                flag = true;
                return;
              }
            });
          }
          if (flag) {
            return d;
          }
        });
        self.total = self.filtedTableData.length;
        return self.computeTableData(self.filtedTableData);
      }
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
      getData() {
        const self = this;
        this.$http.get(this.tableUrl).then((response) => {
          if (response.data.status == 0) {
            self.allData = response.data.data;
          } else if (response.data.status > 0) {
            self.$message.error('获取分组列表失败！' + response.data.msg);
          } else {
            self.$message.error('获取分组列表失败！请稍后再试或联系管理员');
          }
        })
      },
      search() {
        this.is_search = true;
      },
      handleEdit(index, row) {
        this.dialogFormVisible = true;
        this.selectTable = row;
      },
      handleDelete(index, row) {
        this.$confirm('此操作将删除该记录, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.delete(row.id);
        }).catch(() => {
        });
      },
      handleCurrentChange(val) {
        this.currentPage = val;
      },
      handleSizeChange(val) {
        this.pageSize = val;
      },
      computeTableData(allData) {
        let page = this.currentPage;
        let pageSize = this.pageSize;
        return allData.slice(pageSize * (page - 1), pageSize * page);
      },
      update() {
        let postData = qs.stringify(this.selectTable);
        this.$http.post(this.updateUrl, postData).then((response) => {
          if (response.data.status == 0) {
            this.$alert('更新成功', '提示', {
              confirmButtonText: '确定',
              callback: action => {
                window.location.href = "/admin/student-table";
              }
            });
          } else if (response.data.status > 0) {
            this.$message.error("更新失败！" + response.data.msg);
          } else {
            this.$message.error("更新失败！请稍后重试或咨询管理员");
          }
        });
      },
      delete(id) {
        let params = new URLSearchParams();
        params.append("id", id);
        this.$http.post(this.deleteUrl, params).then((response) => {
          if (response.data.status == 0) {
            this.$alert('删除成功', '提示', {
              confirmButtonText: '确定',
              callback: action => {
                window.location.href = "/admin/student-table";
              }
            });
          } else if (response.data.status > 0) {
            this.$message.error("删除失败！" + response.data.msg);
          } else {
            this.$message.error("删除失败！请稍后重试或咨询管理员");
          }
        });
      }
    }
  }
</script>

<style scoped>
  .handle-box {
    margin-bottom: 20px;
  }

  .handle-select {
    width: 120px;
  }

  .handle-input {
    width: 300px;
    display: inline-block;
  }

  .demo-table-expand {
    font-size: 0;
  }

  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }

  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }
</style>
