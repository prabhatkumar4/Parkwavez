package com.example.paymentservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.paymentservice.entities.MyOrder;

public interface MyOrderRepository extends JpaRepository<MyOrder ,Long > {

	public MyOrder findByOrderId(String orderId);
}
