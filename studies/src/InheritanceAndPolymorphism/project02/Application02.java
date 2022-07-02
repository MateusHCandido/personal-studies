package InheritanceAndPolymorphism.project02;


    /* Make a program to read the data of N products (N supplied by the user). At the end, show the price tag
     * of each product in the same order they were entered.*/

    /* Every product has a name and price. Imported products have a customs fee, and used products have a date
     * of manufacturing. These specific data must be added to the price tag. For imported products, the fee and
     * customs must be added at the end of the product.*/

import InheritanceAndPolymorphism.project02.entities.ImportedProduct;
import InheritanceAndPolymorphism.project02.entities.Product;
import InheritanceAndPolymorphism.project02.entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Application02 {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Product product = new Product();
        Product importedProduct = new ImportedProduct();
        Product usedProduct = new UsedProduct();
        List<Product> productList= new ArrayList<>();

        System.out.print("Enter the number of products: ");
        Integer numberP = input.nextInt();

        for(int prod = 1; prod < numberP+1; prod ++){
            System.out.println("Product #" + prod + " data: ");
            System.out.print("Common, used or imported (c/u/i)?");
            char type = input.next().charAt(0);

            switch (type){
                case 'c':
                    System.out.print("Name: ");
                    String name = input.next();
                    System.out.print("Price: $ ");
                    Double price = input.nextDouble();
                    product = new Product(name, price);
                    productList.add(product);
                    break;

                case 'u':
                    System.out.print("Name: ");
                    name = input.next();
                    System.out.print("Price: $ ");
                    price = input.nextDouble();
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    Date manufactureDate = sdf.parse(input.next());
                    usedProduct = new UsedProduct(name, price, manufactureDate);
                    productList.add(usedProduct);
                    break;

                case 'i':
                    System.out.print("Name: ");
                    name = input.next();
                    System.out.print("Price: $ ");
                    price = input.nextDouble();
                    System.out.print("Customs fee: ");
                    Double customsFee = input.nextDouble();
                    importedProduct = new ImportedProduct(name, price, customsFee);
                    productList.add(importedProduct);
                    break;
            }
        }
        System.out.println();
        System.out.println("PRICE TAGS: ");
        for(Product products: productList){
            System.out.println(products.priceTag());
        }
    }
}
