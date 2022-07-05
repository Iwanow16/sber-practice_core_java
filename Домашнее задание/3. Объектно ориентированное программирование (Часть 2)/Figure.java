public abstract class Figure implements Drawable{
    
    private String nameFigure;
    private Point point;

    public Figure(Point point, String nameFigure){
        this.point = point;
        this.nameFigure = nameFigure;
    }

    public abstract double area();
    public abstract double perimeter();

    public void draw(){
        System.out.printf("Нарисован %s с координатами ( %s , %s )", nameFigure, point.getX(), point.getY());
    }

    public void draw(Color color){
        System.out.printf("Нарисован %s с координатами ( %s , %s ). Цвет: %s", nameFigure, point.getX(), point.getY(), color);
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

}
