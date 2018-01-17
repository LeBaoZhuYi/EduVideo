<template>
  <div class="row">
    <v-header></v-header>
  <div id="slider">
    <div id="header">
      <div id="sitetitle">
        <!--<p>在这儿写几个字试试</p>-->
        <input type="text" name="name" value="小六的主页"  id="my_name">
      </div>
      <!--<a class="header_menu" href="http://www.facebook.com/templatemo"><img src="../assets/temp/images/twitter_header.png" alt="Twitter" /></a>-->
      <!--<a class="header_menu" href="#contactus"><img src="../assets/temp/images/contactus.png" alt="contact us" /></a>-->
    </div>
    <div id="content">

      <div class="scroll">
        <div class="scrollContainer">

          <div class="panel" id="home">
            <div class="col_550 float_l">
              <h1>学生简介</h1>

              <p><em>我叫小六，今年十岁了，是一个活泼开朗，热爱学习和运动的小女孩。我特别喜欢我们的舞蹈老师，她跳的舞特别好看。我希望我也能像她一样，所以我要好好学习舞蹈。我的梦想是在一个非常大的舞台上，跳最美的舞蹈给大家看</em></p>

              <h2>老师寄语</h2>
              <div class="image_wrapper image_fl"><img src="../assets/temp/images/templatemo_image_01.jpg" alt="Image 1" /></div>
              <p>小六是一个非常可爱听话，上课认真活跃的姑娘，老师们都很喜欢她，希望她能顺利实现自己的梦想，成为一名优秀的舞者。</p>
            </div>

            <div class="col_300 float_r">
              <h2>学生信息</h2>
              <p><em>Donec ac eros ac nunc blandit hendrerit. Vestibulum tincidunt, odio at ultricies sollicitudin.</em></p>
              <p>Mauris ligula tortor, congue laoreet rutrum eget, suscipit nec augue hendrerit velit adipiscing.</p>
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

              <div class="cleaner_h30"></div>

              <h2>Featured Work</h2>
              <div class="image_wrapper"><img src="../assets/temp/images/templatemo-image-02.jpg" alt="Image 2" /></div>
              <div class="btn_more"><a href="#gallery">Read more</a></div>
            </div>
          </div> <!-- end of home -->
        </div>
      </div>
    </div>
    <div id="book">
    </div>

    <div id="earth">
    </div>
  </div></div>
</template>
<style>
  @import url('../assets/temp/coda-slider.css');
  @import url('../assets/temp/templatemo_style.css');
</style>
<script>
  import vHeader from './Header.vue'

  export default {
    components:{
      'v-header': vHeader
    }
  }
</script>
