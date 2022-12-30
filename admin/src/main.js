// import { createApp } from 'vue'
// import App from './App.vue'
//
// createApp(App).mount('#app')此方法针对vue3.0
import Vue from 'vue'
import router from './router'
import App from './app'
import axios from 'axios'


Vue.config.productionTip = false;
Vue.prototype.$ajax = axios;

/**
 * axios拦截器
 */
axios.interceptors.request.use(function (config) {
    console.log("请求:",config)
    return config;
},error => {});
axios.interceptors.response.use(function (response) {
    console.log("返回结果:",response);
    return response;

},error => {})

new Vue ({
    router,
    render: h=>h(App),
}).$mount("#app");

console.log("环境:",process.env.NODE_ENV);

