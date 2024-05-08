package com.example.projectbe.maytinhService;

import com.example.projectbe.dto.CategoryDTO;
import com.example.projectbe.entity.Category;
import com.example.projectbe.maytinhrepository.MaytinhRepository;
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
public class MaytinhService {
    @Autowired
    MaytinhRepository maytinhRepository;

    public List<Category> findAll(){
        List<Category> categories = maytinhRepository.findAll();
        return  categories;
    }

    public Page<Category> findAllpage(Integer pageno){
        Pageable pageable = PageRequest.of(pageno-1,4);
        return  maytinhRepository.findAll(pageable);
    }

    public List<Category> searchCategory(String keyword){
        return  maytinhRepository.searchCategory(keyword);
    }

    public Page<Category> searchCategory(String keyword,Integer pageno){
        List list = this.searchCategory(keyword);
        Pageable pageable = PageRequest.of(pageno-1,2);
        Integer start = (int) pageable.getOffset();
        Integer end = (int)(pageable.getOffset() + pageable.getPageSize() > list.size() ? list.size() : pageable.getOffset() + pageable.getPageSize());
        list = list.subList(start, end);
        return new PageImpl<Category>(list,pageable,this.searchCategory(keyword).size());
    }

    public Category findbyidcate(int id){
        Optional<Category> optionalCategory = maytinhRepository.findById(id);
        if(optionalCategory.isEmpty()){
            System.out.println("không tìm thấy sinh viên");
            return null;
        }
        return optionalCategory.get();
    }



    public List<Category> findbyname(String name){
        List<Category> categories = maytinhRepository.findbyname(name);
        return categories;
    }

    public String save(CategoryDTO category) {
        Category category1 = new Category();
        category1.setId(category.getId());
        category1.setIdparent(category.getIdparent());
        category1.setName(category.getName());
        category1.setNotes(category.getNotes());
        category1.setIcon(category.getIcon());
        category1.setCreatedDate(LocalDateTime.parse(category.getCreatedDate()));
        category1.setUpdatedDate(LocalDateTime.parse(category.getUpdatedDate()));
        category1.setCreatedBy(category.getCreatedBy());
        category1.setUpdatedBy(category.getUpdatedBy());
        category1.setIsactive((byte) category.getIsactive());
        maytinhRepository.save(category1);
        return "Thêm thành công";
    }

    public String update(int id , CategoryDTO category){
        boolean idexist = maytinhRepository.existsById(id);
        if(!idexist) return "Không tìm thấy id này !";
        Category category1 = new Category();
        category1.setId(id);
        category1.setIdparent(category.getIdparent());
        category1.setName(category.getName());
        category1.setNotes(category.getNotes());
        category1.setIcon(category.getIcon());
        category1.setCreatedDate(LocalDateTime.parse(category.getCreatedDate()));
        category1.setUpdatedDate(LocalDateTime.parse(category.getUpdatedDate()));
        category1.setCreatedBy(category.getCreatedBy());
        category1.setUpdatedBy(category.getUpdatedBy());
        category1.setIsactive((byte) category.getIsactive());
        maytinhRepository.save(category1);
        return "Update thành công";
    }

    public String Delete(int id){
        boolean idexist = maytinhRepository.existsById(id);
        if(!idexist) return "Không có id này !";
        maytinhRepository.deleteById(id);
        return "Xóa thành công";
    }
}
