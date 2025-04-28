package com.work.fareservation.application.reservation

import com.work.fareservation.domain.reservation.Reservation
import com.work.fareservation.domain.reservation.ReservationRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ReservationUseCase(
    private val reservationRepository: ReservationRepository,
) {

    fun registerReservation(userId: Long, reservedAt: LocalDateTime): Reservation {
        val reservation = Reservation(
            userId = userId,
            reservedAt = reservedAt
        )

        return reservationRepository.save(reservation)
    }

    fun getReservationsByUser(userId: Long): List<Reservation> {
        return reservationRepository.findByUserId(userId)
    }

    fun cancelReservation(reservationId: Long) {
        reservationRepository.deleteById(reservationId)
    }
}