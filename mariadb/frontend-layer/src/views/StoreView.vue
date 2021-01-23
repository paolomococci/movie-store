<template>
  <main>
    <welcome msg="store view"/>
    <store-view-component/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'
import ViewComponent from '@/components/store/ViewComponent.vue'

export default {
  name: 'StoreView',
  components: {
    welcome: WelcomeComponent,
    'store-view-component': ViewComponent
  }
}
</script>
