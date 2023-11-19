<template>
    <el-row class="tac">
      <el-col :span="4">
   <RouterLink to="/">    <h3 class="mb-2">首页</h3></RouterLink> 
        <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
        >
        <el-menu-item index="1" @click="index=1" v-if="mystatus==1">
          <el-icon><setting /></el-icon>
            <span>我的出租</span>
          </el-menu-item>
          <el-menu-item index="2" @click="index=2" v-if="mystatus==2">
          <el-icon><setting /></el-icon>
            <span>我的租赁</span>
          </el-menu-item>
          <el-menu-item index="3" @click="index=3" v-if="mystatus!=0">
          <el-icon><setting /></el-icon>
            <span>我的信息</span>
          </el-menu-item>
          <el-menu-item index="4" @click="index=4" v-if="mystatus==0">
          <el-icon><setting /></el-icon>
            <span>房源管理</span>
          </el-menu-item>
          <el-menu-item index="5" @click="index=5" v-if="mystatus==0">
          <el-icon><setting /></el-icon>
            <span>用户管理</span>
          </el-menu-item>
        </el-menu>

      </el-col>


      <el-col :span="20" v-if="index==5&&mystatus==0">
        <div style="height: auto;">
              <el-table :data="userpost" style="width: 100% " :align="center" >
    <el-table-column prop="userName" label="用户名" width="180" align="center"/>
    <el-table-column prop="userPass" label="密码" width="180" align="center"/>
    <el-table-column prop="phone" label="手机号"  align="center"/>
    <el-table-column prop="" label="操作" align="center">
      <template #default="scope">
      <el-row style="padding-left: 70px;">
      <el-button @click="getuserName(scope.row)">删除</el-button>

  </el-row>
</template>
    </el-table-column>
  </el-table>

  <el-pagination
  v-if="total3!=0"
            class="pagination"
            background
            layout="prev, pager, next"
            :pageSize="pageSize"
            :total="total3"
            @current-change="change3"
        >
        </el-pagination>
            </div>
           
      </el-col>




      <el-col :span="20" v-if="index==2&&mystatus==2">
        <div style="height: auto;">
              <el-table :data="usepost" style="width: 100% " :align="center" >
    <el-table-column prop="type" label="类型" width="180" align="center"/>
    <el-table-column prop="postTitle" label="房屋地址" width="180" align="center"/>
    <el-table-column prop="number" label="门牌号"  align="center"/>
    <el-table-column prop="price" label="租金" align="center" />
    <el-table-column prop="postEditor" label="租期" align="center" />
    <el-table-column prop="" label="操作" align="center">
      <template #default="scope">
      <el-row style="padding-left: 70px;">
      <el-button @click="getpostTitle1(scope.row)">删除</el-button>

  </el-row>
</template>
    </el-table-column>
  </el-table>

  <el-pagination
  v-if="total!=0"
            class="pagination"
            background
            layout="prev, pager, next"
            :pageSize="pageSize"
            :total="total2"
            @current-change="change2"
        >
        </el-pagination>
            </div>
           
      </el-col>

      <el-col :span="20" v-if="index==4&&mystatus==0">
        <div style="height: auto;">
              <el-table :data="allpost" style="width: 100% " :align="center" >
    <el-table-column prop="type" label="类型" width="180" align="center"/>
    <el-table-column prop="postTitle" label="房屋地址" width="180" align="center"/>
    <el-table-column prop="number" label="门牌号"  align="center"/>
    <el-table-column prop="price" label="租金" align="center" />
    <el-table-column prop="" label="操作" align="center">
      <template #default="scope">
      <el-row>
      <el-button @click="getpostTitle(scope.row)">删除</el-button>
  </el-row>
</template>
    </el-table-column>
  </el-table>

  <el-pagination
  v-if="total1!=0"
            class="pagination"
            background
            layout="prev, pager, next"
            :pageSize="pageSize"
            :total="total1"
            @current-change="change1"
        >
        </el-pagination>
            </div>
           
      </el-col>



      <el-form v-model="formupdate" v-if="index==3&&mystatus!=0" style="margin-left: 100px;margin-top: 100px;">
        <el-form-item label="账号">
          <el-input v-model="formupdate.count" placeholder="请输入新的账号" />
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="formupdate.password" placeholder="请输入新的密码" />
        </el-form-item>
        <el-form-item label="手机号">
          <el-input v-model="formupdate.phone" placeholder="请输入新的手机号" />
        </el-form-item>
        <el-button type="primary" @click="updates">确认</el-button>
      </el-form>
      <el-col :span="20" v-if="index==1">
        <div style="height: auto;">
              <el-table :data="tableData" style="width: 100% " :align="center" >
    <el-table-column prop="type" label="类型" width="180" align="center"/>
    <el-table-column prop="postTitle" label="房屋地址" width="180" align="center"/>
    <el-table-column prop="number" label="门牌号"  align="center"/>
    <el-table-column prop="price" label="租金" align="center" />
    <el-table-column prop="" label="操作" align="center">
      <template #default="scope">
      <el-row style="padding-left: 70px;">
      <el-button @click="getpostTitle(scope.row)">删除</el-button>
    <el-button @click="dialogFormVisible=true,getpostid(scope.row)">修改</el-button>
  </el-row>
</template>
    </el-table-column>
  </el-table>

  <el-pagination
  v-if="total!=0"
            class="pagination"
            background
            layout="prev, pager, next"
            :pageSize="pageSize"
            :total="total"
            @current-change="change"
        >
        </el-pagination>
            </div>
           
      </el-col>
    </el-row>

    <el-dialog v-model="dialogFormVisible" style="height: 550px;width: 1000px;">
    <el-form :model="form" :inline="true">
      
        <el-row :gutter=20>
        <el-col :span="12">
          <el-form-item label="小区所在的城市" :label-width="formLabelWidth">
        
          
            <el-select required v-model="form.cateId" class="m-2" placeholder="选择城市" style="width: 100px;">
    <el-option
      v-for="item in form.data"
      :key="item.value"
      :label="item.label"
      :value="item.value"
    />
            </el-select>

        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item  label="出租类型" :label-width="formLabelWidth">
        
          
          <el-select required v-model="form.type" class="m-2" placeholder="选择出租类型" style="width: 150px;">
    <el-option
      v-for="item in form.data1"
      :key="item.value"
      :label="item.label"
      :value="item.value"
    />
            </el-select>

        </el-form-item>
      </el-col>
       
      
       </el-row>

    
      <el-form-item label="小区" :label-width="formLabelWidth">
        <el-input required size="small" style="width: 250px; height: 40px;" v-model="form.postTitle" autocomplete="off" placeholder="请输入小区名"/>
      </el-form-item>
      <el-form-item label="房屋地址" :label-width="formLabelWidth">
        <el-row :gutter="20">
          <el-col :span="8">
            <el-input required v-model="form.number1" autocomplete="off" placeholder="楼栋号" style="height: 40px;"/>
          </el-col>
          <el-col :span="8">
            <el-input required v-model="form.number2" autocomplete="off" placeholder="单元号" style="height: 40px;"/>
          </el-col>
          <el-col :span="8">
            <el-input required v-model="form.number3" autocomplete="off" placeholder="门牌号" style="height: 40px;"/>
          </el-col>
        </el-row>
        
      </el-form-item>
      <el-row>
        <el-col :span="12">
      <el-form-item label="期望租金" :label-width="formLabelWidth">
        
          
        <el-input required v-model="form.price" size="small" autocomplete="off" type="number" placeholder="请输入您期望租出的价格" style="width: 150px; height: 40px;" /> 

        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="面积" :label-width="formLabelWidth">
        
          
        <el-input required v-model="form.area" size="small" autocomplete="off" type="number" placeholder="请输入您的房子大小" style="width: 150px; height: 40px;" /> 

        </el-form-item>
      </el-col>
       
      
       </el-row>

       <el-row :gutter=20>
        <el-col :span="12">
      <el-form-item label="房间数量" :label-width="formLabelWidth">
        
          
        <el-input required v-model="form.roomCount" size="small" type="number" autocomplete="off" placeholder="请输入您的房间数量" style="width: 150px; height: 40px;" /> 

        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="洗手间数量" :label-width="formLabelWidth">
        
          
        <el-input required v-model="form.toiletCount" size="small" type="number" autocomplete="off" placeholder="请输入您的洗手间数量" style="width:150px; height: 40px;" /> 

        </el-form-item>
      </el-col>
       
      
       </el-row>



       <el-form-item label="描述"  :label-width="formLabelWidth">
        
        <el-input
        required
    v-model="textarea1"
    autosize
    type="textarea"
    placeholder="请输入对房子的介绍和你的要求"
    style="width: 400px;height: 40px;"
    maxlength="100"
  />

        </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="dialogFormVisible = false; getformData()">
          提交
        </el-button>
      </span>
    </template>
  </el-dialog>


  </template>
  
  <script >
  import axios from 'axios';
  import { ref } from 'vue';
  import { reactive } from 'vue';
  import {
    Document,
    Menu as IconMenu,
    Location,
    Setting,
  } from '@element-plus/icons-vue'
import { RouterLink } from 'vue-router';
export default{
    setup() {
      const postid=ref(0)
      const form = reactive({
  type:'',
  postTitle:'',
  cateId: '',
  number1: '',
  number2:'',
  number3:'',
  price:'',
  area:'',
  roomCount:'',
  toiletCount:'',
  postContent:'',
  data1:[{
    value:'合租',
    label:'合租'
  },
{
  value:'整租',
  label:'整租'
}],
  data:[
  {
    value: '0',
    label: '北京',
  },
  {
    value: '1',
    label: '上海',
  },
  {
    value: '2',
    label: '深圳 ',
  },{
    value:'3',
    label:'广州'
  }
],
  delivery: false,
  type: [],
  resource: '',
  desc: '',
})
const city=ref('')
const textarea1=ref('')
const dialogTableVisible = ref(false)
const dialogFormVisible = ref(false)
const formLabelWidth = '140px'
        const mystatus = ref(100);
        const index = ref(2);
        const formupdate = reactive({
            count: '',
            password: '',
            phone: ''
        });
        return {
            index,
            formupdate,
            mystatus,
            form,
            city,
            textarea1,
            dialogFormVisible,
            dialogTableVisible,
            formLabelWidth,
            postid
        };
    },
    data() {
        return {
            tableData: [],
            allpost: [],
            usepost:[],
            userpost:[],
            ttt: [{
                    "dd": "dada"
                }],
            pageSize: 10,
            total: 0,
            total1: 0,
            total2:0,
            total3:0,
            pageNum: 0,
            pageNum1: 0,
            pageNum2:0,
            pageNum3:0,
            userId: sessionStorage.getItem("userId")
        };
    },
    created() {
    },
    mounted() {
        this.getuserStatus();
    },
    updated() {
    },
    methods: {

getAlluser(){
axios.get('http://localhost:8080/user/getAlluser').then((res)=>{
  this.userpost = res.data.data.records.slice(0, 4);
                this.total3 = res.data.data.total;
})
},

getuserName(e){

  axios.get(' http://localhost:8080/user/deleteuser', {
                params: {
                    userName:e.userName,
                    userPass:e.userPass
                }
            }).then((res) => {
                if (res.data) {
                    alert("删除成功");
                    this.$router.go(0);
                }
                else {
                    alert("删除失败");
                }
            });
},

getpostid(e){
axios.get("http://localhost:8080/post/getpostId",{
  params:{
postTitle:e.postTitle,
number:e.number
  }
}).then((res)=>{
  alert(res.data)
  this.postid=res.data
  
})
},
      getformData(){
axios.get("http://localhost:8080/post/postupate",{
  params:{
    postid:this.postid,
    postTitle:this.form.postTitle,
    price:this.form.price,
    cateId:this.form.cateId,
    roomCount:this.form.roomCount,
    toiletCount:this.form.toiletCount,
    area:this.form.area,
    number:this.form.number1+this.form.number2+this.form.number3,
    type:this.form.type,
    postContent:this.textarea1
  }
}).then((res)=>{
   if(res.data==1){
    alert("修改成功")
    this.$router.go(0)
   }
   else{
    alter("修改失败")
   }
})
},

        getAllpost() {
            axios.get('http://localhost:8080/user/getAllpost', {
                params: {
                    pageNum: this.pageNum1,
                    pageSize: this.pageSize,
                }
            }).then((res) => {
                this.allpost = res.data.data.records.slice(0, 10);
                this.total1 = res.data.data.total;
            });
        },
        getuseIdpost() {
            axios.get('http://localhost:8080/post/post_useId', {
                params: {
                    useId:sessionStorage.getItem('userId')
                }
            }).then((res) => {
                this.usepost = res.data.data.records.slice(0, 4);
                this.total2 = res.data.data.total;
              
            });
        },
        getuserStatus() {
            axios.get('http://localhost:8080/user/getuserStatus', {
                params: {
                    id: sessionStorage.getItem('userId')
                }
            }).then((res) => {
                this.mystatus = res.data;
                if (res.data == 1) {
                    this.getProductList();
                }
                else {
                  this.getuseIdpost();
                    this.getProductList();
                    this.getAllpost();
                    this.getAlluser();
                }
            });
        },
        updates() {
            axios.get('http://localhost:8080/user/userUpdate', {
                params: {
                    userId: sessionStorage.getItem('userId'),
                    userName: this.formupdate.count,
                    userPass: this.formupdate.password,
                    phone: this.formupdate.phone
                }
            }).then((res) => {
                if (res.data == 1) {
                    alert('修改成功');
                }
                else {
                    alert('修改失败');
                }
            });
        },
        getpostTitle(e) {
            axios.get('http://localhost:8080/user/delete', {
                params: {
                    postTitle: e.postTitle,
                    number: e.number
                }
            }).then((res) => {
                if (res.data == 1) {
                  alert(e.postTitle)
                    alert("删除成功");
                    this.$router.go(0);
                }
                else {
                    alert("删除失败");
                }
            });
        },
        getpostTitle1(e) {
            axios.get('http://localhost:8080/user/delete1', {
                params: {
                    postTitle: e.postTitle,
                    number: e.number
                }
            }).then((res) => {
            
                if (res.data == 1) {
                    alert("删除成功");
                    this.$router.go(0);
                }
                else {
                    alert("删除失败");
                }
            });
        },
        getProductList() {
            axios.get('http://localhost:8080/user/getuser_post', {
                params: {
                    pageNum: this.pageNum,
                    pageSize: this.pageSize,
                    userId: this.userId
                }
            }).then((res) => {
                // this.tableData =[res.data.data.records.slice(0, 10)]
                this.tableData = res.data.data.records.slice(0, 4);
                this.total = res.data.data.total;
            });
        },
        
        change(pageNum) {
            this.pageNum = pageNum;
            this.getProductList();
        },
        change1(pageNum) {
            this.pageNum1 = pageNum;
            this.getAllpost();
        },
        change2(pageNum) {
            this.pageNum2 = pageNum;
            this.getAllpost();
        },
        change3(pageNum) {
            this.pageNum3 = pageNum;
            this.getAllpost();
        },
    },
    components: { RouterLink }
}
  </script>