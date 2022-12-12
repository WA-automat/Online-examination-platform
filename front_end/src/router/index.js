import { createRouter, createWebHashHistory } from 'vue-router'
/*import HomeView from '../views/HomeView.vue'*/
import Login from '../views/Login.vue'
import Register from '../views/Register.vue'
import HomeView from '../views/HomeView'
import ResetPwd from "@/views/ResetPwd";

const routes = [
  {
    path: '/',
    name: 'Introduce',
    component: HomeView
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/register',
    name: 'Register',
    component: Register
  },
  {
    path: '/reset',
    name: 'Reset',
    component: ResetPwd
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
