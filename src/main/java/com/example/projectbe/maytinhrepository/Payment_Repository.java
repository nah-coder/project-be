package com.example.projectbe.maytinhrepository;

import com.example.projectbe.entity.Category;
import com.example.projectbe.entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Payment_Repository extends JpaRepository<PaymentMethod,Integer> {
    @Query("SELECT c FROM PaymentMethod c WHERE c.name LIKE %?1%")
    List<PaymentMethod> searchPaymentMethodBy(String keyword);
}
