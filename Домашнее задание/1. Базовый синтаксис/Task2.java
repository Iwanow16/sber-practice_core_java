// Задание 2

public class Task2 
{
    public static void quickSort(int[] array, int left, int right) 
    {
        if (array.length == 0) return;
        if (left >= right) return;

        int centralElement = left + (right - left) / 2;
        int pollingElement = array[centralElement];

        int i = left, j = right;
        while (i <= j) {
            while (array[i] < pollingElement) 
            {
                i++;
            }
            while (array[j] > pollingElement) 
            {
                j--;
            }

            if (i <= j) 
            {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j) quickSort(array, left, j);
        if (right > i) quickSort(array, i, right);
    }
    public static void main(String[] args) {
        int[] arr = { 12, -13, 24, 43, 3, 7, 20, 0, -23, 11, 0, -1};
   
        int left = 0;
        int right = arr.length - 1;

        quickSort(arr, left, right);

        for (int i : arr) 
        {
            System.out.print(i + " ");
        }
    }
}