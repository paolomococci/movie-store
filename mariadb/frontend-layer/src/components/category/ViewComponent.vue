<template>
  <section>
    <aside>
      <!-- todo aside to show add button -->
    </aside>
    <!-- todo sub-section to show the table list -->
  </section>
</template>

<script>
import CategoryRestfulApiService from '../../services/CategoryRestfulApiService'

export default {
  name: 'ViewComponent',
  props: {
    msg: String
  },
  data: () => ({
    categories: []
    // TODO
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
