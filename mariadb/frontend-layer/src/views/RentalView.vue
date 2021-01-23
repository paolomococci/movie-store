<template>
  <main>
    <welcome msg="rental view"/>
    <rental-view-component/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'
import ViewComponent from '@/components/rental/ViewComponent.vue'

export default {
  name: 'RentalView',
  components: {
    welcome: WelcomeComponent,
    'rental-view-component': ViewComponent
  }
}
</script>
