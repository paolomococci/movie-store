<template>
  <section>
    <b-table>
      <template>
        <b-form-checkbox>
          city details
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
              <!-- city editor component -->
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
import CityRestfulApiService from '../../services/CityRestfulApiService'

export default {
  name: 'TableComponent',
  data: () => ({
    cities: [],
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
      this.$bvToast.toast('data of cities being updated', {
        title: 'update view',
        toaster: 'b-toaster-bottom-center',
        variant: 'info',
        solid: true,
        appendToast: true,
        autoHideDelay: 1000
      });
      await setTimeout(() => {
          this.cities = null;
          this.retrieveCities();
        }, 1000);
    },
    retrieveCities() {
      CityRestfulApiService.readAll()
        .then(response => {
          this.cities = response.data._embedded.cities;
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
      CityRestfulApiService.delete(uri)
        .catch(e => {
          console.log(e);
        });
      this.updateView();
    }
  },
  mounted() {
    // TODO
  }
}
</script>
