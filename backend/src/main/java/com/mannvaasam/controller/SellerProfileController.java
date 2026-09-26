package com.mannvaasam.controller;
import com.mannvaasam.model.*; import com.mannvaasam.repo.*; import com.mannvaasam.service.CurrentUserService; import org.springframework.security.access.prepost.PreAuthorize; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/sellers/profile") @PreAuthorize("hasRole('SELLER')")
public class SellerProfileController { final SellerProfileRepository repo; final CurrentUserService current; public SellerProfileController(SellerProfileRepository r,CurrentUserService c){repo=r;current=c;}
@GetMapping public SellerProfile get(){return repo.findByUserId(current.get().id).orElseThrow();}
@PutMapping public SellerProfile update(@RequestBody SellerProfile in){SellerProfile s=repo.findByUserId(current.get().id).orElseThrow();s.businessName=in.businessName;s.address=in.address;s.contact=in.contact;s.supportedPincodes=in.supportedPincodes;s.latitude=in.latitude;s.longitude=in.longitude;s.deliveryRadiusKm=in.deliveryRadiusKm;s.deliveryDays=in.deliveryDays;return repo.save(s);}}
