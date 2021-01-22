<template>
  <header>
    <nav>
      <navbar-component/>
    </nav>
    <help/>
  </header>
</template>

<script>
import NavbarComponent from '@/components/NavbarComponent'
import HelpComponent from '@/components/HelpComponent'

export default {
  name: 'HeaderComponent',
  components: {
    'navbar-component': NavbarComponent,
    help: HelpComponent
  }
}
</script>
