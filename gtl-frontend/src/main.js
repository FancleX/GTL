import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import '../src/config/axiosConfig'
// import './Listener'


createApp(App).use(router).mount('#app')

// window.onbeforeunload = function() {
//     localStorage.clear();
// };
// window.addEventListener('storage',function(e){
//     if(e.storageArea===sessionStorage){
//         console.log(1)
//     }
// });

// window.onstorage = function(e) {
//     console.log('The ' + e.key + ' key has been changed from ' + e.oldValue + ' to ' + e.newValue + '.');
//   };
