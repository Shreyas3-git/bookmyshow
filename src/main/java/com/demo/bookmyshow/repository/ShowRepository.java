package com.demo.bookmyshow.repository;

import com.demo.bookmyshow.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Booking,Long> {
}
