<template>
  <aside>
    <b-button v-b-toggle.header-sidebar>help</b-button>
    <b-sidebar id="header-sidebar" title="help" shadow>
      <div class="px-3 py-2">
        <b-card header="Edit"
                title="how to modify an item">
          <b-card-text>
            To change an item just click on it, and select the values you want to change.
          </b-card-text>
        </b-card>
        <b-card header="URI"
                title="unique link of each element">
          <b-card-text>
            The URI is what actually identifies each item registered in the system.
          </b-card-text>
        </b-card>
      </div>
    </b-sidebar>
  </aside>
</template>

<script>
export default {
  name: 'HelpComponent'
}
</script>

<style>
  aside {
    margin: 1rem;
  }
</style>
