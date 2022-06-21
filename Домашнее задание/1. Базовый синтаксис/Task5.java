// Задание 5

public class Task5 
{
    public static void main( String[] args ) 
    {
        int i, j;
        boolean flag;
 
        for ( i = 2; i < 100; i++ ) {
            flag = true;
 
            for ( j = 2; j <= i / j; j++ ) 
            {
                if (( i % j ) == 0)
                flag = false;
            }
            if (flag)
                System.out.print( i + " ");
        }
    }
}