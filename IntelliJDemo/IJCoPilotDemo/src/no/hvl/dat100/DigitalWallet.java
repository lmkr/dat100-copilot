package no.hvl.dat100;

public class DigitalWallet {

    private String owner;
    private double balance;

    public DigitalWallet(String owner) {
        this.owner = owner;
        this.balance = 0;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Owner: " + owner + "\nBalance: " + balance;
    }


}
