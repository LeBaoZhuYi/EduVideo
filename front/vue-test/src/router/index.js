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
      component: resolve => require(['../components/admin/Home.vue'], resolve),
      children: [
        {
          path: '/',
          component: resolve => require(['../components/admin/page/Readme.vue'], resolve)
        },
        {
          path: '/user-table',
          component: resolve => require(['../components/admin/page/UserTable.vue'], resolve)
        },
        {
          path: '/auth-table',
          component: resolve => require(['../components/admin/page/AuthTable.vue'], resolve)
        },
        {
          path: '/history-table',
          component: resolve => require(['../components/admin/page/HistoryTable.vue'], resolve)
        },
        {
          path: '/add-video',
          component: resolve => require(['../components/admin/page/AddVideo.vue'], resolve)
        },
        {
          path: '/add-user',
          component: resolve => require(['../components/admin/page/AddUser.vue'], resolve)
        },
        {
          path: '/add-class',
          component: resolve => require(['../components/admin/page/AddClass.vue'], resolve)
        },
        {
          path: '/auth-manage',
          component: resolve => require(['../components/admin/page/AuthManage.vue'], resolve)       // Vue-Core-Image-Upload组件
        },
        {
          path: '/login',
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
