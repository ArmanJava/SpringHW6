package ru.geekbrains.homework4.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.homework4.entity.Product;

@Repository
public interface ProductPaginationRepository extends PagingAndSortingRepository<Product, Long> {

    Page<Product> findByCostBetween(Pageable pageable, Integer min, Integer max);
}
