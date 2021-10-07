<template>
  <main>
    <about-component msg="In this demo you have the possibility to modify the data by calling a RESTful API through a convenient graphical interface."/>
  </main>
</template>

<script>
import AboutComponent from '@/components/AboutComponent.vue'

export default {
  name: 'AboutView',
  components: {
    'about-component': AboutComponent
  }
}
</script>
