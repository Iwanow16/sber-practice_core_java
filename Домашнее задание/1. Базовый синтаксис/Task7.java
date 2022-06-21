// Задание 7

public class Task7 
{
    public static int fib(int i) 
    {
        if (i == 1) return 1;
        if (i == 2) return 1;
        return fib(i - 1) + fib(i - 2);
    }
    public static void main(String[] args) 
    {
        int n = 11; // Количество цифр

        for (int i = 1; i <= n; i++) 
        {
            System.out.print(fib(i) + " ");
        }
    }
}