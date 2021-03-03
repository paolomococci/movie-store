<template>
  <section>
    <aside>
      <payment-add-component @updateView="updateView"/>
    </aside>
    <!-- todo sub-section to show the table list -->
    <payment-table-component/>
  </section>
</template>

<script>
import AddComponent from './AddComponent'
import TableComponent from './TableComponent'

export default {
  name: 'ViewComponent',
  components: {
    'payment-add-component': AddComponent,
    'payment-table-component': TableComponent
  },
  props: {
    msg: String
  }
}
</script>
