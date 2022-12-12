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
    <form class="login-container" label-position="left">
      <h4>
        登录
      </h4>
      <div class="mb-3">
        <input type="text" class="form-control" id="InputUsername1" v-model="LoginForm.username" placeholder="用户名">
      </div>
      <div class="mb-3">
        <input type="password" class="form-control" id="InputPassword1" v-model="LoginForm.password" placeholder="密码">
      </div>
      <div>
        <a href="#/reset" class="link-secondary" style="float: left">忘记密码</a>
        <a href="#/register" class="link-secondary" style="float: right">注册</a>
      </div>
      <button type="submit" class="btn btn-primary" id="LoginSubmit" style="width: 100%;background: #505458;border: none">Login</button>
    </form>
  </body>
</template>

<script>


export default {
  name: 'LoginPage',
  data(){
    return{
      LoginForm:{
        username:'',
        password:''
      }
    }
  },
  methods:{

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
.login-container{
  border-radius: 15px;
  background-clip: padding-box;
  margin: 150px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
#LoginSubmit{
  margin-top: 15px;
}
a:hover{
  color: red;
}
.particles-js{
  width: 100%;
  height: 100%; /**宽高100%是为了图片铺满屏幕 */
  z-index: -1;
  position: absolute;
}
</style>
