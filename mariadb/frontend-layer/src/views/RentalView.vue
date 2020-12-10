<template>
  <div>
    <welcome msg="rental view"/>
  </div>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'

export default {
  name: 'RentalView',
  components: {
    welcome: WelcomeComponent
  }
}
</script>
