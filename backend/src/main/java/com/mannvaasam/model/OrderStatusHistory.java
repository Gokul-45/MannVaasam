package com.mannvaasam.model;
import jakarta.persistence.*; import java.time.*;
@Entity @Table(name="order_status_history")
public class OrderStatusHistory { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id; @ManyToOne(optional=false) public Order order; @Enumerated(EnumType.STRING) public OrderStatus status; public String note; public String changedBy; public Instant createdAt=Instant.now(); }