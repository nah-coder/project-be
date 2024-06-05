package com.example.projectbe.maytinhrepository;

import com.example.projectbe.entity.Category;
import com.example.projectbe.entity.Customer;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT c FROM Customer c WHERE c.name LIKE %?1%")
    List<Customer> searchCustomerBy(String keyword);
}
