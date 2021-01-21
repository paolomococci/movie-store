import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'HomeView',
    component: HomeView
  },
  {
    path: '/about',
    name: 'AboutView',
    component: () => import('../views/AboutView.vue')
  },
  {
    path: '/address',
    name: 'AddressView',
    component: () => import('../views/AddressView.vue')
  },
  {
    path: '/category',
    name: 'CategoryView',
    component: () => import('../views/CategoryView.vue')
  },
  {
    path: '/city',
    name: 'CityView',
    component: () => import('../views/CityView.vue')
  },
  {
    path: '/content',
    name: 'ContentView',
    component: () => import('../views/ContentView.vue')
  },
  {
    path: '/country',
    name: 'CountryView',
    component: () => import('../views/CountryView.vue')
  },
  {
    path: '/customer',
    name: 'CustomerView',
    component: () => import('../views/CustomerView.vue')
  },
  {
    path: '/district',
    name: 'DistrictView',
    component: () => import('../views/DistrictView.vue')
  },
  {
    path: '/inventory',
    name: 'InventoryView',
    component: () => import('../views/InventoryView.vue')
  },
  {
    path: '/iso3166',
    name: 'Iso3166View',
    component: () => import('../views/Iso3166View.vue')
  },
  {
    path: '/language',
    name: 'LanguageView',
    component: () => import('../views/LanguageView.vue')
  },
  {
    path: '/movie',
    name: 'MovieView',
    component: () => import('../views/MovieView.vue')
  },
  {
    path: '/payment',
    name: 'PaymentView',
    component: () => import('../views/PaymentView.vue')
  },
  {
    path: '/player',
    name: 'PlayerView',
    component: () => import('../views/PlayerView.vue')
  },
  {
    path: '/rental',
    name: 'RentalView',
    component: () => import('../views/RentalView.vue')
  },
  {
    path: '/staff',
    name: 'StaffView',
    component: () => import('../views/StaffView.vue')
  },
  {
    path: '/store',
    name: 'StoreView',
    component: () => import('../views/StoreView.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
