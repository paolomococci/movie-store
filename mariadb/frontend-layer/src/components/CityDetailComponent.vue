<template>
  <div>
    <h1 v-text="msg"></h1>
  </div>
</template>

<script>
export default {
  name: 'CityDetailComponent',
  props: {
    msg: String
  }
}
</script>
