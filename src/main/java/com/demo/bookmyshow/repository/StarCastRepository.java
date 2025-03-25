package com.demo.bookmyshow.repository;

import com.demo.bookmyshow.entity.StarCast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StarCastRepository extends JpaRepository<StarCast,Long> {
}
