package io.order.manager.food.order.manager.services;

import io.order.manager.food.order.manager.dto.ProductDTO;
import java.util.List;

public interface ProductService {
    ProductDTO findOne(String email);

    ProductDTO save(ProductDTO userDTO);

    void update(int id, ProductDTO productDTO);

    String delete(int id);

    List<ProductDTO> listAll();

}
