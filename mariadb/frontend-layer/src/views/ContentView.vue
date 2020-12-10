<template>
  <div>
    <welcome msg="content view"/>
  </div>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'

export default {
  name: 'ContentView',
  components: {
    welcome: WelcomeComponent
  }
}
</script>
