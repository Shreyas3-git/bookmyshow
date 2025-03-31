package com.demo.bookmyshow.repository.primary;

import com.demo.bookmyshow.entity.primary.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
}
