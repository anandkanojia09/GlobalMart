package com.globalmart.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.globalmart.app.dto.Payment;



@Component
public interface PaymentRepo extends JpaRepository<Payment, Integer> {

}
