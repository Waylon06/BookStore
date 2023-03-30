import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

import "swiper/css/swiper.min.css"
import '@/assets/css/init.css'
import { Container, Main, Header, Menu, MenuItem, Submenu,Row, Collapse, Col, CollapseItem, Table, TableColumn, Button, Checkbox } from 'element-ui'

Vue.use(Container)
Vue.use(Header)
Vue.use(Main)
Vue.use(Menu)
Vue.use(MenuItem)
Vue.use(Submenu)
Vue.use(Row)
Vue.use(Col)
Vue.use(Collapse)
Vue.use(CollapseItem)
Vue.use(Table)
Vue.use(TableColumn)
Vue.use(Button)
Vue.use(Checkbox)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  el: '#app',
  render: h => h(App)
})
