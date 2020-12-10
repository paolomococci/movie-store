<template>
  <div>
    <h1 v-text="msg"></h1>
  </div>
</template>

<script>
export default {
  name: 'InventoryDetailComponent',
  props: {
    msg: String
  }
}
</script>
