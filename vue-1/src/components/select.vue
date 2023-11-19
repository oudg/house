<template>
    <div>
<navMuent/>
    </div>
<div class="main">
    <div class="input">
        <el-row>
            <el-col :span="20">
        <el-input
        style="height: 40px;"
        v-model="input2"
        class="w-50 m-2"
        placeholder="输入你要搜索的小区名字"
        :prefix-icon="Search"
      />
    </el-col>
    <el-col :span="4">
      <el-button type="primary" style="height: 40px; width: 80px;" @click="byNameandId1">搜索</el-button>
    </el-col>
    </el-row>
    </div>
    <div class="table">
        <el-form :model="form" label-width="120px">
        <el-form-item label="方式" >
            <el-radio-group v-model="form.radio2" size="large"  @change="buttoncontrl()">
      <el-radio-button label="不限">不限</el-radio-button>
      <el-radio-button label="合租">合租</el-radio-button>
      <el-radio-button label="整租">整租</el-radio-button>
      
      
    </el-radio-group>
        </el-form-item>

<el-form-item label="租金">
    <el-radio-group v-model="form.radio1" size="large"  @change="buttoncontrl()">
      <el-radio-button label="0">500≤</el-radio-button>
      <el-radio-button label="500">500-1000</el-radio-button>
      <el-radio-button label="1000">1000-2000</el-radio-button>
      <el-radio-button label="2000">2000-3000</el-radio-button>
      <el-radio-button label="3000">3000-4000</el-radio-button>
      <el-radio-button label="4000">4000-5000</el-radio-button>
      <el-radio-button label="5000">≥5000</el-radio-button>
      <el-radio-button label="1">清空</el-radio-button>
    </el-radio-group>
</el-form-item>

     </el-form>
    </div>

    <el-divider />
<h3>已为你找到{{total}}套房</h3>
{{ xx }}
</div>
<div>

    <div class="page">
  
  <div class="list" v-for="(arr,i) in list" v-bind:key="i">
     
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


</template>
<script>
import navMuent from './navMuent.vue';
import { ref } from 'vue'

import { reactive } from 'vue'
import { Calendar, Search } from '@element-plus/icons-vue'
import axios from 'axios';

export default{
    setup(){
       const input2=ref('')
        const x=ref(0)
        const city=ref()
        const total=ref(0)
        const form=reactive({
            radio1:'1',
            radio2:'不限'
        })
        
        const options=reactive(
            [{
                value:'不限',
                label:'不限'
            },
        {
            value:'合租',
                label:'合租'
        }
    ,{
        value:'整租',
                label:'整租'
    }]
        )
        const list=reactive([''])
return{
    Search,
   form,
   options,
   input2,
    x,
    city,
    total,
    list
   
}
    },
    data(){
        return{
            xx:''
        }
    },
mounted(){
    this.getcity()
    this.xx=this.$route.query.box
       if(this.xx!=null){
this.byNameandId(this.xx)

       }else{

        this.getProductList()
       }
   

},
    data(){
        
        return{
            
      
      pageSize: 60,
      
      pageNum: 0
     
        }
    },
    methods:{
        
    buttoncontrl(){
        if(this.form.radio2=="不限"&&this.form.radio1==1){
            // alert(this.form.radio1+this.form.radio2)
            this.getProductList()
        }
        if(this.form.radio2=="不限"&&this.form.radio1!=1){
            // alert(this.form.radio1+this.form.radio2)
            this.getbyprice()
            
        }
if(this.form.radio2!="不限"&&this.form.radio1==1){
    // alert(this.form.radio1+this.form.radio2)
    this.byTypeandId()
  
}
if(this.form.radio2!="不限"&&this.form.radio1!=1){
    // alert(this.form.radio1+this.form.radio2)
this.getbyTypeAndPrice()

}

    },
    getcity(){
if(sessionStorage.getItem("cityId")!=null){
  this.city=sessionStorage.getItem("cityId")
}
    },

        byTypeandId(){
           
axios.get("http://localhost:8080/post/select_bytype",{
    params:{
        houseType:this.form.radio2,
        cateId:sessionStorage.getItem("cityId")
    }
}).then((res)=>{
    this.list = [res.data.data.records.slice(0, 4), res.data.data.records.slice(4, 8),res.data.data.records.slice(8, 12),
        res.data.data.records.slice(12, 16),res.data.data.records.slice(16, 20),res.data.data.records.slice(20, 24)
        ,res.data.data.records.slice(24, 28)
        ,res.data.data.records.slice(28, 32)
        ,res.data.data.records.slice(32, 36)
        ,res.data.data.records.slice(36, 40)
        ,res.data.data.records.slice(40, 44)
        ,res.data.data.records.slice(44, 48)
        ,res.data.data.records.slice(48, 52)
        ,res.data.data.records.slice(52, 56)
        ,res.data.data.records.slice(56, 60)];
        this.total = res.data.data.total;
})

        },
     byNameandId(){
        axios.get("http://localhost:8080/post/select_byname",{
            params:{
                name:this.xx,
                cateId:sessionStorage.getItem("cityId")
            }
        }).then((res)=>{
            this.list = [res.data.data.records.slice(0, 4), res.data.data.records.slice(4, 8),res.data.data.records.slice(8, 12),
        res.data.data.records.slice(12, 16),res.data.data.records.slice(16, 20),res.data.data.records.slice(20, 24)
        ,res.data.data.records.slice(24, 28)
        ,res.data.data.records.slice(28, 32)
        ,res.data.data.records.slice(32, 36)
        ,res.data.data.records.slice(36, 40)
        ,res.data.data.records.slice(40, 44)
        ,res.data.data.records.slice(44, 48)
        ,res.data.data.records.slice(48, 52)
        ,res.data.data.records.slice(52, 56)
        ,res.data.data.records.slice(56, 60)];
        this.total = res.data.data.total;

        })
     },

     byNameandId1(){
        axios.get("http://localhost:8080/post/select_byname",{
            params:{
                name:this.input2,
                cateId:sessionStorage.getItem("cityId")
            }
        }).then((res)=>{
            this.list = [res.data.data.records.slice(0, 4), res.data.data.records.slice(4, 8),res.data.data.records.slice(8, 12),
        res.data.data.records.slice(12, 16),res.data.data.records.slice(16, 20),res.data.data.records.slice(20, 24)
        ,res.data.data.records.slice(24, 28)
        ,res.data.data.records.slice(28, 32)
        ,res.data.data.records.slice(32, 36)
        ,res.data.data.records.slice(36, 40)
        ,res.data.data.records.slice(40, 44)
        ,res.data.data.records.slice(44, 48)
        ,res.data.data.records.slice(48, 52)
        ,res.data.data.records.slice(52, 56)
        ,res.data.data.records.slice(56, 60)];
        this.total = res.data.data.total;

        })
     },
getbyTypeAndPrice(){
if(this.form.radio1==0){
    this.x=500
}
 if(this.form.radio1==500){
    this.x=1000
}
 if(this.form.radio1==1000){
    this.x=2000
}
 if(this.form.radio1==2000){
    this.x=3000
}
 if(this.form.radio1==3000){
    this.x=4000
}
 if(this.form.radio1==4000){
    this.x=5000
}
if(this.form.radio1==5000){
    this.x=10000
}

axios.get("http://localhost:8080/post/select_bytypeAndprice",{
params:{
    start:this.form.radio1,
    end:this.x,
    cateId:sessionStorage.getItem("cityId"),
    leixing:this.form.radio2
}
}).then((res)=>{
  
    this.list = [res.data.data.records.slice(0, 4), res.data.data.records.slice(4, 8),res.data.data.records.slice(8, 12),
        res.data.data.records.slice(12, 16),res.data.data.records.slice(16, 20),res.data.data.records.slice(20, 24)
        ,res.data.data.records.slice(24, 28)
        ,res.data.data.records.slice(28, 32)
        ,res.data.data.records.slice(32, 36)
        ,res.data.data.records.slice(36, 40)
        ,res.data.data.records.slice(40, 44)
        ,res.data.data.records.slice(44, 48)
        ,res.data.data.records.slice(48, 52)
        ,res.data.data.records.slice(52, 56)
        ,res.data.data.records.slice(56, 60)];
        this.total = res.data.data.total;

})
},
getbyprice(){
if(this.form.radio1==0){
    this.x=500
}
 if(this.form.radio1==500){
    this.x=1000
}
 if(this.form.radio1==1000){
    this.x=2000
}
 if(this.form.radio1==2000){
    this.x=3000
}
 if(this.form.radio1==3000){
    this.x=4000
}
 if(this.form.radio1==4000){
    this.x=5000
}
if(this.form.radio1==5000){
    this.x=10000
}

axios.get("http://localhost:8080/post/select_byprice",{
params:{
    start:this.form.radio1,
    end:this.x,
    cateId:sessionStorage.getItem("cityId")
}
}).then((res)=>{
  
    this.list = [res.data.data.records.slice(0, 4), res.data.data.records.slice(4, 8),res.data.data.records.slice(8, 12),
        res.data.data.records.slice(12, 16),res.data.data.records.slice(16, 20),res.data.data.records.slice(20, 24)
        ,res.data.data.records.slice(24, 28)
        ,res.data.data.records.slice(28, 32)
        ,res.data.data.records.slice(32, 36)
        ,res.data.data.records.slice(36, 40)
        ,res.data.data.records.slice(40, 44)
        ,res.data.data.records.slice(44, 48)
        ,res.data.data.records.slice(48, 52)
        ,res.data.data.records.slice(52, 56)
        ,res.data.data.records.slice(56, 60)];
        this.total = res.data.data.total;
})
},
     getProductList() {
      axios.get('http://localhost:8080/post/postList', {
        params: {
          pageSize: this.pageSize,
          pageNum: this.pageNum,
          category: sessionStorage.getItem("cityId")
        }
      }).then((res) => {
        this.list = [res.data.data.records.slice(0, 4), res.data.data.records.slice(4, 8),res.data.data.records.slice(8, 12),
        res.data.data.records.slice(12, 16),res.data.data.records.slice(16, 20),res.data.data.records.slice(20, 24)
        ,res.data.data.records.slice(24, 28)
        ,res.data.data.records.slice(28, 32)
        ,res.data.data.records.slice(32, 36)
        ,res.data.data.records.slice(36, 40)
        ,res.data.data.records.slice(40, 44)
        ,res.data.data.records.slice(44, 48)
        ,res.data.data.records.slice(48, 52)
        ,res.data.data.records.slice(52, 56)
        ,res.data.data.records.slice(56, 60)];
        this.total = res.data.data.total;
      })
    },
    change(pageNum) {
      this.pageNum = pageNum;
     this.getProductList()
    },

    postRouter(v){
      let house=JSON.stringify(v)
      
      this.$router.push({path:'/house_detail',query:{house: house}})
  
    }

    },
    components:{
        navMuent
    }
}
</script>

<style scoped>

.input{
    width: 50%;
    margin: 0 auto;
}
.table{
    margin-top: 50px;
}
.page{text-align: center;}
.text{
  text-align: left;
}
.pagination{
 justify-content: center;
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

.main{
    height: 300px;
}
.main_post{
 width: 100%;
 justify-content: center;
}
p{
  line-height: 5px;
}
  
  
</style>