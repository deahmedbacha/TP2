//Part 2 - Create domain-specific exceptions


public class BankingException extends Exception {
    public BankingException(String message) {
        super(message);
    }
}
