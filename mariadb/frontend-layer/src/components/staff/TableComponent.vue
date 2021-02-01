<template>
  <section>
    <b-table>
      <template>
        <b-form-checkbox>
          team details
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
              <!-- staff editor component -->
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
import StaffRestfulApiService from '../../services/StaffRestfulApiService'

export default {
  name: 'TableComponent',
  data: () => ({
    teams: [],
    fields: [
      {
        key: 'surname',
        label: 'surnames',
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
      this.$bvToast.toast('data of teams being updated', {
        title: 'update view',
        toaster: 'b-toaster-bottom-center',
        variant: 'info',
        solid: true,
        appendToast: true,
        autoHideDelay: 1000
      });
      await setTimeout(() => {
          this.teams = null;
          this.retrieveTeams();
        }, 1000);
    },
    retrieveTeams() {
      StaffRestfulApiService.readAll()
        .then(response => {
          this.teams = response.data._embedded.teams;
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
      StaffRestfulApiService.delete(uri)
        .catch(e => {
          console.log(e);
        });
      this.updateView();
    }
  },
  mounted() {
    this.retrieveTeams();
  }
}
</script>
