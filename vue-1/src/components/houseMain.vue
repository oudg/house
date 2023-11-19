
<template>
  <div class="Main">
 <div class="main">
<h2 style="text-align: center;">推荐城市</h2>

<diV class="main_city">
    <div class="image1" @click="sendcateId(0)">
       <p style="color: white; margin-top: 200px;"><h2>北京</h2></p>
    </div>
    <div class="image2" @click="sendcateId(1)">
       <p style="color: white; margin-top: 200px;"><h2>上海</h2></p>
    </div>
    <div class="image3" @click="sendcateId(2)">
       <p style="color: white; margin-top: 200px;"><h2>深圳</h2></p>
    </div>
    <div class="image4" @click="sendcateId(3)">
       <p style="color: white; margin-top: 200px;"><h2>广州</h2></p>
    </div>
</diV>

<h2 style="text-align: center; margin-top: 20px;">好房推荐</h2>
<h3 style="text-align: end;"><RouterLink to="/select?name=''">更多</RouterLink></h3>


<div class="page">
  
        <div  v-for="(arr,i) in list" v-bind:key="i">
           
            <div class="post" v-for="(item,j) in arr" :key="j" @click="postRouter(item)" name="1234" :style="{
          boxShadow: `var(${'--el-box-shadow-lighter'})`,
        }">
        <el-image style="width: 250px; height: 180px" :src="item.imgUrl" fit="fit" />
        <div class="text"><p class="p">{{ item.postTitle }}</p>
              <p v-if="city==0" class="p" style="color: #b1b3b8;">北京</p>
              <p v-if="city==1" class="p" style="color: #b1b3b8;">上海</p>
              <p v-if="city==2" class="p" style="color: #b1b3b8;">深圳</p>
              <p v-if="city==3" class="p" style="color: #b1b3b8;">广州</p>
              <h3>{{item.price}}/月</h3>
        </div>
    <hr style="color: #e9e9eb;margin-bottom: 0;"/>
   <p class="p1">卧室:{{item.roomCount}}  洗手间:{{ item.toiletCount }}  面积:{{ item.area }}</p>
   
    </div>


          </div>
      
       
    
    </div>

    <h2 style="text-align: center; margin-top: 20px;">精选好房</h2>
    <h3 style="text-align: end;"><RouterLink to="/select?name=''">更多</RouterLink></h3>
<div style="height: 400px; text-align: center;">


  <div  v-for="(arr,i) in hotlist" v-bind:key="i">
           
           <div class="post" v-for="(item,j) in arr" :key="j" @click="postRouter(item)" name="1234" :style="{
         boxShadow: `var(${'--el-box-shadow-lighter'})`,
       }">
       <el-image style="width: 250px; height: 180px" :src="item.imgUrl" fit="fit" />
       <div class="text"><p class="p">{{ item.postTitle }}</p>
             <p v-if="city==0" class="p" style="color: #b1b3b8;">北京</p>
             <p v-if="city==1" class="p" style="color: #b1b3b8;">上海</p>
             <p v-if="city==2" class="p" style="color: #b1b3b8;">深圳</p>
             <p v-if="city==3" class="p" style="color: #b1b3b8;">广州</p>
             <h3>{{item.price}}/月</h3>
       </div>
   <hr style="color: #e9e9eb;margin-bottom: 0;"/>
  <p class="p1">卧室:{{item.roomCount}}  洗手间:{{ item.toiletCount }}  面积:{{ item.area }}</p>
  


   </div>
         </div>
     

</div>

<h2 style="text-align: center; margin-top: 20px;">低价好房</h2>
    <h3 style="text-align: end;"><RouterLink to="/select?name=''">更多</RouterLink></h3>
<div style="height: 500px; text-align: center;">


  <div  v-for="(arr,i) in lowlist" v-bind:key="i">
           
           <div class="post" v-for="(item,j) in arr" :key="j" @click="postRouter(item)" name="1234" :style="{
         boxShadow: `var(${'--el-box-shadow-lighter'})`,
       }">
       <el-image style="width: 250px; height: 180px" :src="item.imgUrl" fit="fit" />
       <div class="text"><p class="p">{{ item.postTitle }}</p>
             <p v-if="city==0" class="p" style="color: #b1b3b8;">北京</p>
             <p v-if="city==1" class="p" style="color: #b1b3b8;">上海</p>
             <p v-if="city==2" class="p" style="color: #b1b3b8;">深圳</p>
             <p v-if="city==3" class="p" style="color: #b1b3b8;">广州</p>
             <h3>{{item.price}}/月</h3>
       </div>
   <hr style="color: #e9e9eb;margin-bottom: 0;"/>
  <p class="p1">卧室:{{item.roomCount}}  洗手间:{{ item.toiletCount }}  面积:{{ item.area }}</p>
  


   </div>
         </div>
     

</div>

  </div>
 




</div>


</template>

<style scoped>

.page{text-align: center;}
.text{
  text-align: left;
}
.page1{
  text-align: center;
  margin-top: 500px;
}

.el-image{
    border-radius: 10px;
}
.post{
    height: 320px;
    width: 250px;
   background-color: white;
   margin-top: 20px;
    border-radius: 10px;
    margin-left: 10px;
    margin-right: 10px;
    display: inline-block;
}
.p1{
    font-size: 12px;
    line-height: 0px;
    text-align: center;
}
.p{
    line-height: 5px;
    margin-left: 10px;
}
h3{
    color: #409EFF;
    margin-left: 10px;
}


.main_post{
 width: 100%;
 justify-content: center;
}
p{
  line-height: 5px;
}
.main_city{
  text-align: center;
  display: flex;
  justify-content: center;
}
.el-image{
  border-radius: 4px;
}
.Main{
  height: 1000px;

}
.main{
  
width: 80%;
margin: 0 auto;
margin-top: 80px;
}


.image1{
    
    height: 300px;
    width: 200px;
    margin-left: 10px;
    margin-right: 10px;
    border-radius: 10px;
    background-image: url("../pic/北京.jpg");
    background-size: 100% 100%;
}
.image2{
    
    height: 300px;
    width: 200px;
    margin-left: 10px;
    margin-right: 10px;
    border-radius: 10px;
    background-image: url("../pic/上海.jpg");
    background-size: 100% 100%;
}
.image3{
    
    height: 300px;
    width: 200px;
    margin-left: 10px;
    margin-right: 10px;
    border-radius: 10px;
    background-image: url("../pic/深圳.jpg");
    background-size: 100% 100%;
}
.image4{
    
    height: 300px;
    width: 200px;
    margin-left: 10px;
    margin-right: 10px;
    border-radius: 10px;
    background-image: url("../pic/广州.jpg");
    background-size: 100% 100%;
}

</style>
<script>
import post from './post.vue';
import axios from 'axios';
import imageCity from './imageCity.vue';
import { ref } from 'vue';
export default{
  setup(){
const category=ref(0)
const city=ref()
    return{
      category,
      city
    }
  },
     data(){
      return {
      
      list: [],
      hotlist:[],
      lowlist:[],
      pageNum1:Math.floor(Math.random()*14)+1,
      pageSize: 4,
      pageNum2:Math.floor(Math.random()*2)+1,

      pageNum: Math.floor(Math.random()*14)+1,
    }
      },


     mounted(){
this.getProductList();
sessionStorage.setItem('cityId',this.category)
this.getHotpost()
this.getlowprice()
this.getcity()
  },
  methods: {
getlowprice(){
  axios.get('http://localhost:8080/post/selectlow', {
        params: {
          pageSize: 4,
          pageNum: 1,
          category: sessionStorage.getItem('cityId')
        }
      }).then((res) => {
        this.lowlist = [res.data.data.records.slice(0, 4)];
      })
},
    getHotpost(){
      axios.get('http://localhost:8080/post/postList', {
        params: {
          pageSize: this.pageSize,
          pageNum: this.pageNum1,
          category: sessionStorage.getItem('cityId')
        }
      }).then((res) => {
        this.hotlist = [res.data.data.records.slice(0, 4)];
      })
    },
getcity(){
if(sessionStorage.getItem("cityId")!=null){
  this.city=sessionStorage.getItem("cityId")
}
},

sendcateId(res){
sessionStorage.setItem('cityId',res)
this.$router.push('/select')
},

    getProductList() {
      axios.get('http://localhost:8080/post/postList', {
        params: {
          pageSize: this.pageSize,
          pageNum: this.pageNum,
          category: sessionStorage.getItem('cityId')
        }
      }).then((res) => {
        this.list = [res.data.data.records.slice(0, 4)];
      })
    },
    change(pageNum) {
      this.pageNum = pageNum;
      this.getProductList();
    },

    postRouter(v){
      let house=JSON.stringify(v)
      
      this.$router.push({path:'/house_detail',query:{house: house}})
  
    }

  }


}
</script>
