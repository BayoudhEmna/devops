package io.order.manager.food.order.manager.services;

import io.order.manager.food.order.manager.dto.FoodOrderDTO;
import io.order.manager.food.order.manager.dto.ProductDTO;
import io.order.manager.food.order.manager.entities.Product;

import java.util.List;

public interface FoodOrderService {
     FoodOrderDTO findOneOrder(int id);
     FoodOrderDTO saveOrder(FoodOrderDTO foodOrderDTO);
     void updateOrder(int id,FoodOrderDTO foodOrderDTO);
     String deleteOrder(int id );
     List<FoodOrderDTO> getAllOrders();

}
