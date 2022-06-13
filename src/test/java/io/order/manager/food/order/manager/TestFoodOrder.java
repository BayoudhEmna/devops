package io.order.manager.food.order.manager;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.order.manager.food.order.manager.entities.Food_Order;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TestFoodOrder extends FoodOrderManagerApplicationTests {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;


    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

/*    @Test
    public void testCreateFoodOrder() throws Exception {
        Food_Order foodOrder = new Food_Order();
        foodOrder.setId(1);
        foodOrder.setReference("order2");
        foodOrder.setQuantity(4);
        foodOrder.setTotalPrice(1200);
        mockMvc.perform(post("/api/orders").contentType(MediaType.APPLICATION_JSON)
    }*/

    @Test
    public void testFoodOrder() throws Exception {
        mockMvc.perform(get("/api/orders")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("[0].id").value("1")).andExpect(jsonPath("[0].reference").value(" order 2")).andExpect(jsonPath("[0].totalPrice").value("340"))
                .andExpect(jsonPath("[0].quantity").value("4"));

    }
}
