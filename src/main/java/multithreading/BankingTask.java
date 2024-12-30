package multithreading;



public class BankingTask implements Runnable {
        private BankAccount account;



    public BankingTask(BankAccount account) {
            this.account = account;
        }
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                int amount = (int) (Math.random() * 1000);
                if (Math.random() > 0.5) {
                    account.deposit(amount);
                } else {
                    account.withdraw(amount);
                }

                // Simulate processing time
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.err.println("Thread interrupted: " + e.getMessage());
                }
            }
        }
}





