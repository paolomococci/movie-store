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
    // TODO
  }),
  methods: {
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
