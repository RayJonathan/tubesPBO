package Model;

public class ATMCard {
    private String cardNumber;
    private double saldo;
    private int pin;

    public ATMCard(String cardNumber, double saldo, int pin) {
        this.cardNumber = cardNumber;
        this.saldo = saldo;
        this.pin = pin;
    }
    
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public int getPin() {
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }
}
