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

import local.moviestore.data.model.Customer;
import local.moviestore.data.repository.CustomerRepository;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;

import javax.inject.Inject;
import java.util.List;

@GraphQLApi
public class CustomerResource {

    @Inject
    CustomerRepository customerRepository;

    @Query(value = "allCustomers")
    @Description(value = "returns a list of all customers registered in the system")
    public List<Customer> allCustomers() {
        // TODO and, in the future, replace List with CompletionStage
        return this.customerRepository.allCustomers();
    }
}
