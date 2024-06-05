package com.example.projectbe.maytinhService;

import com.example.projectbe.dto.CategoryDTO;
import com.example.projectbe.dto.TransportDTO;
import com.example.projectbe.entity.Category;
import com.example.projectbe.entity.PaymentMethod;
import com.example.projectbe.entity.TransportMethod;
import com.example.projectbe.maytinhrepository.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransportService {
    @Autowired
    TransportRepository transportRepository;
    public List<TransportMethod> findAll(){
        List<TransportMethod> transportMethods = transportRepository.findAll();
        return  transportMethods;
    }

    public TransportMethod findbyidtransport(int id){
        Optional<TransportMethod> optionalTransportMethod = transportRepository.findById(id);
        if(optionalTransportMethod.isEmpty()){
            System.out.println("không tìm thấy sinh viên");
            return null;
        }
        return optionalTransportMethod.get();
    }

//    public List<Category> findbyname(String name){
//        List<Category> categories = maytinhRepository.findbyname(name);
//        return categories;
//    }

    public Page<TransportMethod> findAllpage(Integer pageno){
        Pageable pageable = PageRequest.of(pageno-1,4);
        return  transportRepository.findAll(pageable);
    }

    public List<TransportMethod> searchTransportMethod(String keyword){
        return  transportRepository.searchTransportMethodBy(keyword);
    }

    public Page<TransportMethod> searchTransportMethod(String keyword,Integer pageno){
        List list = this.searchTransportMethod(keyword);
        Pageable pageable = PageRequest.of(pageno-1,2);
        Integer start = (int) pageable.getOffset();
        Integer end = (int)(pageable.getOffset() + pageable.getPageSize() > list.size() ? list.size() : pageable.getOffset() + pageable.getPageSize());
        list = list.subList(start, end);
        return new PageImpl<TransportMethod>(list,pageable,this.searchTransportMethod(keyword).size());
    }

    public String save(TransportDTO transportDTO) {
        TransportMethod transportMethod = new TransportMethod();
        transportMethod.setId(transportDTO.getId());
        transportMethod.setName(transportDTO.getName());
        transportMethod.setNotes(transportDTO.getNotes());
        transportMethod.setCreatedDate(LocalDateTime.parse(transportDTO.getCreatedDate()));
        transportMethod.setUpdatedDate(LocalDateTime.parse(transportDTO.getUpdatedDate()));
        transportMethod.setIsactive((byte) transportDTO.getIsactive());
        transportRepository.save(transportMethod);
        return "Thêm thành công";
    }

    public String update(int id , TransportDTO transportDTO){
        boolean idexist = transportRepository.existsById(id);
        if(!idexist) return "Không tìm thấy id này !";
        TransportMethod transportMethod = new TransportMethod();
        transportMethod.setId(transportDTO.getId());
        transportMethod.setName(transportDTO.getName());
        transportMethod.setNotes(transportDTO.getNotes());
        transportMethod.setCreatedDate(LocalDateTime.parse(transportDTO.getCreatedDate()));
        transportMethod.setUpdatedDate(LocalDateTime.parse(transportDTO.getUpdatedDate()));
        transportMethod.setIsactive((byte) transportDTO.getIsactive());
        transportRepository.save(transportMethod);
        return "Update thành công";
    }

    public String Delete(int id){
        boolean idexist = transportRepository.existsById(id);
        if(!idexist) return "Không có id này !";
        transportRepository.deleteById(id);
        return "Xóa thành công";
    }
}
