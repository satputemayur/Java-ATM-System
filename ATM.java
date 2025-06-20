import java.text.*;
import java.util.*;

class Account {

    DecimalFormat df= new DecimalFormat("###,##0.00 'Rupees' ");

    private int cn;
    private int b;
    double CB=2000;
    void setCustomerNumber(int a){
        cn = a;
        
    }
    void setPinNumber (int b){
    	this.b=b;
    }
    int getCustomerNumber(){
    	return cn;
    }
    int getPinNumber (){
    	return b;
    }

    void getCurrentBalance()
    {
        System.out.println("\nCurrent Balance: " +df.format(CB));
    }
}

class  OptionMenu extends Account {
   Scanner sc = new Scanner(System.in);
   HashMap<Integer, Integer> data = new HashMap<>();
	void getLogin() {
		int i = 1;
		do {
		try {
			data.put(11111, 111);
			data.put(22222, 222);
			data.put(33333, 333);
			data.put(44444, 444);
			data.put(55555, 111);
			
	        System.out.println("\nWelcome to the ATM");
	        System.out.println("Enter the Customer Number");
	        int a = sc.nextInt();
	        setCustomerNumber(a);
	        System.out.println("Enter the PIN Number");
	        setPinNumber(sc.nextInt());
	        
	        int P = getCustomerNumber();
	        int Q = getPinNumber();
	        
	        if(data.containsKey(P) && data.get(P) == Q) {
	        	System.out.println("Login Successfully rohit");
	        	getAccountType();
	        	
	        } else {
	        	System.out.println("Wrong Customer Number and PIN Number");
	        }
			
		} catch(InputMismatchException e) {
			System.out.println("\nPlease Enter only numbers");
			System.out.println("Characters and Symbols are not allowed");
			i = 10;
			
		}
		
		}while(i <= 5);
    }
	
	void getAccountType() {
		System.out.println("\nPlease select the account type you want access");
		System.out.println("Type 1 : Current Account");
		System.out.println("Type 2 : Saving Account");
		System.out.println("Type 3 : Exit");
		System.out.print("\nChoice : ");
		
		int ch = sc.nextInt();
		switch(ch){
			case 1:
				getCurrent();
				break;
			case 2:
				getSaving();
				break;
			case 3:
				System.out.println("Thank You for visiting");
				System.out.println("visit again");
				break;
			default : 
				System.out.println("Invalid Choice");
				System.out.println("Please Enter Valid Choice");
				getAccountType();
				break;
			
		}
	}
	
	void getCurrent() {
		System.out.println("\nCurrent account");
        System.out.println("\nType 1: Check Balance");
        System.out.println("\nType 2: Withdraw Money");
        System.out.println("\nType 3: Fixed Deposite");
        System.out.println("\nType 4: Exit");
        System.out.println("\nChoice :");

        int ch = sc.nextInt();
        switch(ch){
			case 1:
				getCurrentBalance();
                getAccountType();
				break;
			case 2:
				
				break;
            case 3:

                break;
			case 4:
				System.out.println("Thank You for visiting");
				System.out.println("visit again");
				break;
			default : 
				System.out.println("Invalid Choice");
				System.out.println("Please Enter Valid Choice");
				getAccountType();
				break;
			
		}

	}
	
	void getSaving() {
		System.out.println("\nSaving account");
        System.out.println("\nType 1 : Check  Balance");
        System.out.println("\nType 2 : Withdrw Money");
        System.out.println("\nType 3 : Fixed Deposite");
        System.out.println("\n Type 4: Exit");
        System.out.println("\nChoice :");

        int ch = sc.nextInt();
        switch(ch){
			case 1:
				
				break;
			case 2:
				
				break;
            case 3:

                break;
			case 4:
				System.out.println("Thank You for visiting");
				System.out.println("visit again");
				break;
			default : 
				System.out.println("Invalid Choice");
				System.out.println("Please Enter Valid Choice");
				getAccountType();
				break;
			
		}

	}
	
}

class  ATM extends OptionMenu {
    public static void main(String[] args) {
        OptionMenu opm = new OptionMenu();
        opm.getLogin();
    }
}