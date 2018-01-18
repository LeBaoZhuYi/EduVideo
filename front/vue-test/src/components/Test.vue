<template>

  <div class="row">
  <v-header :activeIndex="2"></v-header>
  <div id="slider">

    <div id="header">
      <div id="sitetitle">
        <a href="#"><img src="../assets/temp/images/logo.png" alt="LOGO" /></a>
      </div>
      <a class="header_menu" href="http://www.facebook.com/templatemo"><img src="../assets/temp/images/twitter_header.png" alt="Twitter" /></a>
      <a class="header_menu" href="#contactus"><img src="../assets/temp/images/contactus.png" alt="contact us" /></a>
    </div>

    <div id="content">

      <div class="scroll">
        <div class="scrollContainer">

          <div v-show="scroll1" class="panel" id="home">
            <div class="col_550 float_l">
              <h1>Welcome to Green Board</h1>

              <p><em>Nullam at erat ipsum, quis tincidunt mauris. Nunc sit amet sapien eget eros iaculis hendrerit quis a enim. Vestibulum at leo ante, vel auctor velit.</em></p>
              <p>Green Board is a Free CSS Template from <a href="http://www.cssmoban.com" target="_parent" title="模板之家">模板之家</a>. You may edit and apply this template for your websites. Credits go to Free Photos and <a href="http://jwloh.deviantart.com/art/Social-me-90694011" target="_blank">Social Icons</a>. Nullam eu metus libero, et pretium massa.</p>
              <div class="cleaner_h30"></div>
              <h2>Our Services</h2>
              <div class="image_wrapper image_fl"><img src="../assets/temp/images/templatemo_image_01.jpg" alt="Image 1" /></div>
              <p>Vivamus scelerisque consectetur nunc, nec vehicula lorem fermentum. Cras sodales arcu est, ac vulputate quam. Maecenas non turpis ipsum, viverra posuere. Ut vestibulum dictum tellus. Validate <a href="#" rel="nofollow"><strong>XHTML</strong></a> &amp; <a href="#" rel="nofollow"><strong>CSS</strong></a>.</p> <div class="btn_more"><a href="#services">Read more</a></div>
            </div>

            <div class="col_300 float_r">
              <h2>About Us</h2>
              <p><em>Donec ac eros ac nunc blandit hendrerit. Vestibulum tincidunt, odio at ultricies sollicitudin.</em></p>
              <p>Mauris ligula tortor, congue laoreet rutrum eget, suscipit nec augue hendrerit velit adipiscing.</p>
              <div class="btn_more"><a href="#aboutus">Read more</a></div>

              <div class="cleaner_h30"></div>

              <h2>Featured Work</h2>
              <div class="image_wrapper"><img src="../assets/temp/images/templatemo-image-02.jpg" alt="Image 2" /></div>
              <div class="btn_more"><a href="#gallery">Read more</a></div>
            </div>
          </div> <!-- end of home -->

          <div v-show="scroll2" class="panel" id="aboutus">
            <h1>About Us</h1>
            <div class="image_wrapper image_fl"><img src="../assets/temp/images/templatemo_image_04.jpg" alt="Image 4" /></div>
            <p><em>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse in lectus turpis. Vivamus cursus tortor quis leo ullamcorper auctor quis tincidunt metus.</em></p>
            <p>Vestibulum vitae lectus a leo commodo egestas. Sed et ligula mauris. Donec interdum iaculis eros, sed porttitor justo ornare ac. Suspendisse ultrices arcu auctor sapien malesuada dictum. Vivamus non ante sit amet ligula dignissim blandit ut sit amet purus. Sed tristique euismod lectus sed scelerisque. Curabitur convallis fringilla ante, eget eleifend magna iaculis eget. Praesent at nunc tellus. Sed sed auctor odio. Maecenas ut mauris eu ligula placerat tempor vel ac augue. Integer fermentum, ante eget sodales lacinia, nisl diam semper elit, non hendrerit nunc urna vitae erat. Etiam vel nisi risus.</p>
            <p>Vestibulum tempus porttitor ipsum, ut dictum metus molestie eu. Donec interdum, mi ut facilisis posuere, neque sapien lacinia urna, nec hendrerit dolor arcu sed justo. Aenean rhoncus porttitor dolor non posuere. Nulla eu mi id tellus vehicula pellentesque et vitae magna. </p>
            <div class="cleaner_h30"></div>
            <ul id="social_box">
              <li><a href="#"><img src="../assets/temp/images/facebook.png" alt="facebook" /></a></li>
              <li><a href="#"><img src="../assets/temp/images/twitter.png" alt="twitter" /></a></li>
              <li><a href="#"><img src="../assets/temp/images/linkedin.png" alt="linkin" /></a></li>
              <li><a href="#"><img src="../assets/temp/images/technorati.png" alt="technorati" /></a></li>
              <li><a href="#"><img src="../assets/temp/images/myspace.png" alt="myspace" /></a></li>
            </ul>
          </div>

          <div v-show="scroll3" class="panel" id="services">
            <div class="col_380 float_l">
              <h1>Service Overview</h1>
              <p><em>Nam at arcu libero, ut venenatis elit. Nulla eget risus turpis, non aliquet dui. Vivamus augue felis, ultricies elementum convallis non, ornare vitae urna. Morbi et nisi eros, ut venenatis ipsum. </em></p>
              <p>Sed eu libero quis neque laoreet cursus. Fusce elit metus, elementum nec consequat a, interdum vitae est. Aliquam sit amet odio vitae dui blandit elementum. Ut eu dolor nunc. Nam in nunc sed mi adipiscing lacinia suscipit eget tortor. Vivamus lacinia lectus in velit aliquet ac placerat magna euismod. In hac habitasse platea dictumst.  Mauris consectetur malesuada dolor.</p>
              <p>Integer eget nibh eu libero cursus ultricies. Nam ac eros erat. Integer varius pulvinar molestie. Vestibulum pellentesque felis eget nibh pulvinar accumsan. Etiam non urna at ipsum condimentum tempus at eu mauris. Vivamus eget ante augue. Phasellus ut sapien tellus, placerat cursus augue.</p>

            </div>
            <div class="col_380 float_r">
              <h1>Service List</h1>
              <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse in lectus turpis. Credit goes to <a href="http://www.icojoy.com/" target="_blank">Onebit icons</a> for icons.</p>

              <ul class="service_list">
                <li><a href="#" class="service_one">Sed nec eros egestas nisl</a></li>
                <li><a href="#" class="service_two">Morbi sed nulla ac est cursus</a></li>
                <li><a href="#" class="service_three">Curabitur ullamcorper nibh</a></li>
                <li><a href="#" class="service_four">Pellentesque adipiscing</a></li>
                <li><a href="#" class="service_five">Vestibulum urna purus</a></li>
              </ul>
            </div>
          </div>

          <div v-show="scroll4" class="panel" id="gallery">
            <h1>Website Gallery</h1>

            <div id="gallery_container">
              <div class="gallery_box">
                <img src="../assets/temp/images/gallery/image_01.jpg" alt="Image 1" />
                <h4>Project One</h4>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec ligula vitae ipsum blandit condimentum. Nam fringilla luctus mauris, non ornare turpis. Pellentesque sed quam.</p>
                <div class="btn_more"><a href="#">Visit <span>&raquo;</span></a></div>
                <div class="cleaner"></div>
              </div>
              <div class="gallery_box">
                <img src="../assets/temp/images/gallery/image_02.jpg" alt="Image 2" />
                <h4>Project Two</h4>
                <p>Donec ac eros ac nunc blandit hendrerit. Vestibulum tincidunt, odio at ultricies sollicitudin, ante felis luctus justo, non venenatis quam mauris non tortor. pulvinar non convallis a, bibendum in nibh.</p>
                <div class="btn_more"><a href="#">Visit <span>&raquo;</span></a></div>
                <div class="cleaner"></div>
              </div>
              <div class="gallery_box">
                <img src="../assets/temp/images/gallery/image_03.jpg" alt="Image 3" />
                <h4>Project Three</h4>
                <p> Mauris ligula tortor, congue laoreet rutrum eget, suscipit nec augue. In congue consectetur est, sit amet hendrerit velit adipiscing eget. Pellentesque egestas venenatis elementum.</p>
                <div class="btn_more"><a href="#">Visit <span>&raquo;</span></a></div>
                <div class="cleaner"></div>
              </div>
              <div class="gallery_box">
                <img src="../assets/temp/images/gallery/image_04.jpg" alt="Image 4" />
                <h4>Project Four</h4>
                <p> Curabitur iaculis, erat pharetra porttitor sollicitudin, turpis lectus placerat arcu, ac mattis eros sem ut metus. Nunc congue iaculis lectus in interdum. magna ligula auctor enim, at porttitor elit odio vitae velit.</p>
                <div class="btn_more"><a href="#">Visit <span>&raquo;</span></a></div>
                <div class="cleaner"></div>
              </div>
              <div class="gallery_box">
                <img src="../assets/temp/images/gallery/image_05.jpg" alt="Image 5" />
                <h4>Project Five</h4>
                <p> Pellentesque pellentesque, mauris a egestas placerat, tortor tellus varius odio, a mattis ipsum turpis eget diam. Morbi vel tortor orci. Maecenas congue posuere dapibus arcu eleifend eget lacinia enim blandit. </p>
                <div class="btn_more"><a href="#">Visit <span>&raquo;</span></a></div>
                <div class="cleaner"></div>
              </div>
              <div class="gallery_box">
                <img src="../assets/temp/images/gallery/image_06.jpg" alt="Image 6" />
                <h4>Project Six</h4>
                <p>Sed in viverra nulla. Duis rutrum vehicula ligula, non tempor nunc congue et. Nunc sit amet tortor nulla, ut eleifend enim sed condimentum tellus vesti bulum in. Cras molestie fermentum libero.</p>
                <div class="btn_more"><a href="#">Visit <span>&raquo;</span></a></div>
                <div class="cleaner"></div>
              </div>
              <div class="cleaner"></div>
            </div>

          </div>

          <div v-show="scroll5" class="panel" id="contactus">
            <h1>Contact Information</h1>

            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse in lectus turpis. Vivamus cursus tortor quis leo ullamcorper auctor quis tincidunt metus.</p>

            <div class="cleaner_h10"></div>

            <div class="col_380 float_l">

              <div id="contact_form">

                <form method="post" name="contact" action="#contactus">

                  <label for="author">Name:</label> <input name="author" type="text" class="required input_field" id="author" maxlength="60" />
                  <div class="cleaner_h10"></div>

                  <label for="email">Email:</label> <input name="email" type="text" class="validate-email required input_field" id="email" maxlength="60" />
                  <div class="cleaner_h10"></div>

                  <label for="text">Message:</label> <textarea name="text" rows="0" cols="0" class="required" id="text"></textarea>
                  <div class="cleaner_h10"></div>

                  <input type="submit" class="submit_btn float_l" name="submit" id="submit" value="Send" />
                  <input type="reset" class="submit_btn float_r" name="reset" id="reset" value="Reset" />

                </form>

              </div>

            </div>

            <div class="col_380 float_r">
              <h2>Mailing Address</h2>
              <h4>Company Name</h4>
              150-320 Duis lacinia dictum,<br />
              Vestibulum auctor, 10140<br />
              Nam rhoncus, Diam a mollis<br /><br />

              Tel: 020-030-1880<br />
              Fax: 020-030-1220
            </div>

          </div>
        </div>
      </div>

      <!-- end of scroll -->
    </div>

    <div id="menu">
      <ul class="navigation">
        <li><a href="#home" class="selected" @click="changeScroll('1')">Home<span class="ui_icon home"></span></a></li>
        <li><a href="#aboutus" @click="changeScroll('2')">About Us<span class="ui_icon aboutus"></span></a></li>
        <li><a href="#services" @click="changeScroll('3')">Services<span class="ui_icon services"></span></a></li>
        <li><a href="#gallery" @click="changeScroll('4')">Gallery<span class="ui_icon gallery"></span></a></li>
        <li><a href="#contactus" @click="changeScroll('5')">Contact<span  class="ui_icon contactus"></span></a></li>
      </ul>
    </div>

    <div id="footer">

      Copyright © 2048 <a href="#">Your Company Name</a> | Template from <a href="http://www.cssmoban.com" target="_parent" title="网站模板">网站模板</a>

    </div>

  </div> <!-- end of slider -->
  </div>
</template>
<style>
  @import url('../assets/temp/coda-slider.css');
  @import url('../assets/temp/templatemo_style.css');
  .fade-in-active, .fade-out-active{
     transition: all 0.5s ease
   };
  .fade-in-enter, .fade-out-active{
     opacity: 0
   }
</style>
<script>
  import vHeader from './Header.vue'
  export default {
    data(){
      return {
        scroll1: true,
        scroll2: false,
        scroll3: false,
        scroll4: false,
        scroll5: false
      }
    },
    components:{
      'v-header': vHeader
    },
    methods:{
      changeScroll(id){
        this.scroll1 = false;
        this.scroll2 = false;
        this.scroll3 = false;
        this.scroll4 = false;
        this.scroll5 = false;
        if(id == '1'){
          this.scroll1 = true;
        }
        if(id == '2'){
          this.scroll2 = true;
        }
        if(id == '3'){
          this.scroll3 = true;
        }
        if(id == '4'){
          this.scroll4 = true;
        }
        if(id == '5'){
          this.scroll5 = true;
        }
      }
    }
  }
</script>
