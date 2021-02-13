<template>
  <section>
    <aside>
      <store-add-component @updateView="updateView"/>
    </aside>
    <!-- todo sub-section to show the table list -->
    <store-table-component/>
  </section>
</template>

<script>
import AddComponent from './AddComponent'
import TableComponent from './TableComponent'

export default {
  name: 'ViewComponent',
  components: {
    'store-add-component': AddComponent,
    'store-table-component': TableComponent
  },
  props: {
    msg: String
  }
}
</script>
