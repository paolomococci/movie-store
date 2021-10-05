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

package moviestore.rest.data

import grails.validation.ValidationException

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class Iso3166Controller {

    Iso3166Service iso3166Service

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond iso3166Service.list(params), model:[iso3166Count: iso3166Service.count()]
    }

    def show(Long id) {
        respond iso3166Service.get(id)
    }

    @Transactional
    def save(Iso3166 iso3166) {
        if (iso3166 == null) {
            render status: NOT_FOUND
            return
        }
        if (iso3166.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond iso3166.errors
            return
        }

        try {
            iso3166Service.save(iso3166)
        } catch (ValidationException e) {
            respond iso3166.errors
            return
        }

        respond iso3166, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Iso3166 iso3166) {
        if (iso3166 == null) {
            render status: NOT_FOUND
            return
        }
        if (iso3166.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond iso3166.errors
            return
        }

        try {
            iso3166Service.save(iso3166)
        } catch (ValidationException e) {
            respond iso3166.errors
            return
        }

        respond iso3166, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null || iso3166Service.delete(id) == null) {
            render status: NOT_FOUND
            return
        }

        render status: NO_CONTENT
    }
}
