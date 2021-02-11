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
              v-model="$v.form.staffName.$model"
              :state="onValidateStaffNameField('staffName')"
              aria-describedby="input-name-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-name-feedback-invalid">
              size range of this field is 1 to 100 characters, only the characters `a-z`, `A-Z` and `-` are allowed
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-name-feedback-valid">
              the staff name has a correct format
            </b-form-valid-feedback>
          </b-form-group>
          <!-- nickname field -->
          <b-form-group id="input-nickname-group" label="nickname" label-for="input-nickname">
            <b-form-input
              id="input-nickname"
              name="input-nickname"
              v-model="$v.form.staffNickname.$model"
              :state="onValidateStaffNicknameField('staffNickname')"
              aria-describedby="input-nickname-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-nickname-feedback-invalid">
              max of this field is 100 characters, only the characters `a-z`, `A-Z` and `-` are allowed
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-nickname-feedback-valid">
              the staff nickname has a correct format
            </b-form-valid-feedback>
          </b-form-group>
          <!-- surname field -->
          <b-form-group id="input-surname-group" label="surname" label-for="input-surname">
            <b-form-input
              id="input-surname"
              name="input-surname"
              v-model="$v.form.staffSurname.$model"
              :state="onValidateStaffSurnameField('staffSurname')"
              aria-describedby="input-surname-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-surname-feedback-invalid">
              size range of this field is 1 to 100 characters, only the characters `a-z`, `A-Z` and `-` are allowed
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-surname-feedback-valid">
              the staff surname has a correct format
            </b-form-valid-feedback>
          </b-form-group>
          <!-- phone field -->
          <!-- mobile field -->
          <!-- email field -->
          <!-- username field -->
          <!-- password field -->
          <!-- active field -->
          <!-- updated field -->
          <b-form-group id="staff-updated-group" label="updated" label-for="staff-updated-picker">
            <b-form-datepicker
              id="staff-updated-picker"
              name="staff-updated-picker"
              min="minDate"
              v-model="$v.form.staffUpdated.$model"
              :state="onValidateStaffUpdatedField('staffUpdated')"
              aria-describedby="staff-updated-picker-description-feedback-invalid"
              menu-class="w-100"
              calendar-width="100%"
              class="mb-2"
              locale="en-US"
              v-b-popover.hover.top="'only today\'s or future date are accepted'"></b-form-datepicker>
            <b-form-invalid-feedback id="staff-updated-picker-description-feedback-invalid">
              today or future date are accepted
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="staff-updated-picker-description-feedback-valid">
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
import StaffRestfulApiService from '../../services/StaffRestfulApiService'

const staffNameRegex = helpers.regex('staffNameRegex', /^[a-zA-Z-]*$/);
const staffNicknameRegex = helpers.regex('staffNicknameRegex', /^[a-zA-Z-]*$/);
const staffSurnameRegex = helpers.regex('staffSurnameRegex', /^[a-zA-Z-]*$/);
const staffPhoneRegex = helpers.regex('staffPhoneRegex', /^[0-9-]*$/);
const staffMobileRegex = helpers.regex('staffMobileRegex', /^[0-9-]*$/);
const staffUsernameRegex = helpers.regex('staffUsernameRegex', /^[a-z0-9]*$/);
const staffPasswordRegex = helpers.regex('staffPasswordRegex', /^[a-zA-Z0-9]*$/);

export default {
  name: 'AddComponent',
  mixins: [validationMixin],
  data: () => ({
    form: {
      staffName: '',
      staffNickname: '',
      staffSurname: '',
      staffPhone: '',
      staffMobile: '',
      staffEmail: '',
      staffUsername: '',
      staffPassword: '',
      staffActive: false,
      staffUpdated: ''
    },
    minDate: moment()
  }),
  validations: {
    form: {
      staffName: {
        required,
        minLength: minLength(1),
        maxLength: maxLength(100),
        staffNameRegex
      },
      staffNickname: {
        maxLength: maxLength(100),
        staffNicknameRegex
      },
      staffSurname: {
        required,
        minLength: minLength(1),
        maxLength: maxLength(100),
        staffSurnameRegex
      },
      staffPhone: {
        maxLength: maxLength(20),
        staffPhoneRegex
      },
      staffMobile: {
        required,
        minLength: minLength(12),
        maxLength: maxLength(20),
        staffMobileRegex
      },
      staffEmail: {
        required,
        minLength: minLength(5),
        maxLength: maxLength(50),
        email
      },
      staffUsername: {
        required,
        minLength: minLength(8),
        maxLength: maxLength(100),
        staffUsernameRegex
      },
      staffPassword: {
        required,
        minLength: minLength(12),
        maxLength: maxLength(20),
        staffPasswordRegex
      },
      staffActive: {
        required
      },
      staffUpdated: {
        required
      }
    }
  },
  methods: {
    onValidateStaffNameField(staffName) {
      const { $dirty, $error } = this.$v.form[staffName];
      return $dirty ? !$error : null;
    },
    onValidateStaffNicknameField(staffNickname) {
      const { $dirty, $error } = this.$v.form[staffNickname];
      return $dirty ? !$error : null;
    },
    onValidateStaffSurnameField(staffSurname) {
      const { $dirty, $error } = this.$v.form[staffSurname];
      return $dirty ? !$error : null;
    },
    onValidateStaffPhoneField(staffPhone) {
      const { $dirty, $error } = this.$v.form[staffPhone];
      return $dirty ? !$error : null;
    },
    onValidateStaffMobileField(staffMobile) {
      const { $dirty, $error } = this.$v.form[staffMobile];
      return $dirty ? !$error : null;
    },
    onValidateStaffEmailField(staffEmail) {
      const { $dirty, $error } = this.$v.form[staffEmail];
      return $dirty ? !$error : null;
    },
    onValidateStaffUsernameField(staffUsername) {
      const { $dirty, $error } = this.$v.form[staffUsername];
      return $dirty ? !$error : null;
    },
    onValidateStaffPasswordField(staffPassword) {
      const { $dirty, $error } = this.$v.form[staffPassword];
      return $dirty ? !$error : null;
    },
    onValidateStaffActiveField(staffActive) {
      const { $dirty, $error } = this.$v.form[staffActive];
      return $dirty ? !$error : null;
    },
    onValidateStaffUpdatedField(staffUpdated) {
      const { $dirty, $error } = this.$v.form[staffUpdated];
      return $dirty ? !$error : null;
    },
    onResetForm() {
      this.form = {
        staffName: '',
        staffNickname: '',
        staffSurname: '',
        staffPhone: '',
        staffMobile: '',
        staffEmail: '',
        staffUsername: '',
        staffPassword: '',
        staffActive: false,
        staffUpdated: ''
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
      StaffRestfulApiService.create(data)
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
