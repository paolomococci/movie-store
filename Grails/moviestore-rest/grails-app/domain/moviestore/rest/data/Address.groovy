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

import grails.rest.*

import java.sql.Timestamp

@Resource(
        readOnly = false,
        formats = ['json', 'xml'],
        uri = "/api/address"
)
class Address {

    String code
    String type
    String name
    String civic
    String phone
    Timestamp updated

    static hasMany = [
            stores: Store,
            staff: Staff,
            customers: Customer
    ]

    static belongsTo = [
            district: District
    ]

    static constraints = {
        code size: 8..15, blank: false, unique: true, matches: "^[0-9]*"
        type size: 3..255, matches: "^[a-zA-Z]*"
        name size: 1..127, matches: "^[a-zA-Z_-]*"
        civic size: 1..15, matches: "^[a-zA-Z0-9-]*"
        phone size: 3..31, matches: "^[0-9-]*"
    }

    String toString() {
        code
    }
}
