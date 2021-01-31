<template>
  <section>
    <aside>
      <!-- todo aside to show add button -->
    </aside>
    <!-- todo sub-section to show the table list -->
    <movie-table-component/>
  </section>
</template>

<script>
import MovieRestfulApiService from '../../services/MovieRestfulApiService'
import TableComponent from './TableComponent'

export default {
  name: 'ViewComponent',
  components: {
    'movie-table-component': TableComponent
  },
  props: {
    msg: String
  },
  data: () => ({
    movies: [],
    fields: [
      {
        key: 'title',
        label: 'titles',
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
      MovieRestfulApiService.delete(uri)
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
