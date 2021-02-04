<template>
  <section>
    <aside>
      <player-add-component/>
    </aside>
    <!-- todo sub-section to show the table list -->
    <player-table-component/>
  </section>
</template>

<script>
import AddComponent from './AddComponent'
import TableComponent from './TableComponent'

export default {
  name: 'ViewComponent',
  components: {
    'player-add-component': AddComponent,
    'player-table-component': TableComponent
  },
  props: {
    msg: String
  }
}
</script>
