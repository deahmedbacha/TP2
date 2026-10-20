//Part 2 - Create domain-specific exceptions
public class InvalidAccountException extends BankingException {
    public InvalidAccountException(String message) {
        super(message);
    }
}
