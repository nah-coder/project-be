package com.example.projectbe.MaytinhController;

import com.example.projectbe.entity.Product;
import com.example.projectbe.maytinhService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CommonController {
    @Autowired
    ProductService productService;

    @GetMapping("")
    public String showindex(){
        return "layout/index";
    }

    @GetMapping("/register")
    public String showdangky(){
        return "register";
    }

    @GetMapping("/loginadmin")
    public String showloginadmin(){
        return "loginadmin";
    }

    @GetMapping("/login")
    public String showlogin(){
        return "login";
    }

    @GetMapping("/it_shop_detail/{id}")
    public String Chitiet(Model model,
                          @PathVariable("id") int id ){
        model.addAttribute("id", id);
        Product productDTO = productService.findbyidproduct(id);
        model.addAttribute("productDTO", productDTO);
        return "layout/it_shop_detail";
    }
}
