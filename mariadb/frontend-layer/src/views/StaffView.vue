<template>
  <div>
    <welcome msg="staff view"/>
  </div>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'

export default {
  name: 'StaffView',
  components: {
    welcome: WelcomeComponent
  }
}
</script>
