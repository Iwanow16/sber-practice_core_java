public class PhoneTest {
    public static void main(String[] args) {
        
        Phone phone1 = new Phone("+7(921)861-58-69", "xiaomi redmi note 11", 200);
        Phone phone2 = new Phone("+7(921)116-46-18", "xiaomi redmi note 9 pro");
        Phone phone3 = new Phone();

        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(phone3);

        System.out.println(phone1.getNumber());

        phone1.receiveCall("Никита");
        phone3.receiveCall("Сергей", "+7(921)116-46-18");

        Phone.sendMessage();
    }
}
