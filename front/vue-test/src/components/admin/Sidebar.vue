<template>
  <div class="sidebar">
    <el-menu :default-active="onRoutes" class="el-menu-vertical-demo" theme="dark" unique-opened router>
      <template v-for="item in items">
        <template v-if="item.subs">
          <el-submenu :index="item.index">
            <template slot="title"><i :class="item.icon"></i>{{ item.title }}</template>
            <el-menu-item v-for="(subItem,i) in item.subs" :key="i" :index="subItem.index">{{ subItem.title }}
            </el-menu-item>
          </el-submenu>
        </template>
        <template v-else>
          <el-menu-item :index="item.index">
            <i :class="item.icon"></i>{{ item.title }}
          </el-menu-item>
        </template>
      </template>
    </el-menu>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        items: [
          {
            icon: 'el-icon-menu',
            index: '1',
            title: '学生管理',
            subs: [
              {
                index: 'student-table',
                title: '学生列表'
              },
              {
                index: 'group-table',
                title: '学生分组列表'
              },
              {
                index: 'history-table',
                title: '用户课程历史表'
              }
            ]
          },
          {
            icon: 'el-icon-bell',
            index: '2',
            title: '视频管理',
            subs: [
              {
                index: 'video-table',
                title: '视频列表'
              },
              {
                index: 'class-table',
                title: '课程时间表'
              }
            ]
          },
          {
            icon: 'el-icon-date',
            index: '3',
            title: '管理操作',
            subs: [
              {
                index: 'add-video',
                title: '添加视频'
              },
              {
                index: 'add-group',
                title: '添加分组'
              },
              {
                index: 'add-class',
                title: '添加课程'
              },
              {
                index: 'add-student',
                title: '添加学生'
              }
            ]
          }
        ]
      }
    },
    computed: {
      onRoutes() {
        // return this.$route.path.replace('/','');
      }
    }
  }
</script>

<style scoped>
  .sidebar {
    display: block;
    position: absolute;
    width: 250px;
    left: 0;
    top: 70px;
    bottom: 0;
    background: #2E363F;
  }

  .sidebar > ul {
    height: 100%;
  }
</style>
