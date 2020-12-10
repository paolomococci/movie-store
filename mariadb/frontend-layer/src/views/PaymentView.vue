<template>
  <div>
    <welcome msg="payment view"/>
  </div>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'

export default {
  name: 'PaymentView',
  components: {
    welcome: WelcomeComponent
  }
}
</script>
