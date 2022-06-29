package enums.project03.entities;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {
    private Integer quantity;
    private Double price;
    private Product product;

    public OrderItem(){}

    public OrderItem(Integer quantity, Double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }


    public Double subTotal(){
       return price * quantity;
    }


    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        text.append(product.getName()).append(", ")
                .append("$").append(String.format("%.2f, ",price))
                .append("Quantity: ").append(quantity)
                .append(", Subtotal: ").append(String.format("%.2f",subTotal()))
                .append("\n");
        return String.valueOf(text);
    }


    public Integer getQuantity() {
        return quantity;
    }


    public Double getPrice() {
        return price;
    }


    public Product getProduct() {return product;}


    public void setProduct(Product product) {this.product = product;}
}
