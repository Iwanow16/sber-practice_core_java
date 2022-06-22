public class Phone {
    
    private String number;
    private String model;
    private int weight;

    public Phone(String number, String model, int weight){
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public Phone(String number, String model){
        this.number = number;
        this.model = model;
        weight = 0;
    }

    public Phone(){
        number = "Not specified";
        model = "Not specified";
        weight = 0;
    }

    public String getNumber(){
        return number;
    }

    public void receiveCall(String name){
        System.out.println("Звонит " + name);
    }

    public void receiveCall(String name, String number){
        System.out.println("Звонит: " + name);
        System.out.println("Номер: " + number);
    }

    public static void sendMessage(){
        String[] numbers = {"+7(921)535-40-45", "+7(921)626-24-54", "+7(921)268-25-85"};
        
        for (String string : numbers) {
            System.out.println(string);
        }
    }

   @Override
    public String toString(){
        return String.format("Номер: %s \nМодель: %s \nВес: %s", number, model, weight);
    }
}
