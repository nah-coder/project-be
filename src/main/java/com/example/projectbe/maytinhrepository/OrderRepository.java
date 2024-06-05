package com.example.projectbe.maytinhrepository;

import com.example.projectbe.entity.Category;
import com.example.projectbe.entity.Orders;
import com.example.projectbe.entity.OrdersTransport;
import com.example.projectbe.projection.Ioder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Integer> {
    @Query(value = "SELECT\n" +
            "    o.ID,\n" +
            "    o.IDORDERS,\n" +
            "    o.ORDERS_DATE,\n" +
            "    o.IDCUSTOMER,\n" +
            "    o.TOTAL_MONEY,\n" +
            "    o.NOTES AS order_notes,\n" +
            "    o.NAME_RECIVER,\n" +
            "    o.ADDRESS,\n" +
            "    o.PHONE,\n" +
            "    pm.NAME AS paymentmethodname,\n" +
            "    pm.NOTES AS paymentmethodnotes,\n" +
            "    op.TOTAL AS orderspaymenttotal,\n" +
            "    tm.NAME AS transportmethodname,\n" +
            "    tm.NOTES AS transportmethodnotes,\n" +
            "    ot.TOTAL AS orderstransporttotal\n" +
            "FROM\n" +
            "    orders o\n" +
            "LEFT JOIN\n" +
            "    orders_payment op ON o.ID = op.IDORD\n" +
            "LEFT JOIN\n" +
            "    payment_method pm ON op.IDPAYMENT = pm.ID\n" +
            "LEFT JOIN\n" +
            "    orders_transport ot ON o.ID = ot.IDORD\n" +
            "LEFT JOIN\n" +
            "    transport_method tm ON ot.IDTRANSPORT = tm.ID\n" +
            "WHERE\n" +
            "    o.ID = :ID\n"
            ,nativeQuery = true)
    List<Ioder> findbyidorderdetail(@Param("ID") int ID);
    @Query(value = "SELECT \n" +
            "    od.ID AS orderDetailsId,\n" +
            "    p.NAME AS product_name,\n" +
            "    p.PRICE AS product_price,\n" +
            "    p.IMAGE AS product_image\n" +
            "FROM \n" +
            "    orders o\n" +
            "LEFT JOIN \n" +
            "    orders_details od ON o.ID = od.IDORD\n" +
            "LEFT JOIN \n" +
            "    product p ON od.IDPRODUCT = p.ID\n" +
            "WHERE \n" +
            "    o.ID = :ID\n"
            ,nativeQuery = true)
    List<Ioder> findbyidorderdetailcate(@Param("ID") int ID);

    @Query("SELECT o FROM OrdersTransport o")
    List<OrdersTransport> findAllOrders();

    @Query("SELECT c FROM Orders c WHERE c.nameReciver LIKE %?1%")
    List<Orders> searchOrdersBy(String keyword);
}
