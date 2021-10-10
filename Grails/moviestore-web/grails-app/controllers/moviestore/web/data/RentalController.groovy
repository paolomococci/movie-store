/**
 *
 * Copyright 2020 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package moviestore.web.data

import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.*

class RentalController {

    RentalService rentalService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond rentalService.list(params), model:[rentalCount: rentalService.count()]
    }

    def show(Long id) {
        respond rentalService.get(id)
    }

    def create() {
        respond new Rental(params)
    }

    def save(Rental rental) {
        if (rental == null) {
            notFound()
            return
        }

        try {
            rentalService.save(rental)
        } catch (ValidationException e) {
            respond rental.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rental.label', default: 'Rental'), rental.id])
                redirect rental
            }
            '*' { respond rental, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond rentalService.get(id)
    }

    def update(Rental rental) {
        if (rental == null) {
            notFound()
            return
        }

        try {
            rentalService.save(rental)
        } catch (ValidationException e) {
            respond rental.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'rental.label', default: 'Rental'), rental.id])
                redirect rental
            }
            '*'{ respond rental, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        rentalService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'rental.label', default: 'Rental'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'rental.label', default: 'Rental'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
