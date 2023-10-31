package com.example.thuvien.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.thuvien.entity.Order;
import com.example.thuvien.entity.React;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	List<Order> findOrderByUserId(Long userId);

	List<Order> findOrderByUserIdAndBookId(Long userId, Long bookId);

}