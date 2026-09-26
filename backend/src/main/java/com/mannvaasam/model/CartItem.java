package com.mannvaasam.model;
import jakarta.persistence.*; import java.math.*;
@Entity @Table(name="cart_items",uniqueConstraints=@UniqueConstraint(columnNames={"cart_id","product_id"}))
public class CartItem { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id; @ManyToOne(optional=false) public Cart cart; @ManyToOne(optional=false) public Product product; @Column(nullable=false) public Integer quantity; @Column(nullable=false,precision=12,scale=2) public BigDecimal priceSnapshot; }