<template>
  <section>
    <aside>
      <country-add-component @updateView="updateView"/>
    </aside>
    <!-- todo sub-section to show the table list -->
    <country-table-component/>
  </section>
</template>

<script>
import AddComponent from './AddComponent'
import TableComponent from './TableComponent'

export default {
  name: 'ViewComponent',
  components: {
    'country-add-component': AddComponent,
    'country-table-component': TableComponent
  },
  props: {
    msg: String
  }
}
</script>
