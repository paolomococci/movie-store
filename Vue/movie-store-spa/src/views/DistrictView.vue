<template>
  <main>
    <welcome msg="district view"/>
    <district-view-component/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'
import ViewComponent from '@/components/district/ViewComponent.vue'

export default {
  name: 'DistrictView',
  components: {
    welcome: WelcomeComponent,
    'district-view-component': ViewComponent
  }
}
</script>
