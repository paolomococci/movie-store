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
          <!-- name field -->
          <b-form-group id="input-name-group" label="name" label-for="input-name">
            <b-form-input
              id="input-name"
              name="input-name"
              v-model="$v.form.iso3166Name.$model"
              :state="onValidateIso3166NameField('iso3166Name')"
              aria-describedby="input-name-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-name-feedback-invalid">
              size range of this field is 3 to 100 characters, only the characters `a-z`, `A-Z`, `_` and `-` are allowed
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-name-feedback-valid">
              the country code name has a correct format
            </b-form-valid-feedback>
          </b-form-group>
          <!-- code field -->
          <!-- signature field -->
          <!-- updated field -->
          <b-form-group id="iso3166-updated-group" label="choose a date" label-for="iso3166-updated-picker">
            <b-form-datepicker
              id="iso3166-updated-picker"
              name="iso3166-updated-picker"
              min="minDate"
              v-model="$v.form.iso3166Updated.$model"
              :state="onValidateIso3166UpdatedField('iso3166Updated')"
              aria-describedby="iso3166-updated-picker-description-feedback-invalid"
              menu-class="w-100"
              calendar-width="100%"
              class="mb-2"
              locale="en-US"
              v-b-popover.hover.top="'only today\'s or future date are accepted'"></b-form-datepicker>
            <b-form-invalid-feedback id="iso3166-updated-picker-description-feedback-invalid">
              today or future date are accepted
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="iso3166-updated-picker-description-feedback-valid">
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
import { required, minLength, maxLength, helpers } from 'vuelidate/lib/validators'
import Iso3166RestfulApiService from '../../services/Iso3166RestfulApiService'

const iso3166NameRegex = helpers.regex('iso3166NameRegex', /^[a-zA-Z_-]*$/);
const iso3166CodeRegex = helpers.regex('iso3166CodeRegex', /^[1-9]*$/);
const iso3166SignatureRegex = helpers.regex('iso3166SignatureRegex', /^[A-Z]*$/);

export default {
  name: 'AddComponent',
  mixins: [validationMixin],
  data: () => ({
    form: {
      iso3166Name: '',
      iso3166Code: '',
      iso3166Signature: '',
      iso3166Updated: ''
    },
    minDate: moment()
  }),
  validations: {
    form: {
      iso3166Name: {
        required,
        minLength: minLength(3),
        maxLength: maxLength(100),
        iso3166NameRegex
      },
      iso3166Code: {
        required,
        minLength: minLength(3),
        maxLength: maxLength(3),
        iso3166CodeRegex
      },
      iso3166Signature: {
        required,
        minLength: minLength(2),
        maxLength: maxLength(3),
        iso3166SignatureRegex
      },
      iso3166Updated: {
        required
      }
    }
  },
  methods: {
    onValidateIso3166NameField(iso3166Name) {
      const { $dirty, $error } = this.$v.form[iso3166Name];
      return $dirty ? !$error : null;
    },
    onValidateIso3166CodeField(iso3166Code) {
      const { $dirty, $error } = this.$v.form[iso3166Code];
      return $dirty ? !$error : null;
    },
    onValidateIso3166SignatureField(iso3166Signature) {
      const { $dirty, $error } = this.$v.form[iso3166Signature];
      return $dirty ? !$error : null;
    },
    onValidateIso3166UpdatedField(iso3166Updated) {
      const { $dirty, $error } = this.$v.form[iso3166Updated];
      return $dirty ? !$error : null;
    },
    onResetForm() {
      this.form = {
        iso3166Name: '',
        iso3166Code: '',
        iso3166Signature: '',
        iso3166Updated: ''
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
      Iso3166RestfulApiService.create(data)
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
