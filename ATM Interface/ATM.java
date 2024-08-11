import java.util.Scanner;

class Main {
    public static void main(String[] args) 
    {
        ATM bankAccount = new ATM();
        int choice;
        int temp;
        String Continue = "Y";
        Scanner sc = new Scanner(System.in);

        do 
        {
            System.out.println("\n1) Deposit amount");
            System.out.println("2) Withdraw amount");
            System.out.println("3) Check balance");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            System.out.println();

            if (choice == 1) 
            {
                System.out.print("Enter amount to deposit: ");
                temp = sc.nextInt();
                bankAccount.deposit(temp);
            }
            
            else if (choice == 2) 
            {
                System.out.print("Enter amount to withdraw: ");
                temp = sc.nextInt();
                bankAccount.withdraw(temp);
            } 
            
            else if (choice == 3) 
            {
                bankAccount.checkBalance();
            }
            
            else 
            {
                System.out.println("Please enter a valid option!");
            }

            // Flushing the buffer by consuming the leftover newline
            sc.nextLine();
            System.out.print("Would you like to continue? [Y/N]: ");
            Continue = sc.nextLine();

        } while (Continue.equalsIgnoreCase("Y"));

        System.out.println("THANK YOU!");
    }
}

class ATM {
    private Account account;

    ATM() 
    {
        account = new Account();
        System.out.println("WELCOME TO OUR ATM! \n");
        System.out.print("Please enter Account name: ");
        Scanner sc = new Scanner(System.in);
        account.setName(sc.nextLine());
    }

    public void checkBalance() 
    {
        System.out.println("Current Balance is " + account.getBalance());
    }

    public void deposit(int amount) 
    {
        account.setBalance(account.getBalance() + amount);
        System.out.println(amount + " Successfully deposited");
        checkBalance();
    }

    public void withdraw(int amount) 
    {
        if (amount > account.getBalance()) {
            System.out.println("Insufficient balance");
            checkBalance();
            return;
        }

        account.setBalance(account.getBalance() - amount);
        System.out.println(amount + " Successfully withdrawn");
        checkBalance();
    }
}

class Account {
    private String name;
    private int balance = 0;

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public int getBalance() 
    {
        return balance;
    }

    public void setBalance(int balance) 
    {
        this.balance = balance;
    }
}
