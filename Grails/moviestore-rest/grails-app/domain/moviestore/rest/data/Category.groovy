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
        uri = "/api/category"
)
class Category {

    String code
    String name
    String description
    Timestamp updated

    static hasMany = [
            movies: Movie
    ]

    static constraints = {
        code size: 8..15, blank: false, unique: true, matches: "^[0-9]*"
        name size: 1..127, matches: "^[a-zA-Z_-]*"
        description size: 255, matches: "^[a-zA-Z]*[a-zA-Z0-9 -]*[a-zA-Z]*"
    }

    String toString() {
        code
    }
}
