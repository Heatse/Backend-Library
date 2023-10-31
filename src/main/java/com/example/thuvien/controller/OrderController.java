package com.example.thuvien.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.thuvien.Dto.OrderDto;
import com.example.thuvien.Dto.ReactDto;
import com.example.thuvien.dao.OrderRepository;
import com.example.thuvien.entity.Order;

import com.example.thuvien.service.OrderService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class OrderController {
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	OrderService orderService;

	@GetMapping("/order/{userId}")
	public ResponseEntity<?> getAllOrderOfBook(@PathVariable(value = "userId") Long userId) {
		List<OrderDto> orderDtos = orderService.getAllOderOfBook(userId);
		return new ResponseEntity<>(orderDtos, HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping("/order/book/{bookId}")
	public ResponseEntity<?> createReact(@PathVariable(value = "bookId") Long bookId, @RequestBody OrderDto oderDto) {
		orderService.createOrderOfBook(oderDto.getUserId(),oderDto.getBook_img(), bookId, oderDto.getBooktitle(), oderDto.getTotal());
		return ResponseEntity.ok(HttpStatus.OK);

	}

	@DeleteMapping("/order/{orderId}")
	public ResponseEntity<?> deteleReactOfBook(@PathVariable(value = "orderId") Long orderId) {
		Order order = orderRepository.findById(orderId).get();

		orderRepository.delete(order);
		return ResponseEntity.ok(HttpStatus.OK);
	}
}
