<template>
  <section>
    <aside>
      <!-- todo aside to show add button -->
    </aside>
    <!-- todo sub-section to show the table list -->
  </section>
</template>

<script>
import CityRestfulApiService from '../../services/CityRestfulApiService'

export default {
  name: 'ViewComponent',
  props: {
    msg: String
  },
  data: () => ({
    cities: []
    // TODO
  }),
  methods: {
    async updateView() {
      this.$bvToast.toast('data of cities being updated', {
        title: 'update view',
        toaster: 'b-toaster-bottom-center',
        variant: 'info',
        solid: true,
        appendToast: true,
        autoHideDelay: 1000
      });
      await setTimeout(() => {
          this.cities = null;
          this.retrieveCities();
        }, 1000);
    },
    retrieveCities() {
      CityRestfulApiService.readAll()
        .then(response => {
          this.cities = response.data._embedded.cities;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    deleteItem(uri) {
      CityRestfulApiService.delete(uri)
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
