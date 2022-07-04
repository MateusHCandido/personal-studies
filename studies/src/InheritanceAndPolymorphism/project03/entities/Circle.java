package InheritanceAndPolymorphism.project03.entities;
import InheritanceAndPolymorphism.project03.entities.enums.Color;

public class Circle extends  Shape{

    private static Double pi = 3.14d;
    private Double radius;

    public Circle(){
        super();
    }

    public Circle(Color color, Double radius){
        super(color);
        this.radius =radius;
    }

    @Override
    public Double area(){
        return pi * Math.pow(radius, 2);
    }
}
