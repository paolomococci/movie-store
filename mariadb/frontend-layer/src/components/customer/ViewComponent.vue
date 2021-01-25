<template>
  <section>
    <aside>
      <!-- todo aside to show add button -->
    </aside>
    <!-- todo sub-section to show the table list -->
  </section>
</template>

<script>
import CustomerRestfulApiService from '../../services/CustomerRestfulApiService'

export default {
  name: 'ViewComponent',
  props: {
    msg: String
  },
  data: () => ({
    customers: []
    // TODO
  }),
  methods: {
    async updateView() {
      this.$bvToast.toast('data of customers being updated', {
        title: 'update view',
        toaster: 'b-toaster-bottom-center',
        variant: 'info',
        solid: true,
        appendToast: true,
        autoHideDelay: 1000
      });
      await setTimeout(() => {
          this.customers = null;
          this.retrieveCustomers();
        }, 1000);
    },
    retrieveCustomers() {
      CustomerRestfulApiService.readAll()
        .then(response => {
          this.customers = response.data._embedded.customers;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
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
