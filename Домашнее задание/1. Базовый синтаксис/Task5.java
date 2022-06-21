// Задание 5

public class Task5 
{
    public static void main(String[] args) 
    {
        
        int n = 10;
        double[] array = new double[n];

        for (int i = 0; i < array.length; i++) 
        {
            array[i] = (Math.random() * 98 + 2);
        }

        double max = array[0];
        double average = 0;

        for (int i = 0; i < array.length; i++) 
        {
            if(max < array[i]) max = array[i];
            average += array[i]/array.length;
        }

        System.out.println("max = " + max);
        System.out.println("avg = " + average);
    }
}
