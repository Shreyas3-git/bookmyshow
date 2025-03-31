package com.demo.bookmyshow.repository.primary;

import com.demo.bookmyshow.entity.primary.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Long> {
}
