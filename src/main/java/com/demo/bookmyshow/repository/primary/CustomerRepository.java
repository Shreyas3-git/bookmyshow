package com.demo.bookmyshow.repository.primary;

import com.demo.bookmyshow.entity.primary.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
