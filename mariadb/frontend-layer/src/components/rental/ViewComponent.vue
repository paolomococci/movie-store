<template>
  <section>
    <aside>
      <!-- todo aside to show add button -->
    </aside>
    <!-- todo sub-section to show the table list -->
  </section>
</template>

<script>
import RentalRestfulApiService from '../../services/RentalRestfulApiService'

export default {
  name: 'ViewComponent',
  props: {
    msg: String
  },
  data: () => ({
    rentals: []
    // TODO
  }),
  methods: {
    async updateView() {
      this.$bvToast.toast('data of rentals being updated', {
        title: 'update view',
        toaster: 'b-toaster-bottom-center',
        variant: 'info',
        solid: true,
        appendToast: true,
        autoHideDelay: 1000
      });
      await setTimeout(() => {
          this.rentals = null;
          this.retrieveRentals();
        }, 1000);
    },
    retrieveRentals() {
      RentalRestfulApiService.readAll()
        .then(response => {
          this.rentals = response.data._embedded.rentals;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    deleteItem(uri) {
      RentalRestfulApiService.delete(uri)
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
