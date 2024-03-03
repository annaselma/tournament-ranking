package com.betclic.tournament.domain.repository

import com.betclic.tournament.domain.model.Player
import org.springframework.data.repository.CrudRepository

interface TournamentRepository: CrudRepository<Player, Long>