<template>
  <section>
    <b-navbar toggleable="lg" type="dark" variant="info">
      <b-navbar-brand href="#">
        <b-avatar size="6em" rounded>movie<br>store</b-avatar>
      </b-navbar-brand>
      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item to="/">home</b-nav-item>
          <b-nav-item to="/about">about</b-nav-item>
        </b-navbar-nav>
        <b-navbar-nav class="ml-auto">
          <b-nav-item-dropdown right>
            <template #button-content>
              <em>manage data</em>
            </template>
            <b-dropdown-item to="/address">company</b-dropdown-item>
            <b-dropdown-item to="/category">contest</b-dropdown-item>
            <b-dropdown-item to="/city">employee</b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </section>
</template>

<script>
export default {
  name: 'NavbarComponent'
}
</script>
