<template>
  <div>
    <welcome msg="movie view"/>
  </div>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'

export default {
  name: 'MovieView',
  components: {
    welcome: WelcomeComponent
  }
}
</script>
