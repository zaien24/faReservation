package com.work.fareservation.infrastructure.reservation

import com.work.fareservation.application.reservation.ReservationUseCase
import com.work.fareservation.domain.reservation.Reservation
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
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
}

data class RegisterReservationRequest(
    val userId: Long,
    val reservedAt: LocalDateTime,
)