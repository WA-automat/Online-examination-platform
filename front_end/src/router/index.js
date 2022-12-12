import { createRouter, createWebHashHistory } from 'vue-router'
/*import HomeView from '../views/HomeView.vue'*/
import Login from '../views/Login.vue'
import Register from '../views/Register.vue'
import AboutView from '../views/AboutView'

const routes = [
  {
    path: '/',
    name: 'Introduce',
    component: AboutView
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
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
