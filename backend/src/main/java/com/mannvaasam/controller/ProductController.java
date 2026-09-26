package com.mannvaasam.controller;
import com.mannvaasam.model.*; import com.mannvaasam.repo.*; import com.mannvaasam.service.DeliveryService; import org.springframework.data.domain.*; import org.springframework.web.bind.annotation.*; import java.math.*; import java.util.*;
@RestController @RequestMapping("/api/products") public class ProductController {
 final ProductRepository r; final DeliveryService delivery; final AddressRepository addresses; final UserRepository users;
 ProductController(ProductRepository r,DeliveryService d,AddressRepository a,UserRepository u){this.r=r;delivery=d;addresses=a;users=u;}
 @GetMapping public Page<Product> list(@RequestParam(defaultValue="0")int page,@RequestParam(defaultValue="12")int size,@RequestParam(required=false)String keyword,@RequestParam(required=false)Long categoryId,@RequestParam(required=false)BigDecimal minPrice,@RequestParam(required=false)BigDecimal maxPrice,@RequestParam(required=false)Long addressId){
  List<Product> all=r.findAll().stream().filter(x->x.active).filter(x->keyword==null||keyword.isBlank()||x.name.toLowerCase().contains(keyword.toLowerCase())||(x.description!=null&&x.description.toLowerCase().contains(keyword.toLowerCase()))).filter(x->categoryId==null||(x.category!=null&&x.category.id.equals(categoryId))).filter(x->minPrice==null||x.price.compareTo(minPrice)>=0).filter(x->maxPrice==null||x.price.compareTo(maxPrice)<=0).filter(x->addressId==null||addresses.findById(addressId).map(a->delivery.deliverable(x,a)).orElse(false)).sorted(Comparator.comparing((Product x)->x.createdAt,Comparator.nullsLast(Comparator.naturalOrder())).reversed()).toList();
  int from=Math.min(page*size,all.size()),to=Math.min(from+size,all.size());return new PageImpl<>(all.subList(from,to),PageRequest.of(page,size),all.size());
 }
 @GetMapping("/{id}") Product one(@PathVariable Long id){return r.findById(id).filter(x->x.active).orElseThrow();}
}