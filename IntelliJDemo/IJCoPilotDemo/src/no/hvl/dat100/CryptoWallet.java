package no.hvl.dat100;

public class CryptoWallet extends DigitalWallet {

    private String currency;

    public CryptoWallet(String owner, String currency) {
        super(owner);
        this.currency = currency;

    }

    public void showStatus() {

        System.out.println("CryptoWallet");
        System.out.println(super.toString());
        System.out.println("Currency: " + currency);
    }

    public boolean pay(double amount, double rate) {

        double tobepaid = amount * rate;

        if (tobepaid > this.getBalance()) {
            return false;
        }

        this.setBalance(this.getBalance() - tobepaid);

        return true;
    }
}
