import Vue from 'vue'
import App from './App.vue'
import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.use(VueAxios, axios)

Vue.config.productionTip = false

export const serverUrl = 'http://localhost:9000';

new Vue({
  render: h => h(App),
}).$mount('#app')
