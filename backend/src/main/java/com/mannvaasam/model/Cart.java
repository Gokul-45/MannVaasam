package com.mannvaasam.model;
import jakarta.persistence.*; import java.time.Instant; import java.util.*;
@Entity @Table(name="carts")
public class Cart { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id; @OneToOne(optional=false) public User user; public Instant updatedAt=Instant.now(); @OneToMany(mappedBy="cart",cascade=CascadeType.ALL,orphanRemoval=true) public List<CartItem> items=new ArrayList<>(); }