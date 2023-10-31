package com.example.thuvien.service;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.thuvien.Dto.OrderDto;
import com.example.thuvien.dao.BookRepository;
import com.example.thuvien.dao.OrderRepository;

import com.example.thuvien.dao.UserRepository;
import com.example.thuvien.entity.Book;
import com.example.thuvien.entity.Order;
import com.example.thuvien.entity.User;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
    ModelMapper modelMapper;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OrderRepository orderRepository;
    
    @Override
    public List<OrderDto> getAllOderOfBook(Long userId){
    	User user = userRepository.findById(userId).get();
    	List<OrderDto> orderDtos= user.getOrders().stream()
    			.map(order ->{
    				OrderDto orderDto= modelMapper.map(order, OrderDto.class);
    				orderDto.setBook_img(order.getBook_img());
    				orderDto.setBooktitle(order.getBook_title());
    				orderDto.setBookId(order.getBook().getId());
    				orderDto.setUserId(order.getUser().getId());
    				return orderDto;
    			}).collect(Collectors.toList());
    	Collections.sort(orderDtos,Comparator.comparing(OrderDto::getTime).reversed());
    	Collections.sort(orderDtos,Comparator.comparing(OrderDto::getDate).reversed());   	
		return orderDtos;  	
    }
    @Override
    public void createOrderOfBook(Long userId,String bookImg, Long bookId,String booktitle,String total) {
    	Order order= new Order();
    	order.setBook_img(bookImg);
    	order.setBook_title(booktitle);
    	order.setTotal(total);
    	order.setDate(LocalDate.now());
        LocalTime tm = LocalTime.now();
        order.setTime(LocalTime.parse(String.format("%02d:%02d:%02d", tm.getHour(), tm.getMinute(), tm.getSecond())));
        order.setUser(userRepository.findById(userId).get());
        order.setBook(bookRepository.findById(bookId).get());
        orderRepository.save(order);
    	
    }
    @Override
    public void deleteOrder(Long orderId){
    	Order order=orderRepository.findById(orderId).get();
    	orderRepository.delete(order);
    }
}