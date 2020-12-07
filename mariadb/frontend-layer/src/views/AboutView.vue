<template>
  <div>
    <welcome msg="about view"/>
  </div>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'

export default {
  name: 'AboutView',
  components: {
    welcome: WelcomeComponent
  }
}
</script>
