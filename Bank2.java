/*object, class, instance, types of variable, types of methods.
reading run time value from keyboard, operator, control flow statements
and exception handling by using Bank application 
*/



import java.util.*;

class Address
{
	String dno;
	int strnum;
	String city;
}

class BankAccount 	
{					
	static String bankName;	
	static String branchName;
	static String ifsc;
	
	long accNum;
	String accHName;
	double balance;
	
	Address address;
	
	public void deposit(double amt) throws IllegalArgumentException
	{
		if(amt <= 0)
			throw new IllegalArgumentException("Do not pass -ve amount");
			this.balance = this.balance + amt;
			this.alert(amt, "credited to ");
	}
	
	public double withdraw(double amt) throws IllegalArgumentException, IllegalStateException
	{
		if(amt <= 0)
			throw new IllegalArgumentException("Do not pass -ve amount");
		if(amt > this.balance)
			throw new IllegalStateException("Insufficient Funds");
			this.balance = this.balance - amt;
			this.alert(amt, "debited from ");
			return amt;
	}
	
	private void alert(double amt, String action)
	{
		System.out.println("Cash "+ amt + " is "+action + "your account "+this.accNum);
		System.out.println("Current Balance in your account is: "+this.balance);
	}
	
	public void currentBalance()
	{
		System.out.println(this.balance);
	}
	
	public void transferMoney(BankAccount destAcc, double amt) throws IllegalArgumentException, IllegalStateException
	{
		this.withdraw(amt);
		destAcc.deposit(amt);
		System.out.println("Cash "+ amt + " is transfered to " + destAcc.accNum);
	}
	
	
	static void display(BankAccount acc)
	{
		System.out.println("Bank Name: "+bankName);
		System.out.println("Branch Name: "+branchName);
		System.out.println("IFSC Code: "+ifsc);
		System.out.println("Account Number: "+acc.accNum);
		System.out.println("Account Holder Name: "+acc.accHName);
		System.out.println("Address of account holder: "+acc.address.city);
	}
	
	
}

class Bank2 
{
	public static void main(String[] args) 
	{
		
		System.out.println("\n************** Welcome to e-Banking! *******************\n");
		int n, a, b, count=0, count1=0,count3=0,count4=0, w_amt;
		int des_acc, cr_amt, cr_ac, dis_ac, cnt=0;
		double amt;
		
		
		
		
		//static field initialization
		BankAccount.bankName	="HDFC";
		BankAccount.branchName	="Kashipur";
		BankAccount.ifsc		="H123AM";
		
		BankAccount acc1 = new BankAccount(); //HK
		BankAccount acc2 = new BankAccount(); //BK
		BankAccount acc3 = new BankAccount(); //PK
		
		//acc1 instance field initialization with HK object values;
		acc1.accNum		=12345678;
		acc1.accHName 	="Deepak Kumar";
		acc1.balance 	=15000;
		
		acc1.address	=new Address();
		acc1.address.dno="1-3/A-7";
		acc1.address.strnum=1;
		acc1.address.city	="Vadodara, Gujarat";	
		
		//acc2 instance fields initialization with BK object values
		acc2.accNum 	=23456789;
		acc2.accHName	="Roopak Kumar";
		acc2.balance	=20000;
		
		acc2.address =new Address();
		acc2.address.dno	="1-4/A-8";
		acc2.address.strnum	=1;
		acc2.address.city	="Alwar, Rajsthan";
		
		//acc3 instance fields initialization with PK object values
		acc3.accNum 	=34567890;
		acc3.accHName	="Neha Kumari";
		acc3.balance	=30000;
		
		acc3.address = new Address();
		acc3.address.dno		="2-5/B-8";
		acc3.address.strnum		=5;
		acc3.address.city 		="Kashipur, Uttarakhand";
		
		//performing business operation on acc1
		//acc1.deposit(5000);
		//amt = acc1.withdraw(8000);
		
		//acc1.currentBalance();
		//acc1.transferMoney(acc2, 5000);	
		
		
		
System.out.println("what you want to do....... select your option!");
		
		
		
		Scanner s = new Scanner(System.in);
		
		
		do {
			System.out.println("\n1. Check your Account Balance\n"
					+ "2. Withdraw Money\n"
					+ "3. Transfer money\n"
					+ "4. Credit money\n"
					+ "5. Account details\n"
					+ "6. Logout\n");
			n=s.nextInt();
		
		if(n==1)
		{	
			do {
			
			System.out.println("Enter account number: ");
			a = s.nextInt();
			if(a==acc1.accNum)
			{
				acc1.currentBalance();
				count++;
			}
			else if(a==acc2.accNum)
			{
				acc2.currentBalance();
				count++;
			}
			else if(a==acc3.accNum)
			{
				acc3.currentBalance();
				count++;
			}
			else
			{
				System.out.println("Account number doesn't matched");
			}
			}while(count !=1);
			count=0;	
		}
		
		else if(n==2)
		{
			do {
				
				System.out.println("Enter account number: ");
				b = s.nextInt();
				if(b==acc1.accNum)
				{	
					System.out.println("Enter amount: ");
					w_amt=s.nextInt();
					amt = acc1.withdraw(w_amt);
					count1++;
				}
				else if(b==acc2.accNum)
				{
					System.out.println("Enter amount: ");
					w_amt=s.nextInt();
					amt = acc2.withdraw(w_amt);
					count1++;
				}
				else if(b==acc3.accNum)
				{
					System.out.println("Enter amount: ");
					w_amt=s.nextInt();
					amt = acc3.withdraw(w_amt);
					count1++;
				}
				else
				{
					System.out.println("Account number doesn't matched");
				}
				}while(count1 !=1);
				count1=0;	
		}
		
		else if(n==3)
		{
			do {
				
				System.out.print("Enter your account number:");
				b = s.nextInt();
				System.out.print("Enter Destination account number:");
				des_acc=s.nextInt();
				
				if(b==acc1.accNum)
				{	
					if(des_acc==acc2.accNum)
					{	
						System.out.print("Enter Amount:");
						w_amt=s.nextInt();
						amt = acc1.withdraw(w_amt);
						acc2.deposit(w_amt);
						count3++;
					}
					else if(des_acc==acc3.accNum)
					{
						System.out.print("Enter Amount: ");
						w_amt=s.nextInt();
						amt = acc1.withdraw(w_amt);
						acc3.deposit(w_amt);
						count3++;
					}
					else
					{
						System.out.println("WARNING: Account number doesn't matched");
					}
					
					
				}
				else if(b==acc2.accNum)
				{
					if(des_acc==acc1.accNum)
					{	
						System.out.print("Enter Amount:");
						w_amt=s.nextInt();
						amt = acc2.withdraw(w_amt);
						acc1.deposit(w_amt);
						count3++;
					}
					else if(des_acc==acc3.accNum)
					{
						System.out.print("Enter Amount: ");
						w_amt=s.nextInt();
						amt = acc2.withdraw(w_amt);
						acc3.deposit(w_amt);
						count3++;
					}
					else
					{
						System.out.println("WARNING: Account number doesn't matched");
					}
				}
				else if(b==acc3.accNum)
				{
					if(des_acc==acc2.accNum)
					{	
						System.out.print("Enter Amount:");
						w_amt=s.nextInt();
						amt = acc3.withdraw(w_amt);
						acc2.deposit(w_amt);
						count3++;
					}
					else if(des_acc==acc1.accNum)
					{
						System.out.print("Enter Amount: ");
						w_amt=s.nextInt();
						amt = acc3.withdraw(w_amt);
						acc1.deposit(w_amt);
						count3++;
					}
					else
					{
						System.out.println("WARNING: Account number doesn't matched");
					}
				}
				else
				{
					System.out.println("WARNING: Account number doesn't matched");
				}
				
			}while(count3 !=1);
			count3=0;
		}
		
		else if(n==4)
		{
			System.out.print("Enter account number:");
			cr_ac = s.nextInt();
			
			do {
			if(cr_ac==acc1.accNum)
			{
				System.out.println("Enter amount:");
				cr_amt=s.nextInt();
				acc1.deposit(cr_amt);
				count4++;
			}
			else if(cr_ac==acc2.accNum)
			{
				System.out.println("Enter amount:");
				cr_amt=s.nextInt();
				acc2.deposit(cr_amt);
				count4++;
			}
			
			else if(cr_ac==acc3.accNum)
			{
				System.out.println("Enter amount:");
				cr_amt=s.nextInt();
				acc3.deposit(cr_amt);
				count4++;
			}
			else
			{
				System.out.println("WARNING: Account number doesn't matched");
			}
			
				}while(count4!=1);
			count4=0;
		
		}
		
		
		
		else if(n==5)
		{
			do {
			
			System.out.print("Enter Account number: ");
			dis_ac=s.nextInt();
			if(dis_ac==acc1.accNum)
			{
				acc1.display(acc1);
				cnt++;
			}
			else if(dis_ac==acc2.accNum)
			{
				acc2.display(acc2);
				cnt++;
			}
			else if(dis_ac==acc3.accNum)
			{
				acc3.display(acc3);
				cnt++;
			}
			else
			{
				System.out.println("Account number doesn't exist");
			}
			
			}while(cnt!=1);
			cnt=0;
		}
		
		
		else if(n==6)
		{
			System.out.println("Successfully Logout!\n"
					+ "Thankyou for using e-Banking!\n");
			System.exit(0);
		}
		
		else
		{
			System.out.println("Wrong choice!\nAccount successfully logout");
			
		}

		}while(n==1 || n==2 || n==3 || n==4 || n==5 ||n==6);
	}
}
