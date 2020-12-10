<template>
  <div>
    <h1 v-text="msg"></h1>
  </div>
</template>

<script>
export default {
  name: 'Iso3166Component',
  props: {
    msg: String
  }
}
</script>
