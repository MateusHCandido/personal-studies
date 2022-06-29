package enums.project03;

import enums.project03.entities.*;
import enums.project03.entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*Read the data of an order with N items (N provided by the user). Then show a summary of the order.
        Note: order time must be system time: new Date()*/
public class Application03 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        OrderItem orderItem;
        Product product;
        Client client;
        Order order = new Order();

        System.out.println("============================");
        System.out.println("     ENTER CLIENT DATA      ");
        System.out.println();
        //ENTERING CUSTOMER DATA
        System.out.print("NAME: ");
        String name = input.nextLine();
        System.out.print("EMAIL: ");
        String email = input.nextLine();
        System.out.print("BIRTH DATE (DD/MM/YYYY): ");
        String birthDate = input.nextLine();
        client = new Client(name, email, format.parse(birthDate)); // creation a new client
        System.out.println();
        System.out.println("============================");
        System.out.println("      ENTER ORDER DATA      ");
        System.out.println();
        //ORDER STATUS
        OrderStatus status = null;
        System.out.printf("[0] - PENDING_PAYMENT%n[1] - PROCESSING%n[2] - SHIPPED%n[3] - DELIVERED%n");
        System.out.println("STATUS: ");
        int option = input.nextInt();
        switch (option){
            case 0:
                status = OrderStatus.valueOf("PENDING_PAYMENT");
                break;

            case 1:
                status = OrderStatus.valueOf("PROCESSING");
                break;

            case 2:
                status = OrderStatus.valueOf("SHIPPED");
                break;

            case 3:
                status = OrderStatus.valueOf("DELIVERED");
                break;
        }
        //CREATION OF ORDER
        order = new Order(new Date(), status, client);
        //ORDER ENTRY
        System.out.print("HOW MANY ITEMS TO THIS ORDER? ");
        int repetition = input.nextInt();
        for(int index = 1; index < repetition+1; index++){
            System.out.println("----------------------------");
            System.out.println("ENTER #" + index + " ITEM DATA");
            System.out.println();
            System.out.print("PRODUCT NAME: ");
            String productName = input.next();
            System.out.print("PRODUCT PRICE: ");
            Double price = input.nextDouble();
            System.out.print("QUANTITY: ");
            Integer quantity = input.nextInt();
            product = new Product(productName, price);
            orderItem = new OrderItem(quantity, price, product);
            order.addItem(orderItem);
        }
        System.out.println("----------------------------");
        System.out.println();
        System.out.println("============================");
        System.out.println("       ORDER SUMMARY        ");
        System.out.println();
        System.out.println(order);
        System.out.println("============================");



    }
}
