import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class NameSorting {
    public static void main(String[] args) {
        String pathFileReader = "Домашнее задание\\5. Потоки ввода вывода\\Сортировка имён\\listNames.txt";
        String pathFileWriter = "Домашнее задание\\5. Потоки ввода вывода\\Сортировка имён\\listNames (Edited).txt";

        try (BufferedReader fileInputStream = new BufferedReader(new FileReader(pathFileReader)); 
            BufferedWriter fileOutputStream = new BufferedWriter(new FileWriter(pathFileWriter))){
                
                String line = fileInputStream.readLine();
                String[] words = line.split(" ");
                Arrays.sort(words);

                for (String string : words) {
                    fileOutputStream.write(string + " ");
                }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}