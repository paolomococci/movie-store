<template>
  <div>
    <welcome msg="city view"/>
  </div>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'

export default {
  name: 'CityView',
  components: {
    welcome: WelcomeComponent
  }
}
</script>
