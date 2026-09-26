package com.mannvaasam.model;
import jakarta.persistence.*; import java.time.*;
@Entity @Table(name="users",uniqueConstraints=@UniqueConstraint(columnNames="email"))
public class User { @Id @GeneratedValue(strategy=GenerationType.IDENTITY) public Long id; @Column(nullable=false) public String name; @Column(nullable=false) public String email; @Column(nullable=false) public String passwordHash; @Enumerated(EnumType.STRING) public Role role=Role.BUYER; public String phone; public boolean active=true; public Instant createdAt=Instant.now(); public Instant updatedAt=Instant.now(); }