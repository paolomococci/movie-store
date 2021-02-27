<template>
  <main>
    <welcome msg="country view"/>
    <country-view-component/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'
import ViewComponent from '@/components/country/ViewComponent.vue'

export default {
  name: 'CountryView',
  components: {
    welcome: WelcomeComponent,
    'country-view-component': ViewComponent
  }
}
</script>
