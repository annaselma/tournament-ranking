package com.betclic.tournament

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition
class TournamentRankingApplication

fun main(args: Array<String>) {
	runApplication<TournamentRankingApplication>(*args)
}
