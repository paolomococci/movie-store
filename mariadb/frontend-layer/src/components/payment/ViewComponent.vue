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
    // TODO
  }),
  methods: {
    retrievePayments() {
      PaymentRestfulApiService.readAll()
        .then(response => {
          this.payments = response.data._embedded.payments;
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
