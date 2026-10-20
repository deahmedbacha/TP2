//Part 2 - Create domain-specific exceptions
public class TransferLimitExceededException extends BankingException {
    public TransferLimitExceededException(String message) {
        super(message);
    }
}
