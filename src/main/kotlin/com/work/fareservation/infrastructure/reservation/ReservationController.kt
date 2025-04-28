package com.work.fareservation.infrastructure.reservation

import com.work.fareservation.application.reservation.ReservationUseCase
import com.work.fareservation.domain.reservation.Reservation
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/reservations")
class ReservationController(
    private val reservationUseCase: ReservationUseCase,
) {

    @PostMapping
    fun registerReservation(
        @RequestBody request: RegisterReservationRequest
    ): Reservation {
        return reservationUseCase.registerReservation(
            request.userId,
            request.reservedAt
        )
    }

    @GetMapping
    fun getReservations(@RequestParam userId: Long): List<Reservation> {
        return reservationUseCase.getReservationsByUser(userId)
    }

    @DeleteMapping("/{id}")
    fun cancelReservation(@PathVariable id: Long) {
        reservationUseCase.cancelReservation(id)
    }
}

data class RegisterReservationRequest(
    val userId: Long,
    val reservedAt: LocalDateTime,
)