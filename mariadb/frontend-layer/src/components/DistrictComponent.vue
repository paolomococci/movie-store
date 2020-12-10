<template>
  <div>
    <h1 v-text="msg"></h1>
  </div>
</template>

<script>
export default {
  name: 'DistrictComponent',
  props: {
    msg: String
  }
}
</script>
