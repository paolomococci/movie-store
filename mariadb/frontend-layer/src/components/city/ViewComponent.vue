<template>
  <section>
    <aside>
      <city-add-component @updateView="updateView"/>
    </aside>
    <!-- todo sub-section to show the table list -->
    <city-table-component/>
  </section>
</template>

<script>
import AddComponent from './AddComponent'
import TableComponent from './TableComponent'

export default {
  name: 'ViewComponent',
  components: {
    'city-add-component': AddComponent,
    'city-table-component': TableComponent
  },
  props: {
    msg: String
  }
}
</script>
