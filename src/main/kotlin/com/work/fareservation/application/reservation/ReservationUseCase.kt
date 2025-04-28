package com.work.fareservation.application.reservation

import com.work.fareservation.common.exception.BusinessException
import com.work.fareservation.domain.reservation.Reservation
import com.work.fareservation.domain.reservation.ReservationRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ReservationUseCase(
    private val reservationRepository: ReservationRepository,
) {

    fun registerReservation(userId: Long, reservedAt: LocalDateTime): Reservation {
        // 1. 중복 예약 여부 확인
        val existing = reservationRepository.findByUserIdAndReservedAt(userId, reservedAt)
        if (existing != null) {
            throw BusinessException("이미 해당 시간에 예약이 존재합니다.")
        }

        // 2. 예약 저장
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