<template>
  <section>
    <b-jumbotron>
      <template #header>in Movie Store web application</template>
      <hr class="my-4">
      <h3 v-text="msg"></h3>
      <b-table
        id="data-grid"
        :items="items"
        :per-page="pages"
        :current-page="current"
        selectable
        @row-selected="onRowSelected">
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
      {entities: "address", description: "the addresses to which customers have registered"},
      {entities: "category", description: "the possible categories of films taken into consideration"},
      {entities: "city", description: "the cities in which our service is present"},
      {entities: "content", description: "type of content suitable for a certain audience"},
      {entities: "country", description: "region or state where our service is present"},
      {entities: "customer", description: "data relating to our customers"},
      {entities: "district", description: "district where our service is present"},
      {entities: "inventory", description: "list of available titles"},
      {entities: "iso3166", description: "ISO codes of countries"},
      {entities: "language", description: "languages ​​available for a certain title"},
      {entities: "movie", description: "complete list of all movies"},
      {entities: "payment", description: "payment registration"},
      {entities: "player", description: "data of those who worked in various capacities on the movie"},
      {entities: "rental", description: "rental history"},
      {entities: "staff", description: "currently active and non-active personnel"},
      {entities: "store", description: "list of all associated stores"}
    ]
  }),
  computed: {
    rows() {
      return this.items.length;
    }
  },
  methods: {
    onRowSelected(item) {
      this.$router.push(item[0].entities);
    }
  }
}
</script>
