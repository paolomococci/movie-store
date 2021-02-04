<template>
  <section>
    <aside>
      <movie-add-component/>
    </aside>
    <!-- todo sub-section to show the table list -->
    <movie-table-component/>
  </section>
</template>

<script>
import AddComponent from './AddComponent'
import TableComponent from './TableComponent'

export default {
  name: 'ViewComponent',
  components: {
    'movie-add-component': AddComponent,
    'movie-table-component': TableComponent
  },
  props: {
    msg: String
  }
}
</script>
