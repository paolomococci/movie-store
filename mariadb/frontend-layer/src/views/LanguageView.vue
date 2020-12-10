<template>
  <div>
    <welcome msg="language view"/>
  </div>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'

export default {
  name: 'LanguageView',
  components: {
    welcome: WelcomeComponent
  }
}
</script>
