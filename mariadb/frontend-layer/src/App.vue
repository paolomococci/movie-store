<template>
  <div id="app">
    <div id="nav">
      <router-link class="routerLink" to="/">home</router-link> |
      <router-link class="routerLink" to="/about">about</router-link>
    </div>
    <router-view/>
  </div>
</template>


<style lang="scss">
.routerLink {
  margin: 5px;
}
</style>
