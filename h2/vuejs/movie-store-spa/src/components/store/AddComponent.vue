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
              v-model="$v.form.storeName.$model"
              :state="onValidateStoreNameField('storeName')"
              aria-describedby="input-name-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-name-feedback-invalid">
              size range of this field is 1 to 50 characters, only the characters `a-z`, `A-Z`, `0-9`, `_` and `-` are allowed
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-name-feedback-valid">
              the store name has a correct format
            </b-form-valid-feedback>
          </b-form-group>
          <!-- inaugurated field -->
          <b-form-group id="store-inaugurated-group" label="inaugurated" label-for="store-inaugurated-picker">
            <b-form-datepicker
              id="store-inaugurated-picker"
              name="store-inaugurated-picker"
              min="minDate"
              v-model="$v.form.storeInaugurated.$model"
              :state="onValidateStoreInauguratedField('storeInaugurated')"
              aria-describedby="store-inaugurated-picker-description-feedback-invalid"
              menu-class="w-100"
              calendar-width="100%"
              class="mb-2"
              locale="en-US"
              v-b-popover.hover.top="'todo'"></b-form-datepicker>
            <b-form-invalid-feedback id="store-inaugurated-picker-description-feedback-invalid">
              todo
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="store-inaugurated-picker-description-feedback-valid">
              the date all right
            </b-form-valid-feedback>
          </b-form-group>
          <!-- updated field -->
          <b-form-group id="store-updated-group" label="updated" label-for="store-updated-picker">
            <b-form-datepicker
              id="store-updated-picker"
              name="store-updated-picker"
              min="minDate"
              v-model="$v.form.storeUpdated.$model"
              :state="onValidateStoreUpdatedField('storeUpdated')"
              aria-describedby="store-updated-picker-description-feedback-invalid"
              menu-class="w-100"
              calendar-width="100%"
              class="mb-2"
              locale="en-US"
              v-b-popover.hover.top="'only today\'s or future date are accepted'"></b-form-datepicker>
            <b-form-invalid-feedback id="store-updated-picker-description-feedback-invalid">
              today or future date are accepted
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="store-updated-picker-description-feedback-valid">
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
import StoreRestfulApiService from '../../services/StoreRestfulApiService'

const storeNameRegex = helpers.regex('storeNameRegex', /^[a-zA-Z0-9_-]*$/);

export default {
  name: 'AddComponent',
  mixins: [validationMixin],
  data: () => ({
    form: {
      storeName: '',
      storeInaugurated: '',
      storeUpdated: ''
    },
    minDate: moment()
  }),
  validations: {
    form: {
      storeName: {
        required,
        minLength: minLength(1),
        maxLength: maxLength(50),
        storeNameRegex
      },
      storeInaugurated: {
        required
      },
      storeUpdated: {
        required
      }
    }
  },
  methods: {
    onValidateStoreNameField(storeName) {
      const { $dirty, $error } = this.$v.form[storeName];
      return $dirty ? !$error : null;
    },
    onValidateStoreInauguratedField(storeInaugurated) {
      const { $dirty, $error } = this.$v.form[storeInaugurated];
      return $dirty ? !$error : null;
    },
    onValidateStoreUpdatedField(storeUpdated) {
      const { $dirty, $error } = this.$v.form[storeUpdated];
      return $dirty ? !$error : null;
    },
    onResetForm() {
      this.form = {
        storeName: '',
        storeInaugurated: '',
        storeUpdated: ''
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
      StoreRestfulApiService.create(data)
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
