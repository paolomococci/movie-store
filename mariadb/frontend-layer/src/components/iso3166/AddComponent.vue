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
    }
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
      iso3166Name: {
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
