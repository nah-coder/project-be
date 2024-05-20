package com.example.projectbe.maytinhService;

import com.example.projectbe.dto.CustommerDTO;
import com.example.projectbe.dto.ProductDTO;
import com.example.projectbe.entity.Category;
import com.example.projectbe.entity.Customer;
import com.example.projectbe.entity.Product;
import com.example.projectbe.maytinhrepository.ProductRepository;
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
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public List<Product> findAll(){
        List<Product> products = productRepository.findAll();
        return  products;
    }
    public Product findbyidproduct(int id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            System.out.println("không tìm thấy khách hàng");
            return null;
        }
        return optionalProduct.get();
    }
    public Page<Product> findAllpage(Integer pageno){
        Pageable pageable = PageRequest.of(pageno-1,4);
        return  productRepository.findAll(pageable);
    }
    public List<Product> searchProduct(String keyword){
        return  productRepository.searchProduct(keyword);
    }
    public Page<Product> searchProduct(String keyword,Integer pageno){
        List list = this.searchProduct(keyword);
        Pageable pageable = PageRequest.of(pageno-1,2);
        Integer start = (int) pageable.getOffset();
        Integer end = (int)(pageable.getOffset() + pageable.getPageSize() > list.size() ? list.size() : pageable.getOffset() + pageable.getPageSize());
        list = list.subList(start, end);
        return new PageImpl<Product>(list,pageable,this.searchProduct(keyword).size());
    }
    public String save(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setNotes(productDTO.getNotes());
        product.setImage(productDTO.getImage());
        product.setIdcategory(productDTO.getIdcategory());
        product.setPrice(productDTO.getPrice());
        product.setQuatity(productDTO.getQuatity());
        product.setCreatedDate(LocalDateTime.parse(productDTO.getCreatedDate()));
        product.setUpdatedDate(LocalDateTime.parse(productDTO.getUpdatedDate()));
        product.setCreatedBy(productDTO.getCreatedBy());
        product.setUpdatedBy(productDTO.getUpdatedBy());
        product.setIsactive(Byte.valueOf(productDTO.getIsactive()));
        productRepository.save(product);
        return "Thêm thành công";
    }

    public String update(int id, ProductDTO productDTO){
        boolean idexist = productRepository.existsById(id);
        if(!idexist) return "Không tìm thấy id này !";
        Product product = new Product();
        product.setId(id);
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setNotes(productDTO.getNotes());
        product.setImage(productDTO.getImage());
        product.setIdcategory(productDTO.getIdcategory());
        product.setPrice(Double.valueOf(productDTO.getPrice()));
        product.setQuatity(productDTO.getQuatity());
        product.setCreatedDate(LocalDateTime.parse(productDTO.getCreatedDate()));
        product.setUpdatedDate(LocalDateTime.parse(productDTO.getUpdatedDate()));
        product.setCreatedBy(productDTO.getCreatedBy());
        product.setUpdatedBy(productDTO.getUpdatedBy());
        product.setIsactive(Byte.valueOf(productDTO.getIsactive()));
        productRepository.save(product);
        return "Update thành công";
    }

    public String Delete(int id){
        boolean idexist = productRepository.existsById(id);
        if(!idexist) return "Không có id này !";
        productRepository.deleteById(id);
        return "Xóa thành công";
    }
}
