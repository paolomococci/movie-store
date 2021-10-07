<template>
  <main>
    <welcome msg="category view"/>
    <category-view-component/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'
import ViewComponent from '@/components/category/ViewComponent.vue'

export default {
  name: 'CategoryView',
  components: {
    welcome: WelcomeComponent,
    'category-view-component': ViewComponent
  }
}
</script>
