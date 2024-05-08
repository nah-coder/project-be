package com.example.projectbe.maytinhService;

import com.example.projectbe.dto.CategoryDTO;
import com.example.projectbe.dto.CustommerDTO;
import com.example.projectbe.entity.Category;
import com.example.projectbe.entity.Customer;
import com.example.projectbe.maytinhrepository.CustomerRepository;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public List<Customer> findAll(){
        List<Customer> customers = customerRepository.findAll();
        return  customers;
    }
    public Customer findbyidcustom(int id){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isEmpty()){
            System.out.println("không tìm thấy khách hàng");
            return null;
        }
        return optionalCustomer.get();
    }

//    public List<Category> findbyname(String name){
//        List<Category> categories = maytinhRepository.findbyname(name);
//        return categories;
//    }

    public String save(CustommerDTO custommerDTO) {
        Customer customer = new Customer();
        customer.setId(custommerDTO.getId());
        customer.setName(custommerDTO.getName());
        customer.setUsername(custommerDTO.getUsername());
        customer.setPassword(custommerDTO.getPassword());
        customer.setAddress(custommerDTO.getAddress());
        customer.setEmail(custommerDTO.getEmail());
        customer.setPhone(custommerDTO.getPhone());
        customer.setCreatedDate(LocalDateTime.parse(custommerDTO.getCreatedDate()));
        customer.setIsactive((byte) custommerDTO.getIsactive());
        customerRepository.save(customer);
        return "Thêm thành công";
    }

    public String update(int id, CustommerDTO custommerDTO){
        boolean idexist = customerRepository.existsById(id);
        if(!idexist) return "Không tìm thấy id này !";
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(custommerDTO.getName());
        customer.setUsername(custommerDTO.getUsername());
        customer.setPassword(custommerDTO.getPassword());
        customer.setAddress(custommerDTO.getAddress());
        customer.setEmail(custommerDTO.getEmail());
        customer.setPhone(custommerDTO.getPhone());
        customer.setCreatedDate(LocalDateTime.parse(custommerDTO.getCreatedDate()));
        customer.setIsactive((byte) custommerDTO.getIsactive());
        customerRepository.save(customer);
        return "Update thành công";
    }

    public String Delete(int id){
        boolean idexist = customerRepository.existsById(id);
        if(!idexist) return "Không có id này !";
        customerRepository.deleteById(id);
        return "Xóa thành công";
    }
}
