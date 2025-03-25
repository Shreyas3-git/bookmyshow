package com.demo.bookmyshow.repository;

import com.demo.bookmyshow.entity.Theather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatherRepository extends JpaRepository<Theather,Long> {
}
