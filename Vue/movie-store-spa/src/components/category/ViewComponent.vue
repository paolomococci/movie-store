<template>
  <section>
    <aside>
      <category-add-component @updateView="updateView"/>
    </aside>
    <!-- todo sub-section to show the table list -->
    <category-table-component/>
  </section>
</template>

<script>
import AddComponent from './AddComponent'
import TableComponent from './TableComponent'

export default {
  name: 'ViewComponent',
  components: {
    'category-add-component': AddComponent,
    'category-table-component': TableComponent
  },
  props: {
    msg: String
  }
}
</script>
