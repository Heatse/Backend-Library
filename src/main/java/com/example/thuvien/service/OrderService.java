package com.example.thuvien.service;

import java.util.List;

import com.example.thuvien.Dto.OrderDto;

public interface OrderService {

	List<OrderDto> getAllOderOfBook(Long bookId);

	void deleteOrder(Long orderId);

	void createOrderOfBook(Long userId, String bookImg, Long bookId, String booktitle, String total);
}