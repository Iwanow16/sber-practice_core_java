import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class TestHero {
    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("Домашнее задание\\5. Потоки ввода вывода\\Сохранение и загрузка\\HeroSaveFile.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                FileInputStream fileInputStream = new FileInputStream("Домашнее задание\\5. Потоки ввода вывода\\Сохранение и загрузка\\HeroSaveFile.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                    // Сохранение
                    Weapon weapon = new Weapon("beginner's sword", 5);
                    Armor armor =  new Armor("beginner's armour", 3);
                    Hero hero = new Hero("Hero", weapon, armor);
                    objectOutputStream.writeObject(hero); 
                    // Загрузка
                    Weapon weapon1 = new Weapon("sword", 0);
                    Armor armor1 =  new Armor("armour", 0);
                    Hero hero1 = new Hero("", weapon1, armor1);
                    hero1 = (Hero) objectInputStream.readObject(); 
                    System.out.println();
                    hero1.showInformation();

        } catch (IOException e) {
            System.out.println(e.getMessage());;
        } catch (ClassNotFoundException classNotFoundEx) {
            System.out.println(classNotFoundEx.getMessage());
        }
    }
}
