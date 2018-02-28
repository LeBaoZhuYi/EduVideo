import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      redirect: '/index'
    },
    {
      path: '/b',
      component: resolve => require(['../components/B.vue'], resolve)
    },
    {
      path: '/admin',
      redirect: '/admin/index'
    },
    {
      path: '/admin',
      component: resolve => require(['../components/admin/Home.vue'], resolve),
      children: [
        {
          path: '/admin/index',
          component: resolve => require(['../components/admin/page/Readme.vue'], resolve)
        },
        {
          path: '/admin/student-table',
          component: resolve => require(['../components/admin/page/StudentTable.vue'], resolve)
        },
        {
          path: '/admin/group-table',
          component: resolve => require(['../components/admin/page/GroupTable.vue'], resolve)
        },
        {
          path: '/admin/history-table',
          component: resolve => require(['../components/admin/page/HistoryTable.vue'], resolve)
        },
        {
          path: '/admin/video-table',
          component: resolve => require(['../components/admin/page/VideoTable.vue'], resolve)
        },
        {
          path: '/admin/class-table',
          component: resolve => require(['../components/admin/page/ClassTable.vue'], resolve)
        },
        {
          path: '/admin/add-video',
          component: resolve => require(['../components/admin/page/AddVideo.vue'], resolve)
        },
        {
          path: '/admin/add-student',
          component: resolve => require(['../components/admin/page/AddStudent.vue'], resolve)
        },
        {
          path: '/admin/add-class',
          component: resolve => require(['../components/admin/page/AddClass.vue'], resolve)
        },
        {
          path: '/admin/add-group',
          component: resolve => require(['../components/admin/page/AddGroup.vue'], resolve)       // Vue-Core-Image-Upload组件
        },
        {
          path: '/admin/login',
          component: resolve => require(['../components/admin/page/Login.vue'], resolve)
        }
      ]
    },
    {
      path: '/index',
      component: resolve => require(['../components/Index.vue'], resolve)
    },
    {
      path: '/home',
      component: resolve => require(['../components/Home.vue'], resolve)
    },
    {
      path: '/person',
      component: resolve => require(['../components/Person.vue'], resolve)
    },
    {
      path: '/test',
      component: resolve => require(['../components/Test.vue'], resolve)
    },
    {
      path: '/test2',
      component: resolve => require(['../components/Test2.vue'], resolve)
    }
  ]
})
