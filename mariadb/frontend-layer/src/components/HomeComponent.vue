<template>
  <section>
    <b-jumbotron>
      <template #header>in this web application</template>
      <hr class="my-4">
      <h3 v-text="msg"></h3>
      <b-table
        id="data-grid"
        :items="items"
        :per-page="pages"
        :current-page="current">
      </b-table>
      <hr class="my-3">
      <b-pagination
        v-model="current"
        pills
        :total-rows="rows"
        :per-page="pages"
        aria-controls="data-grid"
        first-text="first"
        prev-text="prev"
        next-text="next"
        last-text="last"
        size="lg">
      </b-pagination>
    </b-jumbotron>
  </section>
</template>

<script>

export default {
  name: 'HomeComponent',
  props: {
    msg: String
  },
  data: () => ({
    pages: 4,
    current: 1,
    items: [
      {entities: "address"},
      {entities: "category"},
      {entities: "city"},
      {entities: "content"},
      {entities: "country"},
      {entities: "customer"},
      {entities: "district"},
      {entities: "inventory"},
      {entities: "iso3166"},
      {entities: "language"},
      {entities: "movie"},
      {entities: "payment"},
      {entities: "player"},
      {entities: "rental"},
      {entities: "staff"},
      {entities: "store"}
    ]
  }),
  computed: {
    rows() {
      return this.items.length;
    }
  }
}
</script>
