package com.work.fareservation.domain.reservation

import org.springframework.data.jpa.repository.JpaRepository

interface ReservationRepository : JpaRepository<Reservation, Long> {
    fun findByUserId(userId: Long): List<Reservation>
}