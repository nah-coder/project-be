package com.example.projectbe.maytinhService;

import com.example.projectbe.maytinhrepository.OrderTransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.projectbe.projection.TransportProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersTransportService {
    @Autowired
    OrderTransportRepository orderTransportRepository;

    public List<TransportProjection> getTransportMethodsByOrderId(int id) {
        return orderTransportRepository.findTransportByOrderId(id);
    }
}
