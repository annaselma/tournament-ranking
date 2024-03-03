package com.betclic.tournament.infrastructure.api

import com.betclic.tournament.domain.model.Player
import com.betclic.tournament.domain.repository.TournamentRepository
import com.betclic.tournament.provider.TournamentRankingService
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.mockito.InjectMocks
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import java.util.*

@SpringJUnitConfig
class TournamentApplicationResourceTest {
    private var tournamentRankingApplication: TournamentRankingService = mock()

    @InjectMocks
    private lateinit var tournamentApplicationResource: TournamentApplicationResource

    val firstPlayer = Player(
        playerId = 134L,
        username = "player92",
        age = 15,
        points = 0)
    val secondPlayer = Player(
        playerId = 137L,
        username = "yushi",
        age = 15,
        points = 165)
    val thirdPlayer = Player(
        playerId = 138L,
        username = "player-Betclic",
        age = 25,
        points = 5600)

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `save player should return code 201 `() {
        val player = Player(
            playerId = 134L,
            username = "player92",
            age = 15,
            points = 0
        )
        `when`(tournamentRankingApplication.savePlayer(player)).thenReturn(any())
        val response = tournamentApplicationResource.savePlayer(player)
        assertEquals(HttpStatus.CREATED, response.statusCode)
    }

    @Test
    fun `update player should return code 200`() {
        val player = Player(
            playerId = 134L,
            username = "player92",
            age = 15,
            points = 0
        )
        `when`(
            tournamentRankingApplication.updatePlayerPoints(
                playerId = player.playerId,
                points = 500
            )
        ).thenReturn(player.copy(points = 500))
        val response = tournamentApplicationResource.updatePlayerPoints(
            playerId = player.playerId,
            points = player.points
        )
        assertEquals(HttpStatus.OK, response.statusCode)
    }

    @Test
    fun `fetchRankedPlayers should return code 200`() {
        val sortedPlayers = listOf(thirdPlayer,secondPlayer,firstPlayer)
        `when`(
            tournamentRankingApplication.getRankedPlayers()
        ).thenReturn(sortedPlayers)
        val response = tournamentApplicationResource.fetchRankedPlayers()
        assertEquals(HttpStatus.OK, response.statusCode)
    }

    @Test
    fun `fetchPlayerById should return code 200`() {
        val player = Player(
            playerId = 134L,
            username = "player92",
            age = 15,
            points = 0
        )
        `when`(
            tournamentRankingApplication.retrievePlayerById(playerId = player.playerId)
        ).thenReturn(player)
        val response = tournamentApplicationResource.fetchPlayerById(playerId = player.playerId)
        assertEquals(HttpStatus.OK, response.statusCode)
    }
}
