<template>
  <main>
    <welcome msg="iso3166 view"/>
    <iso3166-view-component/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'
import ViewComponent from '@/components/iso3166/ViewComponent.vue'

export default {
  name: 'Iso3166View',
  components: {
    welcome: WelcomeComponent,
    'iso3166-view-component': ViewComponent
  }
}
</script>
