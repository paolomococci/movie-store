<template>
  <section>
    <aside>
      <customer-add-component @updateView="updateView"/>
    </aside>
    <!-- todo sub-section to show the table list -->
    <customer-table-component/>
  </section>
</template>

<script>
import AddComponent from './AddComponent'
import TableComponent from './TableComponent'

export default {
  name: 'ViewComponent',
  components: {
    'customer-add-component': AddComponent,
    'customer-table-component': TableComponent
  },
  props: {
    msg: String
  }
}
</script>
