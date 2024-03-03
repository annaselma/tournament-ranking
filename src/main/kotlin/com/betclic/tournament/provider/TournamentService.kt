package com.betclic.tournament.provider

import com.betclic.tournament.domain.model.Player
import com.betclic.tournament.domain.repository.TournamentRepository
import org.springframework.stereotype.Service

@Service
class TournamentRankingService(private val tournamentRepository: TournamentRepository) {
    fun savePlayer(player: Player): Player = tournamentRepository.save(player)

    fun updatePlayerPoints(playerId: Long, points: Int): Player {
        val retrievedPlayer = tournamentRepository.findById(playerId)
        points.also { retrievedPlayer.get().points = it }
        return tournamentRepository.save(retrievedPlayer.get())
    }

    fun retrievePlayerById(playerId: Long): Player = tournamentRepository.findById(playerId).get()
    fun getRankedPlayers(): List<Player> =
        tournamentRepository.findAll().sortedByDescending { it.points }

    fun deleteAllPlayers() {
            tournamentRepository.deleteAll()
        }
}