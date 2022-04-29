import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import '../src/config/axiosConfig'


createApp(App).use(router).mount('#app')

// window.onbeforeunload = function() {
//     localStorage.clear();
// };