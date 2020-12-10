<template>
  <div>
    <h1 v-text="msg"></h1>
  </div>
</template>

<script>
export default {
  name: 'AddressComponent',
  props: {
    msg: String
  }
}
</script>
