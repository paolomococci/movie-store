<template>
  <main>
    <welcome msg="address view"/>
    <address-view-component/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'
import ViewComponent from '@/components/address/ViewComponent.vue'

export default {
  name: 'AddressView',
  components: {
    welcome: WelcomeComponent,
    'address-view-component': ViewComponent
  }
}
</script>
