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
class Iso3166ServiceSpec
        extends Specification {

    Iso3166Service iso3166Service
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Iso3166(...).save(flush: true, failOnError: true)
        //new Iso3166(...).save(flush: true, failOnError: true)
        //Iso3166 iso3166 = new Iso3166(...).save(flush: true, failOnError: true)
        //new Iso3166(...).save(flush: true, failOnError: true)
        //new Iso3166(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //iso3166.id
    }

    void "test get"() {
        setupData()

        expect:
        iso3166Service.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Iso3166> iso3166List = iso3166Service.list(max: 2, offset: 2)

        then:
        iso3166List.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        iso3166Service.count() == 5
    }

    void "test delete"() {
        Long iso3166Id = setupData()

        expect:
        iso3166Service.count() == 5

        when:
        iso3166Service.delete(iso3166Id)
        sessionFactory.currentSession.flush()

        then:
        iso3166Service.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Iso3166 iso3166 = new Iso3166()
        iso3166Service.save(iso3166)

        then:
        iso3166.id != null
    }
}
