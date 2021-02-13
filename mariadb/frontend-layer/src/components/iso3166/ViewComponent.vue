<template>
  <section>
    <aside>
      <iso3166-add-component @updateView="updateView"/>
    </aside>
    <!-- todo sub-section to show the table list -->
    <iso3166-table-component/>
  </section>
</template>

<script>
import AddComponent from './AddComponent'
import TableComponent from './TableComponent'

export default {
  name: 'ViewComponent',
  components: {
    'iso3166-add-component': AddComponent,
    'iso3166-table-component': TableComponent
  },
  props: {
    msg: String
  }
}
</script>
