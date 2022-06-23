import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BankOnline {
    
    public static boolean isNumeric(String str) { 
        try {  
          Double.parseDouble(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
      }

    private boolean isBlocked(String cardNumber){
        try (BufferedReader bReader = new BufferedReader(new FileReader("Домашнее задание\\4. Исключения\\BlockedCards.txt"))) {
            String bCard = bReader.readLine();
            while (bCard != null){
                bCard = bCard.replaceAll("\\s+", "");
                if (cardNumber.equals(bCard))
                    return true;
                bCard = bReader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом");
        }
        return false;
    }

    public void send(String cardNumber, Double money) {
        try{
            if (cardNumber == null){
                throw new NullCardNumbertException("Номер карты не введён");
            }
            if (money == null){
                throw new NullCardNumbertException("Сумма перевода не введена");
            }
            cardNumber = cardNumber.replaceAll("\\s+", "");
            
            if (cardNumber.length() != 16 || !isNumeric(cardNumber)){
                throw new InvalidCardNumberException("Некоректно указан номер карты");
            }
            if (isBlocked(cardNumber)){
                throw new BlockedCardException("Карта заблокирована");
            }
            if (money > 50000){
                throw new OutOfLimitTransferException("Превышен лимит перевода");
            }
            if (money < 0) {
                throw new NegativeTransferException("Перевод не может быть отрицательным");
            }

        } catch(NullCardNumbertException nullCardEx) {
            System.out.println(nullCardEx.getMessage());
        } catch (InvalidCardNumberException invalidCardNumEx){
            System.out.println(invalidCardNumEx.getMessage());
        } catch (BlockedCardException blockedCardEx){
            System.out.println(blockedCardEx.getMessage());
        } catch (OutOfLimitTransferException limitTransferEx){
            System.out.println(limitTransferEx.getMessage());
        } catch (NegativeTransferException negativeTransferEx) {
            System.out.println(negativeTransferEx.getMessage());
        }
    }
}
