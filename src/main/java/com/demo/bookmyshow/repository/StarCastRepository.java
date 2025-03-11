package com.demo.bookmyshow.repository;

import com.demo.bookmyshow.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarCastRepository extends JpaRepository<Booking,Long> {
}
