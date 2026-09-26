package com.mannvaasam.controller;
import com.mannvaasam.model.Order; import com.mannvaasam.service.OrderService; import org.springframework.http.MediaType; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/orders") public class OrderController {
 private final OrderService s; public OrderController(OrderService s){this.s=s;}
 @GetMapping public List<Order> mine(){return s.myOrders();}
 @PostMapping public Order checkout(@RequestBody Map<String,String> b){return s.checkout(Long.valueOf(b.get("addressId")),b.getOrDefault("paymentMethod","COD"));}
 @GetMapping("/{id}") public Order one(@PathVariable Long id){return s.getBuyer(id);}
 @PostMapping("/{id}/cancel") public Order cancel(@PathVariable Long id){return s.cancel(id);}
 @GetMapping(value="/{id}/print",produces=MediaType.TEXT_HTML_VALUE) public String print(@PathVariable Long id){return s.print(id);}
}