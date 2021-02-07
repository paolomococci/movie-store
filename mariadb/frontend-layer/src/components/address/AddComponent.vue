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
          <!-- type field -->
          <b-form-group id="input-type-group" label="type" label-for="input-type">
            <b-form-input
              id="input-type"
              name="input-type"
              v-model="$v.form.addressType.$model"
              :state="onValidateAddressTypeField('addressType')"
              aria-describedby="input-type-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-type-feedback-invalid">
              size range of this field is 3 to 255 characters, only the characters `a-z` and `A-Z` characters are accepted
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-type-feedback-valid">
              the address type has a correct format
            </b-form-valid-feedback>
          </b-form-group>
          <!-- name field -->
          <b-form-group id="input-name-group" label="name" label-for="input-name">
            <b-form-input
              id="input-name"
              name="input-name"
              v-model="$v.form.addressName.$model"
              :state="onValidateAddressNameField('addressName')"
              aria-describedby="input-name-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-name-feedback-invalid">
              size range of this field is 1 to 100 characters, only the characters `a-z`, `A-Z`, `_` and `-` are allowed
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-name-feedback-valid">
              the address name has a correct format
            </b-form-valid-feedback>
          </b-form-group>
          <!-- civic field -->
          <b-form-group id="input-civic-group" label="civic" label-for="input-civic">
            <b-form-input
              id="input-civic"
              name="input-civic"
              v-model="$v.form.addressCivic.$model"
              :state="onValidateAddressCivicField('addressCivic')"
              aria-describedby="input-civic-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-civic-feedback-invalid">
              size range of this field is 1 to 10 characters, only the characters `a-z`, `A-Z`, `0-9` and `-` are allowed
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-civic-feedback-valid">
              the address civic has a correct format
            </b-form-valid-feedback>
          </b-form-group>
          <!-- phone field -->
          <b-form-group id="input-phone-group" label="phone" label-for="input-phone">
            <b-form-input
              id="input-phone"
              name="input-phone"
              v-model="$v.form.addressPhone.$model"
              :state="onValidateAddressPhoneField('addressPhone')"
              aria-describedby="input-phone-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-phone-feedback-invalid">
              max of this field is 25 characters, only the characters `0-9` and `-` are allowed
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-phone-feedback-valid">
              the address phone has a correct format
            </b-form-valid-feedback>
          </b-form-group>
          <!-- updated field -->
          <b-form-group id="address-updated-group" label="choose a date" label-for="address-updated-picker">
            <b-form-datepicker
              id="address-updated-picker"
              name="address-updated-picker"
              min="minDate"
              v-model="$v.form.addressUpdated.$model"
              :state="onValidateAddressUpdatedField('addressUpdated')"
              aria-describedby="address-updated-picker-description-feedback-invalid"
              menu-class="w-100"
              calendar-width="100%"
              class="mb-2"
              locale="en-US"
              v-b-popover.hover.top="'only today\'s or future date are accepted'"></b-form-datepicker>
            <b-form-invalid-feedback id="address-updated-picker-description-feedback-invalid">
              today or future date are accepted
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="address-updated-picker-description-feedback-valid">
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
import AddressRestfulApiService from '../../services/AddressRestfulApiService'

const addressTypeRegex = helpers.regex('addressTypeRegex', /^[a-zA-Z]*$/);

export default {
  name: 'AddComponent',
  mixins: [validationMixin],
  data: () => ({
    form: {
      addressType: '',
      addressName: '',
      addressCivic: '',
      addressPhone: '',
      addressUpdated: ''
    },
    minDate: moment()
  }),
  validations: {
    form: {
      addressType: {
        required,
        minLength: minLength(3),
        maxLength: maxLength(255),
        addressTypeRegex
      },
      addressName: {
        required,
        minLength: minLength(1),
        maxLength: maxLength(100)
      },
      addressCivic: {
        required,
        minLength: minLength(1),
        maxLength: maxLength(10)
      },
      addressPhone: {
        required,
        minLength: minLength(5),
        maxLength: maxLength(25)
      },
      addressUpdated: {
        required
      }
    }
  },
  methods: {
    onValidateAddressTypeField() {
      // TODO
    },
    onValidateAddressNameField() {
      // TODO
    },
    onValidateAddressCivicField() {
      // TODO
    },
    onValidateAddressPhoneField() {
      // TODO
    },
    onValidateAddressUpdatedField() {
      // TODO
    },
    onResetForm() {
      this.form = {
        addressType: '',
        addressName: '',
        addressCivic: '',
        addressPhone: '',
        addressUpdated: ''
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
      AddressRestfulApiService.create(data)
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
