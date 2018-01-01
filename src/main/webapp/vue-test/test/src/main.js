// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import Vuex from 'vuex'
import App from './App'
import router from './router'
import axios from 'axios'
Vue.use(Vuex)
Vue.prototype.$http = axios;

Vue.config.productionTip = false
// Vuex配置
  const store = new Vuex.Store({
  state: {
    domain:'http://test.example.com', //保存后台请求的地址，修改时方便（比方说从测试服改成正式服域名）
    userInfo: { //保存用户信息
      nick: null,
      ulevel: null,
      uid: null,
      portrait: null
    }
  },
  mutations: {
    //更新用户信息
    updateUserInfo(state, newUserInfo) {
      state.userInfo = newUserInfo;
    }
  }
})
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App },
  //监听路由检查登录
  watch:{
    "$route" : 'checkLogin'
  },
  //进入页面时
  created() {
    this.checkLogin();
  },
  methods: {
    checkLogin() {
      //检查是否存在session
      //cookie操作方法在源码里有或者参考网上的即可
      if (!this.getCookie('session')) {
        //如果没有登录状态则跳转到登录页
        this.$router.push('/login');
      } else {
        //否则跳转到登录后的页面
        this.$router.push('/user_info');
      }
    }
  }
})
Vue.filter('formatDate', function(str) {
		    if (!str) return ''
		    var date = new Date(str)
		    var time = new Date().getTime() - date.getTime() //现在的时间-传入的时间 = 相差的时间（单位 = 毫秒）
		    if (time < 0) {
		        return ''
		    } else if ((time / 1000 < 30)) {
		        return '刚刚'
		    } else if (time / 1000 < 60) {
		        return parseInt((time / 1000)) + '秒前'
		    } else if ((time / 60000) < 60) {
		        return parseInt((time / 60000)) + '分钟前'
		    } else if ((time / 3600000) < 24) {
		        return parseInt(time / 3600000) + '小时前'
		    } else if ((time / 86400000) < 31) {
		        return parseInt(time / 86400000) + '天前'
		    } else if ((time / 2592000000) < 12) {
		        return parseInt(time / 2592000000) + '月前'
		    } else {
		        return parseInt(time / 31536000000) + '年前'
		    }
		}
)
