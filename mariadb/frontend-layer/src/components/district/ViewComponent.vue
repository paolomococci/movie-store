<template>
  <section>
    <aside>
      <district-add-component/>
    </aside>
    <!-- todo sub-section to show the table list -->
    <district-table-component/>
  </section>
</template>

<script>
import AddComponent from './AddComponent'
import TableComponent from './TableComponent'

export default {
  name: 'ViewComponent',
  components: {
    'district-add-component': AddComponent,
    'district-table-component': TableComponent
  },
  props: {
    msg: String
  }
}
</script>
