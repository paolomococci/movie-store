<template>
  <section>
    <aside>
      <!-- todo aside to show add button -->
    </aside>
    <!-- todo sub-section to show the table list -->
  </section>
</template>

<script>
import PaymentRestfulApiService from '../../services/PaymentRestfulApiService'

export default {
  name: 'ViewComponent',
  props: {
    msg: String
  },
  data: () => ({
    payments: []
    // TODO
  }),
  methods: {
    async updateView() {
      this.$bvToast.toast('data of payments being updated', {
        title: 'update view',
        toaster: 'b-toaster-bottom-center',
        variant: 'info',
        solid: true,
        appendToast: true,
        autoHideDelay: 1000
      });
      await setTimeout(() => {
          this.payments = null;
          this.retrievePayments();
        }, 1000);
    },
    retrievePayments() {
      PaymentRestfulApiService.readAll()
        .then(response => {
          this.payments = response.data._embedded.payments;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    deleteItem(uri) {
      PaymentRestfulApiService.delete(uri)
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
