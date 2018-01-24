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
                        title: '用户管理',
                        subs: [
                          {
                            index: 'user-table',
                            title: '用户列表'
                          },
                          {
                            index: 'auth-table',
                            title: '用户视频权限表'
                          },
                          {
                            index: 'history-table',
                            title: '用户观看历史表'
                          }
                        ]
                    },
                  {
                    icon: 'el-icon-menu',
                    index: '2',
                    title: '视频管理',
                    subs: [
                      {
                        index: 'basetable',
                        title: '视频列表'
                      },
                      {
                        index: 'authtable',
                        title: '课程时间表'
                      },
                      {
                        index: 'authtable',
                        title: '视频观看统计表'
                      }
                    ]
                  },
                  {
                    icon: 'el-icon-date',
                    index: '3',
                    title: '管理操作',
                    subs: [
                      {
                        index: 'baseform',
                        title: '添加课程'
                      },
                      {
                        index: 'vueeditor',
                        title: '新增用户'
                      },
                      {
                        index: 'markdown',
                        title: 'markdown'
                      },
                      {
                        index: 'upload',
                        title: '文件上传'
                      }
                    ]
                  },
                  {
                    icon: 'el-icon-star-on',
                    index: 'basecharts',
                    title: '图表'
                  },
                  {
                    icon: 'el-icon-upload2',
                    index: 'drag',
                    title: '拖拽'
                  }
                ]
            }
        },
        computed:{
            onRoutes(){
                return this.$route.path.replace('/','');
            }
        }
    }
</script>

<style scoped>
    .sidebar{
        display: block;
        position: absolute;
        width: 250px;
        left: 0;
        top: 70px;
        bottom:0;
        background: #2E363F;
    }
    .sidebar > ul {
        height:100%;
    }
</style>
