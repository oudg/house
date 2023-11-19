<template>


<navMuent></navMuent>
   <diV class="head_main">



  <h3 style="color: black;">发现租房市场上最低价</h3>

<h1 style="line-height: 5px;">让我们带你回家吧</h1>

   <div class="input">

    <el-input
    style="width: 700px;height: 50px;"
      placeholder="请输入你要查找的小区名字"
      v-model="value1"
      class="input-with-select"

    >
      <template #append>

        <el-button :icon="Search" style="width: 80px;" @click="sendData()"/>

      </template>

    </el-input>

   </div>

   </diV>

</template>


<script>
import { Search } from '@element-plus/icons-vue';
import navMuent from './navMuent.vue';
import { ref } from 'vue';
export default{
  setup(){

return{
  
}
  },
data(){
  return{
    Search,
    value1:''
  }
},
methods:{
 sendData(){
  this.$router.push({path:'/select',query:{box:this.value1}})
 }
},

mounted(){

},
components:{
  navMuent
}
}
 
</script>
<style scoped>
.input{
width: 60%;
margin: 0px auto;
margin-top: 50px;
}
.head_main_text{
text-align: center;
}
.head_main{
height: 400px;
background: transparent url("src/pic/R-C.jpg") no-repeat;
background-size: 100% 100%;
background-color: rgba(0, 0, 0,0.5);
text-align: center;
}


</style>
