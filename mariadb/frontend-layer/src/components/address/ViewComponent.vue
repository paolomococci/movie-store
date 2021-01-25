<template>
  <section>
    <aside>
      <!-- todo aside to show add button -->
    </aside>
    <!-- todo sub-section to show the table list -->
  </section>
</template>

<script>
import AddressRestfulApiService from '../../services/AddressRestfulApiService'

export default {
  name: 'ViewComponent',
  props: {
    msg: String
  },
  data: () => ({
    addresses: []
    // TODO
  }),
  methods: {
    async updateView() {
      this.$bvToast.toast('data of addresses being updated', {
        title: 'update view',
        toaster: 'b-toaster-bottom-center',
        variant: 'info',
        solid: true,
        appendToast: true,
        autoHideDelay: 1000
      });
      await setTimeout(() => {
          this.addresses = null;
          this.retrieveAddresses();
        }, 1000);
    },
    retrieveAddresses() {
      AddressRestfulApiService.readAll()
        .then(response => {
          this.addresses = response.data._embedded.addresses;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    deleteItem(uri) {
      AddressRestfulApiService.delete(uri)
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
