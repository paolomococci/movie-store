<template>
  <main>
    <welcome msg="inventory view"/>
    <inventory-view-component/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'
import ViewComponent from '@/components/inventory/ViewComponent.vue'

export default {
  name: 'InventoryView',
  components: {
    welcome: WelcomeComponent,
    'inventory-view-component': ViewComponent
  }
}
</script>
