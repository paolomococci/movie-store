<template>
  <section>
    <aside>
      <!-- todo aside to show add button -->
    </aside>
    <!-- todo sub-section to show the table list -->
    <inventory-table-component/>
  </section>
</template>

<script>
import TableComponent from './TableComponent'

export default {
  name: 'ViewComponent',
  components: {
    'inventory-table-component': TableComponent
  },
  props: {
    msg: String
  }
}
</script>
