package io.order.manager.food.order.manager.services.impl;

import io.order.manager.food.order.manager.dto.ProductDTO;
import io.order.manager.food.order.manager.entities.Category;
import io.order.manager.food.order.manager.entities.Product;
import io.order.manager.food.order.manager.mappers.ProductMapper;
import io.order.manager.food.order.manager.repositories.ProductRepository;
import io.order.manager.food.order.manager.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductDTO findOne(String email) {
        return null;
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product product = productRepository.save(productMapper.convertDtoToEntity(productDTO));
        return productMapper.convertEntityToDto(product);
    }

    @Override
    public void update(int id, ProductDTO productDTO) {
        if(!Objects.equals(id, productDTO.getId())){
            throw new IllegalArgumentException("IDs don't match");
        }
        Product product = productMapper.convertDtoToEntity(productDTO);
        productRepository.save(product);
    }

    @Override
    public String delete(int id) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
            return "order supprimé";
        } else {
            return "order non supprimé";
        }
    }

    @Override
    public List<ProductDTO> listAll() {
        List<Product> allOrders = productRepository.findAll();
        return allOrders.stream().map(x -> productMapper.convertEntityToDto(x)).collect(Collectors.toList());
    }
}
