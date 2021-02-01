<template>
  <section>
    <b-table>
      <template>
        <b-form-checkbox>
          category details
        </b-form-checkbox>
      </template>
      <template>
        <b-card>
          <b-row>
            <b-col></b-col>
            <b-col></b-col>
          </b-row>
          <b-row>
            <b-button-group>
              <!-- category editor component -->
              <!-- view references component -->
              <b-dropdown>
                <b-dropdown-item></b-dropdown-item>
                <b-dropdown-divider/>
                <b-dropdown-item></b-dropdown-item>
              </b-dropdown>
            </b-button-group>
          </b-row>
        </b-card>
      </template>
    </b-table>
  </section>
</template>

<script>
import CategoryRestfulApiService from '../../services/CategoryRestfulApiService'

export default {
  name: 'TableComponent',
  data: () => ({
    categories: [],
    fields: [
      {
        key: 'name',
        label: 'names',
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
      this.$bvToast.toast('data of categories being updated', {
        title: 'update view',
        toaster: 'b-toaster-bottom-center',
        variant: 'info',
        solid: true,
        appendToast: true,
        autoHideDelay: 1000
      });
      await setTimeout(() => {
          this.categories = null;
          this.retrieveCategories();
        }, 1000);
    },
    retrieveCategories() {
      CategoryRestfulApiService.readAll()
        .then(response => {
          this.categories = response.data._embedded.categories;
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
      CategoryRestfulApiService.delete(uri)
        .catch(e => {
          console.log(e);
        });
      this.updateView();
    }
  },
  mounted() {
    this.retrieveCategories();
  }
}
</script>
