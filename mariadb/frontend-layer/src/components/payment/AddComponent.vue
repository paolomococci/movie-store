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
          <!-- amount field -->
          <b-form-group id="input-amount-group" label="amount" label-for="input-amount">
            <b-form-input
              id="input-amount"
              name="input-amount"
              v-model="$v.form.paymentAmount.$model"
              :state="onValidatePaymentAmountField('paymentAmount')"
              aria-describedby="input-amount-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-amount-feedback-invalid">
              todo
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-amount-feedback-valid">
              the payment amount has a correct format
            </b-form-valid-feedback>
          </b-form-group>
          <!-- payed field -->
          <!-- updated field -->
          <b-form-group id="payment-updated-group" label="updated" label-for="payment-updated-picker">
            <b-form-datepicker
              id="payment-updated-picker"
              name="payment-updated-picker"
              min="minDate"
              v-model="$v.form.paymentUpdated.$model"
              :state="onValidatePaymentUpdatedField('paymentUpdated')"
              aria-describedby="payment-updated-picker-description-feedback-invalid"
              menu-class="w-100"
              calendar-width="100%"
              class="mb-2"
              locale="en-US"
              v-b-popover.hover.top="'only today\'s or future date are accepted'"></b-form-datepicker>
            <b-form-invalid-feedback id="payment-updated-picker-description-feedback-invalid">
              today or future date are accepted
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="payment-updated-picker-description-feedback-valid">
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
import PaymentRestfulApiService from '../../services/PaymentRestfulApiService'

export default {
  name: 'AddComponent',
  mixins: [validationMixin],
  data: () => ({
    form: {
      paymentAmount: 0.0,
      paymentPayed: '',
      paymentUpdated: ''
    },
    minDate: moment()
  }),
  validations: {
    form: {
      paymentAmount: {
        required
      },
      paymentPayed: {
        required
      },
      paymentUpdated: {
        required
      }
    }
  },
  methods: {
    onValidatePaymentAmountField(paymentAmount) {
      const { $dirty, $error } = this.$v.form[paymentAmount];
      return $dirty ? !$error : null;
    },
    onValidatePaymentPayedField(paymentPayed) {
      const { $dirty, $error } = this.$v.form[paymentPayed];
      return $dirty ? !$error : null;
    },
    onValidatePaymentUpdatedField(paymentUpdated) {
      const { $dirty, $error } = this.$v.form[paymentUpdated];
      return $dirty ? !$error : null;
    },
    onResetForm() {
      this.form = {
        paymentAmount: 0.0,
        paymentPayed: '',
        paymentUpdated: ''
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
      PaymentRestfulApiService.create(data)
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
