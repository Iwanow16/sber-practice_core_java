import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class RemoveExtraSpaces {
    public static void main(String[] args) {
        
        String pathFileReader = "Домашнее задание\\5. Потоки ввода вывода\\Убрать лишние пробелы\\Borodino.txt";
        String pathFileWriter = "Домашнее задание\\5. Потоки ввода вывода\\Убрать лишние пробелы\\Borodino (Edited).txt";
        
        try (BufferedReader fileInputStream = new BufferedReader(new FileReader(pathFileReader)); 
            BufferedWriter fileOutputStream = new BufferedWriter(new FileWriter(pathFileWriter))){
                String line;
                while((line = fileInputStream.readLine()) != null){
                    fileOutputStream.write(line.replaceAll("\s{2,}", " ") + "\n");
                }
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
