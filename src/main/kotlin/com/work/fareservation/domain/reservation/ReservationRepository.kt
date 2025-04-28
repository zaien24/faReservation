package com.work.fareservation.domain.reservation

import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface ReservationRepository : JpaRepository<Reservation, Long> {
    fun findByUserId(userId: Long): List<Reservation>

    fun findByUserIdAndReservedAt(userId: Long, reservedAt: LocalDateTime): Reservation?
}