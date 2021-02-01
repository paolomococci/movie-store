<template>
  <section>
    <aside>
      <!-- todo aside to show add button -->
    </aside>
    <!-- todo sub-section to show the table list -->
    <customer-table-component/>
  </section>
</template>

<script>
import TableComponent from './TableComponent'

export default {
  name: 'ViewComponent',
  components: {
    'customer-table-component': TableComponent
  },
  props: {
    msg: String
  }
}
</script>
