package com.mannvaasam.model;
import jakarta.persistence.*; import java.math.*;
@Entity @Table(name="order_items")
public class OrderItem { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id; @ManyToOne(optional=false) public Order order; @ManyToOne(optional=false) public Product product; @Column(nullable=false) public String productName,unit; @Column(nullable=false) public Integer quantity; @Column(nullable=false,precision=12,scale=2) public BigDecimal unitPrice,subtotal; }