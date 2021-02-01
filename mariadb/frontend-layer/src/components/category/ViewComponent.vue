<template>
  <section>
    <aside>
      <!-- todo aside to show add button -->
    </aside>
    <!-- todo sub-section to show the table list -->
    <category-table-component/>
  </section>
</template>

<script>
import TableComponent from './TableComponent'

export default {
  name: 'ViewComponent',
  components: {
    'category-table-component': TableComponent
  },
  props: {
    msg: String
  }
}
</script>
