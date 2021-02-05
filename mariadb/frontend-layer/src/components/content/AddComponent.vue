<template>
  <section>
    <b-button
      variant="outline-primary"
      @click="showModalDetail">add</b-button>
    <b-button
      variant="outline-secondary"
      @click="updateView">refresh</b-button>
    <b-modal
      ref="modal-add"
      hide-footer
      title="enter the details of a new item">
      <div class="d-block text-center">
        <h3>fields</h3>
        <b-form  @submit.stop.prevent="onSubmitForm">
          <!-- todo fields -->
          <b-form-group>
            <b-form-input></b-form-input>
            <b-form-invalid-feedback>
              description of the error
            </b-form-invalid-feedback>
            <b-form-valid-feedback>all right</b-form-valid-feedback>
          </b-form-group>
          <!-- buttons -->
          <b-button
            class="mt-3"
            variant="outline-secondary"
            block
            @click="hideModalDetail">cancel</b-button>
          <b-button
            class="mt-3"
            variant="outline-warning"
            block
            @click="onResetForm()">reset</b-button>
          <b-button
            class="mt-3"
            variant="outline-primary"
            block
            type="submit">save</b-button>
        </b-form>
      </div>
    </b-modal>
  </section>
</template>

<script>
import { validationMixin } from 'vuelidate'
import ContentRestfulApiService from '../../services/ContentRestfulApiService'

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
    addItem() {
      var data = {};
      ContentRestfulApiService.create(data)
        .then(response => {
          console.log(response.data);
        }).catch(e => {
          console.log(e);
        });
      this.$refs['modal-add'].hide();
      this.updateView();
    },
    showModalDetail() {
      this.$refs['modal-add'].show();
    },
    hideModalDetail() {},
    updateView() {}
  }
}
</script>
