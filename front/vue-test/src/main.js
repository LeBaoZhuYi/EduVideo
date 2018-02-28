import Vue from 'vue'
import Vuex from 'vuex'
import App from './App'
import router from './router'
import axios from 'axios'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';    // 默认主题
import 'babel-polyfill'

Vue.use(Vuex);
Vue.use(ElementUI);
Vue.prototype.$http = axios;

Vue.config.productionTip = false;
Vue.prototype.setLocalStorage = function (key, value) {
  if (value == null) {
    return;
  }
  let curTime = new Date().getTime();
  localStorage.setItem(key, JSON.stringify({data: value, time: curTime}));
};
Vue.prototype.getLocalStorage = function (key, value) {
  let data = localStorage.getItem(key);
  if (data == null) {
    return null;
  }
  let dataObj = JSON.parse(data);
  let exp = 1000 * 60 * 300;
  if (new Date().getTime() - dataObj.time > exp) {
    localStorage.removeItem(key);
    return localStorage.getItem(key);
  } else {
    let dataObjDatatoJson = JSON.parse(dataObj.data);
    return dataObjDatatoJson;
  }
};
Vue.prototype.dateToString = function (date) {
  let y = date.getFullYear();
  let m = date.getMonth() + 1;
  m = m < 10 ? ('0' + m) : m;
  let d = date.getDate();
  d = d < 10 ? ('0' + d) : d;
  let h = date.getHours();
  h = h < 10 ? ('0' + h) : h;
  let minute = date.getMinutes();
  let second = date.getSeconds();
  minute = minute < 10 ? ('0' + minute) : minute;
  second = second < 10 ? ('0' + second) : second;
  return y + '-' + m + '-' + d + ' ' + h + ':' + minute + ':' + second;
};
Vue.prototype.timestampToString = function (timeStamp) {
  let date = new Date(timeStamp);
  return this.dateToString(date);
};
Vue.prototype.formatObjectData = function (data) {
  Object.keys(data).forEach(k => {
    if (data[k] == undefined) {
      data[k] = "";
    }
    if (k == "ctime" || k == "startTime" || k == "endTime") {
      data[k] = this.timestampToString(data[k]);
    } else {
      data[k] = String(data[k]);
    }
  });
};

Vue.prototype.setCookie = function (name, value, exDays) {
  let d = new Date();
  d.setTime(d.getTime() + (exDays * 24 * 60 * 60 * 1000));
  let expires = "expires=" + d.toUTCString();
  document.cookie = name + "=" + value + "; " + expires;
};
Vue.prototype.clearCookie = function (name) {
  this.setCookie(name, "", -1);
};
Vue.prototype.getCookie = function (cname) {
  let name = cname + "=";
  let ca = document.cookie.split(';');
  for (let i = 0; i < ca.length; i++) {
    let c = ca[i];
    while (c.charAt(0) == ' ') c = c.substring(1);
    if (c.indexOf(name) != -1) return c.substring(name.length, c.length);
  }
  return "";
};
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: {App},
  //监听路由检查登录
  watch: {
    "$route": 'checkLogin'
  },
  //进入页面时
  beforeMount() {
    this.checkLogin();
  },
  methods: {
    checkLogin() {
      if ((navigator.userAgent.match(/(iPhone|iPod|Android|ios|iOS|iPad|Backerry|WebOS|Symbian|Windows Phone|Phone)/i))) {
        this.$router.push('/b');
      }
      if (this.$route.path == "/b" || this.$route.path == "/" || this.$route.path == "/index"
        || this.$route.path == "/document" || this.$route.path == "/noAuth" || this.$route.path == "/admin/noAuth") {
        return;
      }
      if (this.$route.path.indexOf("/admin") >= 0) {
        if (this.$route.path == "/admin/login") {
          return;
        }
        let checkUrl = '/api/admin/user/checkLogin';
        this.$http.get(checkUrl).then((response) => {
          if (response.data.status != 0) {
            this.$message.error('当前并未登录');
            window.location.href = "/admin/noAuth";
            return;
          }
        });
        return;
      } else {
        let checkUrl = '/api/user/checkLogin';
        this.$http.get(checkUrl).then((response) => {
          if (response.data.status != 0) {
            this.$message.error('当前并未登录');
            window.location.href = "/noAuth";
            return;
          }
        });
      }
    }
  }
});
