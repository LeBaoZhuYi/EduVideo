<template>

  <div id="main_container">

    <div id="top_banner">

    </div>
    <div id="logo">
      <img src="../assets/css/images/person_logo.png" width="400" height="100" name="myImg1" border="0" class="" alt="Variable Opacity Rules">
    </div>

    <div id="center_content">
      <div class="left_box">
        <img src="../assets/css/images/snowman.jpg" width="167" height="212" alt="" title="" />
      </div>

      <div class="right_box">

        <h1>学生简介</h1>
        <p>我叫小六，今年十岁了，是一个活泼开朗，热爱学习和运动的小女孩。我特别喜欢我们的舞蹈老师，她跳的舞特别好看。我希望我也能像她一样，所以我要好好学习舞蹈。我的梦想是在一个非常大的舞台上，跳最美的舞蹈给大家看</p>

        <div class="float_box1">
          <a href="#"><img src="../assets/css/images/write.jpg" width="250" height="100" border="0" alt="" title="" /></a>

        </div>

        <div class="float_box2">
          <h2>老师寄语</h2>
          小六是一个非常可爱听话，上课认真活跃的姑娘，老师们都很喜欢她，希望她能顺利实现自己的梦想，成为一名优秀的舞者。
        </div>

        <h3>Santa's Gifts</h3>

        <a href="#"><img src="../assets/css/images/gift1.jpg" width="100" height="100" alt="" title="" class="gift" /></a>
        <a href="#"><img src="../assets/css/images/gift2.jpg" width="100" height="100" alt="" title="" class="gift" /></a>
        <a href="#"><img src="../assets/css/images/gift3.jpg" width="100" height="100" alt="" title="" class="gift" /></a>
        <a href="#"><img src="../assets/css/images/gift4.jpg" width="100" height="100" alt="" title="" class="gift" /></a>
        <a href="#"><img src="../assets/css/images/gift5.jpg" width="100" height="100" alt="" title="" class="gift" /></a>


        <h3>学生信息</h3>

        <div id="form">
          <label>姓名:</label>
          <input type="text" name="user" class="input" />
          <div class="clear"></div>
          <label>年龄:</label>
          <input type="text" name="age"  class="input"/>
          <div class="clear"></div>
          <label>邮箱:</label>
          <input type="email" name="email"  class="input"/>
          <div class="clear"></div>
          <label>电话:</label>
          <input type="text" name="phone"  class="input"/>
          <div class="clear"></div>
        </div>

      </div>



      <div class="spacer"></div>
    </div>
  </div>
</template>
<style>
  @import url("../assets/css/person.css");
</style>
<script>
  export default {
  }
</script>
