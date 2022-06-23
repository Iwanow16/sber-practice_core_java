public class NegativeTransferException extends BankOnlineException{

    public NegativeTransferException() {}

    public NegativeTransferException(String message) {
        super(message);
    }
}