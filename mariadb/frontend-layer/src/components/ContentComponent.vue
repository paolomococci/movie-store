<template>
  <div>
    <h1 v-text="msg"></h1>
  </div>
</template>

<script>
export default {
  name: 'ContentComponent',
  props: {
    msg: String
  }
}
</script>
