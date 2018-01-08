import Vue from 'vue';
import Router from 'vue-router';

Vue.use(Router);

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            redirect: '/home'
        },
        {
            path: '/user',
            component: resolve => require(['../components/Video.vue'], resolve),
            children:[
                {
                  path: '/video',
                  component: resolve => require(['../components/Video.vue'], resolve)
                }
            ]
        },
        {
            path: '/admin',
            component: resolve => require(['../components/admin/Home.vue'], resolve),
            children:[
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
                    path: '/baseform',
                    component: resolve => require(['../components/admin/page/BaseForm.vue'], resolve)
                },
                {
                    path: '/vueeditor',
                    component: resolve => require(['../components/admin/page/VueEditor.vue'], resolve)    // Vue-Quill-Editor组件
                },
                {
                    path: '/markdown',
                    component: resolve => require(['../components/admin/page/Markdown.vue'], resolve)     // Vue-Quill-Editor组件
                },
                {
                    path: '/upload',
                    component: resolve => require(['../components/admin/page/Upload.vue'], resolve)       // Vue-Core-Image-Upload组件
                },
                {
                    path: '/basecharts',
                    component: resolve => require(['../components/admin/page/BaseCharts.vue'], resolve)   // vue-schart组件
                },
                {
                  path: '/login',
                  component: resolve => require(['../components/admin/page/Login.vue'], resolve)
                },
                {
                    path: '/drag',
                    component: resolve => require(['../components/admin/page/DragList.vue'], resolve)    // 拖拽列表组件
                }
            ]
        },
        {
            path: '/home',
            component: resolve => require(['../components/Home.vue'], resolve)
        },
        {
          path: '/test',
          component: resolve => require(['../components/topic/Art.vue'], resolve)
        }
    ]
})
