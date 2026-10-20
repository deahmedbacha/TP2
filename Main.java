import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BankAccount compte1 = new BankAccount("ABD01", 2000);
        BankAccount compte2 = new BankAccount("ABD02", 500);
        TransferService service = new TransferService();
        Scanner scanner = new Scanner(System.in);

        try {
            BankAccount source = compte1;

            System.out.print("compte destination (ABD01 ou ABD02) ? : ");
            String numero = scanner.next();
            BankAccount destination = null;
            if (numero.equals("ABD01")) {
                destination = compte1;
            } else if (numero.equals("ABD02")) {
                destination = compte2;
            }

            System.out.print("solde a transferer ? : ");
            double amount = scanner.nextDouble();
            service.transfer(source, destination, amount);
            System.out.println("Transfer successful");
            System.out.println("Source balance: " + source.getBalance());
            System.out.println("Destination balance: " + destination.getBalance());
        } catch (InputMismatchException e) {
            System.out.println("Input error handled; program does not crash.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid amount: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (TransferLimitExceededException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidAccountException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (BankingException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("transaction terminée.");
            scanner.close();
        }
    }
}