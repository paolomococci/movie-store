<template>
  <section>
    <b-table :items="countryCodes" :fields="fields" striped resposive="sm">
      <template #cell(showDetails)="row">
        <b-form-checkbox v-model="row.detailsShowing" @change="row.toggleDetails">
          country code details
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
              <!-- iso3166 editor component -->
              <!-- view references component -->
              <b-dropdown>
                <b-dropdown-item @click="row.toggleDetails">toggle</b-dropdown-item>
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
import Iso3166RestfulApiService from '../../services/Iso3166RestfulApiService'

export default {
  name: 'TableComponent',
  data: () => ({
    countryCodes: [],
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
      this.$bvToast.toast('data of country codes being updated', {
        title: 'update view',
        toaster: 'b-toaster-bottom-center',
        variant: 'info',
        solid: true,
        appendToast: true,
        autoHideDelay: 1000
      });
      await setTimeout(() => {
          this.countryCodes = null;
          this.retrieveCountryCodes();
        }, 1000);
    },
    retrieveCountryCodes() {
      Iso3166RestfulApiService.readAll()
        .then(response => {
          this.countryCodes = response.data._embedded.iso3166s;
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
      Iso3166RestfulApiService.delete(uri)
        .catch(e => {
          console.log(e);
        });
      this.updateView();
    }
  },
  mounted() {
    this.retrieveCountryCodes();
  }
}
</script>
