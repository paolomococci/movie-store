<template>
  <div id="app">
    <div id="nav">
      <header-component/>
    </div>
    <router-view/>
  </div>
</template>

<script>
import HeaderComponent from '@/components/HeaderComponent'

export default {
  components: {
    'header-component': HeaderComponent
  }
}
</script>
