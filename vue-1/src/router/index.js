import { createRouter, createWebHistory } from 'vue-router'
import App from '../App.vue'
import house_detail from '../components/house_detail.vue'
import dialog from '../components/dialog.vue'
import user_detail from '../components/user_detail.vue'
import test from '../components/test.vue'
import select from '../components/select.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      component: App,
    },
 {
  path: '/house_detail',
  name: 'house_detail',
  component: house_detail
 },
 {
  path: '/dialog',
  name: 'dialog',
  component: dialog
 },
 {
  path: '/user_detail',
  name: 'user_detail',
  component: user_detail
 },{
  path:'/test',
  name:'test',
  component:test
 },
 {
  path:'/select',
  name:'select',
  component:select
 }
  ]
})

export default router
