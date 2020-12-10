<template>
  <div>
    <h1 v-text="msg"></h1>
  </div>
</template>

<script>
export default {
  name: 'InventoryComponent',
  props: {
    msg: String
  }
}
</script>
