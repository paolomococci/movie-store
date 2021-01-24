<template>
  <section>
    <aside>
      <!-- todo aside to show add button -->
    </aside>
    <!-- todo sub-section to show the table list -->
  </section>
</template>

<script>
import ContentRestfulApiService from '../../services/ContentRestfulApiService'

export default {
  name: 'ViewComponent',
  props: {
    msg: String
  },
  data: () => ({
    // TODO
  }),
  methods: {
    retrieveContents() {
      ContentRestfulApiService.readAll()
        .then(response => {
          this.contents = response.data._embedded.contents;
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
