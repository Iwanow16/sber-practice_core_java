public class Square extends Rectangle{
    
    public Square(Point point, double side) {
        super(point, side, side);
    }

    public void setSide(double side){
        super.setWidth(side);
        super.setHeight(side);
    }

    public double getSide() {
        return getHeight();
    }
}
