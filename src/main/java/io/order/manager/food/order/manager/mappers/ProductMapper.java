package io.order.manager.food.order.manager.mappers;

import io.order.manager.food.order.manager.dto.ProductDTO;
import io.order.manager.food.order.manager.entities.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    @Autowired
    private ModelMapper modelMapper;

    public ProductDTO convertEntityToDto(Product product){

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        ProductDTO productDTO = new ProductDTO();
        productDTO = modelMapper.map(product, ProductDTO.class);
        return productDTO;
    }

    public Product convertDtoToEntity(ProductDTO productDTO){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Product product = new Product();
        product = modelMapper.map(productDTO, Product.class);
        return product;
    }
}
