public class Triangle extends Figure{
    
    private double firstSide;
    private double secondSide;
    private double thirdSide;

    public Triangle(Point point, double firstSide, double secondSide, double thirdSide) {
        super(point, "треугольник");
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    public double area(){
        double p = perimeter() / 2;
        return Math.sqrt(p * (p-firstSide) * (p-secondSide) * (p-thirdSide));
    }

    public double perimeter(){
        return (firstSide + secondSide + thirdSide); 
    }

    public void setFirstSide(double firstSide) {
        this.firstSide = firstSide;
    }

    public void setSecondSide(double secondSide) {
        this.secondSide = secondSide;
    }

    public void setThirdSide(double thirdSide) {
        this.thirdSide = thirdSide;
    }

    public double getFirstSide() {
        return firstSide;
    }

    public double getSecondSide() {
        return secondSide;
    }

    public double getThirdSide() {
        return thirdSide;
    }
}
