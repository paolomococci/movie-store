<template>
  <div>
    <h1><span v-text="msg"></span></h1>
  </div>
</template>

<script>
export default {
  name: 'CustomerComponent',
  props: {
    msg: String
  }
}
</script>
