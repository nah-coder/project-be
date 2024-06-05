package com.example.projectbe.maytinhrepository;

import com.example.projectbe.entity.Category;
import com.example.projectbe.entity.PaymentMethod;
import com.example.projectbe.entity.TransportMethod;
import com.sun.jdi.connect.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportRepository extends JpaRepository<TransportMethod,Integer> {
    @Query("SELECT c FROM TransportMethod c WHERE c.name LIKE %?1%")
    List<TransportMethod> searchTransportMethodBy(String keyword);
}
