<template>
  <main>
    <welcome msg="content view"/>
    <content-view-component/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'
import ViewComponent from '@/components/content/ViewComponent.vue'

export default {
  name: 'ContentView',
  components: {
    welcome: WelcomeComponent,
    'content-view-component': ViewComponent
  }
}
</script>
