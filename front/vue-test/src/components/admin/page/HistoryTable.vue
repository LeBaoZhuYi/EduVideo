<template>
  <div class="table">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item><i class="el-icon-menu"></i> 表格</el-breadcrumb-item>
        <el-breadcrumb-item>用户列表</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="handle-box">
      <el-input v-model="select_word" placeholder="筛选关键词" class="handle-input mr10"></el-input>
      <el-button type="primary" icon="search" @click="search">搜索</el-button>
    </div>
    <el-table :data="data" border style="width: 100%">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="id" label="序号" sortable width="150">
      </el-table-column>
      <el-table-column prop="studyName" label="学生姓名" width="120">
      </el-table-column>
      <el-table-column prop="className" label="课程名" width="240">
      </el-table-column>
      <el-table-column prop="time" label="时间">
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
  </div>
</template>
<script>
  export default {
    data() {
      return {
        url: '/api/admin/history/getList',
        total: 0,
        currentPage: 1,
        pageSize: 5,
        dialogFormVisible: false,
        selectTable: {},
        select_cate: '',
        select_word: '',
        del_list: [],
        is_search: false,
        tableData: [],
        allData: [{
          id: '1',
          studyName: '好滋好味鸡蛋仔',
          className: '',
          ctime: (new Date()).toDateString()
        }, {
          id: '2',
          studyName: '好滋好味鸡蛋仔',
          className: '',
          ctime: (new Date()).toDateString()
        }, {
          id: '3',
          studyName: '好滋好味鸡蛋仔',
          className: '',
          ctime: (new Date()).toDateString()
        }]
      }
    },
    created() {
      // this.getData();
      this.tableData = this.allData;
      this.handleCurrentChange(1);
    },
    computed: {
      data() {
        const self = this;
        self.filtedTableData = self.allData.filter(function (d) {
          self.formatObjectData(d);
          let is_del = false;
          for (let i = 0; i < self.del_list.length; i++) {
            if (d.studyName === self.del_list[i].studyName) {
              is_del = true;
              break;
            }
          }
          if (!is_del) {
            let flag = false;
            Object.values(d).forEach(v => {
              if (v.indexOf(self.select_word) > -1) {
                flag = true;
                return;
              }
            });
            if (flag) {
              return d;
            }
          }
        });
        self.total = self.filtedTableData.length;
        return self.computeTableData(self.filtedTableData);
      }
    },
    methods: {
      getData() {
        const self = this;
        this.$http.get(this.url).then((response) => {
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
      }
    }
  }
</script>

<style scoped>
  .handle-box {
    margin-bottom: 20px;
  }

  .handle-input {
    width: 300px;
    display: inline-block;
  }
</style>
