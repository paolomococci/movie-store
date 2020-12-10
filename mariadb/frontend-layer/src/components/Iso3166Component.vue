<template>
  <div>
    <h1><span v-text="msg"></span></h1>
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
