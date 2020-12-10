<template>
  <div>
    <welcome msg="inventory view"/>
  </div>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'

export default {
  name: 'InventoryView',
  components: {
    welcome: WelcomeComponent
  }
}
</script>
