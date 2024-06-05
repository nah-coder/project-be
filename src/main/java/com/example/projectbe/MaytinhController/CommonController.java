package com.example.projectbe.MaytinhController;

import com.example.projectbe.dto.OrderDTO;
import com.example.projectbe.entity.CartItem;
import com.example.projectbe.entity.Orders;
import com.example.projectbe.entity.Product;
import com.example.projectbe.maytinhService.OrderService;
import com.example.projectbe.maytinhService.OrdersTransportService;
import com.example.projectbe.maytinhService.ProductService;
import com.example.projectbe.maytinhService.Shopping_cartService;
import com.example.projectbe.projection.TransportProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommonController {

    @Autowired
    ProductService productService;
    @Autowired
    Shopping_cartService shoppingCartService;
    @Autowired
    OrderService orderService;

    @GetMapping("/User")
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

//    @GetMapping("/it_cart/{id}")
//    public String show_cart(Model model, @PathVariable("id") int id ){
//        model.addAttribute("id", id);
//        Product productDTO = productService.findbyidproduct(id);
//        model.addAttribute("productDTO", productDTO);
//        return "layout/it_cart";
//    }

    @GetMapping("/show_cart")
    public String showcart(Model model) {
//        model.addAttribute("categoryDTO", new Category());
//        List<Product> products = productService.findAll();
        model.addAttribute("CART_ITEM", shoppingCartService.getAllItem());
        model.addAttribute("TOTAL",shoppingCartService.getTotal());
        return "layout/it_cart";
    }

    @GetMapping("/cart_add/{id}")
    public String addCart(@PathVariable("id") Integer id){
        Product product = productService.findbyidproduct(id);
        if(product != null){
            CartItem cartItem = new CartItem();
            cartItem.setProductId(product.getId());
            cartItem.setName(product.getName());
            cartItem.setPrice(product.getPrice());
            cartItem.setQty(1);
            cartItem.setImage(product.getImage());
            shoppingCartService.add(cartItem);
        }
        return "redirect:/show_cart";
    }

    @GetMapping("/clear")
    public String clearcart(){
        shoppingCartService.clear();
        return "redirect:/show_cart";
    }

    @GetMapping("/remove/{productId}")
    public String removecart(@PathVariable("productId") Integer productId) {
        shoppingCartService.remove(productId);
        return "redirect:/show_cart";
    }
    @PostMapping("/update")
    public String update(@RequestParam("id") Integer id, @RequestParam("qty") Integer qty){
        shoppingCartService.update(id,qty);
        return "redirect:/show_cart";
    }
//    @GetMapping("/orderdetail/{id}")
//    public String orderDetail(Model model, @PathVariable("id") int id) {
//        List<TransportProjection> orderTransportDetails = ordersTransportService.getTransportsByOrderId(id);
//        model.addAttribute("orderdetailall", orderTransportDetails);
//        model.addAttribute("id", id);
//        return "orderdetail";
//    }

    @GetMapping("info")
    public String info(Model model){
        model.addAttribute("orderDTO", new Orders());
        return "function/add-info";
    }

    @PostMapping("/orderinfo-save")
    public String addorder(@ModelAttribute("orderDTO") OrderDTO orderDTO) {
        orderService.save(orderDTO);
        return "redirect:/myhome";
    }
}
