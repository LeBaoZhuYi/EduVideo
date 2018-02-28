<template>
  <div class="table">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item><i class="el-icon-menu"></i> 表格</el-breadcrumb-item>
        <el-breadcrumb-item>视频列表</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="handle-box">
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
          <template slot-scope="props">
            <el-button v-if="props.row.status == '上传失败'" size="small" type="warning"
                       @click="restartUpload(props.$index, props.row)">重新上传
            </el-button>
            <el-button v-if="props.row.status == '正常' || props.row.status == '停用' || props.row.status == '等待手动编辑'" size="small"
                       @click="handleEdit(props.$index, props.row)">编辑
            </el-button>
            <el-button size="small" type="danger"
                       @click="handleDelete(props.$index, props.row)">删除
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
          <el-form-item label="FileId" label-width="100px">
            <el-input type="textarea" v-model="selectTable.fileId"></el-input>
          </el-form-item>
          <el-form-item label="源地址" label-width="100px">
            <el-input type="textarea" v-model="selectTable.od"></el-input>
          </el-form-item>
          <el-form-item label="转码标清" label-width="100px">
            <el-input type="textarea" v-model="selectTable.sd"></el-input>
          </el-form-item>
          <el-form-item label="转码高清" label-width="100px">
            <el-input type="textarea" v-model="selectTable.hd"></el-input>
          </el-form-item>
          <el-form-item label="状态">
            <el-radio-group v-model="selectTable.status">
              <el-radio label="正常"></el-radio>
              <el-radio label="停用"></el-radio>
            </el-radio-group>
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
  import qs from 'qs'
  export default {
    data() {
      return {
        tableUrl: '/api/admin/video/getList',
        updateUrl: '/api/admin/video/update',
        deleteUrl: '/api/admin/video/delete',
        restartUploadUrl: '/api/admin/video/restartUpload',
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
        allData: []

      }
    },
    mounted() {
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
                window.location.href = "/admin/video-table";
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
                window.location.href = "/admin/video-table";
              }
            });
          } else if (response.data.status > 0) {
            this.$message.error("删除失败！" + response.data.msg);
          } else {
            this.$message.error("删除失败！请稍后重试或咨询管理员");
          }
        });
      },
      restartUpload(index, row){
        let params = new URLSearchParams();
        params.append("id", row.id);
        this.$http.post(this.restartUploadUrl, params).then((response) => {
          if (response.data.status == 0) {
            this.$alert('重启成功，请稍等后刷新', '提示', {
              confirmButtonText: '确定',
              callback: action => {
                window.location.href = "/admin/video-table";
              }
            });
          } else if (response.data.status > 0) {
            this.$message.error("重启失败！" + response.data.msg);
          } else {
            this.$message.error("重启失败！请稍后重试或咨询管理员");
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
