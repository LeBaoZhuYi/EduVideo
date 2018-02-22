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
              <el-form-item label="爱吃食物">
                <span>{{ props.row.food }}</span>
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
              <el-form-item label="学生状态">
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
        <el-table-column prop="studyGroup" label="学生分组">
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
            <el-input v-model="selectTable.loginName"></el-input>
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
        is_search: false,
        tableData: [],
        allData: [{
          id: '1',
          studyId: '好滋好味鸡蛋仔',
          studyName: '好滋好味鸡蛋仔',
          groupName: '',
          ctime: (new Date()).toDateString(),
          studyIntro: '好滋好味鸡蛋仔',
          teacherRemark: '好滋好味鸡蛋仔',
          parentWords: '好滋好味鸡蛋仔',
          birthday: '江浙小吃、小吃零食',
          food: '荷兰优质淡奶，奶香浓而不腻',
          interest: '上海市普陀区真北路',
          disagree: '王小虎夫妻店',
          ideal: '10333',
          status: '10333',
          loginName: 'en'
        }, {
          id: '2',
          studyId: '好滋好味鸡蛋仔',
          studyName: '好滋好味鸡蛋仔',
          groupName: '',
          ctime: (new Date()).toDateString(),
          studyIntro: '好滋好味鸡蛋仔',
          teacherRemark: '好滋好味鸡蛋仔',
          parentWords: '好滋好味鸡蛋仔',
          birthday: '江浙小吃、小吃零食',
          food: '荷兰优质淡奶，奶香浓而不腻',
          interest: '上海市普陀区真北路',
          disagree: '王小虎夫妻店',
          ideal: '10333',
          status: '10333',
          loginName: 'en'
        }, {
          id: '3',
          studyId: '好滋好味鸡蛋仔',
          studyName: '好滋好味鸡蛋仔',
          groupName: '',
          ctime: (new Date()).toDateString(),
          studyIntro: '好滋好味鸡蛋仔',
          teacherRemark: '好滋好味鸡蛋仔',
          parentWords: '好滋好味鸡蛋仔',
          birthday: '江浙小吃、小吃零食',
          food: '荷兰优质淡奶，奶香浓而不腻',
          interest: '上海市普陀区真北路',
          disagree: '王小虎夫妻店',
          ideal: '10333',
          status: '10333',
          loginName: 'en'
        }, {
          id: '4',
          studyId: '好滋好味鸡蛋仔',
          studyName: '好滋好味鸡蛋仔',
          groupName: '',
          ctime: (new Date()).toDateString(),
          studyIntro: '好滋好味鸡蛋仔',
          teacherRemark: '好滋好味鸡蛋仔',
          parentWords: '好滋好味鸡蛋仔',
          birthday: '江浙小吃、小吃零食',
          food: '荷兰优质淡奶，奶香浓而不腻',
          interest: '上海市普陀区真北路',
          disagree: '王小虎夫妻店',
          ideal: '10333',
          status: '10333',
          loginName: 'en'
        }, {
          id: '5',
          studyId: '好滋好味鸡蛋仔',
          studyName: '好滋好味鸡蛋仔',
          groupName: '',
          ctime: (new Date()).toDateString(),
          studyIntro: '好滋好味鸡蛋仔',
          teacherRemark: '好滋好味鸡蛋仔',
          parentWords: '好滋好味鸡蛋仔',
          birthday: '江浙小吃、小吃零食',
          food: '荷兰优质淡奶，奶香浓而不腻',
          interest: '上海市普陀区真北路',
          disagree: '王小虎夫妻店',
          ideal: '10333',
          status: '10333',
          loginName: 'en'
        }, {
          id: '6',
          studyId: '好滋好味鸡蛋仔',
          studyName: '好滋好味鸡蛋仔',
          groupName: '',
          ctime: (new Date()).toDateString(),
          studyIntro: '好滋好味鸡蛋仔',
          teacherRemark: '好滋好味鸡蛋仔',
          parentWords: '好滋好味鸡蛋仔',
          birthday: '江浙小吃、小吃零食',
          food: '荷兰优质淡奶，奶香浓而不腻',
          interest: '上海市普陀区真北路',
          disagree: '王小虎夫妻店',
          ideal: '10333',
          status: '10333'
        }, {
          id: '7',
          studyId: '好滋好味鸡蛋仔',
          studyName: '好滋好味鸡蛋仔',
          groupName: '',
          ctime: (new Date()).toDateString(),
          studyIntro: '好滋好味鸡蛋仔',
          teacherRemark: '好滋好味鸡蛋仔',
          parentWords: '好滋好味鸡蛋仔',
          birthday: '江浙小吃、小吃零食',
          food: '荷兰优质淡奶，奶香浓而不腻',
          interest: '上海市普陀区真北路',
          disagree: '王小虎夫妻店',
          ideal: '10333',
          status: '10333'
        }, {
          id: '8',
          studyId: '好滋好味鸡蛋仔',
          studyName: '好滋好味鸡蛋仔',
          groupName: '',
          ctime: (new Date()).toDateString(),
          studyIntro: '好滋好味鸡蛋仔',
          teacherRemark: '好滋好味鸡蛋仔',
          parentWords: '好滋好味鸡蛋仔',
          birthday: '江浙小吃、小吃零食',
          food: '荷兰优质淡奶，奶香浓而不腻',
          interest: '上海市普陀区真北路',
          disagree: '王小虎夫妻店',
          ideal: '10333',
          status: '10333'
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
