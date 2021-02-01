<template>
  <section>
    <b-table>
      <template>
        <b-form-checkbox>
          player details
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
              <!-- player editor component -->
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
import PlayerRestfulApiService from '../../services/PlayerRestfulApiService'

export default {
  name: 'TableComponent',
  data: () => ({
    players: [],
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
      this.$bvToast.toast('data of players being updated', {
        title: 'update view',
        toaster: 'b-toaster-bottom-center',
        variant: 'info',
        solid: true,
        appendToast: true,
        autoHideDelay: 1000
      });
      await setTimeout(() => {
        this.players = null;
        this.retrievePlayers();
      }, 1000);
  },
    retrievePlayers() {
      PlayerRestfulApiService.readAll()
        .then(response => {
          this.players = response.data._embedded.players;
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
      PlayerRestfulApiService.delete(uri)
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
