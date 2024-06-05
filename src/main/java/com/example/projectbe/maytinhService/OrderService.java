package com.example.projectbe.maytinhService;

import com.example.projectbe.dto.CategoryDTO;
import com.example.projectbe.dto.OrderDTO;
import com.example.projectbe.dto.OrderDetailDTO;
import com.example.projectbe.entity.Category;
import com.example.projectbe.entity.Orders;
import com.example.projectbe.entity.OrdersDetails;
import com.example.projectbe.entity.OrdersTransport;
import com.example.projectbe.maytinhrepository.OrderDetailRepository;
import com.example.projectbe.maytinhrepository.OrderRepository;
import com.example.projectbe.projection.Ioder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;

    public List<Orders> findAll(){
        List<Orders> orders = orderRepository.findAll();
        return orders;
    }

    public List<OrdersTransport> findAlll(){
        List<OrdersTransport>ordersTransports = orderRepository.findAllOrders();
        return ordersTransports;
    }

    public List<Ioder> findbyidorderdetail(int id){
        return orderRepository.findbyidorderdetail(id);
    }

    public List<Ioder> findbyidorderdetailcate(int id){
        return orderRepository.findbyidorderdetailcate(id);
    }

    public Orders findbyidorder(int id){
        Optional<Orders> optionalOrders = orderRepository.findById(id);
        if(optionalOrders.isEmpty()){
            System.out.println("không tìm thấy sinh viên");
            return null;
        }
        return optionalOrders.get();
    }


    public Page<Orders> findAllpage(Integer pageno){
        Pageable pageable = PageRequest.of(pageno-1,4);
        return orderRepository.findAll(pageable);
    }

    public List<Orders> searchOrder(String keyword){
        return  orderRepository.searchOrdersBy(keyword);
    }

    public Page<Orders> searchOrder(String keyword,Integer pageno){
        List list = this.searchOrder(keyword);
        Pageable pageable = PageRequest.of(pageno-1,2);
        Integer start = (int) pageable.getOffset();
        Integer end = (int)(pageable.getOffset() + pageable.getPageSize() > list.size() ? list.size() : pageable.getOffset() + pageable.getPageSize());
        list = list.subList(start, end);
        return new PageImpl<Orders>(list,pageable,this.searchOrder(keyword).size());
    }

//    public List<Category> findbyname(String name){
//        List<Category> categories = maytinhRepository.findbyname(name);
//        return categories;
//    }

    public String save(OrderDTO orderDTO) {
        Orders orders = new Orders();
        orders.setId(orderDTO.getId());
        orders.setIdorders(orderDTO.getIdorder());
        orders.setOrdersDate(LocalDateTime.parse(orderDTO.getOrdersDate()));
        orders.setIdcustomer(orderDTO.getIdcustomer());
        orders.setTotalMoney(orderDTO.getTotalMoney());
        orders.setNotes(orderDTO.getNotes());
        orders.setNameReciver(orderDTO.getNameReciver());
        orders.setAddress(orderDTO.getAddress());
        orders.setPhone(orderDTO.getPhone());
        orderRepository.save(orders);
        return "Thêm thành công";
    }

    public String savedetail(int Idord, OrderDetailDTO orderDetailDTO) {
        OrdersDetails ordersDetails1 = new OrdersDetails();
//        ordersDetails1.setId(id);
        ordersDetails1.setIdord(Idord);
        ordersDetails1.setIdproduct(orderDetailDTO.getIdproduct());
        orderDetailRepository.save(ordersDetails1);
        return "Thêm thành công";
    }

    public String update(int id , OrderDTO orderDTO){
        boolean idexist = orderRepository.existsById(id);
        if(!idexist) return "Không tìm thấy id này !";
        Orders orders = new Orders();
        orders.setId(id);
        orders.setIdorders(orderDTO.getIdorder());
        orders.setOrdersDate(LocalDateTime.parse(orderDTO.getOrdersDate()));
        orders.setIdcustomer(orderDTO.getIdcustomer());
        orders.setTotalMoney(orderDTO.getTotalMoney());
        orders.setNotes(orderDTO.getNotes());
        orders.setNameReciver(orderDTO.getNameReciver());
        orders.setAddress(orderDTO.getAddress());
        orders.setPhone(orderDTO.getPhone());
        orderRepository.save(orders);
        return "Update thành công";
    }

    public String Delete(int id){
        boolean idexist = orderRepository.existsById(id);
        if(!idexist) return "Không có id này !";
        orderRepository.deleteById(id);
        return "Xóa thành công";
    }

    public OrdersDetails findbyidorderdetailfuction(int id){
        Optional<OrdersDetails> optionalOrdersDetails = orderDetailRepository.findById(id);
        if(optionalOrdersDetails.isEmpty()){
            System.out.println("không tìm thấy sinh viên");
            return null;
        }
        return optionalOrdersDetails.get();
    }

    public String Delete_orderdetail(int id){
//        boolean idexist = orderRepository.existsById(id);
//        if(!idexist)
//            return "Không có id này !";
        orderDetailRepository.deleteById(id);
        return "Xóa thành công";
    }

}
