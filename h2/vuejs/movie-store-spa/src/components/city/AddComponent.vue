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
              v-model="$v.form.cityName.$model"
              :state="onValidateCityNameField('cityName')"
              aria-describedby="input-name-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-name-feedback-invalid">
              size range of this field is 1 to 100 characters, only the characters `a-z`, `A-Z`, `_` and `-` are allowed
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-name-feedback-valid">
              the city name has a correct format
            </b-form-valid-feedback>
          </b-form-group>
          <!-- updated field -->
          <b-form-group id="city-updated-group" label="updated" label-for="city-updated-picker">
            <b-form-datepicker
              id="city-updated-picker"
              name="city-updated-picker"
              min="minDate"
              v-model="$v.form.cityUpdated.$model"
              :state="onValidateCityUpdatedField('cityUpdated')"
              aria-describedby="city-updated-picker-description-feedback-invalid"
              menu-class="w-100"
              calendar-width="100%"
              class="mb-2"
              locale="en-US"
              v-b-popover.hover.top="'only today\'s or future date are accepted'"></b-form-datepicker>
            <b-form-invalid-feedback id="city-updated-picker-description-feedback-invalid">
              today or future date are accepted
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="city-updated-picker-description-feedback-valid">
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
import CityRestfulApiService from '../../services/CityRestfulApiService'

const cityNameRegex = helpers.regex('cityNameRegex', /^[a-zA-Z_-]*$/);

export default {
  name: 'AddComponent',
  mixins: [validationMixin],
  data: () => ({
    form: {
      cityName: '',
      cityUpdated: ''
    },
    minDate: moment()
  }),
  validations: {
    form: {
      cityName: {
        required,
        minLength: minLength(1),
        maxLength: maxLength(100),
        cityNameRegex
      },
      cityUpdated: {
        required
      }
    }
  },
  methods: {
    onValidateCityNameField(cityName) {
      const { $dirty, $error } = this.$v.form[cityName];
      return $dirty ? !$error : null;
    },
    onValidateCityUpdatedField(cityUpdated) {
      const { $dirty, $error } = this.$v.form[cityUpdated];
      return $dirty ? !$error : null;
    },
    onResetForm() {
      this.form = {
        cityName: '',
        cityUpdated: ''
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
      CityRestfulApiService.create(data)
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
