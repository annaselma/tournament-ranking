package com.betclic.tournament.provider

import com.betclic.tournament.domain.model.Player
import com.betclic.tournament.domain.repository.TournamentRepository
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig
import java.util.*

@SpringJUnitConfig
class TournamentRankingServiceTest{
    private lateinit var tournamentRankingService: TournamentRankingService
    private var tournamentRepository: TournamentRepository = mock()

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        tournamentRankingService = TournamentRankingService(tournamentRepository)
    }

    @Test
    fun `Save player should save player`() {
        val player = Player(
            playerId = 134L,
            username = "player92",
            age = 15,
            points = 0)
        `when`(tournamentRepository.save(player)).thenReturn(player)
        val savedPlayer = tournamentRankingService.savePlayer(player)
        assertEquals(player,savedPlayer)
    }

    @Test
    fun `updatePlayerPoints should update player points`() {
        //Given
        val player = Player(
            playerId = 134L,
            username = "player92",
            age = 15,
            points = 0)
        //when + then
        `when`(tournamentRepository.save(any())).thenReturn(player)
        `when`(tournamentRepository.findById(any())).thenReturn(Optional.of(player))
        val newScore = 234
        val savedPlayer = tournamentRankingService.updatePlayerPoints(player.playerId,newScore)
        assertEquals(savedPlayer.points, newScore)
    }

    @Test
    fun `retrievePlayerById should return player`() {
        val player = Player(
            playerId = 134L,
            username = "player92",
            age = 15,
            points = 0)
        `when`(tournamentRepository.findById(any())).thenReturn(Optional.of(player))
        val result = tournamentRankingService.retrievePlayerById(player.playerId)
        assertEquals(result, player)
    }

    @Test
    fun `getRankedPlayers should return a list of players sorted descending by point `() {
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
        val players = mutableListOf(firstPlayer,secondPlayer,thirdPlayer)
        `when`(tournamentRepository.findAll()).thenReturn(players)
        val result = tournamentRankingService.getRankedPlayers()
        val sortedList = listOf(thirdPlayer,secondPlayer,firstPlayer)
        assertEquals(result, sortedList)
    }

    @Test
    fun `deleteAllPlayers should remove all players from the database`() {
        tournamentRankingService.deleteAllPlayers()
        verify(tournamentRepository).deleteAll()
    }
}