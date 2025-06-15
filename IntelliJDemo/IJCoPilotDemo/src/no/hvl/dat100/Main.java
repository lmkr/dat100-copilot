package no.hvl.dat100;

public class Main {

    public static void main(String[] args) {

        CryptoWallet w1 = new CryptoWallet("Henrik", "BitCoin");

        CryptoWallet w2 = new CryptoWallet("Eva", "Ethereum");

        CryptoWallet w3 = new CryptoWallet("Kari", "Trumph Coin");

        CryptoWallet[] ws = {w1, w2, w3};

        for(CryptoWallet w : ws) {
            w.showStatus();
        }
    }

}
