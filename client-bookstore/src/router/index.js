import Vue from 'vue'
import VueRouter from 'vue-router'
import Main from '../views/Main.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'main',
    component: Main,
    redirect: 'home',
    children:[
      {
        path: '/home',
        name: 'home',
        component: () => import("@/views/HomeView")
      },
      {
      path: '/cart',
      name: 'cart',
      component: () => import("@/components/CartTableComponent")
    },
    {
      path: '/notice',
      name: 'notice',
      component: () => import("@/views/NoticeView")
    },
    {
      path: '/order',
      name: 'order',
      component: () => import("@/components/OrderComponent")
    }
  ]
  },
  {
    path: '/login',
    name: 'login',
    component: () => import("@/views/LoginView")
  },
  
  // {
  //   path: '/about',
  //   name: 'about',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  // }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
