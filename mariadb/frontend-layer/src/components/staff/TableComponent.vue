<template>
  <section>
    <b-table>
      <template>
        <b-form-checkbox>
          team details
        </b-form-checkbox>
      </template>
      <template>
        <b-card>
          <b-row>
            <b-col></b-col>
            <b-col></b-col>
          </b-row>
          <b-row>
            <b-button-group>
              <!-- edit staff component -->
              <!-- view references component -->
              <b-dropdown>
                <b-dropdown-item></b-dropdown-item>
                <b-dropdown-divider/>
                <b-dropdown-item></b-dropdown-item>
              </b-dropdown>
            </b-button-group>
          </b-row>
        </b-card>
      </template>
    </b-table>
  </section>
</template>

<script>

export default {
  name: 'TableComponent',
  props: {
    // TODO
  }
}
</script>
