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
              v-model="$v.form.customerName.$model"
              :state="onValidateCustomerNameField('customerName')"
              aria-describedby="input-name-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-name-feedback-invalid">
              size range of this field is 1 to 100 characters, only the characters `a-z`, `A-Z` and `-` are allowed
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-name-feedback-valid">
              the customer name has a correct format
            </b-form-valid-feedback>
          </b-form-group>
          <!-- nickname field -->
          <b-form-group id="input-nickname-group" label="nickname" label-for="input-nickname">
            <b-form-input
              id="input-nickname"
              name="input-nickname"
              v-model="$v.form.customerNickname.$model"
              :state="onValidateCustomerNicknameField('customerNickname')"
              aria-describedby="input-nickname-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-nickname-feedback-invalid">
              max of this field is 100 characters, only the characters `a-z`, `A-Z` and `-` are allowed
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-nickname-feedback-valid">
              the customer nickname has a correct format
            </b-form-valid-feedback>
          </b-form-group>
          <!-- surname field -->
          <b-form-group id="input-surname-group" label="surname" label-for="input-surname">
            <b-form-input
              id="input-surname"
              name="input-surname"
              v-model="$v.form.customerSurname.$model"
              :state="onValidateCustomerSurnameField('customerSurname')"
              aria-describedby="input-surname-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-surname-feedback-invalid">
              size range of this field is 1 to 100 characters, only the characters `a-z`, `A-Z` and `-` are allowed
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-surname-feedback-valid">
              the customer surname has a correct format
            </b-form-valid-feedback>
          </b-form-group>
          <!-- phone field -->
          <b-form-group id="input-phone-group" label="phone" label-for="input-phone">
            <b-form-input
              id="input-phone"
              name="input-phone"
              v-model="$v.form.customerPhone.$model"
              :state="onValidateCustomerPhoneField('customerPhone')"
              aria-describedby="input-phone-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-phone-feedback-invalid">
              max of this field is 20 characters, only the characters `0-9` and `-` are allowed
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-phone-feedback-valid">
              the customer phone has a correct format
            </b-form-valid-feedback>
          </b-form-group>
          <!-- mobile field -->
          <b-form-group id="input-mobile-group" label="mobile" label-for="input-mobile">
            <b-form-input
              id="input-mobile"
              name="input-mobile"
              v-model="$v.form.customerMobile.$model"
              :state="onValidateCustomerMobileField('customerMobile')"
              aria-describedby="input-mobile-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-mobile-feedback-invalid">
              size range of this field is 12 to 20 characters, only the characters `0-9` and `-` are allowed
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-mobile-feedback-valid">
              the customer mobile has a correct format
            </b-form-valid-feedback>
          </b-form-group>
          <!-- email field -->
          <b-form-group id="input-email-group" label="email" label-for="input-email">
            <b-form-input
              id="input-email"
              name="input-email"
              v-model="$v.form.customerEmail.$model"
              :state="onValidateCustomerEmailField('customerEmail')"
              aria-describedby="input-email-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-email-feedback-invalid">
              size range of this field is 5 to 50 characters
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-email-feedback-valid">
              the customer email has a correct format
            </b-form-valid-feedback>
          </b-form-group>
          <!-- birthday field -->
          <!-- active field -->
          <!-- updated field -->
          <b-form-group id="customer-updated-group" label="choose a date" label-for="customer-updated-picker">
            <b-form-datepicker
              id="customer-updated-picker"
              name="customer-updated-picker"
              min="minDate"
              v-model="$v.form.customerUpdated.$model"
              :state="onValidateCustomerUpdatedField('customerUpdated')"
              aria-describedby="customer-updated-picker-description-feedback-invalid"
              menu-class="w-100"
              calendar-width="100%"
              class="mb-2"
              locale="en-US"
              v-b-popover.hover.top="'only today\'s or future date are accepted'"></b-form-datepicker>
            <b-form-invalid-feedback id="customer-updated-picker-description-feedback-invalid">
              today or future date are accepted
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="customer-updated-picker-description-feedback-valid">
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
import { required, minLength, maxLength, email, helpers } from 'vuelidate/lib/validators'
import CustomerRestfulApiService from '../../services/CustomerRestfulApiService'

const customerNameRegex = helpers.regex('customerNameRegex', /^[a-zA-Z-]*$/);
const customerNicknameRegex = helpers.regex('customerNicknameRegex', /^[a-zA-Z-]*$/);
const customerSurnameRegex = helpers.regex('customerSurnameRegex', /^[a-zA-Z-]*$/);
const customerPhoneRegex = helpers.regex('customerPhoneRegex', /^[0-9-]*$/);
const customerMobileRegex = helpers.regex('customerMobileRegex', /^[0-9-]*$/);

export default {
  name: 'AddComponent',
  mixins: [validationMixin],
  data: () => ({
    form: {
      customerName: '',
      customerNickname: '',
      customerSurname: '',
      customerPhone: '',
      customerMobile: '',
      customerEmail: '',
      customerBirthday: '',
      customerActive: false,
      customerUpdated: ''
    },
    minDate: moment()
  }),
  validations: {
    form: {
      customerName: {
        required,
        minLength: minLength(1),
        maxLength: maxLength(100),
        customerNameRegex
      },
      customerNickname: {
        maxLength: maxLength(100),
        customerNicknameRegex
      },
      customerSurname: {
        required,
        minLength: minLength(1),
        maxLength: maxLength(100),
        customerSurnameRegex
      },
      customerPhone: {
        required,
        minLength: minLength(7),
        maxLength: maxLength(20),
        customerPhoneRegex
      },
      customerMobile: {
        required,
        minLength: minLength(12),
        maxLength: maxLength(20),
        customerMobileRegex
      },
      customerEmail: {
        required,
        minLength: minLength(5),
        maxLength: maxLength(50),
        email
      },
      customerBirthday: {
        required
      },
      customerActive: {
        required
      },
      customerUpdated: {
        required
      }
    }
  },
  methods: {
    onValidateCustomerNameField(customerName) {
      const { $dirty, $error } = this.$v.form[customerName];
      return $dirty ? !$error : null;
    },
    onValidateCustomerNicknameField(customerNickname) {
      const { $dirty, $error } = this.$v.form[customerNickname];
      return $dirty ? !$error : null;
    },
    onValidateCustomerSurnameField(customerSurname) {
      const { $dirty, $error } = this.$v.form[customerSurname];
      return $dirty ? !$error : null;
    },
    onValidateCustomerPhoneField(customerPhone) {
      const { $dirty, $error } = this.$v.form[customerPhone];
      return $dirty ? !$error : null;
    },
    onValidateCustomerMobileField(customerMobile) {
      const { $dirty, $error } = this.$v.form[customerMobile];
      return $dirty ? !$error : null;
    },
    onValidateCustomerEmailField(customerEmail) {
      const { $dirty, $error } = this.$v.form[customerEmail];
      return $dirty ? !$error : null;
    },
    onValidateCustomerBirthdayField(customerBirthday) {
      const { $dirty, $error } = this.$v.form[customerBirthday];
      return $dirty ? !$error : null;
    },
    onValidateCustomerActiveField(customerActive) {
      const { $dirty, $error } = this.$v.form[customerActive];
      return $dirty ? !$error : null;
    },
    onValidateCustomerUpdatedField(customerUpdated) {
      const { $dirty, $error } = this.$v.form[customerUpdated];
      return $dirty ? !$error : null;
    },
    onResetForm() {
      this.form = {
        customerName: '',
        customerNickname: '',
        customerSurname: '',
        customerPhone: '',
        customerMobile: '',
        customerEmail: '',
        customerBirthday: '',
        customerActive: false,
        customerUpdated: ''
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
      CustomerRestfulApiService.create(data)
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
