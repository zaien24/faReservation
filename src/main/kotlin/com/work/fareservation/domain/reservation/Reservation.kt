package com.work.fareservation.domain.reservation

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
class Reservation(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val userId: Long,

    val reservedAt: LocalDateTime,

    val createdAt: LocalDateTime = LocalDateTime.now(),
)
