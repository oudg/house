<script>
import Myhead from './components/Myhead.vue';
import houseMain from './components/houseMain.vue';
export default{

components:{
  houseMain,
  Myhead
}
}
</script>
<template>
  <div>
    <RouterView></RouterView>
    <Myhead/>
   <houseMain/>
  </div>
  
</template>