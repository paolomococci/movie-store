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

class Iso3166Controller {

    Iso3166Service iso3166Service

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond iso3166Service.list(params), model:[iso3166Count: iso3166Service.count()]
    }

    def show(Long id) {
        respond iso3166Service.get(id)
    }

    def create() {
        respond new Iso3166(params)
    }

    def save(Iso3166 iso3166) {
        if (iso3166 == null) {
            notFound()
            return
        }

        try {
            iso3166Service.save(iso3166)
        } catch (ValidationException e) {
            respond iso3166.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'iso3166.label', default: 'Iso3166'), iso3166.id])
                redirect iso3166
            }
            '*' { respond iso3166, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond iso3166Service.get(id)
    }

    def update(Iso3166 iso3166) {
        if (iso3166 == null) {
            notFound()
            return
        }

        try {
            iso3166Service.save(iso3166)
        } catch (ValidationException e) {
            respond iso3166.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'iso3166.label', default: 'Iso3166'), iso3166.id])
                redirect iso3166
            }
            '*'{ respond iso3166, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        iso3166Service.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'iso3166.label', default: 'Iso3166'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'iso3166.label', default: 'Iso3166'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
