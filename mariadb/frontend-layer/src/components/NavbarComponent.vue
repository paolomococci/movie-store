<template>
  <section>
    <b-navbar toggleable="lg" type="dark" variant="info">
      <b-navbar-brand to="/">
        <b-avatar size="6em" rounded>movie<br>store</b-avatar>
      </b-navbar-brand>
      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item to="/about">about</b-nav-item>
        </b-navbar-nav>
        <b-navbar-nav class="ml-auto">
          <b-nav-item-dropdown right>
            <template #button-content>
              <em>manage data</em>
            </template>
            <b-dropdown-item to="/address">address</b-dropdown-item>
            <b-dropdown-item to="/category">category</b-dropdown-item>
            <b-dropdown-item to="/city">city</b-dropdown-item>
            <b-dropdown-item to="/content">content</b-dropdown-item>
            <b-dropdown-item to="/country">country</b-dropdown-item>
            <b-dropdown-item to="/customer">customer</b-dropdown-item>
            <b-dropdown-item to="/district">district</b-dropdown-item>
            <b-dropdown-item to="/inventory">inventory</b-dropdown-item>
            <b-dropdown-item to="/iso3166">iso3166</b-dropdown-item>
            <b-dropdown-item to="/language">language</b-dropdown-item>
            <b-dropdown-item to="/movie">movie</b-dropdown-item>
            <b-dropdown-item to="/payment">payment</b-dropdown-item>
            <b-dropdown-item to="/player">player</b-dropdown-item>
            <b-dropdown-item to="/rental">rental</b-dropdown-item>
            <b-dropdown-item to="/staff">staff</b-dropdown-item>
            <b-dropdown-item to="/store">store</b-dropdown-item>
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
