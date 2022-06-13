package io.order.manager.food.order.manager.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Food_Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String reference;
    private long totalPrice;
    private int quantity;

    /*@OneToMany(fetch = FetchType.LAZY,mappedBy = "food_order",cascade = CascadeType.ALL)*/
    @OneToMany(mappedBy = "food_order")
    private List<Product> products;



    public Food_Order() {
    }

    public Food_Order(String reference, long totalPrice, int quantity, List<Product> products) {
        this.reference = reference;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.products = products;
    }

    public Food_Order(int id, String reference, long totalPrice, int quantity) {
        this.id = id;
        this.reference = reference;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }



    @Override
    public String toString() {
        return "Food_Order{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", totalPrice=" + totalPrice +
                ", quantity=" + quantity +
                '}';
    }
}
