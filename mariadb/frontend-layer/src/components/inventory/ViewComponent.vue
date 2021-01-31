<template>
  <section>
    <aside>
      <!-- todo aside to show add button -->
    </aside>
    <!-- todo sub-section to show the table list -->
    <inventory-table-component/>
  </section>
</template>

<script>
import InventoryRestfulApiService from '../../services/InventoryRestfulApiService'
import TableComponent from './TableComponent'

export default {
  name: 'ViewComponent',
  components: {
    'inventory-table-component': TableComponent
  },
  props: {
    msg: String
  },
  data: () => ({
    inventories: [],
    fields: [
      {
        key: 'updated',
        label: 'updated',
        sortable: true
      },
      {
        key: 'showDetails',
        label: 'details'
      }
    ]
  }),
  methods: {
    async updateView() {
      this.$bvToast.toast('data of inventories being updated', {
        title: 'update view',
        toaster: 'b-toaster-bottom-center',
        variant: 'info',
        solid: true,
        appendToast: true,
        autoHideDelay: 1000
      });
      await setTimeout(() => {
          this.inventories = null;
          this.retrieveInventories();
        }, 1000);
    },
    retrieveInventories() {
      InventoryRestfulApiService.readAll()
        .then(response => {
          this.inventories = response.data._embedded.inventories;
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
      InventoryRestfulApiService.delete(uri)
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
