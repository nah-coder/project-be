package com.example.projectbe.maytinhService;

import com.example.projectbe.dto.CategoryDTO;
import com.example.projectbe.dto.PaymentDTO;
import com.example.projectbe.entity.Category;
import com.example.projectbe.entity.PaymentMethod;
import com.example.projectbe.maytinhrepository.Payment_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    Payment_Repository paymentRepository;

    public List<PaymentMethod> findAll(){
        List<PaymentMethod> paymentMethods = paymentRepository.findAll();
        return  paymentMethods;
    }

    public PaymentMethod findbyidpay(int id){
        Optional<PaymentMethod> optionalPaymentMethod = paymentRepository.findById(id);
        if(optionalPaymentMethod.isEmpty()){
            System.out.println("không tìm thấy sinh viên");
            return null;
        }
        return optionalPaymentMethod.get();
    }

//    public List<Category> findbyname(String name){
//        List<Category> categories = maytinhRepository.findbyname(name);
//        return categories;
//    }

    public String save(PaymentDTO paymentDTO) {
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setId(paymentDTO.getId());
        paymentMethod.setName(paymentDTO.getName());
        paymentMethod.setNotes(paymentDTO.getNotes());
        paymentMethod.setCreatedDate(LocalDateTime.parse(paymentDTO.getCreatedDate()));
        paymentMethod.setUpdatedDate(LocalDateTime.parse(paymentDTO.getUpdatedDate()));
        paymentMethod.setIsactive((byte) paymentDTO.getIsactive());
        paymentRepository.save(paymentMethod);
        return "Thêm thành công";
    }

    public String update(int id , PaymentDTO paymentDTO){
        boolean idexist = paymentRepository.existsById(id);
        if(!idexist) return "Không tìm thấy id này !";
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setId(id);
        paymentMethod.setName(paymentDTO.getName());
        paymentMethod.setNotes(paymentDTO.getNotes());
        paymentMethod.setCreatedDate(LocalDateTime.parse(paymentDTO.getCreatedDate()));
        paymentMethod.setUpdatedDate(LocalDateTime.parse(paymentDTO.getUpdatedDate()));
        paymentMethod.setIsactive((byte) paymentDTO.getIsactive());
        paymentRepository.save(paymentMethod);
        return "Update thành công";
    }

    public String Delete(int id){
        boolean idexist = paymentRepository.existsById(id);
        if(!idexist) return "Không có id này !";
        paymentRepository.deleteById(id);
        return "Xóa thành công";
    }
}
