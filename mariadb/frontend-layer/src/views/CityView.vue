<template>
  <main>
    <welcome msg="city view"/>
    <city-view-component/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'
import ViewComponent from '@/components/city/ViewComponent.vue'

export default {
  name: 'CityView',
  components: {
    welcome: WelcomeComponent,
    'city-view-component': ViewComponent
  }
}
</script>
