<template>
  <div id="slime_conteneur">
    <div class="slime" id="slime1" @click="test">
      <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
			 width="125px" height="100px" viewBox="0 0 126.75 103.25" enable-background="new 0 0 126.75 103.25" xml:space="preserve">
        <g class="corps">
          <path d="M126.153,71.798c0,35.275-30.128,31.452-65.403,31.452S0.411,107.073,0.411,71.798S34,0.927,63.282,0.927
            C92,0.927,126.153,36.523,126.153,71.798z"/>
        </g>
        <g class="ombre">
          <path opacity="0.1" d="M98.583,98.968c0,5.085-4.708,4.313-37.833,4.313c-29.563,0-32.769,0.771-32.769-4.313
            c0-8.718,18.86-10.218,35.301-10.218C79.407,88.75,98.583,91.125,98.583,98.968z"/>
        </g>
        <g class="reflet">

            <ellipse transform="matrix(0.5486 -0.8361 0.8361 0.5486 20.2905 77.5842)" opacity="0.5" fill="#FFFFFF" cx="82" cy="20" rx="7.75" ry="13.75"/>
        </g>
        <g class="yeux">
          <g>
            <path d="M36.833,66.583c-3.359,0-6.083,2.724-6.083,6.083c0,3.359,2.724,6.083,6.083,6.083c3.36,0,6.083-2.724,6.083-6.083
              C42.917,69.307,40.193,66.583,36.833,66.583z M39.5,71.25c-0.874,0-1.583-0.709-1.583-1.583c0-0.875,0.709-1.583,1.583-1.583
              c0.875,0,1.583,0.709,1.583,1.583C41.083,70.541,40.375,71.25,39.5,71.25z"/>
            <circle fill="#FFFFFF" cx="39.5" cy="69.667" r="1.583"/>
            <path d="M88.833,66.583c-3.359,0-6.083,2.724-6.083,6.083c0,3.359,2.724,6.083,6.083,6.083c3.36,0,6.083-2.724,6.083-6.083
              C94.917,69.307,92.193,66.583,88.833,66.583z M91.5,71.25c-0.874,0-1.583-0.709-1.583-1.583c0-0.875,0.709-1.583,1.583-1.583
              c0.875,0,1.583,0.709,1.583,1.583C93.083,70.541,92.375,71.25,91.5,71.25z"/>
            <circle fill="#FFFFFF" cx="91.5" cy="69.667" r="1.583"/>
          </g>
        </g>
        <g class="bouche">
          <g>
            <path fill="#A862A6">
              <animate id="animBouche" attributeName="d" dur="3s" repeatCount="indefinite" values="M49.9,78c0,3.151,1.885,5.435,4.528,7c3.228-1.911,7.589-2.749,11.072-2.749S73.344,83.089,76.572,85
          c2.643-1.565,4.528-3.849,4.528-7H65.584H49.9z;
              M49.9,73c0,3.151,1.885,10.435,4.528,12c3.228-1.911,7.589-2.749,11.072-2.749S73.344,83.089,76.572,85
          c2.643-1.565,4.528-8.849,4.528-12H65.584H49.9z;
          M49.9,78c0,3.151,1.885,5.435,4.528,7c3.228-1.911,7.589-2.749,11.072-2.749S73.344,83.089,76.572,85
          c2.643-1.565,4.528-3.849,4.528-7H65.584H49.9z" />
            </path>
            <path fill="#E0B7E5" d="M52.678,84.25c7.116,3.558,15.028,3.558,22.144,0C68.463,80.485,59.037,80.485,52.678,84.25
              C52.679,84.25,52.656,84.25,52.678,84.25z"/>
          </g>
        </g>
		  </svg>
    </div>
    <div class="slime" id="slime2" @click="test">
      <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
			 width="125px" height="100px" viewBox="0 0 126.75 103.25" enable-background="new 0 0 126.75 103.25" xml:space="preserve">
		<g class="corps">
			<path d="M126.153,71.798c0,35.275-30.128,31.452-65.403,31.452S0.411,107.073,0.411,71.798S34,0.927,63.282,0.927
				C92,0.927,126.153,36.523,126.153,71.798z"/>
		</g>
		<g class="ombre">
			<path opacity="0.1" d="M98.583,98.968c0,5.085-4.708,4.313-37.833,4.313c-29.563,0-32.769,0.771-32.769-4.313
				c0-8.718,18.86-10.218,35.301-10.218C79.407,88.75,98.583,91.125,98.583,98.968z"/>
		</g>
		<g class="reflet">

				<ellipse transform="matrix(0.5486 -0.8361 0.8361 0.5486 20.2905 77.5842)" opacity="0.5" fill="#FFFFFF" cx="82" cy="20" rx="7.75" ry="13.75"/>
		</g>
		<g class="yeux">
			<g>
				<path d="M36.833,66.583c-3.359,0-6.083,2.724-6.083,6.083c0,3.359,2.724,6.083,6.083,6.083c3.36,0,6.083-2.724,6.083-6.083
					C42.917,69.307,40.193,66.583,36.833,66.583z M39.5,71.25c-0.874,0-1.583-0.709-1.583-1.583c0-0.875,0.709-1.583,1.583-1.583
					c0.875,0,1.583,0.709,1.583,1.583C41.083,70.541,40.375,71.25,39.5,71.25z"/>
				<circle fill="#FFFFFF" cx="39.5" cy="69.667" r="1.583"/>
				<path d="M88.833,66.583c-3.359,0-6.083,2.724-6.083,6.083c0,3.359,2.724,6.083,6.083,6.083c3.36,0,6.083-2.724,6.083-6.083
					C94.917,69.307,92.193,66.583,88.833,66.583z M91.5,71.25c-0.874,0-1.583-0.709-1.583-1.583c0-0.875,0.709-1.583,1.583-1.583
					c0.875,0,1.583,0.709,1.583,1.583C93.083,70.541,92.375,71.25,91.5,71.25z"/>
				<circle fill="#FFFFFF" cx="91.5" cy="69.667" r="1.583"/>
			</g>
		</g>
		<g class="bouche">
			<g>
				<path fill="#A862A6">
					<animate id="animBouche" attributeName="d" dur="3s" repeatCount="indefinite" values="M49.9,78c0,3.151,1.885,5.435,4.528,7c3.228-1.911,7.589-2.749,11.072-2.749S73.344,83.089,76.572,85
			c2.643-1.565,4.528-3.849,4.528-7H65.584H49.9z;
					M49.9,73c0,3.151,1.885,10.435,4.528,12c3.228-1.911,7.589-2.749,11.072-2.749S73.344,83.089,76.572,85
			c2.643-1.565,4.528-8.849,4.528-12H65.584H49.9z;
			M49.9,78c0,3.151,1.885,5.435,4.528,7c3.228-1.911,7.589-2.749,11.072-2.749S73.344,83.089,76.572,85
			c2.643-1.565,4.528-3.849,4.528-7H65.584H49.9z" />
				</path>
				<path fill="#E0B7E5" d="M52.678,84.25c7.116,3.558,15.028,3.558,22.144,0C68.463,80.485,59.037,80.485,52.678,84.25
					C52.679,84.25,52.656,84.25,52.678,84.25z"/>
			</g>
		</g>
		</svg>
    </div>
    <div class="slime" id="slime3" @click="test">
      <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
			 width="125px" height="100px" viewBox="0 0 126.75 103.25" enable-background="new 0 0 126.75 103.25" xml:space="preserve">
		<g class="corps">
			<path d="M126.153,71.798c0,35.275-30.128,31.452-65.403,31.452S0.411,107.073,0.411,71.798S34,0.927,63.282,0.927
				C92,0.927,126.153,36.523,126.153,71.798z"/>
		</g>
		<g class="ombre">
			<path opacity="0.1" d="M98.583,98.968c0,5.085-4.708,4.313-37.833,4.313c-29.563,0-32.769,0.771-32.769-4.313
				c0-8.718,18.86-10.218,35.301-10.218C79.407,88.75,98.583,91.125,98.583,98.968z"/>
		</g>
		<g class="reflet">

				<ellipse transform="matrix(0.5486 -0.8361 0.8361 0.5486 20.2905 77.5842)" opacity="0.5" fill="#FFFFFF" cx="82" cy="20" rx="7.75" ry="13.75"/>
		</g>
		<g class="yeux">
			<g>
				<path d="M36.833,66.583c-3.359,0-6.083,2.724-6.083,6.083c0,3.359,2.724,6.083,6.083,6.083c3.36,0,6.083-2.724,6.083-6.083
					C42.917,69.307,40.193,66.583,36.833,66.583z M39.5,71.25c-0.874,0-1.583-0.709-1.583-1.583c0-0.875,0.709-1.583,1.583-1.583
					c0.875,0,1.583,0.709,1.583,1.583C41.083,70.541,40.375,71.25,39.5,71.25z"/>
				<circle fill="#FFFFFF" cx="39.5" cy="69.667" r="1.583"/>
				<path d="M88.833,66.583c-3.359,0-6.083,2.724-6.083,6.083c0,3.359,2.724,6.083,6.083,6.083c3.36,0,6.083-2.724,6.083-6.083
					C94.917,69.307,92.193,66.583,88.833,66.583z M91.5,71.25c-0.874,0-1.583-0.709-1.583-1.583c0-0.875,0.709-1.583,1.583-1.583
					c0.875,0,1.583,0.709,1.583,1.583C93.083,70.541,92.375,71.25,91.5,71.25z"/>
				<circle fill="#FFFFFF" cx="91.5" cy="69.667" r="1.583"/>
			</g>
		</g>
		<g class="bouche">
			<g>
				<path fill="#A862A6">
					<animate id="animBouche" attributeName="d" dur="3s" repeatCount="indefinite" values="M49.9,78c0,3.151,1.885,5.435,4.528,7c3.228-1.911,7.589-2.749,11.072-2.749S73.344,83.089,76.572,85
			c2.643-1.565,4.528-3.849,4.528-7H65.584H49.9z;
					M49.9,73c0,3.151,1.885,10.435,4.528,12c3.228-1.911,7.589-2.749,11.072-2.749S73.344,83.089,76.572,85
			c2.643-1.565,4.528-8.849,4.528-12H65.584H49.9z;
			M49.9,78c0,3.151,1.885,5.435,4.528,7c3.228-1.911,7.589-2.749,11.072-2.749S73.344,83.089,76.572,85
			c2.643-1.565,4.528-3.849,4.528-7H65.584H49.9z" />
				</path>
				<path fill="#E0B7E5" d="M52.678,84.25c7.116,3.558,15.028,3.558,22.144,0C68.463,80.485,59.037,80.485,52.678,84.25
					C52.679,84.25,52.656,84.25,52.678,84.25z"/>
			</g>
		</g>
		</svg>
    </div>
    <div id="box"><span id="text" class="test">{{spanText}}</span></div>
  </div>
</template>
<style>
  @import url('../assets/css/rice-roll.css');

  * {
    margin: 0;
    padding: 0;
  }
  .test{
    position: relative;
    text-align: center;
    top: 40%;
    font-family: fengbi;
    font-size: 40px;
  }
  #box {
    position: relative;
    /*left: 100px;*/
    top: 30%;
    left: 25%;
    width: 50%;
    /*height: 100px;*/
    background: #088cb7;
    -moz-border-radius: 12px;
    -webkit-border-radius: 12px;
    border-radius: 12px;
  }

  #box{-webkit-animation-fill-mode:both; -webkit-animation-duration: 0.5s;
  }
  #box.show{ -webkit-animation-name: slideIn;}
  #box.hide{ -webkit-animation-name: slideOut;}
  #text.show{ -webkit-animation-name: slideTextIn;}
  #text.hide{ -webkit-animation-name: slideTextOut;}

  @-webkit-keyframes slideIn{
    0%{height: 0; display: block;}
    50%{height: 50px;}
    100%{height: 100px;}
  }

  @-webkit-keyframes slideOut{
    0%{height: 100%;}
    50%{height: 50%;}
    100%{height: 0; display: none;}
  }

  @-webkit-keyframes slideTextIn{
    0%{height: 0; display: block;}
    50%{height: 50%;}
    100%{height: 100%;}
  }

  @-webkit-keyframes slideTextOut{
    0%{height: 100px;}
    50%{height: 50px;}
    100%{height: 0; display: none;}
  }
</style>
<script>
  export default {
    data(){
      return {
        spanText: '',
        spanTextList: ['嘿嘿嘿',
          '你好，我是包子',
          '我是窝窝头',
          '那好吧，我是汤圆',
          '抖一抖',
          '因为乐宝爱吃汤圆',
          '我又稀饭乐宝',
          '所以乐宝是天下最可爱的汤圆',
          '乐宝辣么萌',
          '是的是的',
          '不知道用什么样的言语表达对乐宝的稀饭',
          '就希望乐宝每天都像个可爱的汤圆辣样',
          '抖两抖',
          '那样天真可爱',
          '乐宝才不胖呢',
          '对呀对呀',
          '谁敢说我乐宝胖',
          '就罚他这辈子吃不到窝头馒头包子汤圆',
          '抖抖抖抖抖',
          '乐宝明明就是我见过的最漂亮的汤圆',
          '所以我',
          '还有我',
          '还有有我',
          '都想乐宝能每天开开心心',
          '就算有这样那样的烦恼',
          '就算有时候钻钻钻钻',
          '心里会有一潭清水',
          '静静地',
          '美美的',
          '相信着自己的美好',
          '相信着因自己编织出来的，自己的因缘造就的世界的美好',
          '再抖抖',
          '相信着',
          '天空的尽头依偎着大地',
          '早晚的霞光清算着年纪',
          '时间与空间的狭间里',
          '念着你的是我',
          '写着我的是你',
          '呱',
          '还想再听一遍呀？',
          '辣抖一抖',
          '嗯，萌萌的'
        ]
      }
    },
    mounted: function () {
      localStorage.setItem('count', '0');
      this.changeFond();
      this.changeCouleur();
    },
    methods: {
      changeFond() {
        let couleurFond;
        let numFond = Math.floor((Math.random() * 10) + 1);
        switch (numFond) {
          case 1:
            couleurFond = "#16a085";
            break;
          case 2:
            couleurFond = "#27ae60";
            break;
          case 3:
            couleurFond = "#2980b9";
            break;
          case 4:
            couleurFond = "#8e44ad";
            break;
          case 5:
            couleurFond = "#2c3e50";
            break;
          case 6:
            couleurFond = "#f39c12";
            break;
          case 7:
            couleurFond = "#d35400";
            break;
          case 8:
            couleurFond = "#c0392b";
            break;
          case 9:
            couleurFond = "#bdc3c7";
            break;
          case 10:
            couleurFond = "#7f8c8d";
            break;
        }
        document.body.style.background = couleurFond;
      },
      changeCouleur() {
        let tabNum = [];
        while (tabNum.length < 3) {
          let numSlime = Math.floor((Math.random() * 10) + 1);
          if (tabNum.indexOf(numSlime) == -1) {
            tabNum.push(numSlime);
          }
        }
        let corpsSlime = document.getElementsByClassName("corps");
        for (let i = 0; i < 3; i++) {
          let couleurSlime;
          switch (tabNum[i]) {
            case 1:
              couleurSlime = "#1abc9c";
              break;
            case 2:
              couleurSlime = "#2ecc71";
              break;
            case 3:
              couleurSlime = "#3498db";
              break;
            case 4:
              couleurSlime = "#9b59b6";
              break;
            case 5:
              couleurSlime = "#34495e";
              break;
            case 6:
              couleurSlime = "#f1c40f";
              break;
            case 7:
              couleurSlime = "#e67e22";
              break;
            case 8:
              couleurSlime = "#e74c3c";
              break;
            case 9:
              couleurSlime = "#ecf0f1";
              break;
            case 10:
              couleurSlime = "#95a5a6";
              break;
          }
          corpsSlime[i].style.fill = couleurSlime;
        }
      },
      test(){
        if (document.getElementById("box").classList.contains("show")) {
          this.spanText = "";
          document.getElementById("box").classList.add("hidden");
          document.getElementById("box").classList.remove("show");
          document.getElementById("text").classList.add("hidden");
          document.getElementById("text").classList.remove("show");
        } else{
          let count = parseInt(localStorage.getItem("count"));
            this.spanText = this.spanTextList[count];
          count += 1;
          if (count >= 42){
            count -= 42;
          }
          localStorage.setItem("count", count);
          document.getElementById("box").classList.add("show");
          document.getElementById("box").classList.remove("hidden");
          document.getElementById("text").classList.add("show");
          document.getElementById("text").classList.remove("hidden");
        }
      }
    }
  }
</script>
