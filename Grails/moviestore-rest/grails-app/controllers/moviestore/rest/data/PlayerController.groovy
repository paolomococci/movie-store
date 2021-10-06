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
class PlayerController {

    PlayerService playerService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond playerService.list(params), model:[playerCount: playerService.count()]
    }

    def show(Long id) {
        respond playerService.get(id)
    }

    @Transactional
    def save(Player player) {
        if (player == null) {
            render status: NOT_FOUND
            return
        }
        if (player.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond player.errors
            return
        }

        try {
            playerService.save(player)
        } catch (ValidationException e) {
            respond player.errors
            return
        }

        respond player, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Player player) {
        if (player == null) {
            render status: NOT_FOUND
            return
        }
        if (player.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond player.errors
            return
        }

        try {
            playerService.save(player)
        } catch (ValidationException e) {
            respond player.errors
            return
        }

        respond player, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null || playerService.delete(id) == null) {
            render status: NOT_FOUND
            return
        }

        render status: NO_CONTENT
    }
}
