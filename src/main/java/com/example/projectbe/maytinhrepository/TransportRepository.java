package com.example.projectbe.maytinhrepository;

import com.example.projectbe.entity.PaymentMethod;
import com.example.projectbe.entity.TransportMethod;
import com.sun.jdi.connect.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository extends JpaRepository<TransportMethod,Integer> {

}
