package com.demo.bookmyshow.repository.primary;

import com.demo.bookmyshow.entity.primary.Theather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatherRepository extends JpaRepository<Theather,Long> {
}
