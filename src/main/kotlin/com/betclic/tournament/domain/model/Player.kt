package com.betclic.tournament.domain.model

import jakarta.persistence.*

@Entity
@Table(name = "PLAYER")
data class Player(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var playerId:Long,
    @Column(name = "user_name", unique = true, nullable = false)
    val username: String,
    @Column(name = "age", nullable = false)
    val age:Int,
    @Column(name = "points", nullable = true)
    var points: Int)