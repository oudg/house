<template>
    <div class="post">
        <el-image style="width: 250px; height: 180px" src="src\pic\house.jpg" fit="fit" />
        <div><p class="p">111</p>
              <p class="p" style="color: #b1b3b8;">city</p>
              <h3>4300/月</h3>
        </div>
    <hr style="color: #e9e9eb;margin-bottom: 0;"/>
   <p class="p1">卧室:3  洗手间:1  面积:100</p>
   
    </div>
</template>
<style scoped>
.el-image{
    border-radius: 10px;
}
.post{
    height: 320px;
    width: 250px;
   background-color: white;
    border-radius: 10px;
    margin-left: 10px;
    margin-right: 10px;
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
</style>
<script>
export default{
props:{
  
}
}
</script>