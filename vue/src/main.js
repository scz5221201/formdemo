import Vue from 'vue'
import App from './App.vue'
import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import router from "@/router";
import FormMaking from 'form-making'
import 'form-making/dist/FormMaking.css'
import {postRequest} from "./utils/api";
import {getRequest} from "./utils/api";
import {putRequest} from "./utils/api";
import {deleteRequest} from "./utils/api";



Vue.config.productionTip = false
Vue.use(Element)
Vue.use(FormMaking)

Vue.prototype.postRequest = postRequest
Vue.prototype.getRequest = getRequest
Vue.prototype.putRequest = putRequest
Vue.prototype.deleteRequest = deleteRequest


new Vue({
    render: h => h(App),
    router
}).$mount('#app')
