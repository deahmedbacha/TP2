// Part 1 Validate a transfer

public class TransferService {

    public void transfer(BankAccount source, BankAccount destination, double amount) throws BankingException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Le nombre doit être positif");
        }
        if (source == null || destination == null) {
            throw new InvalidAccountException("compte n'existe pas");
        }
        if (source == destination) {
            throw new InvalidAccountException("source est destination sont identiques");
        }
        if (amount > 10000) {
            throw new TransferLimitExceededException("transfert limité (10000euro)");
        }
        if (amount > source.getBalance()) {
            throw new InsufficientFundsException("solde insuffisant");
        }

        source.debit(amount);
        try {
            destination.credit(amount);
        } catch (RuntimeException e) {
            source.credit(amount);
            throw e;
        }
    }
}
