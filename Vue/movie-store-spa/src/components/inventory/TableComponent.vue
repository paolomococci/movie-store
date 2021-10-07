<template>
  <section>
    <b-table :items="inventories" :fields="fields" striped responsive="sm">
      <template #cell(showDetails)="row">
        <b-form-checkbox v-model="row.detailsShowing" @change="row.toggleDetails">
          inventory details
        </b-form-checkbox>
      </template>
      <template #row-details="row">
        <b-card>
          <b-row class="mb-2">
            <b-col sm="3" class="text-sm-right"><em>URI:</em></b-col>
            <b-col><output v-text="row.item._links.self.href"></output></b-col>
          </b-row>
          <b-row>
            <b-button-group>
              <!-- inventory editor component -->
              <!-- view references component -->
              <b-dropdown>
                <b-dropdown-item @click="row.toggleDetails">toggle</b-dropdown-item>
                <b-dropdown-divider/>
                <b-dropdown-item @click="deleteItemConfirm(row.item._links.self.href)">
                  delete item
                </b-dropdown-item>
              </b-dropdown>
            </b-button-group>
          </b-row>
        </b-card>
      </template>
    </b-table>
  </section>
</template>

<script>
import InventoryRestfulApiService from '../../services/InventoryRestfulApiService'

export default {
  name: 'TableComponent',
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
  mounted() {
    this.retrieveInventories();
  }
}
</script>
