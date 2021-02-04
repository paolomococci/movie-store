<template>
  <section>
    <aside>
      <content-add-component/>
    </aside>
    <!-- todo sub-section to show the table list -->
    <content-table-component/>
  </section>
</template>

<script>
import AddComponent from './AddComponent'
import TableComponent from './TableComponent'

export default {
  name: 'ViewComponent',
  components: {
    'content-add-component': AddComponent,
    'content-table-component': TableComponent
  },
  props: {
    msg: String
  }
}
</script>
