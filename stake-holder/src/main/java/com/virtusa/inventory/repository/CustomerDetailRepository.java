package com.virtusa.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.inventory.modal.CustomerDetail;

public interface CustomerDetailRepository extends JpaRepository<CustomerDetail,Integer> {

}
