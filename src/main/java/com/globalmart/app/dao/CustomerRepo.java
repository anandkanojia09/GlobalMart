package com.globalmart.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globalmart.app.dto.CustomerDetails;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerDetails, Integer> {

}
