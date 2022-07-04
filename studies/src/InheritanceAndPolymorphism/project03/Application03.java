package InheritanceAndPolymorphism.project03;

import InheritanceAndPolymorphism.project03.entities.Circle;
import InheritanceAndPolymorphism.project03.entities.Rectangle;
import InheritanceAndPolymorphism.project03.entities.Shape;
import InheritanceAndPolymorphism.project03.entities.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Application03 {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        List<Shape> shapeList = new ArrayList<>();

        System.out.print("Enter the number of shapes: ");
        Integer shapes = input.nextInt();
        for(int shape = 1; shape< shapes+1; shape++){
            System.out.println("Shape #" + shape + " data: ");
            System.out.print("Rectangle or Circle (r/c)? ");
            char format = input.next().charAt(0);
            System.out.print("Color (BLACK/BLUE/RED): ");
            String color = input.next();

            switch (format){
                case 'r':
                    System.out.println("SHAPE OF RECTANGLE");
                    System.out.println();
                    System.out.print("Width: ");
                    Double width = input.nextDouble();
                    System.out.print("Height: ");
                    Double height = input.nextDouble();
                    shapeList.add(new Rectangle(Color.valueOf(color), width, height));
                    break;

                case 'c':
                    System.out.println("SHAPE OF CIRCLE");
                    System.out.println();
                    System.out.print("Radius: ");
                    Double radius = input.nextDouble();
                    shapeList.add(new Circle(Color.valueOf(color), radius));
                    break;

                default:
                    System.out.println("ERROR: INVALID OPTION. DISREGARDED COUNT");
                    break;
            }
        }
        System.out.println();
        System.out.println("SHAPE AREAS");
        for(Shape shp: shapeList){
            System.out.println(shp.area());
        }
    }
}
