package com.test.BankProject;
import java.util.Scanner;

class Bank {
    private String accno;
    private String name;
    private long balance;
    private String address;
    private String typeac;
    private String dob;

    Scanner sc = new Scanner(System.in);

    //method to open an account
    void openAccount() {
        System.out.print("Enter Account No: ");
        accno = sc.next();
        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.print("Enter your Address : ");
        address = sc.next();
        System.out.print("Enter Balance: ");
        balance = sc.nextLong();
        System.out.print("Enter Date of birth(dd-mm-yyyy) : ");
        dob = sc.next();
        System.out.print("Enter type of account(SB/CA/TD/LOAN) : ");
        typeac = sc.next();
    }

    //method to display account details
    void showAccount() {
        System.out.print("Customer Name : "+name);
        System.out.print("\nDate of Birth : "+dob);
        System.out.print("\n Account NUmber : "+accno);
        System.out.print("\nAccount type : "+typeac);
        System.out.print("\nAddress : "+address);
        System.out.print("\nAccount Balance : "+balance);
    }

    //method to search an account number
    boolean search(String acn) {
        if (accno.equals(acn)) {
            showAccount();
            return (true);
        }
        return (false);
    }
}

public class BankProject {
    public static void main(String arg[]) {
        Scanner KB = new Scanner(System.in);

        //create initial accounts
        System.out.print("How Many Customer U Want to Input : ");
        int n = KB.nextInt();
        Bank Customer[] = new Bank[n];
        for (int i = 0; i < Customer.length; i++) {
            Customer[i] = new Bank();
            Customer[i].openAccount();
        }

        //run loop until menu 5 is not pressed
        int ch;
        do {
            System.out.println("\n\nMain Menu\n1. Display All\n2. Search By Account\n3. Delete an account\n4. Exit ");
                System.out.println("Ur Choice :"); ch = KB.nextInt();
                switch (ch) {
                    case 1:
                        for (int i = 0; i < Customer.length; i++) {
                            Customer[i].showAccount();
                        }
                        break;

                    case 2:
                        System.out.print("Enter Account No U Want to Search...: ");
                        String acn = KB.next();
                        boolean found = false;
                        for (int i = 0; i < Customer.length; i++) {
                            found = Customer[i].search(acn);
                            if (found) {
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Search Failed..Account Not Exist..");
                        }
                        break;
                    case 3:
                    	System.out.println("Enter the account number of the acccount you would like to delete: ");
                    	String accDelete = KB.next();
                    	Bank obj = new Bank();
                    	obj = null;
                    	System.out.println("Account number: " + accDelete + " has been deleted");
                    	break;
                    case 4:
                        System.out.println("Good Bye..");
                        break;
                }
            }
            while (ch != 4);
        }
    }
