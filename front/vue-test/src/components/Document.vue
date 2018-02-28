<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item><i class="el-icon-setting"></i> 爱特熠星在线课堂</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="ms-doc">
      <h3>使用说明</h3>
      <article>
        <el-alert type="warning">注意事项：由于兼容性原因，推荐使用谷歌，火狐等主流浏览器有更好的体验效果；360浏览器有较小可能会因为视频过大无法播放；暂不推荐使用IE</el-alert>
        <h1>一、获得账号</h1>
        <p>在完成付费购买后，由老师于后台创建账号并发放给学生和家长；</p>
        <p>一个账号关联一名学生，账号基本信息有学生姓名、登录名\密码、电话号等；</p>
        <p>在账号开通并可以登录后，学生可在主页的个人中心页面添加修改自己的其它信息，详情见后面图示；</p>
        <h2>注意：每个账号同时只能登录一个，当有另一处登录时会踢掉当前在线用户，因此请注意保护，谨防账号泄露；</h2>
        <h1>二、主页说明</h1>
        <p>网站首页有四个滚动页，登录界面位于第一页</p>
        <h4>第三页为学生作品展示，届时将挑选优秀的学生作业挂在该展示区，供其他学生家长观看</h4>
        <h1>三、课程页说明</h1>
        <p>在完成登录后，网站将跳转至《今日课程》分页</p>
        <h3>页面布局</h3>
        <p>上边：页面头部，包含“主页”，“今日课程”，“个人中心”三个超链接</p>
        <p>左边：信息栏，包含个人信息和今日课程信息</p>
        <p>右边：当月历史课程表，用于课程复习，可进行点播</p>
        <p>中部：视频展示与播放窗口</p>
        <h3>分页自动检查今日课程，存在下列情况</h3>
        <p>未到课程开始时间，小黑板上会有倒计时</p>
        <p>已到课程开始时间，小黑板上会直接切换到课程视频播放窗口</p>
        <p>已过课程结束时间，小黑板上会展示“今日课程已结束”字样</p>
        <p>今日无课程，小黑板上计时为0，左边信息栏展示“今日无课程”字样</p>
        <h1>三、历史课程点播</h1>
        <p>学生可在头部点击“个人中心”前往《个人中心》页</p>
        <p>该页以中心小黑板的形式展示学生信息</p>
        <p>小黑板内左右两侧有小箭头，点击可翻页</p>
        <p>通常情况下有四页，首两页为信息展示，后两页为信息编辑</p>
        <h2>公用测试账号暂时不支持编辑</h2>
      </article>
    </div>

  </div>
</template>

<script>
  import ElAlert from "element-ui/packages/alert/src/main";

  export default {
    components: {ElAlert},
    data: function () {
      return {}
    }
  }
</script>

<style scoped>
  .ms-doc {
    width: 100%;
    max-width: 980px;
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Helvetica, Arial, sans-serif;
  }

  .ms-doc h3 {
    padding: 9px 10px 10px;
    margin: 0;
    font-size: 14px;
    line-height: 17px;
    background-color: #f5f5f5;
    border: 1px solid #d8d8d8;
    border-bottom: 0;
    border-radius: 3px 3px 0 0;
  }

  .ms-doc article {
    padding: 45px;
    word-wrap: break-word;
    background-color: #fff;
    border: 1px solid #ddd;
    border-bottom-right-radius: 3px;
    border-bottom-left-radius: 3px;
  }

  .ms-doc article h1 {
    font-size: 32px;
    padding-bottom: 10px;
    margin-bottom: 15px;
    border-bottom: 1px solid #ddd;
  }

  .ms-doc article h2 {
    margin: 24px 0 16px;
    font-weight: 600;
    line-height: 1.25;
    padding-bottom: 7px;
    font-size: 24px;
    border-bottom: 1px solid #eee;
  }

  .ms-doc article p {
    margin-bottom: 15px;
    line-height: 1.5;
  }

  .ms-doc article .el-checkbox {
    margin-bottom: 5px;
  }
</style>
