package com.example.codingtehnique.controller;

import com.example.codingtehnique.MODEL.Product;
import com.example.codingtehnique.dto.ProductDto;
import com.example.codingtehnique.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/clients")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/index")
    public String listProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "clients/index"; // This refers to templates/clients/index.html
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        ProductDto productDto = new ProductDto();
        model.addAttribute("productDto", productDto);
        return "clients/create";
    }
    @PostMapping("/create")
    public String createProduct(@ModelAttribute ProductDto productDto,BindingResult result){
        if(result.hasErrors()){
            return "clients/create";
        }
        Product product =new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        productService.saveProduct(product);
        return "redirect:/clients/index";

    }
    @GetMapping("/edit")
    public String showEditPage(Model model,@RequestParam int id){
        Optional<Product> productOptional=productService.getProductById(id);
        if(productOptional.isPresent()){
            model.addAttribute("product",productOptional.get());
            return "clients/edit";
        }
        else{
            return "redirect:/clients/index";
        }
    }
    @PostMapping("/edit")
    public String updateClient(@ModelAttribute Product product){
        productService.updateProduct(product);
        return "redirect:/clients/index";
    }
    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int id){
        productService.deleteProduct(id);
        return "redirect:/clients/index";
    }

}