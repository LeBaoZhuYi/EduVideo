<template>
  <div class="table">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item><i class="el-icon-menu"></i> 表格</el-breadcrumb-item>
        <el-breadcrumb-item>视频列表</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="handle-box">
      <el-select v-model="select_cate" placeholder="筛选分组" class="handle-select mr10">
        <el-option key="1" label="选项一" value="选项一"></el-option>
        <el-option key="2" label="选项二" value="选项二"></el-option>
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
              <el-form-item label="视频名">
                <span>{{ props.row.title }}</span>
              </el-form-item>
              <el-form-item label="简介">
                <span>{{ props.row.comment }}</span>
              </el-form-item>
              <el-form-item label="状态">
                <span>{{ props.row.status }}</span>
              </el-form-item>
              <el-form-item label="点播次数">
                <span>{{ props.row.watchedTimes }}</span>
              </el-form-item>
              <el-form-item label="创建时间">
                <span>{{ props.row.ctime }}</span>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column prop="id" label="编号" sortable width="120">
        </el-table-column>
        <el-table-column prop="title" label="视频名" width="120">
        </el-table-column>
        <el-table-column prop="status" label="状态">
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
      <el-dialog title="修改视频信息" :visible.sync="dialogFormVisible">
        <el-form :model="selectTable">
          <el-form-item label="视频名称" label-width="100px">
            <el-input v-model="selectTable.title" auto-complete="off"></el-input>
          </el-form-item>
          <el-form-item label="视频简介" label-width="100px">
            <el-input type="textarea" v-model="selectTable.comment"></el-input>
          </el-form-item>
          <el-form-item label="状态" label-width="100px">
            <el-input v-model="selectTable.status"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="">确 定</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        url: '/static/UserTable.json',
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
          title: '好滋好味鸡蛋仔',
          comment: '奶香浓而不腻',
          status: '1',
          ctime: (new Date()).toDateString()
        }, {
          id: '2',
          title: '好滋好味鸡蛋仔',
          comment: '奶香浓而不腻',
          status: '1',
          ctime: (new Date()).toDateString()
        }, {
          id: '3',
          title: '好滋好味鸡蛋仔',
          comment: '奶香浓而不腻',
          status: '1',
          ctime: (new Date()).toDateString()
        }, {
          id: '4',
          title: '好滋好味鸡蛋仔',
          comment: '奶香浓而不腻',
          status: '1',
          ctime: (new Date()).toDateString()
        }]

      }
    },
    created() {
      this.getData();
      // this.tableData = this.allData;
      this.handleCurrentChange(1);
    },
    computed: {
      data() {
        const self = this;
        self.filtedTableData = self.allData.filter(function (d) {
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
        });
        self.total = self.filtedTableData.length;
        return self.computeTableData(self.filtedTableData);
      }
    },
    methods: {
      getData() {
//                if(process.env.NODE_ENV === 'development'){
//                    this.url = '/ms/table/list';
//                };
//         this.$http.get(this.url, {page: this.cur_page}).then((res) => {
//           this.tableData = res.data.list;
//         })
      },
      search() {
        this.is_search = true;
      },
      handleEdit(index, row) {
        this.dialogFormVisible = true;
        this.selectTable = row;
      },
      handleDelete(index, row) {
        this.$message.error('删除第' + (index + 1) + '行');
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
