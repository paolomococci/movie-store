<template>
  <section>
    <aside>
      <!-- todo aside to show add button -->
    </aside>
    <!-- todo sub-section to show the table list -->
    <staff-table-component/>
  </section>
</template>

<script>
import TableComponent from './TableComponent'

export default {
  name: 'ViewComponent',
  components: {
    'staff-table-component': TableComponent
  },
  props: {
    msg: String
  }
}
</script>
