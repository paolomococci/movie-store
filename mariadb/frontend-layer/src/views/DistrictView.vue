<template>
  <main>
    <welcome msg="customer view"/>
    <customer-view-component/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'
import ViewComponent from '@/components/customer/ViewComponent.vue'

export default {
  name: 'CustomerView',
  components: {
    welcome: WelcomeComponent,
    'customer-view-component': ViewComponent
  }
}
</script>
