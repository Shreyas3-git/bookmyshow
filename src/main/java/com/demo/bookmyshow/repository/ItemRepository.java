package com.demo.bookmyshow.repository;

import com.demo.bookmyshow.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long>  {
}
