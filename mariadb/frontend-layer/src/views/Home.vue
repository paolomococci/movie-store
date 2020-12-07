<template>
  <div>
    <hello msg="home view"/>
  </div>
</template>

<script>
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  components: {
    hello: HelloWorld
  }
}
</script>
