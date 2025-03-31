package com.demo.bookmyshow.repository.primary;

import com.demo.bookmyshow.entity.primary.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepository extends JpaRepository<Screen,Long>  {
}
