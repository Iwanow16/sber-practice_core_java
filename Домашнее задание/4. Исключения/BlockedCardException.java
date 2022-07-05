public class BlockedCardException extends BankOnlineException{

    public BlockedCardException() {}

    public BlockedCardException(String message) {
        super(message);
    }
}