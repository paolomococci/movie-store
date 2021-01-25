<template>
  <section>
    <aside>
      <!-- todo aside to show add button -->
    </aside>
    <!-- todo sub-section to show the table list -->
  </section>
</template>

<script>
import DistrictRestfulApiService from '../../services/DistrictRestfulApiService'

export default {
  name: 'ViewComponent',
  props: {
    msg: String
  },
  data: () => ({
    districts: []
    // TODO
  }),
  methods: {
    async updateView() {
      this.$bvToast.toast('data of districts being updated', {
        title: 'update view',
        toaster: 'b-toaster-bottom-center',
        variant: 'info',
        solid: true,
        appendToast: true,
        autoHideDelay: 1000
      });
      await setTimeout(() => {
          this.districts = null;
          this.retrieveDistricts();
        }, 1000);
    },
    retrieveDistricts() {
      DistrictRestfulApiService.readAll()
        .then(response => {
          this.districts = response.data._embedded.districts;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    deleteItem(uri) {
      DistrictRestfulApiService.delete(uri)
        .catch(e => {
          console.log(e);
        });
      this.updateView();
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
