<template>
  <section>
    <b-jumbotron>
      <template #header>web application for manage the data of some entities</template>
      <template #lead><span v-text="msg"></span></template>
      <hr class="my-4">
    </b-jumbotron>
  </section>
</template>

<script>

export default {
  name: 'AboutComponent',
  props: {
    msg: String
  }
}
</script>
