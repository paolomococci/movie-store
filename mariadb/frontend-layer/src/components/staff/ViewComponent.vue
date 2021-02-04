<template>
  <section>
    <aside>
      <staff-add-component/>
    </aside>
    <!-- todo sub-section to show the table list -->
    <staff-table-component/>
  </section>
</template>

<script>
import AddComponent from './AddComponent'
import TableComponent from './TableComponent'

export default {
  name: 'ViewComponent',
  components: {
    'staff-add-component': AddComponent,
    'staff-table-component': TableComponent
  },
  props: {
    msg: String
  }
}
</script>
