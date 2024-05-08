package com.example.projectbe.MaytinhController;

import com.example.projectbe.dto.CategoryDTO;
import com.example.projectbe.entity.Category;
import com.example.projectbe.maytinhService.MaytinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/maytinh")
public class MaytinhController {
    @Autowired
    private MaytinhService maytinhService;

    @GetMapping("")
    public List<Category> findAll(){
        return maytinhService.findAll();
    }

    @GetMapping("/findbyidcate")
    public Category findbyidcate(@RequestParam("id") int id){
//        List<Category> categories = maytinhService.findbyidcate(id);
        return maytinhService.findbyidcate(id);
    }

    @GetMapping("/findbyname")
    public List<Category> findbyname(@RequestParam("name") String name){
        return maytinhService.findbyname(name);
    }

    @PostMapping("")
    String save(@RequestBody CategoryDTO category){
        String mess = maytinhService.save(category);
        return mess;
    }

    @PutMapping("")
    public String update(@RequestParam("id") int id, @RequestBody CategoryDTO category){
        String mess = maytinhService.update(id, category);
        return mess;
    }

    @DeleteMapping("")
    public String Delete(@RequestParam("id") int id){
        String mess = maytinhService.Delete(id);
        return mess;
    }
}
