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
          <!-- subject field -->
          <b-form-group id="input-subject-group" label="subject" label-for="input-subject">
            <b-form-input
              id="input-subject"
              name="input-subject"
              v-model="$v.form.contentSubject.$model"
              :state="onValidateContentSubjectField('contentSubject')"
              aria-describedby="input-subject-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-subject-feedback-invalid">
              max of this field is 255 characters, only the characters `a-z`, `A-Z`, `_`, `-` and space are allowed
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-subject-feedback-valid">
              the content subject has a correct format
            </b-form-valid-feedback>
          </b-form-group>
          <!-- updated field -->
          <b-form-group id="content-updated-group" label="choose a date" label-for="content-updated-picker">
            <b-form-datepicker
              id="content-updated-picker"
              name="content-updated-picker"
              min="minDate"
              v-model="$v.form.contentUpdated.$model"
              :state="onValidateContentUpdatedField('contentUpdated')"
              aria-describedby="content-updated-picker-description-feedback-invalid"
              menu-class="w-100"
              calendar-width="100%"
              class="mb-2"
              locale="en-US"
              v-b-popover.hover.top="'only today\'s or future date are accepted'"></b-form-datepicker>
            <b-form-invalid-feedback id="content-updated-picker-description-feedback-invalid">
              today or future date are accepted
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="content-updated-picker-description-feedback-valid">
              the date all right
            </b-form-valid-feedback>
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
import moment from 'moment'
import { validationMixin } from 'vuelidate'
import { required, maxLength, helpers } from 'vuelidate/lib/validators'
import ContentRestfulApiService from '../../services/ContentRestfulApiService'

const contentSubjectRegex = helpers.regex('contentSubjectRegex', /^[a-zA-Z]*[a-zA-Z0-9 -]*[a-zA-Z]*$/);

export default {
  name: 'AddComponent',
  mixins: [validationMixin],
  data: () => ({
    form: {
      contentSubject: '',
      contentUpdated: ''
    },
    minDate: moment()
  }),
  validations: {
    form: {
      contentSubject: {
        maxLength: maxLength(255),
        contentSubjectRegex
      },
      contentUpdated: {
        required
      }
    }
  },
  methods: {
    onValidateContentSubjectField(contentSubject) {
      const { $dirty, $error } = this.$v.form[contentSubject];
      return $dirty ? !$error : null;
    },
    onValidateContentUpdatedField(contentUpdated) {
      const { $dirty, $error } = this.$v.form[contentUpdated];
      return $dirty ? !$error : null;
    },
    onResetForm() {
      this.form = {
        contentSubject: '',
        contentUpdated: ''
      };
      this.$nextTick(() => {
        this.$v.$reset();
      });
    },
    onSubmitForm() {
      this.$v.form.$touch();
      if (this.$v.form.$anyError) {
        this.onResetForm();
        return;
      }
      this.onConfirm();
    },
    onConfirm() {
      this.messageBoxToConfirmDeletion = '';
      this.$bvModal.msgBoxConfirm('are you sure you want to add this item', {
        title: 'please confirm',
        size: 'md',
        buttonSize: 'md',
        okVariant: 'warning',
        okTitle: 'yes',
        cancelTitle: 'no',
        footerClass: 'p-2',
        hideHeaderClose: false,
        centered: true
      }).then(value => {
        if(value) {
          this.addItem();
        }
      });
    },
    addItem() {
      var data = {};
      ContentRestfulApiService.create(data)
        .then(response => {
          console.log(response.data);
        }).catch(e => {
          console.log(e);
        });
      this.hideModalDetail();
      this.updateView();
    },
    showModalDetail() {
      this.$refs['modal-add'].show();
    },
    hideModalDetail() {
      this.$refs['modal-add'].hide();
    },
    updateView() {
      this.$emit('updateView');
    }
  }
}
</script>
