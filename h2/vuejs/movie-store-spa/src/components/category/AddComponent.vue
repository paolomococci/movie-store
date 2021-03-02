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
              v-model="$v.form.categoryName.$model"
              :state="onValidateCategoryNameField('categoryName')"
              aria-describedby="input-name-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-name-feedback-invalid">
              size range of this field is 3 to 50 characters, only the characters `a-z`, `A-Z`, `_` and `-` are allowed
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-name-feedback-valid">
              the category name has a correct format
            </b-form-valid-feedback>
          </b-form-group>
          <!-- description field -->
          <b-form-group id="input-description-group" label="name" label-for="input-description">
            <b-form-input
              id="input-description"
              name="input-description"
              v-model="$v.form.categoryDescription.$model"
              :state="onValidateCategoryDescriptionField('categoryDescription')"
              aria-describedby="input-description-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-description-feedback-invalid">
              max field is 200 characters, only the characters `a-z`, `A-Z`, `_`, `-` and space are allowed
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-description-feedback-valid">
              the category description has a correct format
            </b-form-valid-feedback>
          </b-form-group>
          <!-- updated field -->
          <b-form-group id="category-updated-group" label="updated" label-for="category-updated-picker">
            <b-form-datepicker
              id="category-updated-picker"
              name="category-updated-picker"
              min="minDate"
              v-model="$v.form.categoryUpdated.$model"
              :state="onValidateCategoryUpdatedField('categoryUpdated')"
              aria-describedby="category-updated-picker-description-feedback-invalid"
              menu-class="w-100"
              calendar-width="100%"
              class="mb-2"
              locale="en-US"
              v-b-popover.hover.top="'only today\'s or future date are accepted'"></b-form-datepicker>
            <b-form-invalid-feedback id="category-updated-picker-description-feedback-invalid">
              today or future date are accepted
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="category-updated-picker-description-feedback-valid">
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
import CategoryRestfulApiService from '../../services/CategoryRestfulApiService'

const categoryNameRegex = helpers.regex('categoryNameRegex', /^[a-zA-Z_-]*$/);
const categoryDescriptionRegex = helpers.regex('categoryDescriptionRegex', /^[a-zA-Z]*[a-zA-Z0-9 -]*[a-zA-Z]*$/);

export default {
  name: 'AddComponent',
  mixins: [validationMixin],
  data: () => ({
    form: {
      categoryName: '',
      categoryDescription: '',
      categoryUpdated: ''
    },
    minDate: moment()
  }),
  validations: {
    form: {
      categoryName: {
        required,
        minLength: minLength(3),
        maxLength: maxLength(50),
        categoryNameRegex
      },
      categoryDescription: {
        maxLength: maxLength(200),
        categoryDescriptionRegex
      },
      categoryUpdated: {
        required
      }
    }
  },
  methods: {
    onValidateCategoryNameField(categoryName) {
      const { $dirty, $error } = this.$v.form[categoryName];
      return $dirty ? !$error : null;
    },
    onValidateCategoryDescriptionField(categoryDescription) {
      const { $dirty, $error } = this.$v.form[categoryDescription];
      return $dirty ? !$error : null;
    },
    onValidateCategoryUpdatedField(categoryUpdated) {
      const { $dirty, $error } = this.$v.form[categoryUpdated];
      return $dirty ? !$error : null;
    },
    onResetForm() {
      this.form = {
        categoryName: '',
        categoryDescription: '',
        categoryUpdated: ''
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
      CategoryRestfulApiService.create(data)
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
