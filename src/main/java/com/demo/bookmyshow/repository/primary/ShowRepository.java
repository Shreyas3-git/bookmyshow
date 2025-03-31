package com.demo.bookmyshow.repository.primary;

import com.demo.bookmyshow.entity.primary.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show,Long> {
}
