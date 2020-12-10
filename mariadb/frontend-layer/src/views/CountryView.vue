<template>
  <div>
    <welcome msg="country view"/>
  </div>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'

export default {
  name: 'CountryView',
  components: {
    welcome: WelcomeComponent
  }
}
</script>
