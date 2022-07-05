public class TestPizzaOrder {
    public static void main(String[] args) {
        
        PizzaOrder pizzaOrder = new PizzaOrder("Карбонара", "BIG", true, "Городской вал 26");
        pizzaOrder.cancel();
        pizzaOrder.order();
        pizzaOrder.cancel();

        System.out.println(pizzaOrder);

        pizzaOrder.setAdress("Городской вал 26А");
        pizzaOrder.setSauce(true);
        pizzaOrder.setSize("MEDIUM");
        pizzaOrder.setTitle("Колбаски барбекю");
        
        System.out.println();

        pizzaOrder.order();
        System.out.println(pizzaOrder.getAdress());
        System.out.println(pizzaOrder.getSauce());
        System.out.println(pizzaOrder.getTitle());
        System.out.println(pizzaOrder.getSize());
        System.out.println(pizzaOrder);
    }
}