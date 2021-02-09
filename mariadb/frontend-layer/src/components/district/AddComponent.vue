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
              v-model="$v.form.districtName.$model"
              :state="onValidateDistrictNameField('districtName')"
              aria-describedby="input-name-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-name-feedback-invalid">
              size range of this field is 1 to 50 characters, only the characters `a-z`, `A-Z`, `_` and `-` are allowed
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-name-feedback-valid">
              the district name has a correct format
            </b-form-valid-feedback>
          </b-form-group>
          <!-- code field -->
          <!-- updated field -->
          <b-form-group id="district-updated-group" label="choose a date" label-for="district-updated-picker">
            <b-form-datepicker
              id="district-updated-picker"
              name="district-updated-picker"
              min="minDate"
              v-model="$v.form.districtUpdated.$model"
              :state="onValidateDistrictUpdatedField('districtUpdated')"
              aria-describedby="district-updated-picker-description-feedback-invalid"
              menu-class="w-100"
              calendar-width="100%"
              class="mb-2"
              locale="en-US"
              v-b-popover.hover.top="'only today\'s or future date are accepted'"></b-form-datepicker>
            <b-form-invalid-feedback id="district-updated-picker-description-feedback-invalid">
              today or future date are accepted
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="district-updated-picker-description-feedback-valid">
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
import DistrictRestfulApiService from '../../services/DistrictRestfulApiService'

const districtNameRegex = helpers.regex('districtNameRegex', /^[a-zA-Z_-]*$/);
const districtCodeRegex = helpers.regex('districtCodeRegex', /^[a-zA-Z0-9_-]*$/);

export default {
  name: 'AddComponent',
  mixins: [validationMixin],
  data: () => ({
    form: {
      districtName: '',
      districtCode: '',
      districtUpdated: ''
    },
    minDate: moment()
  }),
  validations: {
    form: {
      districtName: {
        required,
        minLength: minLength(1),
        maxLength: maxLength(50),
        districtNameRegex
      },
      districtCode: {
        required,
        minLength: minLength(3),
        maxLength: maxLength(6),
        districtCodeRegex
      },
      districtUpdated: {
        required
      }
    }
  },
  methods: {
    onValidateDistrictNameField(districtName) {
      const { $dirty, $error } = this.$v.form[districtName];
      return $dirty ? !$error : null;
    },
    onValidateDistrictCodeField(districtCode) {
      const { $dirty, $error } = this.$v.form[districtCode];
      return $dirty ? !$error : null;
    },
    onValidateDistrictUpdatedField(districtUpdated) {
      const { $dirty, $error } = this.$v.form[districtUpdated];
      return $dirty ? !$error : null;
    },
    onResetForm() {
      this.form = {
        districtName: '',
        districtCode: '',
        districtUpdated: ''
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
      DistrictRestfulApiService.create(data)
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
