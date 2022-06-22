public class PaintExample {
    public static void main(String[] args) {

        Point point1 = new Point(5, 5);
        Circle circle = new Circle(point1, 8.0);
        circle.draw(Color.красный);

        Point point2 = new Point(201, 305);
        Square square = new Square(point2, 200);
        System.out.println("Сторона: " + square.getSide());
        System.out.println("Площадь: " + square.area());
        System.out.println("Периметр: " + square.perimeter());
        square.draw();

        Point point3 = new Point(101, 405);
        Rectangle rectangle = new Rectangle(point3, 9.0, 10.0);
        System.out.println("Площадь: " + rectangle.area());
        System.out.println("Периметр: " + rectangle.perimeter());
        rectangle.draw(Color.синий);

        Point point4 = new Point(601, 205);
        Triangle triangle = new Triangle(point4, 6, 6,6);
        System.out.println("Площадь: " + triangle.area());
        System.out.println("Периметр: " + triangle.perimeter());
        triangle.draw();
    }
}
