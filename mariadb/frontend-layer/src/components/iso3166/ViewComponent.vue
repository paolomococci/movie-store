<template>
  <section>
    <aside>
      <!-- todo aside to show add button -->
    </aside>
    <!-- todo sub-section to show the table list -->
  </section>
</template>

<script>
import Iso3166RestfulApiService from '../../services/Iso3166RestfulApiService'

export default {
  name: 'ViewComponent',
  props: {
    msg: String
  },
  data: () => ({
    // TODO
  }),
  methods: {
    retrieveCountryCodes() {
      Iso3166RestfulApiService.readAll()
        .then(response => {
          this.iso3166s = response.data._embedded.iso3166s;
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
