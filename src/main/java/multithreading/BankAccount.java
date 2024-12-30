package multithreading;

public class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amounts){
        balance += amounts;
        System.out.println(Thread.currentThread().getName() + " deposited " + amounts + ". New balance: " + balance);
    }

    public synchronized void withdraw (int amount){
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". New balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + " but insufficient balance. Current balance: " + balance);
        }
    }
    public int getBalance() {
        return balance;
    }
}

