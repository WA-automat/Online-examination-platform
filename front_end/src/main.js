import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import bootstrap from 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';
import VueParticles from 'vue-particles'

createApp(App).use(store).use(router).use(bootstrap).use(VueParticles).mount('#app')
