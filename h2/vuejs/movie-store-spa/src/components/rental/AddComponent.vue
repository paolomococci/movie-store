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
          <!-- rent field -->
          <b-form-group id="rental-rent-group" label="rent" label-for="rental-rent-picker">
            <b-form-datepicker
              id="rental-rent-picker"
              name="rental-rent-picker"
              min="minDate"
              v-model="$v.form.rentalRent.$model"
              :state="onValidateRentalRentField('rentalRent')"
              aria-describedby="rental-rent-picker-description-feedback-invalid"
              menu-class="w-100"
              calendar-width="100%"
              class="mb-2"
              locale="en-US"
              v-b-popover.hover.top="'todo'"></b-form-datepicker>
            <b-form-invalid-feedback id="rental-rent-picker-description-feedback-invalid">
              todo
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="rental-rent-picker-description-feedback-valid">
              the date all right
            </b-form-valid-feedback>
          </b-form-group>
          <!-- back field -->
          <b-form-group id="rental-back-group" label="back" label-for="rental-back-picker">
            <b-form-datepicker
              id="rental-back-picker"
              name="rental-back-picker"
              min="minDate"
              v-model="$v.form.rentalBack.$model"
              :state="onValidateRentalBackField('rentalBack')"
              aria-describedby="rental-back-picker-description-feedback-invalid"
              menu-class="w-100"
              calendar-width="100%"
              class="mb-2"
              locale="en-US"
              v-b-popover.hover.top="'todo'"></b-form-datepicker>
            <b-form-invalid-feedback id="rental-back-picker-description-feedback-invalid">
              todo
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="rental-back-picker-description-feedback-valid">
              the date all right
            </b-form-valid-feedback>
          </b-form-group>
          <!-- updated field -->
          <b-form-group id="rental-updated-group" label="updated" label-for="rental-updated-picker">
            <b-form-datepicker
              id="rental-updated-picker"
              name="rental-updated-picker"
              min="minDate"
              v-model="$v.form.rentalUpdated.$model"
              :state="onValidateRentalUpdatedField('rentalUpdated')"
              aria-describedby="rental-updated-picker-description-feedback-invalid"
              menu-class="w-100"
              calendar-width="100%"
              class="mb-2"
              locale="en-US"
              v-b-popover.hover.top="'only today\'s or future date are accepted'"></b-form-datepicker>
            <b-form-invalid-feedback id="rental-updated-picker-description-feedback-invalid">
              today or future date are accepted
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="rental-updated-picker-description-feedback-valid">
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
import { required } from 'vuelidate/lib/validators'
import RentalRestfulApiService from '../../services/RentalRestfulApiService'

export default {
  name: 'AddComponent',
  mixins: [validationMixin],
  data: () => ({
    form: {
      rentalRent: '',
      rentalBack: '',
      rentalUpdated: ''
    },
    minDate: moment()
  }),
  validations: {
    form: {
      rentalRent: {
        required
      },
      rentalBack: {
        required
      },
      rentalUpdated: {
        required
      }
    }
  },
  methods: {
    onValidateRentalRentField(rentalRent) {
      const { $dirty, $error } = this.$v.form[rentalRent];
      return $dirty ? !$error : null;
    },
    onValidateRentalBackField(rentalBack) {
      const { $dirty, $error } = this.$v.form[rentalBack];
      return $dirty ? !$error : null;
    },
    onValidateRentalUpdatedField(rentalUpdated) {
      const { $dirty, $error } = this.$v.form[rentalUpdated];
      return $dirty ? !$error : null;
    },
    onResetForm() {
      this.form = {
        rentalRent: '',
        rentalBack: '',
        rentalUpdated: ''
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
      RentalRestfulApiService.create(data)
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
