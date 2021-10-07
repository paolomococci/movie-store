<template>
  <section>
    <aside>
      <language-add-component @updateView="updateView"/>
    </aside>
    <!-- todo sub-section to show the table list -->
    <language-table-component/>
  </section>
</template>

<script>
import AddComponent from './AddComponent'
import TableComponent from './TableComponent'

export default {
  name: 'ViewComponent',
  components: {
    'language-add-component': AddComponent,
    'language-table-component': TableComponent
  },
  props: {
    msg: String
  }
}
</script>
