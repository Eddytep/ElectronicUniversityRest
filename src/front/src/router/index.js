import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import UsersView from "@/views/UsersView";
import UserProfileView from "@/views/UserProfileView";
// import PageNotFoundView from "@/views/PageNotFoundView";

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/users',
    name: 'users',
    component: UsersView,
  },
  {
    path: '/users/:id',
    name: 'userProfile',
    component: UserProfileView,
  },
  {
    path: '/*',
    // path: "/:catchAll(.*)",
    name: "NotFound",
    component: HomeView,
    meta: {
      requiresAuth: false
    }
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
