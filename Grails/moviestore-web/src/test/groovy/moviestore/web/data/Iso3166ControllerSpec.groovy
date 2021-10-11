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

import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import grails.validation.ValidationException

import spock.lang.*

class Iso3166ControllerSpec
        extends Specification
        implements ControllerUnitTest<Iso3166Controller>, DomainUnitTest<Iso3166> {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {
        given:
        controller.iso3166Service = Mock(Iso3166Service) {
            1 * list(_) >> []
            1 * count() >> 0
        }

        when:"The index action is executed"
        controller.index()

        then:"The model is correct"
        !model.iso3166List
        model.iso3166Count == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
        controller.create()

        then:"The model is correctly created"
        model.iso3166!= null
    }

    void "Test the save action with a null instance"() {
        when:"Save is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        controller.save(null)

        then:"A 404 error is returned"
        response.redirectedUrl == '/iso3166/index'
        flash.message != null
    }

    void "Test the save action correctly persists"() {
        given:
        controller.iso3166Service = Mock(Iso3166Service) {
            1 * save(_ as Iso3166)
        }

        when:"The save action is executed with a valid instance"
        response.reset()
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        populateValidParams(params)
        def iso3166 = new Iso3166(params)
        iso3166.id = 1

        controller.save(iso3166)

        then:"A redirect is issued to the show action"
        response.redirectedUrl == '/iso3166/show/1'
        controller.flash.message != null
    }

    void "Test the save action with an invalid instance"() {
        given:
        controller.iso3166Service = Mock(Iso3166Service) {
            1 * save(_ as Iso3166) >> { Iso3166 iso3166 ->
                throw new ValidationException("Invalid instance", iso3166.errors)
            }
        }

        when:"The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        def iso3166 = new Iso3166()
        controller.save(iso3166)

        then:"The create view is rendered again with the correct model"
        model.iso3166 != null
        view == 'create'
    }

    void "Test the show action with a null id"() {
        given:
        controller.iso3166Service = Mock(Iso3166Service) {
            1 * get(null) >> null
        }

        when:"The show action is executed with a null domain"
        controller.show(null)

        then:"A 404 error is returned"
        response.status == 404
    }

    void "Test the show action with a valid id"() {
        given:
        controller.iso3166Service = Mock(Iso3166Service) {
            1 * get(2) >> new Iso3166()
        }

        when:"A domain instance is passed to the show action"
        controller.show(2)

        then:"A model is populated containing the domain instance"
        model.iso3166 instanceof Iso3166
    }

    void "Test the edit action with a null id"() {
        given:
        controller.iso3166Service = Mock(Iso3166Service) {
            1 * get(null) >> null
        }

        when:"The show action is executed with a null domain"
        controller.edit(null)

        then:"A 404 error is returned"
        response.status == 404
    }

    void "Test the edit action with a valid id"() {
        given:
        controller.iso3166Service = Mock(Iso3166Service) {
            1 * get(2) >> new Iso3166()
        }

        when:"A domain instance is passed to the show action"
        controller.edit(2)

        then:"A model is populated containing the domain instance"
        model.iso3166 instanceof Iso3166
    }


    void "Test the update action with a null instance"() {
        when:"Save is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(null)

        then:"A 404 error is returned"
        response.redirectedUrl == '/iso3166/index'
        flash.message != null
    }

    void "Test the update action correctly persists"() {
        given:
        controller.iso3166Service = Mock(Iso3166Service) {
            1 * save(_ as Iso3166)
        }

        when:"The save action is executed with a valid instance"
        response.reset()
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        populateValidParams(params)
        def iso3166 = new Iso3166(params)
        iso3166.id = 1

        controller.update(iso3166)

        then:"A redirect is issued to the show action"
        response.redirectedUrl == '/iso3166/show/1'
        controller.flash.message != null
    }

    void "Test the update action with an invalid instance"() {
        given:
        controller.iso3166Service = Mock(Iso3166Service) {
            1 * save(_ as Iso3166) >> { Iso3166 iso3166 ->
                throw new ValidationException("Invalid instance", iso3166.errors)
            }
        }

        when:"The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(new Iso3166())

        then:"The edit view is rendered again with the correct model"
        model.iso3166 != null
        view == 'edit'
    }

    void "Test the delete action with a null instance"() {
        when:"The delete action is called for a null instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(null)

        then:"A 404 is returned"
        response.redirectedUrl == '/iso3166/index'
        flash.message != null
    }

    void "Test the delete action with an instance"() {
        given:
        controller.iso3166Service = Mock(Iso3166Service) {
            1 * delete(2)
        }

        when:"The domain instance is passed to the delete action"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(2)

        then:"The user is redirected to index"
        response.redirectedUrl == '/iso3166/index'
        flash.message != null
    }
}
