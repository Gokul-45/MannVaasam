package com.mannvaasam.controller;
import com.mannvaasam.model.*; import com.mannvaasam.repo.*; import com.mannvaasam.service.CurrentUserService; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/buyers/wishlist") public class WishlistController { final WishlistRepository wish; final ProductRepository products; final CurrentUserService current; public WishlistController(WishlistRepository w,ProductRepository p,CurrentUserService c){wish=w;products=p;current=c;}
@GetMapping public List<Wishlist> all(){return wish.findByBuyerOrderByCreatedAtDesc(current.get());}
@PostMapping("/{productId}") public Wishlist add(@PathVariable Long productId){Product p=products.findById(productId).orElseThrow();return wish.findByBuyerAndProduct(current.get(),p).orElseGet(()->{Wishlist w=new Wishlist();w.buyer=current.get();w.product=p;return wish.save(w);});}
@DeleteMapping("/{productId}") public Map<String,String> remove(@PathVariable Long productId){Product p=products.findById(productId).orElseThrow();wish.findByBuyerAndProduct(current.get(),p).ifPresent(wish::delete);return Map.of("message","Removed from wishlist");}}
