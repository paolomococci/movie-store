<template>
  <section>
    <!-- todo -->
  </section>
</template>

<script>
import { validationMixin } from 'vuelidate'

export default {
  name: 'AddComponent',
  mixins: [validationMixin],
  data: () => ({
    form: {}
  }),
  validations: {
    form: {}
  },
  methods: {
    onValidateField() {},
    onResetForm() {},
    onSubmitForm() {},
    onConfirm() {},
    addItem() {},
    showModalDetail() {},
    hideModalDetail() {},
    updateView() {}
  }
}
</script>
