public class TestCompensation {
    public static void main(String[] args) {
        BankAccount source = new BankAccount("ABD01", 2000);
        BankAccount destination = new BankAccount("ABD02", 500) {
            @Override
            public void credit(double amount) {
                throw new RuntimeException("Erreur credit");
            }
        };

        TransferService service = new TransferService();

        try {
            service.transfer(source, destination, 500);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Source balance: " + source.getBalance());
        System.out.println("Destination balance: " + destination.getBalance());
    }
}
