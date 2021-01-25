<template>
  <section>
    <aside>
      <!-- todo aside to show add button -->
    </aside>
    <!-- todo sub-section to show the table list -->
  </section>
</template>

<script>
import CountryRestfulApiService from '../../services/CountryRestfulApiService'

export default {
  name: 'ViewComponent',
  props: {
    msg: String
  },
  data: () => ({
    countries: []
    // TODO
  }),
  methods: {
    async updateView() {
      this.$bvToast.toast('data of countries being updated', {
        title: 'update view',
        toaster: 'b-toaster-bottom-center',
        variant: 'info',
        solid: true,
        appendToast: true,
        autoHideDelay: 1000
      });
      await setTimeout(() => {
          this.countries = null;
          this.retrieveCountries();
        }, 1000);
    },
    retrieveCountries() {
      CountryRestfulApiService.readAll()
        .then(response => {
          this.countries = response.data._embedded.countries;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    deleteItem(uri) {
      CountryRestfulApiService.delete(uri)
        .catch(e => {
          console.log(e);
        });
      this.updateView();
    }
    // TODO
  },
  computed: {
    // TODO
  },
  mounted() {
    // TODO
  }
}
</script>
