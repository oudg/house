<template>
<diV>
    <div class="head">
<RouterLink to="/"><h1>LOGO</h1></RouterLink>
    </div>
    <div class="main">
<el-card class="box_card">
    <div class="login">
        <h3 style="text-align: center;">MEMBER LOGIN</h3>
        <el-form :model="loginForm" :rules="rules" ref="loginForm">
            <el-form-item :props="loginForm.name">
                <el-input
        v-model="loginForm.name"
        class="w-50 m-2"
        placeholder="账号"
        :prefix-icon="User"
      />
    </el-form-item>
    <el-form-item :props="loginForm.password">
        <el-input
        v-model="loginForm.password"
        class="w-50 m-2"
        type="password"
        placeholder="密码"
        :prefix-icon="Lock"
      />
    </el-form-item>
        <el-button type="primary" style="width: 100%;" @click="confirm">登录</el-button>
        <el-button style="margin-top: 10px; float: right;" 
        @click="dialogreg=true"
      
      :type="primary"
      link
      >注册</el-button
    >
    </el-form>
    </div>
</el-card>
    </div>
    <el-dialog v-model="dialogreg" title="注册" style="width: 480px;">
  <el-form :model="form_reg" style="margin-left: 80px;" >
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
        <el-select v-model="value" class="m-2" placeholder="Select">
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
</diV>

</template>
<style scoped>
.head{
    height: 80px;
    margin-left: 200px;
}
.main{
    height: 580px;
    width: 100%;
    background: url('../pic/1699030302498.jpg') no-repeat;
    background-size: 100% 100%;
    background-attachment: fixed;
}
.box_card{
    float: right;
    margin-right: 200px;
    height: 350px;
    width: 350px;
    margin-top: 150px;
}
</style>
<script>
import { User,Lock } from '@element-plus/icons-vue'
import axios from 'axios';
import { ref } from 'vue';
import { reactive } from 'vue';
export default{
    setup(){
      const value=ref()
        const dialogreg=ref(false)
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
return{
    User,
    Lock,
    dialogreg,
    form_reg,
    value
}

    },
    data(){
        return {
            
                loginForm:{
                    name:'',
                    password:''
                },

                // 输入信息长度验证
                rules:{
                    name: [
                        { required: true, message: '请输入用户名', trigger: 'blur' },
                        { min: 2, max: 5, message: '用户名长度在 2 到 5 个字符', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: '请输密码', trigger: 'blur' },
                        { min: 2, max: 5, message: '密码长度在 2 到 5 个字符', trigger: 'blur' }
                    ]
                }

            

        }


},
methods:{
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
    confirm(){
                this.$refs.loginForm.validate((valid) => {
                    if (valid) { //valid成功为true，失败为false
                        //去后台验证用户名密码，并返回token
                        axios.get('http://localhost:8080/user/login',{params:{
                            userName:this.loginForm.name,
                               userPass:this.loginForm.password
                        }
                           
                        }).then(res=>{
                            console.log(res.data)
                            if(res.data.userName!=null){
        
                                sessionStorage.setItem("userIofo",res.data.userName)
                                sessionStorage.setItem("userId",res.data.id)
                                //跳转到主页
                                this.$router.replace('/');
                            }else{
                                alert('用户名或密码错误！');
                                return false;
                            }
                        });
                    } else {
                        console.log('校验失败');
                        return false;
                    }
                });
            }
        }

}

</script>