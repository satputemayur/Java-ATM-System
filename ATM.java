import java.text.DecimalFormat;
import java.util.*;

// Base class for accounts
class Account {
    DecimalFormat df = new DecimalFormat("###,##0.00 'Rupees'");

    private int cn;
    private int b;

    double currentBalance = 2000;
    double savingBalance = 3000;

    void setCustomerNumber(int a) {
        cn = a;
    }

    void setPinNumber(int b) {
        this.b = b;
    }

    int getCustomerNumber() {
        return cn;
    }

    int getPinNumber() {
        return b;
    }

    void getCurrentBalance() {
        System.out.println("\nCurrent Balance: " + df.format(currentBalance));
    }

    void getSavingBalance() {
        System.out.println("\nSaving Balance: " + df.format(savingBalance));
    }

    void withdrawCurrent(double amount) {
        if (amount <= currentBalance) {
            currentBalance -= amount;
            System.out.println("Withdrawal successful. New Current Balance: " + df.format(currentBalance));
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void withdrawSaving(double amount) {
        if (amount <= savingBalance) {
            savingBalance -= amount;
            System.out.println("Withdrawal successful. New Saving Balance: " + df.format(savingBalance));
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void fixedDepositCurrent(double amount) {
        if (amount <= currentBalance) {
            currentBalance -= amount;
            System.out.println("Fixed Deposit of " + df.format(amount) + " created from Current Account.");
        } else {
            System.out.println("Not enough balance for fixed deposit!");
        }
    }

    void fixedDepositSaving(double amount) {
        if (amount <= savingBalance) {
            savingBalance -= amount;
            System.out.println("Fixed Deposit of " + df.format(amount) + " created from Saving Account.");
        } else {
            System.out.println("Not enough balance for fixed deposit!");
        }
    }
}

// Menu and login system
class OptionMenu extends Account {
    Scanner sc = new Scanner(System.in);
    HashMap<Integer, Integer> data = new HashMap<>();

    void getLogin() {
        data.put(11111, 111);
        data.put(22222, 222);
        data.put(33333, 333);
        data.put(44444, 444);
        data.put(55555, 111);

        int i = 0;
        do {
            try {
                System.out.println("\nWelcome to the ATM");
                System.out.print("Enter the Customer Number: ");
                int a = sc.nextInt();
                setCustomerNumber(a);

                System.out.print("Enter the PIN Number: ");
                setPinNumber(sc.nextInt());

                if (data.containsKey(getCustomerNumber()) && data.get(getCustomerNumber()) == getPinNumber()) {
                    System.out.println("Login Successfully!");
                    getAccountType();
                    return;
                } else {
                    System.out.println("Wrong Customer Number or PIN.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nPlease enter numbers only. Try again.");
                sc.nextLine(); // clear buffer
            }
            i++;
        } while (i < 3);

        System.out.println("Too many failed attempts. Exiting.");
    }

    void getAccountType() {
        System.out.println("\nPlease select the account type:");
        System.out.println("1: Current Account");
        System.out.println("2: Saving Account");
        System.out.println("3: Exit");
        System.out.print("Choice: ");

        int ch = sc.nextInt();
        switch (ch) {
            case 1 -> getCurrent();
            case 2 -> getSaving();
            case 3 -> {
                System.out.println("Thank you for visiting!");
                System.out.println("Visit again.");
            }
            default -> {
                System.out.println("Invalid Choice. Try again.");
                getAccountType();
            }
        }
    }

    void getCurrent() {
        System.out.println("\nCurrent Account Menu:");
        System.out.println("1: Check Balance");
        System.out.println("2: Withdraw Money");
        System.out.println("3: Fixed Deposit");
        System.out.println("4: Exit");
        System.out.print("Choice: ");

        int ch = sc.nextInt();
        switch (ch) {
            case 1 -> {
                getCurrentBalance();
				
                getCurrent();
            }
            case 2 -> {
                System.out.print("Enter amount to withdraw: ");
                double amt = sc.nextDouble();
                withdrawCurrent(amt);
                getCurrent();
            }
            case 3 -> {
                System.out.print("Enter amount for Fixed Deposit: ");
                double amt = sc.nextDouble();
                fixedDepositCurrent(amt);
                getCurrent();
            }
            case 4 -> getAccountType();
            default -> {
                System.out.println("Invalid Choice. Try again.");
                getCurrent();
            }
        }
    }

    void getSaving() {
        System.out.println("\nSaving Account Menu:");
        System.out.println("1: Check Balance");
        System.out.println("2: Withdraw Money");
        System.out.println("3: Fixed Deposit");
        System.out.println("4: Exit");
        System.out.print("Choice: ");

        int ch = sc.nextInt();
        switch (ch) {
            case 1 -> {
                getSavingBalance();
                getSaving();
            }
            case 2 -> {
                System.out.print("Enter amount to withdraw: ");
                double amt = sc.nextDouble();
                withdrawSaving(amt);
                getSaving();
            }
            case 3 -> {
                System.out.print("Enter amount for Fixed Deposit: ");
                double amt = sc.nextDouble();
                fixedDepositSaving(amt);
                getSaving();
            }
            case 4 -> getAccountType();
            default -> {
                System.out.println("Invalid Choice. Try again.");
                getSaving();
            }
        }
    }
}

// Main class
public class ATM {
    public static void main(String[] args) {
        OptionMenu opm = new OptionMenu();
        opm.getLogin();
    }
}
