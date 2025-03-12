package com.demo.bookmyshow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item
{
    @Id
    @GeneratedValue(generator = "native",strategy = GenerationType.AUTO)
    @Column(name = "item_id",columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "catagory",columnDefinition = "VARCHAR(100)")
    private String catagory;

    @Column(name = "name",columnDefinition = "VARCHAR(100)")
    private String name;

    @Column(name = "quantity",columnDefinition = "INT")
    private Integer quantity;

    @Column(name = "price",columnDefinition = "DOUBLE")
    private Double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "show_id")
    private Show shows;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id")
    private Booking cartItems;
}
