<template>
  <section>
    <aside>
      <!-- todo aside to show add button -->
    </aside>
    <!-- todo sub-section to show the table list -->
  </section>
</template>

<script>
import MovieRestfulApiService from '../../services/MovieRestfulApiService'

export default {
  name: 'ViewComponent',
  props: {
    msg: String
  },
  data: () => ({
    movies: []
    // TODO
  }),
  methods: {
    async updateView() {
      this.$bvToast.toast('data of movies being updated', {
        title: 'update view',
        toaster: 'b-toaster-bottom-center',
        variant: 'info',
        solid: true,
        appendToast: true,
        autoHideDelay: 1000
      });
      await setTimeout(() => {
          this.movies = null;
          this.retrieveMovies();
        }, 1000);
    },
    retrieveMovies() {
      MovieRestfulApiService.readAll()
        .then(response => {
          this.movies = response.data._embedded.movies;
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
