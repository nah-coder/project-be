package com.example.projectbe.MaytinhController;

import com.example.projectbe.dto.*;
import com.example.projectbe.entity.*;
import com.example.projectbe.maytinhService.*;
import com.example.projectbe.maytinhrepository.OrderRepository;
import com.example.projectbe.projection.Ioder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebController {
    @Autowired
    PaymentService paymentService;
    @Autowired
    MaytinhService maytinhService;
    @Autowired
    TransportService transportService;
    @Autowired
    CustomerService customerService;
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;
    @Autowired
    OrderRepository orderRepository;


    @GetMapping("/admin")
    public String showcategory(Model model, @Param("keyword") String keyword,@RequestParam(name = "pageno" , defaultValue = "1")Integer pageno) {
        Page<Category> categories = maytinhService.findAllpage(pageno);
        if(keyword!=null && !keyword.isEmpty()){
            categories = this.maytinhService.searchCategory(keyword,pageno);
            model.addAttribute("keyword", keyword);
        }
        model.addAttribute("totalPage",categories.getTotalPages());
        model.addAttribute("currentPage",pageno);
        model.addAttribute("category_all", categories);
        return "indexx";
    }

    @GetMapping("/view/add-category")
    public String showAddCategory(Model model) {
        model.addAttribute("categoryDTO", new Category());
        return "function/add-category";
    }

    @PostMapping("/category_save")
    public String addCategory(@ModelAttribute("categoryDTO") CategoryDTO category) {
        maytinhService.save(category);
        return "redirect:/admin";
    }

    @GetMapping("/update-category/{id}")
    public String UpdateCategory(Model model, @PathVariable("id") int id) {
        model.addAttribute("id", id);
        Category category = maytinhService.findbyidcate(id);
        model.addAttribute("categoryDTO", category);
        return "function/update-category";
    }

    // sửa sinh viên
    @PostMapping("/update-category/{id}")
    public String UpdateCategory(@PathVariable("id") int id, @ModelAttribute("categoryDTO") CategoryDTO categoryDTO) {
        maytinhService.update(id, categoryDTO);
        return "redirect:/admin";
    }

    @GetMapping("/delete-category/{id}")
    public String deletecategory(Model model, @PathVariable("id") int id) {
        model.addAttribute("id", id);
        Category category = maytinhService.findbyidcate(id);
        model.addAttribute("categoryDTO", category);
        return "function/delete-category";
    }

    // Xóa sinh viên theo ID
    @PostMapping("delete-Category/{id}")
    public String deletecategory(@PathVariable("id") int id, @ModelAttribute("categoryDTO") CategoryDTO categoryDTO) {
        maytinhService.Delete(id);
        return "redirect:/admin";
    }

    @GetMapping("/show_servicelist")
    public String showservicelist(Model model) {
        model.addAttribute("categoryDTO", new Category());
        return "layout/it_service_list";
    }

    @GetMapping("/show_shop")
    public String showshop(Model model) {
//        model.addAttribute("product_all", new Product());
        List<Product> products = productService.findAll();
            model.addAttribute("product_all", products);
        return "layout/it_shop";
    }

    @GetMapping("/show_shopdetail")
    public String showshopdetail(Model model) {
        List<Product> productDTO = productService.findAll();
        model.addAttribute("productDTO", productDTO);
        return "layout/it_shop_detail";
    }



    @GetMapping("/show_checkout")
    public String showcheckout(Model model) {
        model.addAttribute("categoryDTO", new Category());
        return "layout/it_checkout";
    }

    @GetMapping("/show_home")
    public String showhome(Model model) {
        model.addAttribute("categoryDTO", new Category());
        return "layout/it_home";
    }

    @GetMapping("/show_homedark")
    public String showhomedark(Model model) {
        model.addAttribute("categoryDTO", new Category());
        return "layout/it_home_dark";
    }

    @GetMapping("/show_about")
    public String showabout(Model model) {
        model.addAttribute("categoryDTO", new Category());
        return "layout/it_about";
    }

    @GetMapping("/show_servicedetail")
    public String showservicedetail(Model model) {
        model.addAttribute("categoryDTO", new Category());
        return "layout/it_service_detail";
    }

    @GetMapping("/show_blog")
    public String showblog(Model model) {
        model.addAttribute("categoryDTO", new Category());
        return "layout/it_blog";
    }

    @GetMapping("/show_bloggrid")
    public String showbloggrid(Model model) {
        model.addAttribute("categoryDTO", new Category());
        return "layout/it_blog_grid";
    }

    @GetMapping("/show_career")
    public String showcareer(Model model) {
        model.addAttribute("categoryDTO", new Category());
        return "layout/it_career";
    }

    @GetMapping("/show_price")
    public String showprice(Model model) {
        model.addAttribute("categoryDTO", new Category());
        return "layout/it_price";
    }

    @GetMapping("/show_faq")
    public String showfaq(Model model) {
        model.addAttribute("categoryDTO", new Category());
        return "layout/it_faq";
    }

    @GetMapping("/show_privacypolicy")
    public String showprivacypolicy(Model model) {
        model.addAttribute("categoryDTO", new Category());
        return "layout/it_privacy_policy";
    }

    @GetMapping("/show_error")
    public String showerror(Model model) {
        model.addAttribute("categoryDTO", new Category());
        return "layout/it_error";
    }

    @GetMapping("/show_contact")
    public String showcontact(Model model) {
        model.addAttribute("categoryDTO", new Category());
        return "layout/it_contact";
    }

    @GetMapping("/show_contact2")
    public String showcontact2(Model model) {
        model.addAttribute("categoryDTO", new Category());
        return "layout/it_contact_2";
    }

    @GetMapping("/show_termcondition")
    public String showtermcondition(Model model) {
        model.addAttribute("categoryDTO", new Category());
        return "layout/it_term_condition";
    }

    @GetMapping("/show_news")
    public String shownews(Model model) {
        model.addAttribute("categoryDTO", new Category());
        return "layout/it_news";
    }

    @GetMapping("/show_datarecovery")
    public String show_datarecovery(Model model) {
        model.addAttribute("categoryDTO", new Category());
        return "layout/it_data_recovery";
    }

    @GetMapping("/show_computerepair")
    public String show_computerepair(Model model) {
        model.addAttribute("categoryDTO", new Category());
        return "layout/it_computer_repair";
    }

    @GetMapping("/show_mobileservice")
    public String show_mobileservice(Model model) {
        model.addAttribute("categoryDTO", new Category());
        return "layout/it_mobile_service";
    }

    @GetMapping("/show_networksolutiom")
    public String show_networksolutiom(Model model) {
        model.addAttribute("categoryDTO", new Category());
        return "layout/it_network_solution";
    }

    @GetMapping("/show_technsupport")
    public String show_technsupport(Model model) {
        model.addAttribute("categoryDTO", new Category());
        return "layout/it_techn_support";
    }

    @GetMapping("/myhome")
    public String myhome() {
        return "layout/index";
    }

    @GetMapping("/custommer")
    public String showcustomer(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("custommer", customers);
        return "Custommer";
    }

    @GetMapping("/view/add-customer")
    public String showAddcustomer(Model model) {
        model.addAttribute("customerDTO", new Customer());
        return "function/add-custommer";
    }

    @PostMapping("/customer-save")
    public String addCategory(@ModelAttribute("customerDTO") CustommerDTO custommerDTO) {
        customerService.save(custommerDTO);
        return "redirect:/custommer";
    }

    @GetMapping("/update-custommer/{id}")
    public String UpdateCustommer(Model model, @PathVariable("id") int id) {
        model.addAttribute("id", id);
        Customer customer = customerService.findbyidcustom(id);
        model.addAttribute("customerDTO", customer);
        return "function/update-custommer";
    }

    // sửa sinh viên
    @PostMapping("/update-custommer/{id}")
    public String UpdateCustommer(@PathVariable("id") int id, @ModelAttribute("customerDTO") CustommerDTO custommerDTO) {
        customerService.update(id, custommerDTO);
        return "redirect:/custommer";
    }

    //
    @GetMapping("/delete-custommer/{id}")
    public String deletecustommer(Model model, @PathVariable("id") int id) {
        model.addAttribute("id", id);
        Customer customer = customerService.findbyidcustom(id);
        model.addAttribute("customerDTO", customer);
        return "function/delete-custommer";
    }

    // Xóa sinh viên theo ID
    @PostMapping("delete-custommer/{id}")
    public String deletecustomer(@PathVariable("id") int id, @ModelAttribute("customerDTO") CustommerDTO custommerDTO) {
        customerService.Delete(id);
        return "redirect:/custommer";
    }

    //orderrrrrr
    @GetMapping("/order")
    public String showorder(Model model) {
        List<Orders> orders = orderService.findAll();
        model.addAttribute("order", orders);
        return "order";
    }



    @GetMapping("/view/add-order")
    public String showAddorder(Model model) {
        model.addAttribute("orderDTO", new Orders());
        return "function/add-order";
    }

    @PostMapping("/order-save")
    public String addorder(@ModelAttribute("orderDTO") OrderDTO orderDTO) {
        orderService.save(orderDTO);
        return "redirect:/order";
    }

    @GetMapping("/update-order/{id}")
    public String UpdateOrder(Model model, @PathVariable("id") int id) {
        model.addAttribute("id", id);
        Orders orders = orderService.findbyidorder(id);
        model.addAttribute("orderDTO", orders);
        return "function/update-order";
    }

    @PostMapping("/update-order/{id}")
    public String UpdateOrder(@PathVariable("id") int id, @ModelAttribute("orderDTO") OrderDTO orderDTO) {
        orderService.update(id, orderDTO);
        return "redirect:/order";
    }

    //    //
    @GetMapping("/delete-order/{id}")
    public String deleteorder(Model model, @PathVariable("id") int id) {
        model.addAttribute("id", id);
        Orders orders = orderService.findbyidorder(id);
        model.addAttribute("orderDTO", orders);
        return "function/delete-order";
    }

    // Xóa sinh viên theo ID
    @PostMapping("delete-order/{id}")
    public String deleteorder(@PathVariable("id") int id, @ModelAttribute("orderDTO") OrderDTO orderDTO) {
        orderService.Delete(id);
        return "redirect:/order";
    }

    //paymentttt
    @GetMapping("/payment")
    public String showpayment(Model model) {
        List<PaymentMethod> paymentMethods = paymentService.findAll();
        model.addAttribute("payment_methodall", paymentMethods);
        return "Payment_method";
    }

    @GetMapping("/view/add-payment")
    public String showAddpayment(Model model) {
        model.addAttribute("paymentDTO",new PaymentMethod());
        return "function/add-payment";
    }

    @PostMapping("/payment_save")
    public String addPayment(@ModelAttribute("paymentDTO") PaymentDTO paymentDTO) {
        paymentService.save(paymentDTO);
        return "redirect:/payment";
    }

    @GetMapping("/update-payment/{id}")
    public String UpdatePayment(Model model,
                                 @PathVariable("id") int id) {
        model.addAttribute("id", id);
        PaymentMethod paymentMethod = paymentService.findbyidpay(id);
        model.addAttribute("paymentDTO", paymentMethod);
        return "function/update-payment";
    }

    // sửa sinh viên
    @PostMapping("/update-payment/{id}")
    public String UpdatePayment(@PathVariable("id") int id,
                                 @ModelAttribute("paymentDTO") PaymentDTO paymentDTO) {
        paymentService.update(id, paymentDTO);
        return "redirect:/payment";
    }

    @GetMapping("/delete-payment/{id}")
    public String deletepayment(Model model,
                                 @PathVariable("id") int id){
        model.addAttribute("id",id);
        PaymentMethod paymentMethod = paymentService.findbyidpay(id);
        model.addAttribute("paymentDTO", paymentMethod);
        return "function/delete-payment";
    }

    // Xóa sinh viên theo ID
    @PostMapping ("delete-payment/{id}")
    public String deletepayment(@PathVariable("id") int id,
                                 @ModelAttribute("paymentDTO") PaymentDTO paymentDTO) {
        paymentService.Delete(id);
        return "redirect:/payment";
    }

//transsssss

    @GetMapping("/transport")
    public String showtransport(Model model) {
        List<TransportMethod> transportMethods = transportService.findAll();
        model.addAttribute("transport_methodall", transportMethods);
        return "Transport_method";
    }

    @GetMapping("/view/add-transport")
    public String showAddTransport(Model model) {
        model.addAttribute("transportDTO", new TransportMethod());
        return "function/add-transport";
    }

    @PostMapping("/transport_save")
    public String addtransport(@ModelAttribute("transportDTO") TransportDTO transportDTO) {
        transportService.save(transportDTO);
        return "redirect:/transport";
    }

    @GetMapping("/update-transport/{id}")
    public String Updatetransport(Model model,
                                 @PathVariable("id") int id) {
        model.addAttribute("id", id);
        TransportMethod transportMethod = transportService.findbyidtransport(id);
        model.addAttribute("transportDTO", transportMethod);
        return "function/update-transport";
    }

    // sửa sinh viên
    @PostMapping("/update-transport/{id}")
    public String UpdateTransport(@PathVariable("id") int id,
                                 @ModelAttribute("transportDTO") TransportDTO transportDTO) {
        transportService.update(id, transportDTO);
        return "redirect:/transport";
    }


    @GetMapping("/delete-transport/{id}")
    public String deletetransport(Model model,
                                 @PathVariable("id") int id){
        model.addAttribute("id",id);
        TransportMethod transportMethod = transportService.findbyidtransport(id);
        model.addAttribute("transportDTO", transportMethod);
        return "function/delete-transport";
    }

    // Xóa sinh viên theo ID
    @PostMapping ("delete-transport/{id}")
    public String deletetransport(@PathVariable("id") int id,
                                 @ModelAttribute("transportDTO") TransportDTO transportDTO) {
        transportService.Delete(id);
        return "redirect:/transport";
    }


    ///////productttttttttt
    @GetMapping("/product")
    public String showproduct(Model model, @Param("keyword") String keyword,@RequestParam(name = "pageno" , defaultValue = "1")Integer pageno) {
        Page<Product> productPage = productService.findAllpage(pageno);
        if(keyword!=null && !keyword.isEmpty()){
            productPage = this.productService.searchProduct(keyword,pageno);
            model.addAttribute("keyword", keyword);
        }
        model.addAttribute("totalPage",productPage.getTotalPages());
        model.addAttribute("currentPage",pageno);
        model.addAttribute("product_all", productPage);
        return "product";
    }

    @GetMapping("/view/add-product")
    public String showAddproduct(Model model) {
        model.addAttribute("productDTO", new Product());
        return "function/add-product";
    }

    @PostMapping("/product_save")
    public String addproduct(@ModelAttribute("productDTO") ProductDTO productDTO) {
        productService.save(productDTO);
        return "redirect:/product";
    }

    @GetMapping("/update-product/{id}")
    public String UpdateProduct(Model model,
                                @PathVariable("id") int id) {
        model.addAttribute("id", id);
        Product product = productService.findbyidproduct(id);
        model.addAttribute("productDTO", product);
        return "function/update-product";
    }

    // sửa sinh viên
    @PostMapping("/update-product/{id}")
    public String Updateproduct(@PathVariable("id") int id,
                                @ModelAttribute("productDTO") ProductDTO productDTO) {
        productService.update(id, productDTO);
        return "redirect:/product";
    }

    @GetMapping("/delete-product/{id}")
    public String deleteproduct(Model model,
                                @PathVariable("id") int id) {
        model.addAttribute("id", id);
        Product product = productService.findbyidproduct(id);
        model.addAttribute("productDTO", product);
        return "function/delete-product";
    }

    // Xóa sinh viên theo ID
    @PostMapping("delete-product/{id}")
    public String deleteproduct(@PathVariable("id") int id,
                                @ModelAttribute("productDTO") ProductDTO productDTO) {
        productService.Delete(id);
        return "redirect:/product";
    }

    @GetMapping("/orderdetail/{id}")
    public String Orderdetail(Model model, @PathVariable("id") int id) {
        List<Ioder> orderdetail = orderService.findbyidorderdetail(id);
        List<Ioder> orderdetailcate = orderService.findbyidorderdetailcate(id);
//        Orders orders = orderService.findbyidorder(id);
        model.addAttribute("order", orderdetail);
        model.addAttribute("orderdetailcate", orderdetailcate);
        model.addAttribute("id", id);
        return "orderdetail";
    }

    @GetMapping("/view/add-orderdetail/{id}")
    public String showAddorderdetail(Model model, @PathVariable("id") int id) {
//        List<Ioder> orderdetailcate = orderService.findbyidorderdetailcate(id);
//        List<Ioder> orderdetail = orderService.findbyidorderdetail(id);
//        Product product = productService.findbyidproduct(id);
        List<Product> productList = productService.findAll();
//        model.addAttribute("productDTO", product);
        model.addAttribute("OrdersDetails", new OrdersDetails());
//        model.addAttribute("order", orderdetail);
//        model.addAttribute("Orderdetailcate", orderdetailcate);
        model.addAttribute("ID", id);
        model.addAttribute("productList", productList);
        return "/function/add-orderdetail";
    }

    @PostMapping("/orderdetail-save/{Idord}")
    public String addorderdetail(@ModelAttribute("OrderDetailDTO") OrderDetailDTO OrderDetailDTO,@PathVariable("Idord") int Idord) {
        orderService.savedetail(Idord, OrderDetailDTO);
        return "redirect:/orderdetail/" + Idord;
    }
}

//thiếu bật tắt idorder theo ngày tháng năm
//phân quyền
//cách sử dụng one to many và many to many


//optional là gì
//khi nào thì sử dụng interface,abtract
//cách debug để fixbug
//xử dụng docker
//phân biệt requetsparam vs @param
//cách sử dụng call api
//tại sao e ko dùng đc put vs delete mà e lại bị dùng post vì dùng 2 cái kia nó bị lỗi
//bảng order sao cột idorder lại null
