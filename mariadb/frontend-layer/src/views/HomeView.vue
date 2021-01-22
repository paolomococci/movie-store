<template>
  <main>
    <home-component msg="you can view and edit this type of entities:"/>
  </main>
</template>

<script>
import HomeComponent from '@/components/HomeComponent.vue'

export default {
  name: 'HomeView',
  components: {
    'home-component': HomeComponent
  }
}
</script>
