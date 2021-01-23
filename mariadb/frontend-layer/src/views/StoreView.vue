<template>
  <main>
    <welcome msg="staff view"/>
    <staff-view-component/>
  </main>
</template>

<script>
import WelcomeComponent from '@/components/WelcomeComponent.vue'
import ViewComponent from '@/components/staff/ViewComponent.vue'

export default {
  name: 'StaffView',
  components: {
    welcome: WelcomeComponent,
    'staff-view-component': ViewComponent
  }
}
</script>
