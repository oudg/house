<template>
    <div class="meun">
<div
class="meun_left">
<h1 style="margin-left: 300px;display: inline;">LOGO  </h1>
<h3 style="display: inline;">当前城市</h3>
<el-select v-model="city" class="m-2"  style="margin-left: 10px; width: 75px;" @change="changecity(this.city)">
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value"
    />
  </el-select>
</div>

<div class="meun_right">
  <el-row :gutter="10">
    <el-col :span="3"><p @click="getHome">首页</p></el-col>
    <el-col :span="3"><p>合租</p></el-col>
    <el-col :span="3"><p>整租</p></el-col>
    <el-col :span="4" @click="islogin()" v-if="mystatus==1"><p>房源发布</p></el-col>
    
    <el-col :span="4" class="buttn" v-show="userInfo==null"><el-button round @click="dialogreg=true">注册</el-button>
    </el-col>
    <el-col :span="4" class="buttn" v-show="userInfo==null"><el-button type="primary" round @click="getLogin">登录</el-button></el-col>
    <el-col :span="3" class="icon" v-show="userInfo!=null"><div>
      <el-avatar :icon="UserFilled" />
    </div></el-col>
    <el-col :span="4" style="padding-top: 30px;" v-show="userInfo!=null"><span><el-link @click="user_detail" target="_blank" style="font-weight: bold;font-size: large;">{{userInfo}}</el-link></span></el-col>
    <el-col :span="4" style="padding-top: 30px;" v-show="userInfo!=null"><span><el-link @click="getout" target="_blank" style="font-weight: bold;font-size: large;">退出</el-link></span></el-col>
  </el-row>
</div>

<el-dialog v-model="dialogreg" title="注册" style="width: 480px;">
  <el-form :model="form_reg" >
      <el-form-item label="账号" :label-width="formLabelWidth">
        <el-input style="width: 200px;" v-model="form_reg.number" autocomplete="off" placeholder="请输入你的账号" />
      </el-form-item>
      <el-form-item label="密码" :label-width="formLabelWidth">
        <el-input style="width: 200px;" v-model="form_reg.password" autocomplete="off"  placeholder="请输入你的密码"></el-input>
      </el-form-item>
      <el-form-item label="手机号" :label-width="formLabelWidth">
        <el-input style="width: 200px;" v-model="form_reg.phone" autocomplete="off"  placeholder="请输入你的手机号"></el-input>
      </el-form-item>
      <el-form-item label="选择你的身份" :label-width="formLabelWidth">
        <el-select v-model="value" class="m-2" placeholder="Select" style="width: 200px;">
    <el-option
      v-for="item in form_reg.options"
      :label="item.label"
      :value="item.value"
    />
  </el-select>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogreg = false">取消</el-button>
        <el-button type="primary" @click="dialogreg = false,getregit()">
          确认
        </el-button>
      </span>
    </template>
  </el-dialog>


<el-dialog v-model="dialogFormVisible" style="height: 550px;width: 1000px;">
    <el-form :model="form" :inline="true">
      
        <el-row :gutter=20>
        <el-col :span="12">
          <el-form-item label="小区所在的城市" :label-width="formLabelWidth">
        
          
            <el-select v-model="form.cateId" class="m-2" placeholder="选择小区所在的城市" style="width: 100px;">
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
        <el-form-item label="出租类型" :label-width="formLabelWidth">
        
          
          <el-select v-model="form.type" class="m-2" placeholder="选择出租类型" style="width: 150px;">
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
        <el-input size="small" style="width: 250px; height: 40px;" v-model="form.postTitle" autocomplete="off" placeholder="请输入小区名"/>
      </el-form-item>
      <el-form-item label="房屋地址" :label-width="formLabelWidth">
        <el-row :gutter="20">
          <el-col :span="8">
            <el-input  v-model="form.number1" autocomplete="off" placeholder="楼栋号" style="height: 40px;"/>
          </el-col>
          <el-col :span="8">
            <el-input  v-model="form.number2" autocomplete="off" placeholder="单元号" style="height: 40px;"/>
          </el-col>
          <el-col :span="8">
            <el-input  v-model="form.number3" autocomplete="off" placeholder="门牌号" style="height: 40px;"/>
          </el-col>
        </el-row>
        
      </el-form-item>
      <el-row>
        <el-col :span="12">
      <el-form-item label="期望租金" :label-width="formLabelWidth">
        
          
        <el-input v-model="form.price" size="small" autocomplete="off" type="number" placeholder="请输入您期望租出的价格" style="width: 150px; height: 40px;" /> 

        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="面积" :label-width="formLabelWidth">
        
          
        <el-input v-model="form.area" size="small" autocomplete="off" type="number" placeholder="请输入您的房子大小" style="width: 150px; height: 40px;" /> 

        </el-form-item>
      </el-col>
       
      
       </el-row>

       <el-row :gutter=20>
        <el-col :span="12">
      <el-form-item label="房间数量" :label-width="formLabelWidth">
        
          
        <el-input v-model="form.roomCount" size="small" type="number" autocomplete="off" placeholder="请输入您的房间数量" style="width: 150px; height: 40px;" /> 

        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="洗手间数量" :label-width="formLabelWidth">
        
          
        <el-input v-model="form.toiletCount" size="small" type="number" autocomplete="off" placeholder="请输入您的洗手间数量" style="width:150px; height: 40px;" /> 

        </el-form-item>
      </el-col>
       
      
       </el-row>



       <el-form-item label="描述" :label-width="formLabelWidth">
        
        <el-input
    v-model="textarea1"
    autosize
    type="textarea"
    placeholder="请输入对房子的介绍和你的要求"
    style="width: 400px;height: 40px;"
    maxlength="100"
  />

        </el-form-item>
        <el-form-item label="请上传图片">
          <el-upload class="upload"
                 ref="upload"
                 action="#"
                 :file-list="fileList"	
                 :auto-upload="false"		
                 :http-request="uploadFile"		
                 :on-change="handleChange"	
                 :on-preview="handlePreview"	
                 :on-remove="handleRemove"	
                 multiple="multiple">	
        <el-button slot="trigger"
                   size="small"
                   type="primary"
                   @click="delFile">选取文件</el-button>
      </el-upload>
        </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="dialogFormVisible = false;getformData();onSubmit()">
          提交
        </el-button>
      </span>
    </template>
  </el-dialog>

  </div>
</template>

<style scoped>

.el-button--text {
  margin-right: 15px;
}
.el-select {
  width: 300px;
}
.dialog-footer button:first-child {
  margin-right: 10px;
}

.meun_left{
  width: 50%;
  padding-top: 15px;
}
.meun_right{
  width: 50%;
}
.meun{
  height: 80px;
  display: flex;
}
.buttn{
  margin-top: 30px;color: black;
}
p{
  line-height: 60px;
  font-weight: bold;
}
.icon{
  padding-top: 25px;
}
.el-row{
  width: 70%;
}
</style>
<script>
import axios from 'axios';
import { UserFilled } from '@element-plus/icons-vue'
import { reactive, ref } from 'vue'
export default{
setup(){
  const value=ref()
  const city=ref('')
  const mystatus=ref(0)
const textarea1=ref('')
const dialogTableVisible = ref(false)
const dialogFormVisible = ref(false)
const formLabelWidth = '140px'
const dialogreg=ref(false)
const userInfo=ref(sessionStorage.getItem("userIofo"))
const userId=ref(sessionStorage.getItem("userId"))
const form_reg=reactive({
  number:'',
  password:'',
  phone:'',
  options:[
    {
      value:1,
      label:'房东'
    },
    {
      value:2,
      label:'租户'
    }
  ]
})
const options=[{
    value: 0,
    label: '北京',
  },
  {
    value: 1,
    label: '上海',
  },
  {
    value: 2,
    label: '深圳',
  },
  {
    value: 3,
    label: '广州',
  },
]
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
return{
  UserFilled,
  dialogFormVisible,
  dialogTableVisible,
  form,
  formLabelWidth,
  textarea1,
  userId,
  userInfo,
  dialogreg,
  form_reg,
  options,
  city,
  value,
  mystatus

 
}
  
},
created(){
this.city=this.options[0]
this.value=this.form_reg.options[1]
},
mounted(){
this.creatcity()

if(sessionStorage.getItem('userId')!=null){
  this.getststus()
}

},
  data(){
    return{
      dialogImageUrl: '',
        dialogVisible: false,
        fileList: [],
      // 不支持多选
      multiple: false,
      formData: "",
    }
  },
 
  methods:{
   
    onSubmit () {
      setTimeout(()=>{
        let formData = new FormData();
        formData.append("file", this.fileList[0].raw);
       
        formData.append("title", this.title);
        axios.post('http://localhost:8080/pic/upload1', formData, {
        "Content-Type": "multipart/form-data;charset=utf-8"
      })
        .then((res) => {
          
        })

      },2000)
        

  },
      //点击上传文件触发的额外事件,清空fileList
      delFile () {
      this.fileList = [];
    },
    handleChange (file, fileList) {
      this.fileList = fileList;
      // console.log(this.fileList, "sb");
    },
    //自定义上传文件
    uploadFile (file) {
      this.formData.append("file", file.file);
      // console.log(file.file, "sb2");
    },
    //删除文件
    handleRemove (file, fileList) {
      console.log(file, fileList);
    },
    // 点击文件
    handlePreview (file) {
      console.log(file);
    },

    creatcity(){
if(sessionStorage.getItem('cityId')==0){
  this.city='北京'
}
if(sessionStorage.getItem('cityId')==1){
  this.city='上海'
}
if(sessionStorage.getItem('cityId')==2){
  this.city='深圳'
}
if(sessionStorage.getItem('cityId')==3){
  this.city='广州'
}
    },
changecity(res){
if(res==0){
  
  sessionStorage.setItem('cityId',0)
}
if(res==1){
  
  sessionStorage.setItem('cityId',1)
 
}
if(res==2){
  
  sessionStorage.setItem('cityId',2)
}
if(res==3){
  
  sessionStorage.setItem('cityId',3)
}
this.$router.go(0)
},
    islogin(){
if(this.userInfo!=null){
  this.dialogFormVisible=true
}else{
  alert("请先登录")
  this.$router.push('/dialog')
}

    },
getHome(){
  this.$router.push('/')
},
getLogin(){
  this.$router.push('/dialog')
},
getregit(){
  axios.get("http://localhost:8080/user/regite",{
    params:{
      userName:this.form_reg.number,
      userPass:this.form_reg.password,
      phone:this.form_reg.phone,
      user_status:this.value
    }
  }).then((reg)=>{
    if(reg.data==1){
      alert("注册成功")
    }else{
      alert("注册失败")
    }
  })
},
getout(){
sessionStorage.removeItem("userIofo")
sessionStorage.removeItem("userId")
this.$router.go(0)
},
user_detail(){
  this.$router.push('/user_detail')
},
getuser(){
axios.get("http://localhost:8080/user")
},
getststus(){
axios.get("http://localhost:8080/user/getuserStatus",{
  params:{
    id:sessionStorage.getItem('userId')
  },
}).then((res)=>{
this.mystatus=res.data
})
},
getformData(){
  
axios.get("http://localhost:8080/user/addPost",{
  params:{
    userId:sessionStorage.getItem("userId"),
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
    alert("发布成功")
   }
   else{
   alert ("发布失败")
   }
})
}
  },
  components:{

  }




}


</script>