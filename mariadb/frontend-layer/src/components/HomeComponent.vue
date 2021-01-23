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
            v-b-popover.hover.top="'click to view the list of registered addresses'"
            title="addresses">addresses</b-button>
        </b-col>
        <b-col>
          <b-button
            size="xl"
            variant="outline-secondary"
            href="#/category"
            v-b-popover.hover.top="'click to view the list of registered categories'"
            title="categories">categories</b-button>
        </b-col>
        <b-col>
          <b-button
            size="xl"
            variant="outline-secondary"
            href="#/city"
            v-b-popover.hover.top="'click to view the list of registered cities'"
            title="cities">cities</b-button>
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
