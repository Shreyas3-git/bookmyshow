package com.demo.bookmyshow.repository.primary;

import com.demo.bookmyshow.entity.primary.StarCast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StarCastRepository extends JpaRepository<StarCast,Long> {
}
