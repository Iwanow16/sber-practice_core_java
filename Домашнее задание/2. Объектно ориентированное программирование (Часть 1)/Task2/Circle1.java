public class Circle1 {
    
    private double radius;
    private String color;

    public Circle1(double radius, String color){
        this.radius = radius;
        this.color = color;
    }

    public double area(){
        return (Math.PI * radius * radius); 
    }

    public double perimeter(){
        return (2 * Math.PI * radius);
    }
    
    public String toString(){
        return String.format("Радиус: %s \nЦвет: %s \nПлощадь: %s \nПериметр: %s", radius, color, area(), perimeter());
    }
}
