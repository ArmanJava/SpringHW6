package ru.geekbrains.homework4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.homework4.entity.Product;
import ru.geekbrains.homework4.service.ProductService;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String catalogPage(
            @RequestParam(value = "min", required = false) Integer min,
            @RequestParam(value = "max", required = false) Integer max,
            @RequestParam(value = "page", required = false) Integer pageNumber,
            Model model
    ) {
        if (min == null) min = 0;
        if (max == null) max = 1000000;
        if (pageNumber == null) pageNumber = 0;
        Page<Product> page = productService.getPage(pageNumber, min, max);
        model.addAttribute("numberOfPages", page.getTotalPages());
        model.addAttribute("products", page.getContent());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        return "catalog";
    }
}
