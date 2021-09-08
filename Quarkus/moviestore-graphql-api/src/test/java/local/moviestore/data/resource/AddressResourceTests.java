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

package local.moviestore.data.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class AddressResourceTests {

    private static final String PATH_SIZE;
    private static final String QUERY_ALL_ADDRESSES_TYPE_NAME_CIVIC_PHONE;

    static {
        PATH_SIZE = "allAddresses.size()";
        QUERY_ALL_ADDRESSES_TYPE_NAME_CIVIC_PHONE = "{\"query\":\"{ allAddresses { type name civic phone}}\"}";
    }

    @Test
    //@Disabled
    public void emptyTest() {
        RestAssured.given().body(this.QUERY_ALL_ADDRESSES_TYPE_NAME_CIVIC_PHONE)
                .then().contentType(ContentType.JSON)
                .body(this.PATH_SIZE, Matchers.is(0))
                .statusCode(200);
    }
}
