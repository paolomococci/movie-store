<template>
  <div>
    <welcome msg="player view"/>
  </div>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'

export default {
  name: 'PlayerView',
  components: {
    welcome: WelcomeComponent
  }
}
</script>
