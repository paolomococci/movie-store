<template>
  <section>
    <aside>
      <address-add-component/>
    </aside>
    <!-- todo sub-section to show the table list -->
    <address-table-component/>
  </section>
</template>

<script>
import AddComponent from './AddComponent'
import TableComponent from './TableComponent'

export default {
  name: 'ViewComponent',
  components: {
    'address-add-component': AddComponent,
    'address-table-component': TableComponent
  },
  props: {
    msg: String
  }
}
</script>
