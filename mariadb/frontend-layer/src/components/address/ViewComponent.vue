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
    addresses: [],
    fields: [
      {
        key: 'showDetails',
        label: 'details'
      }
    ]
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
    deleteItemConfirm(uri) {
      this.messageBoxToConfirmDeletion = '';
      this.$bvModal.msgBoxConfirm('are you sure you want to delete this item', {
        title: 'please confirm',
        size: 'md',
        buttonSize: 'md',
        okVariant: 'danger',
        okTitle: 'yes',
        cancelTitle: 'no',
        footerClass: 'p-2',
        hideHeaderClose: false,
        centered: true
      }).then(value => {
        if(value) {
          this.deleteItem(uri);
        }
      });
    },
    deleteItem(uri) {
      AddressRestfulApiService.delete(uri)
        .catch(e => {
          console.log(e);
        });
      this.updateView();
    }
  },
  computed: {
    // TODO
  },
  mounted() {
    // TODO
  }
}
</script>
