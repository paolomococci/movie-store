<template>
  <section>
    <b-jumbotron>
      <template #header>in this web application</template>
      <hr class="my-4">
      <p v-text="msg"></p>
      <b-row>
        <b-col>
          <b-button
            size="xl"
            variant="outline-secondary"
            href="#/address"
            v-b-popover.hover.top="'click to view the list of registered companies'"
            title="companies">company</b-button>
        </b-col>
        <b-col>
          <b-button
            size="xl"
            variant="outline-secondary"
            href="#/category"
            v-b-popover.hover.top="'click to view the list of registered contests'"
            title="contests">contest</b-button>
        </b-col>
        <b-col>
          <b-button
            size="xl"
            variant="outline-secondary"
            href="#/city"
            v-b-popover.hover.top="'click to view the list of registered employees'"
            title="employees">employee</b-button>
        </b-col>
      </b-row>
    </b-jumbotron>
  </section>
</template>

<script>

export default {
  name: 'HomeComponent',
  props: {
    msg: String
  }
}
</script>
