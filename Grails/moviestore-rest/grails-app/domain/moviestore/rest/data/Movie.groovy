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

import com.fasterxml.jackson.annotation.JsonFormat

import grails.rest.*

import java.sql.Date
import java.sql.Time
import java.sql.Timestamp

@Resource(
        readOnly = false,
        formats = ['json', 'xml'],
        uri = "/api/movie"
)
class Movie {

    String code
    String title
    String subtitle
    String description

    @JsonFormat(pattern = "yyyy-MM-dd")
    Date comeOut

    @JsonFormat(pattern = "HH:mm:ss")
    Time duration

    Double cost
    Double rent
    Double rating
    Timestamp updated

    static hasMany = [
            categories: Category,
            contents: Content,
            directors: Director,
            inventories: Inventory,
            languages: Language,
            players: Player,
            producers: Producer
    ]

    static constraints = {
        code size: 8..12, blank: false, unique: true
        title size: 1..127
        subtitle size: 8..127
        description size: 16..255
        rating max: 1, min: 0
    }

    String toString() {
        code
    }
}
