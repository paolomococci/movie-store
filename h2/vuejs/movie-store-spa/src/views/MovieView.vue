<template>
  <main>
    <welcome msg="movie view"/>
    <movie-view-component/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'
import ViewComponent from '@/components/movie/ViewComponent.vue'

export default {
  name: 'MovieView',
  components: {
    welcome: WelcomeComponent,
    'movie-view-component': ViewComponent
  }
}
</script>
