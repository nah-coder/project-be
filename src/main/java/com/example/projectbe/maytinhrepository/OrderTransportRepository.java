package com.example.projectbe.maytinhrepository;

import com.example.projectbe.entity.OrdersTransport;
import com.example.projectbe.projection.TransportProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderTransportRepository extends JpaRepository<OrdersTransport, Integer> {
    @Query("SELECT tm.name AS name, ot.total AS total FROM OrdersTransport ot JOIN TransportMethod tm ON ot.idtransport = tm.id WHERE ot.idord = :id")
    List<TransportProjection> findTransportByOrderId(@Param("id") int id);
}
