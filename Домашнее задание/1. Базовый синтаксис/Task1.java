// Задание 1

public class Task1 
{
    // Сортировка пузырьком
    public static void bubbleSort(int[] arr) 
    { 
        for (int i = 0; i < arr.length; i++) 
        {
            for (int j = 0; j < arr.length-1; j++) 
            {
                if (arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
       
    public static void main(String[] args) 
    {
        int[]array = new int[]{10, 3, 4, 1, 6, 8, 3, 4, 8, 5};
        
        bubbleSort(array);

        for (int i : array) 
        {
            System.out.print(i + " ");
        }
    }
}
