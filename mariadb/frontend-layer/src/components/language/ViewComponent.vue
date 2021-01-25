<template>
  <section>
    <aside>
      <!-- todo aside to show add button -->
    </aside>
    <!-- todo sub-section to show the table list -->
  </section>
</template>

<script>
import LanguageRestfulApiService from '../../services/LanguageRestfulApiService'

export default {
  name: 'ViewComponent',
  props: {
    msg: String
  },
  data: () => ({
    languages: []
    // TODO
  }),
  methods: {
    async updateView() {
      this.$bvToast.toast('data of languages being updated', {
        title: 'update view',
        toaster: 'b-toaster-bottom-center',
        variant: 'info',
        solid: true,
        appendToast: true,
        autoHideDelay: 1000
      });
      await setTimeout(() => {
          this.languages = null;
          this.retrieveLanguages();
        }, 1000);
    },
    retrieveLanguages() {
      LanguageRestfulApiService.readAll()
        .then(response => {
          this.languages = response.data._embedded.languages;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },
    deleteItem(uri) {
      LanguageRestfulApiService.delete(uri)
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
