<template>
  <main>
    <welcome msg="player view"/>
    <player-view-component/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'
import ViewComponent from '@/components/player/ViewComponent.vue'

export default {
  name: 'PlayerView',
  components: {
    welcome: WelcomeComponent,
    'player-view-component': ViewComponent
  }
}
</script>
