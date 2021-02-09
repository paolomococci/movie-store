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
          <!-- title field -->
          <b-form-group id="input-title-group" label="title" label-for="input-title">
            <b-form-input
              id="input-title"
              name="input-title"
              v-model="$v.form.movieTitle.$model"
              :state="onValidateMovieTitleField('movieTitle')"
              aria-describedby="input-title-feedback-invalid"></b-form-input>
            <b-form-invalid-feedback id="input-title-feedback-invalid">
              size range of this field is 1 to 100 characters, only the characters `a-z`, `A-Z`, `0-9`, `_` and `-` are allowed
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="input-title-feedback-valid">
              the movie title has a correct format
            </b-form-valid-feedback>
          </b-form-group>
          <!-- updated field -->
          <b-form-group id="movie-updated-group" label="choose a date" label-for="movie-updated-picker">
            <b-form-datepicker
              id="movie-updated-picker"
              name="movie-updated-picker"
              min="minDate"
              v-model="$v.form.movieUpdated.$model"
              :state="onValidateMovieUpdatedField('movieUpdated')"
              aria-describedby="movie-updated-picker-description-feedback-invalid"
              menu-class="w-100"
              calendar-width="100%"
              class="mb-2"
              locale="en-US"
              v-b-popover.hover.top="'only today\'s or future date are accepted'"></b-form-datepicker>
            <b-form-invalid-feedback id="movie-updated-picker-description-feedback-invalid">
              today or future date are accepted
            </b-form-invalid-feedback>
            <b-form-valid-feedback id="movie-updated-picker-description-feedback-valid">
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
import MovieRestfulApiService from '../../services/MovieRestfulApiService'

const movieTitleRegex = helpers.regex('movieTitleRegex', /^[a-zA-Z0-9_-]*$/);
const movieSubtitleRegex = helpers.regex('movieSubtitleRegex', /^[a-zA-Z0-9_-]*$/);
const movieDescriptionRegex = helpers.regex('movieDescriptionRegex', /^[a-zA-Z0-9_-]*$/);

export default {
  name: 'AddComponent',
  mixins: [validationMixin],
  data: () => ({
    form: {
      movieTitle: '',
      movieSubtitle: '',
      movieDescription: '',
      movieDebut: '',
      movieCost: 0.0,
      movieRent: 0.0,
      movieRating: 0.0,
      movieUpdated: ''
    },
    minDate: moment()
  }),
  validations: {
    form: {
      movieTitle: {
        required,
        minLength: minLength(1),
        maxLength: maxLength(100),
        movieTitleRegex
      },
      movieSubtitle: {
        maxLength: maxLength(100),
        movieSubtitleRegex
      },
      movieDescription: {
        required,
        minLength: minLength(5),
        maxLength: maxLength(255),
        movieDescriptionRegex
      },
      movieDebut: {
        required
      },
      movieCost: {
        required
      },
      movieRent: {
        required
      },
      movieRating: {
        required
      },
      movieUpdated: {
        required
      }
    }
  },
  methods: {
    onValidateMovieTitleField(movieTitle) {
      const { $dirty, $error } = this.$v.form[movieTitle];
      return $dirty ? !$error : null;
    },
    onValidateMovieSubtitleField(movieSubtitle) {
      const { $dirty, $error } = this.$v.form[movieSubtitle];
      return $dirty ? !$error : null;
    },
    onValidateMovieDescriptionField(movieDescription) {
      const { $dirty, $error } = this.$v.form[movieDescription];
      return $dirty ? !$error : null;
    },
    onValidateMovieDebutField(movieDebut) {
      const { $dirty, $error } = this.$v.form[movieDebut];
      return $dirty ? !$error : null;
    },
    onValidateMovieCostField(movieCost) {
      const { $dirty, $error } = this.$v.form[movieCost];
      return $dirty ? !$error : null;
    },
    onValidateMovieRentField(movieRent) {
      const { $dirty, $error } = this.$v.form[movieRent];
      return $dirty ? !$error : null;
    },
    onValidateMovieRatingField(movieRating) {
      const { $dirty, $error } = this.$v.form[movieRating];
      return $dirty ? !$error : null;
    },
    onValidateMovieUpdatedField(movieUpdated) {
      const { $dirty, $error } = this.$v.form[movieUpdated];
      return $dirty ? !$error : null;
    },
    onResetForm() {
      this.form = {
        movieTitle: '',
        movieSubtitle: '',
        movieDescription: '',
        movieDebut: '',
        movieCost: 0.0,
        movieRent: 0.0,
        movieRating: 0.0,
        movieUpdated: ''
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
      MovieRestfulApiService.create(data)
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
