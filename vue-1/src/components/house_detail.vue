<template>
    <div class="box">
       <navMuent></navMuent>
       <diV class="head">

       <div class="carousel">
        <el-carousel height="500px">
            
      <el-carousel-item v-for="item in imgarr" :key="item">
        <img class="imgx" :src="item"/>
      </el-carousel-item>   
    </el-carousel>
       </div>

      
       <div class="detail">
 <el-row>
    <el-col :span="12"><div class="detail_left">
        
        <h1>
            {{ house.postTitle }}
        </h1>
    <h3>
        {{ house.number }}({{ house.type }})
    </h3>
    </div></el-col>
    <el-col :span="12"><div class="detail_right">
        <h3 v-if="house.postStatus==0">正在出租</h3>
        <h3 v-else>已经出租</h3>
        <h1 style="color: #79bbff"> {{ house.price }}/元</h1>
       
    </div></el-col>
  </el-row>
       </div>
    </diV>


   

       <div class="main">
        <el-row :gutter="20">


    <el-col :span="16"><div class="left_up"  :style="{
          boxShadow: `var(${'--el-box-shadow-lighter'})`,
        }">
         <el-carousel height="400px" style="border-radius: 10px;">
      <el-carousel-item v-for="item in imgbrr" :key="item">
        <img :src="item" style="width: 100%;height: 100%; object-fit: cover;"/>
      </el-carousel-item>
    </el-carousel>
    </div></el-col>

    <el-col :span="8"><div class="right_up" :style="{
          boxShadow: `var(${'--el-box-shadow-lighter'})`,
        }">
        <span><h2 style="margin-left: 20px;padding-top:  20px;">业主</h2></span>
      <div style="text-align: center;">
        <el-avatar :size="150"
        src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"
      />
      </div>
      <span><h3 style="margin-left: 10px;">联系电话:{{ phone }}</h3></span>
      
      </div></el-col>
  </el-row>
  <el-row :gutter="20" style="margin-top: 30px;">
    <el-col :span="16"><div class="left_down" >
        
        <el-row :gutter="20">
    <el-col :span="8"><div class="left_down_unit" :style="{
          boxShadow: `var(${'--el-box-shadow-lighter'})`,
        }">
    <h3>卧室：</h3>
    <h3>{{ house.roomCount }}个</h3>    
    </div></el-col>
    <el-col :span="8"><div class="left_down_unit" :style="{
          boxShadow: `var(${'--el-box-shadow-lighter'})`,
        }">
        <h3>卫生间：</h3>  
    <h3>{{ house.toiletCount }}个</h3> 
        </div></el-col>
    <el-col :span="8"><div class="left_down_unit" :style="{
          boxShadow: `var(${'--el-box-shadow-lighter'})`,
        }">
     <h3>面积：</h3>
    <h3>{{ house.area }} M²</h3>  
    </div></el-col>
  </el-row>
  
    </div></el-col>
    <el-col :span="8"><div class="right_down" :style="{
          boxShadow: `var(${'--el-box-shadow-lighter'})`,
        }">
      <div class="right_down_unit">
<h3>立即预约看房</h3>
<el-select v-model="value" class="m-2" placeholder="Select">
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value"
    />
  </el-select>
<div style="margin-top: 15px;"><el-button type="primary" style="width: 220px;" @click="islogin()">确认</el-button></div>

      </div>
    </div></el-col>
  </el-row>


  <el-row :gutter="20">
    <el-col :span="16"><div class="" style="height: 300px; border-radius: 10px;" :style="{
          boxShadow: `var(${'--el-box-shadow-lighter'})`,
        }">
        <div style="padding-left: 20px; padding-top: 10px;">
    <span>
        <h3>详细介绍:</h3>
    </span>    
    <span>
      <h5> {{ house.postContent }}</h5>
    </span>
</div>
    </div></el-col>
   
    <el-col :span="8"><div class=""></div></el-col>
  </el-row>
       </div>
       <div>
      
      
      
      </div>
    </div>
    
    

</template>

<style>
.imgx{
    height: 100%;
    width: 100%;
    object-fit: cover;
}
.left_down_unit{
    height: 100px;
    
    border-radius: 10px;
   text-align: center;
}
.detail{
    margin: 0 auto;
width: 70%;

}
.detail_right{
    float: right;
}

.head{
    height: 700px;
}
.demonstration {
  color: var(--el-text-color-secondary);
}

.el-carousel__item h3 {
  color: #475669;
  opacity: 0.75;
  line-height: 150px;
  margin: 0;
  text-align: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}





.left_up{
   
  height: 400px;
  border-radius: 10px;
 
    
}
.right_up{
  height: 400px;
  border-radius: 10px;
   
}

.left_down{
   height: 100px;
   border-radius: 10px;
   margin: 0 auto;
    
}
.right_down{
    height: 200px;
    border-radius: 10px;
   
 text-align: center;

}
.right_down_unit{
   
   display: inline-block;
}
.main{
    width: 70%;
    margin: 0 auto;
    height: 1000px;
   
}
</style>
<script >
import { UserFilled } from '@element-plus/icons-vue'
import navMuent from './navMuent.vue';
import { ref } from 'vue';
import axios from 'axios';
import moment from'moment'
export default{
    setup(){
      const phone=ref()
      const value=ref()
      const options = [
  {
    value: '一个月',
    label: '一个月',
  },
  {
    value: '三个月',
    label: '三个月',
  },
  {
    value: '半年',
    label: '半年',
  },
  {
    value: '一年',
    label: '一年',
  },
  {
    value: '两年',
    label: '两年',
  },
]
      return{
        UserFilled,
        phone,
        value,
        options
      }
    },
    data(){
      
        
      return{

      nowDate:'',
      nexDate:'',
        imgarr:[],
        imgbrr:[],
   house: JSON.parse(this.$route.query.house),
text:JSON.parse(this.$route.query.house).postThumbnail,
text1:JSON.parse(this.$route.query.house).postSummary
      }
    },
 
methods:{
  islogin(){
if(sessionStorage.getItem("userId")==null){
alert("请先登录")
this.$router.push('/dialog')
}else if(this.value==null){
  alert("选择不能为空")

}else{
  this.saveuseId()
  this.nowDate=moment().format('YYYY-MM-DD')
if(this.value=='一个月')

{
  this.nexDate=moment().add(1,'M').format('YYYY-MM-DD')
}
if(this.value=='三个月')

{
  this.nexDate=moment().add(3,'M').format('YYYY-MM-DD')
}

if(this.value=='半年')

{
  this.nexDate=moment().add(6,'M').format('YYYY-MM-DD')
}

if(this.value=='一年')

{
  this.nexDate=moment().add(1,'y').format('YYYY-MM-DD')
}

if(this.value=='一年')

{
  this.nexDate=moment().add(2,'y').format('YYYY-MM-DD')
}

  axios.get('http://localhost:8080/post/postedit',{
    params:{
      postTitle:this.house.postTitle,
      number:this.house.number,
      edit:this.nowDate+'~'+this.nexDate
    }
  }).then((res)=>{
    alert("预约成功")
  })
}
  },
  saveuseId(){
    axios.get('http://localhost:8080/post/postUseId',{
    params:{
      postTitle:this.house.postTitle,
      number:this.house.number,
      useId:sessionStorage.getItem("userId")
    }
  }).then((res)=>{
   
  })
  },
getphone(){
  axios.get('http://localhost:8080/user/getphone',{
    params:{
      id:this.house.userId
    }
  }).then((res)=>{
    this.phone=res.data
  })
},
  gettext(){
    let x=this.text.split(',')
    let y=this.text1.split(',')
    this.imgarr=x
    this.imgbrr=y
  }
},
mounted(){
  this.getphone()
    this.gettext()
},
    components:{
        navMuent
    },
}
</script>