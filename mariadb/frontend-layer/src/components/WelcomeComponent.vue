<template>
  <section>
    <b-jumbotron>
      <template #header><span v-text="msg"></span></template>
      <hr class="my-4">
    </b-jumbotron>
  </section>
</template>

<script>
export default {
  name: 'WelcomeComponent',
  props: {
    msg: String
  }
}
</script>
