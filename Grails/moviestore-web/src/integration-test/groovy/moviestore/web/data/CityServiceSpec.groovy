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

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback

import spock.lang.Specification

import org.hibernate.SessionFactory

@Integration
@Rollback
class CityServiceSpec
        extends Specification {

    CityService cityService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new City(...).save(flush: true, failOnError: true)
        //new City(...).save(flush: true, failOnError: true)
        //City city = new City(...).save(flush: true, failOnError: true)
        //new City(...).save(flush: true, failOnError: true)
        //new City(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //city.id
    }

    void "test get"() {
        setupData()

        expect:
        cityService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<City> cityList = cityService.list(max: 2, offset: 2)

        then:
        cityList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        cityService.count() == 5
    }

    void "test delete"() {
        Long cityId = setupData()

        expect:
        cityService.count() == 5

        when:
        cityService.delete(cityId)
        sessionFactory.currentSession.flush()

        then:
        cityService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        City city = new City()
        cityService.save(city)

        then:
        city.id != null
    }
}
