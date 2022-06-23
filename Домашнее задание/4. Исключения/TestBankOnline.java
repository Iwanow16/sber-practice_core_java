public class TestBankOnline {
    public static void main(String[] args) {
        BankOnline bank = new BankOnline();

        bank.send(null, 49_999.0);
        bank.send("1111 1111 1111 1112", null);
        bank.send("1111 1111 1111 1111", 10_000.0);
        bank.send("1111 1111 1111 1112", 60_000.0);
        bank.send("1111 1111 1111 1112", -60_000.0);
    }
}
