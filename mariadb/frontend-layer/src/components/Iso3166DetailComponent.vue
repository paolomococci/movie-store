<template>
  <div>
    <h1 v-text="msg"></h1>
  </div>
</template>

<script>
export default {
  name: 'Iso3166DetailComponent',
  props: {
    msg: String
  }
}
</script>
