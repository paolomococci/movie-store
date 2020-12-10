<template>
  <div>
    <welcome msg="customer view"/>
  </div>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'

export default {
  name: 'CustomerView',
  components: {
    welcome: WelcomeComponent
  }
}
</script>
