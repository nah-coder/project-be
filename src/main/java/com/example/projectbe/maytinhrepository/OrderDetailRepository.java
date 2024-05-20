package com.example.projectbe.maytinhrepository;

import com.example.projectbe.entity.OrdersDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrdersDetails,Integer> {
}
