package com.mannvaasam.controller;
import com.mannvaasam.model.*; import com.mannvaasam.repo.*; import org.springframework.security.access.prepost.PreAuthorize; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/admin") @PreAuthorize("hasRole('ADMIN')")
public class AdminController { final UserRepository users; final ProductRepository products; final OrderRepository orders; final CategoryRepository cats; public AdminController(UserRepository u,ProductRepository p,OrderRepository o,CategoryRepository c){users=u;products=p;orders=o;cats=c;}
@GetMapping("/stats") public Map<String,Object> stats(){return Map.of("users",users.count(),"products",products.count(),"orders",orders.count(),"categories",cats.count());}
@GetMapping("/users") public List<User> users(){return users.findAll();}
@PatchMapping("/users/{id}/active") public User active(@PathVariable Long id,@RequestParam boolean value){User u=users.findById(id).orElseThrow();u.active=value;return users.save(u);}
@GetMapping("/products") public List<Product> products(){return products.findAll();}
@GetMapping("/orders") public List<Order> orders(){return orders.findAll();}
@PostMapping("/categories") public Category category(@RequestBody Category c){c.id=null;return cats.save(c);}
}