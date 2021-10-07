<template>
  <main>
    <welcome msg="language view"/>
    <language-view-component/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'
import ViewComponent from '@/components/language/ViewComponent.vue'

export default {
  name: 'LanguageView',
  components: {
    welcome: WelcomeComponent,
    'language-view-component': ViewComponent
  }
}
</script>
