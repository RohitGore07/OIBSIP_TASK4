package atm;

import java.util.Scanner;

public class BankTransaction {
	
	String name;
	String uName;
	String pword;
	Double accNo;
	String accType;
	String TransactionHistory="";
	
	int transaction=0;
	float bankBalance=100000f;
	Scanner sc=new Scanner(System.in);
	public void register() {
	System.out.println("Enter Name: ");
	name=sc.nextLine();
	System.out.println("Enter UserName: ");
	uName=sc.nextLine();
	System.out.println("Enter Password: ");
	pword=sc.nextLine();
	System.out.println("Enter Account Number: ");
	accNo=Double.parseDouble(sc.nextLine());
	System.out.println("Enter Account Type");
	accType=sc.nextLine();
	System.out.println("Registration Completed....Please login");
	
	}
	
	public boolean login() {
		System.out.println("Enter UserName: ");
		String uN=sc.nextLine();
		System.out.println("Enter password: ");
		String pW=sc.nextLine();
		if(uN.equals(uName)&& pW.equals(pword)) {
		
		return true;
		}
		else {
		return false;
	}
	}
	
	public void withdraw() {
		System.out.println("Enter The Amount You Want to Withdraw :");
		float amt=Float.parseFloat(sc.nextLine());
		if(bankBalance>=amt) {
			transaction++;
			bankBalance=bankBalance-amt;
			String th=amt+" Amount Withdraw Sucessfuly \n";
			System.out.println(th);
			TransactionHistory =TransactionHistory.concat(th);
		}
		else
		{
			System.out.println
			("Insufficient Balance");
		}
	}
	public void deposite() {
		System.out.println(" Enter The Amount You want to deposite : ");
		float amt=Float.parseFloat(sc.nextLine());
		if(amt<=100000f) {
			transaction++;
			bankBalance=bankBalance+amt;
			String t2=amt+" Amount Deposite Sucessfuly \n";
			System.out.println(t2);
			TransactionHistory = TransactionHistory.concat(t2);
		}
		else
		{
			System.out.println
			("opps!!! Limit is 100000");
		}
	}
	public void showBalance() {
		System.out.println(" Available Balance Is: " +bankBalance);
	}
	
	public void transfer() {
		System.out.println("\nEnter Receipent's Name : ");
		String rName = sc.nextLine();
		System.out.println("\nEnter Amount to transfer : ");
		float amt = Float.parseFloat(sc.nextLine());
		if(bankBalance >= amt) {
			if(amt<=50000f) {
				transaction++;
				bankBalance = bankBalance-amt;
				System.out.println("\nSuccessfully Transfered to "+ rName);
				String th =amt + " Rs transaction to "+ rName +"\n";
				TransactionHistory = TransactionHistory.concat(th);
			}
			else {
				System.out.println("\nSorry....Limit Is 50000.00");
			}
		}
		else {
			System.out.println("\nInsufficient Balance");
		}
	}
	
	public void TransactionHistory() {
		
		if(transaction==0) {
			System.out.println("\nNo Transaction Available");
		}
		else {
			System.out.println("\n" +TransactionHistory);
		}
		
	}
	
	public class Atm_Transaction{
		public static void main(String args[]) {
			Scanner sc=new Scanner(System.in);
			boolean loop1=true;
			boolean loop2=true;
			boolean loop3=true;
			
			while(loop1) {
				System.out.println("**********WELCOME TO ATM**********");
				System.out.println("\n1.Register\n2.Exit");
				int choice=Integer.parseInt(sc.nextLine());
				switch(choice) {
				case 1:
					BankTransaction at=new BankTransaction();
					at.register();
					
					while(loop2) {
						System.out.println("\n1.Login \n2.Exit");
						int z=Integer.parseInt(sc.nextLine());
						switch(z) {
						case 1:
							boolean isLogin=at.login();
							if(isLogin)
							{
								System.out.println("Welcome back " +at.name);
								while(loop3) {
									System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.check Balance \n5.Transaction History \n6.Exit");
									System.out.println("\nEnter Your Choice : ");
									int choice1=Integer.parseInt(sc.nextLine());
									switch(choice1) {
									case 1:
										at.withdraw();
										break;
									case 2:
										at.deposite();
										break;
									case 3:
										at.transfer();
										break;
									case 4:
										at.showBalance();
										break;
									case 5:
										at.TransactionHistory();
										break;
									case 6:
										loop3=false;
										System.out.println("Thank You ");
										break;
									}//end switch
								}//end of loop3
							}//end of if
							
							else {
								
								System.out.println("opps...Incorrect UserName/Password");
							}//else
							break;
						case 2:
							loop2=false;
							System.out.println("Thank You ");
							break;
						}//end of outer switch
					}//loop1
				}
			}
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
