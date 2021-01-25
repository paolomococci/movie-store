<template>
  <section>
    <aside>
      <!-- todo aside to show add button -->
    </aside>
    <!-- todo sub-section to show the table list -->
  </section>
</template>

<script>
import InventoryRestfulApiService from '../../services/InventoryRestfulApiService'

export default {
  name: 'ViewComponent',
  props: {
    msg: String
  },
  data: () => ({
    inventories: []
    // TODO
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
