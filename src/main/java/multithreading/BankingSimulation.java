package multithreading;

public class BankingSimulation {
    public static void main(String[] args) {
        BankAccount bank = new BankAccount(5000);

        Runnable r = new Runnable() {
            public void run() {
                bank.deposit(5000);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.err.println(Thread.currentThread().getName() + " interrupted: " + e.getMessage());
                }
                bank.withdraw(500);
            }
        };

        Thread t2 = new Thread( r, "User-2");
        Thread t1 = new Thread(r, "User-1");
        Thread t3 = new Thread(r, "User-3");

        t1.start();
        t2.start();
        t3.start();


        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("Final balance: " + bank.getBalance());
    }
}


