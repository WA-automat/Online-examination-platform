<template>
  <body id="poster">
  <vue-particles
      class="particles-js"
      color="#39AFFD"
      :particleOpacity="0.7"
      :particlesNumber="150"
      shapeType="circle"
      :particleSize="4"
      linesColor="#8DD1FE"
      :linesWidth="1"
      :lineLinked="true"
      :lineOpacity="0.4"
      :linesDistance="150"
      :moveSpeed="4"
      :hoverEffect="true"
      hoverMode="grab"
      :clickEffect="true"
      clickMode="push"
  >
  </vue-particles>
  <form class="reset-container" label-position="left">
    <h4>
      重置密码
    </h4>
    <div class="mb-3">
      <input type="password" class="form-control" id="InputPassword3" v-model="ResetFrom.password1" placeholder="新密码">
    </div>
    <div class="mb-3">
      <input type="password" class="form-control" id="CheckPassword3" v-model="ResetFrom.password2" placeholder="确认密码">
    </div>
    <div class="mb-3">
      <input type="text" class="form-control" id="InputEmail2" v-model="ResetFrom.email" placeholder="邮箱">
    </div>
    <div class="mb-3">
      <input type="text" class="form-control" id="CheckNumber2" v-model="ResetFrom.CheckNumber"  placeholder="请输入验证码">
      <button type="button" class="btn btn-secondary" id="SendCheckNum2">发送验证码</button>
    </div>
    <button type="submit" class="btn btn-primary" style="width: 100%;background: #505458;border: none" id="ResetSubmit">Submit</button>
  </form>
  </body>
</template>

<script>

export default {
  name: 'ResetPage',
  data(){
    return{
      ResetFrom:{
        password1:'',
        password2:'',
        email:'',
        CheckNumber:'',
      }
    }
  },
  components: {

  }
}
</script>

<style>
#poster{
  background-position: center;
  height:100%;
  width:100%;
  background-size: cover;
  position: fixed;
}
body{
  margin: 0px;
  padding: 0px;
}
.reset-container{
  border-radius: 15px;
  background-clip: padding-box;
  margin: 150px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
#CheckNumber2{
  float: left;
  width: 180px;
}
#SendCheckNum2{
  font-size: smaller;
  width: auto;
  height: 38px;
  float: right;
}
#ResetSubmit{
  margin-top: 15px;
}
.particles-js{
  width: 100%;
  height: 100%; /**宽高100%是为了图片铺满屏幕 */
  z-index: -1;
  position: absolute;
}
</style>
