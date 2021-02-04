<template>
  <section>
    <aside>
      <inventory-add-component/>
    </aside>
    <!-- todo sub-section to show the table list -->
    <inventory-table-component/>
  </section>
</template>

<script>
import AddComponent from './AddComponent'
import TableComponent from './TableComponent'

export default {
  name: 'ViewComponent',
  components: {
    'inventory-add-component': AddComponent,
    'inventory-table-component': TableComponent
  },
  props: {
    msg: String
  }
}
</script>
