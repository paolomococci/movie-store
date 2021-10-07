<template>
  <section>
    <aside>
      <rental-add-component @updateView="updateView"/>
    </aside>
    <!-- todo sub-section to show the table list -->
    <rental-table-component/>
  </section>
</template>

<script>
import AddComponent from './AddComponent'
import TableComponent from './TableComponent'

export default {
  name: 'ViewComponent',
  components: {
    'rental-add-component': AddComponent,
    'rental-table-component': TableComponent
  },
  props: {
    msg: String
  }
}
</script>
