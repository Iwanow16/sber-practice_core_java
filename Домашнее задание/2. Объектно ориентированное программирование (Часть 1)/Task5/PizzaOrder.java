public class PizzaOrder {
    private String title;
    public enum Size {
        SMALL,
        MEDIUM,
        BIG
    }
    private Size size;
    private boolean sauce;
    private String adress;
    private boolean orderAccepted = false;

    public PizzaOrder(String title, String size, boolean sauce, String adress){
        this.title = title;
        
        switch(size){
            case "SMALL":
                this.size = Size.SMALL; 
                break;
            case "MEDIUM":
                this.size = Size.MEDIUM; 
                break;
            case "BIG":
                this.size = Size.BIG; 
                break;
        }

        this.sauce = sauce;
        this.adress = adress;
    }

    public void order(){
        if (orderAccepted){
            System.out.println("Заказ уже принят");
            return;
        }
        orderAccepted = true;

        String SizePizza;
        switch(size){
            case SMALL:
                SizePizza = "Маленькая"; 
                break;
            case MEDIUM:
                SizePizza = "Средняя"; 
                break;
            case BIG:
                SizePizza = "Большая"; 
                break;
            default:
                SizePizza = "Маленькая";
        }
        String saucePresence;
        if (sauce){
            saucePresence = "с соусом";
        }
        else {
            saucePresence = "без соуса";
        }
        System.out.println(String.format("Заказ принят. %s пицца <<%s>> %s на адрес %s", SizePizza, title, saucePresence, adress));
    }
    public void cancel(){
        if (orderAccepted){
            orderAccepted = false;
            System.out.println("Заказ отменён");
        } 
        else {
            System.out.println("Заказ не был принят");
        }
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSize(String size) {
        switch(size){
            case "SMALL":
                this.size = Size.SMALL; 
                break;
            case "MEDIUM":
                this.size = Size.MEDIUM; 
                break;
            case "BIG":
                this.size = Size.BIG; 
                break;
        }
    }

    public void setSauce(boolean sauce) {
        this.sauce = sauce;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTitle() {
        return title;
    }

    public Size getSize() {
        return size;
    }

    public boolean getSauce() {
        return sauce;
    }

    public String getAdress() {
        return adress;
    }

    @Override
    public String toString() {
        return String.format("Название пиццы: %s \nРазмер пиццы: %s \nСоус заказан: %s \nЗаказ принят: %s \nАдрес: %s", title, size, sauce, orderAccepted, adress);
    }
}
