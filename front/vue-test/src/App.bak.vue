<template>
  <div id="app" class="app">
    <page :currentPage="currentPage">
      <cn-header></cn-header>
      <login></login>
      <section class="animate">
      </section>
    </page>
    <page :currentPage="currentPage">
      <section class="animate">
      </section>
    </page>
    <page :currentPage="currentPage">
      <section class="animate">
      </section>
    </page>
    <page :currentPage="currentPage">
      <section class="animate">
      </section>
    </page>
    <page-controller :pageNum="pageNum" :currentPage="currentPage" @changePage="changePage" :option="controllerOption"></page-controller>
  </div>
</template>

<script>
  import cnHeader from './components/Header'
 import Login from './components/Login.vue';
import Page from './components/Page.vue';
import PageController from './components/PageController.vue';
// 页面进出动画
function afterEnterAnimate($child) {
  $child.$el.querySelector('.animate').classList.remove('move-left', 'move-right');
}
function beforeLeaveAnimate($child) {
  let moveType = Math.random() > 0.5 ? 'move-left' : 'move-right';
  $child.$el.querySelector('.animate').classList.add(moveType);
}
export default {
  name: 'app',
  data() {
    return {
      currentPage: 1,
      options: [{
        backgroundImage:"url(" + require("./assets/img/index1.jpg") + ")",
        // is content center
        // isCenter: true,
        // the function before page show
        afterEnter: afterEnterAnimate,
        // the function after page show
        beforeLeave: beforeLeaveAnimate
      }, {
        backgroundImage:"url(" + require("./assets/img/index2.jpg") + ")",
        isCenter: true,
        afterEnter: afterEnterAnimate,
        beforeLeave: beforeLeaveAnimate
      }, {
        backgroundImage:"url(" + require("./assets/img/index3.jpg") + ")",
        isCenter: true,
        afterEnter: afterEnterAnimate,
        beforeLeave: beforeLeaveAnimate
      }, {
        backgroundImage:"url(" + require("./assets/img/index4.jpg") + ")",
        isCenter: true,
        afterEnter: afterEnterAnimate,
        beforeLeave: beforeLeaveAnimate
      }],
      controllerOption: {
        arrowsType: false,
        navbar: true,
        highlight: true,
        loop: false
      }
    }
  },
  computed: {
    // 总page数
    pageNum() {
      return this.options.length;
    }
  },
  methods: {
    changePage(index) {
      // beforeLeave Hook
      let beforeIndex = this.currentPage - 1;
      let leaveFunction = this.options[beforeIndex].beforeLeave;
      typeof leaveFunction === 'function' && leaveFunction.call(this, this.$children[beforeIndex]);
      // change page
      this.currentPage = index;
      // afterEnter Hook
      let nextIndex = index - 1;
      let enterFunction = this.options[nextIndex].afterEnter;
      this.$nextTick(function() {
        typeof enterFunction === 'function' && enterFunction.call(this, this.$children[nextIndex]);
      })
    },
    //请求用户的一些信息
    getUserInfo() {
      this.userInfo = {
        nick: 'Doterlin',
        ulevel: 20,
        uid: '10000',
        portrait: 'images/profile.png'
      };
      //获取信息请求
      var url='www.baidu.com'
      this.$http.get(url, {
        //参数
        "params": this.userInfo
      }).then((response) => {
        //Success
        if(response.data.code == 0){
          this.$store.commit('updateUserInfo', this.userInfo);
        }
      },
      (response) =>{});
    }
  },
  components: {
    Page, PageController, Login,cnHeader
  },
  mounted() {
    //组件开始挂载时获取用户信息
    this.getUserInfo();
    this.$children.forEach((child, index) => {
      // 动态设置各个page内的options
      if (child.option === null) {
        let childOption = this.options[index];
        this.$set(childOption, 'index', index + 1);
        child.option = childOption;
      }
    });
  }
}
</script>

<style>
html,
body {
  margin: 0;
  padding: 0;
  height: 100%;
  width: 100%;
  overflow: hidden;
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #fff;
}
.app {
  height: 100%;
  width: 100%;
}
/* 下面的是与fullPage无关的样式 */
.animate {
  transition: all 1s ease-out 0s;
}
.move-left {
  transform: translateX(-1000%);
}
.move-right {
  transform: translateX(1000%);
}
@media screen and (max-width:768px) {
  html,
  body {
    font-size: 12px;
  }
}
a {
  text-decoration: none;
  color: inherit;
}
a:hover {
  text-decoration: underline;
}
.person-img {
  width: 223px;
  height: 185px;
  float: left;
  background-color: #fff;
  box-shadow: 3px 3px 10px #999;
}
.person-img img {
  height: 100%;
  width: 100%;
}
.person-basic-info {
  overflow: hidden;
  float: right;
  margin-left: 40px;
}
.info-line {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: flex-start;
}
.text-center {
  text-align: center;
}
.text-bold {
  font-weight: bold;
}
.demo-intro {
  text-indent: 2em;
}
dt {
  font-weight: bold;
  font-size: 16px;
}
ul {
  padding-left: 1em;
}
.avatar {
  margin: 10px auto;
  display: block;
  box-shadow: 1px 1px 5px #666;
}
.author-info {
  text-align: center;
}
</style>
