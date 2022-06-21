// Задание 8

import java.util.Scanner;
public class Task8 
{
    public static void main(String[] args) 
    {
        System.out.println("Внимание загадка:");
        System.out.println("Что это такое: синий, большой, с усами и полностью набит зайцами?");
        System.out.println("У тебя 3 попытки");
        
        int chances = 3;
        Scanner scanner = new Scanner(System.in);

        while (chances > 0) 
        {
            String answer = scanner.nextLine();
            System.out.println(answer); 
            
            switch (answer) {
                case ("Троллейбус"): 
                System.out.println("Правильно!"); 
                chances = -1;
                break; 

                case ("Сдаюсь"): 
                System.out.println("Правильный ответ: троллейбус"); 
                chances = -1;
                break;

                default: 
                System.out.println("Неправильный ответ, давай еще раз");
                chances -= 1;
            }
        }
        if (chances == 0)
        {
            System.out.println("Ты проиграл! Правильный ответ: Троллейбус");
        }
        scanner.close();
    }
}