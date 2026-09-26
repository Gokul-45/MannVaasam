package com.mannvaasam.model;
import jakarta.persistence.*; import java.math.*; import java.time.*;
@Entity @Table(name="payments")
public class Payment { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id; @OneToOne(optional=false) public Order order; @Enumerated(EnumType.STRING) public PaymentMethod method; @Enumerated(EnumType.STRING) public PaymentStatus status; @Column(precision=12,scale=2) public BigDecimal amount; public String transactionReference; public Instant createdAt=Instant.now(); }