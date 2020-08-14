package ru.geekbrains.homework4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework4.entity.Product;
import ru.geekbrains.homework4.repository.ProductPaginationRepository;


@Service
public class ProductService {

    private ProductPaginationRepository productPaginationRepository;

    @Autowired
    public void setProductPaginationRepository(ProductPaginationRepository productPaginationRepository) {
        this.productPaginationRepository = productPaginationRepository;
    }

    public Page<Product> getPage(Integer pageNumber, Integer min, Integer max) {
        return productPaginationRepository.findByCostBetween(PageRequest.of(pageNumber, 3), min, max);
    }
}
