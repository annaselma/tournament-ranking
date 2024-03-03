@file:Suppress("NAME_SHADOWING")

package com.betclic.tournament.infrastructure.api

import com.betclic.tournament.domain.model.Player
import com.betclic.tournament.provider.TournamentRankingService
import io.swagger.v3.oas.annotations.Operation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Suppress("NAME_SHADOWING")
@RestController
@RequestMapping(
    value = ["/api/v1/players"],
    produces = [APPLICATION_JSON_VALUE]
)
class TournamentApplicationResource(@Autowired private val tournamentService: TournamentRankingService) {

    @PostMapping(consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
    @Operation(
        method = "POST",
        summary = " Adding a player",
        description = "Add player to participate in the tournament"
    )
    fun savePlayer(@RequestBody player: Player): ResponseEntity<Player> {
        val player = tournamentService.savePlayer(player)
        return ResponseEntity(player, HttpStatus.CREATED)
    }

    @PutMapping(value = ["/{playerId}/points"], produces = [APPLICATION_JSON_VALUE])
    @Operation(
        method = "PUT",
        summary = "Update player points",
        description = "Update player points by playerId and points"
    )
    fun updatePlayerPoints(@PathVariable playerId: Long, @RequestParam points: Int): ResponseEntity<Player> {
        val player = tournamentService.updatePlayerPoints(playerId, points)
        return ResponseEntity(player, HttpStatus.OK)
    }

    @GetMapping(value= ["/{playerId}"], produces = [APPLICATION_JSON_VALUE])
    @Operation(
        method = "GET",
        summary = "fetch player informations by playerId",
        description = "fetch player by playerId"
    )
    fun fetchPlayerById(@PathVariable playerId: Long): ResponseEntity<Player> {
        val player = tournamentService.retrievePlayerById(playerId)
        return ResponseEntity(player, HttpStatus.OK)
    }

    @GetMapping("/ranked")
    @Operation(
        method = "GET",
        summary = "fetch players sorted by rank",
        description = "retrieve a list of players sorted by rank"
    )
    fun fetchRankedPlayers(): ResponseEntity<List<Player>> {
        val players = tournamentService.getRankedPlayers()
        return ResponseEntity(players, HttpStatus.OK)
    }

    @DeleteMapping
    fun removeAllPlayers(): ResponseEntity<Unit> {
        tournamentService.deleteAllPlayers()
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}