<template>
  <div class="row">
    <v-header @transferTopic="getTopic"></v-header>
    <v-star v-show="topic1"></v-star>
    <v-common v-show="topic2"></v-common>
    <v-art v-show="topic3"></v-art>
    <v-video v-show="page1"></v-video>
    <v-accordion v-show="page2"></v-accordion>
  </div>
</template>
<style>
  .row{
    height: 100%;
    width: 100%;
  }
</style>
<script>
  import vVideo from './Video.vue'
  import vAccordion from './Accordion2.vue'
  import vStar from './topic/Star.vue'
  import vCommon from './topic/Common.vue'
  import vArt from './topic/Art.vue'
  import vHeader from "./Header.vue"
  export default {
    data(){
      return {
        topic1: false,
        topic2: true,
        topic3: false,
        // page1: true,
        page2: true
      }
    },
    components: {
      'v-video': vVideo,
      'v-star': vStar,
      'v-common': vCommon,
      'v-header': vHeader,
      'v-art': vArt,
      'v-accordion': vAccordion
    },
    methods: {
      getTopic: function(msg){
        this.topic1 = false;
        this.topic2 = false;
        this.topic3 = false;
        if(msg == "1"){
          this.topic1 = true;
        } else if(msg == "2"){
          this.topic2 = true;
        } else if (msg == "3"){
          this.topic3 = true;
        }
      }
    }
  }
</script>
