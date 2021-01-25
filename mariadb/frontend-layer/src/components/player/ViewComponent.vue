<template>
  <section>
    <aside>
      <!-- todo aside to show add button -->
    </aside>
    <!-- todo sub-section to show the table list -->
  </section>
</template>

<script>
import PlayerRestfulApiService from '../../services/PlayerRestfulApiService'

export default {
  name: 'ViewComponent',
  props: {
    msg: String
  },
  data: () => ({
    players: []
    // TODO
  }),
  methods: {
    retrievePlayers() {
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
      PlayerRestfulApiService.readAll()
        .then(response => {
          this.players = response.data._embedded.players;
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
