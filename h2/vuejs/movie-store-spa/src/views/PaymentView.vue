<template>
  <main>
    <welcome msg="payment view"/>
    <payment-view-component/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'
import ViewComponent from '@/components/payment/ViewComponent.vue'

export default {
  name: 'PaymentView',
  components: {
    welcome: WelcomeComponent,
    'payment-view-component': ViewComponent
  }
}
</script>
