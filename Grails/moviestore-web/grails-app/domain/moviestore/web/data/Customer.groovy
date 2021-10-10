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

import java.sql.Timestamp

class Customer {

    String code
    String name
    String nickname
    String surname
    String mobile
    String email
    Date birthday
    Timestamp updated

    static constraints = {
        code size: 8..15, blank: false, unique: true, matches: "^[0-9]*"
        name size: 1..127, matches: "^[a-zA-Z-]*"
        nickname size: 1..127, matches: "^[a-zA-Z-]*"
        surname size: 1..127, matches: "^[a-zA-Z-]*"
        mobile size: 10..31, matches: "^[0-9-]*"
        email size: 16..255, email: true, unique: true
    }

    String toString() {
        code
    }
}
