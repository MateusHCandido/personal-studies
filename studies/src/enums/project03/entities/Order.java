package enums.project03.entities;

import enums.project03.entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date moment;
    private OrderStatus status;
    private List<OrderItem> items = new ArrayList<>();
    private Client client;

    public Order() {}

    public Order(Date moment, OrderStatus status, Client client){
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Order(Date moment, String status) {
    }


    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        text.append("ORDER MOMENT: ").append(sdf.format(getMoment())).append("\n");
        text.append("ORDER STATUS: ").append(getStatus()).append("\n");
        text.append("CLIENT: ").append(getClient()).append("\n");
        for (OrderItem item: items){
            text.append(item);
        }
        text.append("TOTAL PRICE: $").append(total(items)).append("\n");
        return String.valueOf(text);
    }
    public void addItem(OrderItem item){
        items.add(item);
    }


    public void removeItem(OrderItem item){
        items.remove(item);
    }


    public Double total(List<OrderItem> item){
        Double totalProducts = 0d;
        for (OrderItem prod: items) {
            totalProducts += items.get(item.indexOf(prod)).subTotal();
        }
        return totalProducts;
    }


    public Date getMoment() {
        return moment;
    }


    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {return status;}


    public void setStatus(OrderStatus status) {this.status = status;}


    public Client getClient() {return client;}


    public void setClient(Client client) {this.client = client;}

}
