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
import moment from 'moment'
import { validationMixin } from 'vuelidate'
import { required, minLength, maxLength, helpers } from 'vuelidate/lib/validators'
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
    }
  }),
  validations: {
    form: {
      // TODO validation criteria for each field
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
