import java.util.*;
class NewUser{

    Scanner scan = new Scanner(System.in);
    public void newUserDetails(){

    
    System.out.println("New user?\nPress 1 to register: ");
            int newu= scan.nextInt();
            System.out.println("enter your name: ");
            String newUser = scan.nextLine();
            scan.nextLine();


            //members.add(newUser);
            System.out.println(("\ngenerate your customerID: \ncustomerID must contain 3 to 4 digits."));
            int newUserID = scan.nextInt();
        
            if(newUserID < 100 || newUserID > 9999){
                System.out.println("CUSTOMER ID MUST CONTATIN 3 TO 4 DIGITS.");
            }
            else{
                System.out.println("Welcome "+ newUser );
                BankingDetails bank = new BankingDetails();
                bank.show();
            }
            scan.close();
        }
         
}
class BankingDetails{
    Scanner scanner = new Scanner(System.in);
    public void show(){   
        //System.out.println("Welcome "+customerName);
        System.out.println("----------------------------------------------");
        System.out.println("We are here at your service.");
        System.out.println("A. Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");
        InnerBankingSystem obj= new InnerBankingSystem();
        while(true){
            System.out.println("Press a key of your choice.");
            char choice= scanner.next().charAt(0);
            switch (choice) {
                case 'a':
                case 'A':
                    System.out.println("Balance");
                    System.out.println("--------------------------------------");
                    System.out.println("Balance is: "+obj.balance);
                    break;
                case 'c':    
                case 'C':
                    System.out.println("Withdraw");
                    System.out.println("--------------------------------------");
                    System.out.println("enter an amount to withdraw: ");
                    int amount= scanner.nextInt();
                    obj.getWithdrawn(amount);
                    break;
                case 'b':   
                case 'B':
                    System.out.println("Deposit");
                    System.out.println("--------------------------------------");
                    System.out.println("enter an amount to deposit: ");
                    int amount2= scanner.nextInt();
                    obj.getDeposited(amount2);
                    break;
                case 'd':    
                case 'D': 
                    System.out.println("Previous Transaction");
                    System.out.println("--------------------------------------");
                    System.out.println("Previous Transaction is: ");
                    obj.getPreviousTransaction();
                    break;
                case 'e':    
                case 'E': 
                    System.out.println("Thanks for using our service.");
                    System.out.println("---------------------------------------");
                    System.exit(0);
                    break;        
                default:
                    System.out.println("Invalid choice, please enter correct key.");
                    break;
            }
        }

}
}
class BankingSystem2 {

    public  static void main(String[] args){
       
        Scanner sc= new Scanner(System.in);
        System.out.println("new user?...press1\nRegistered user?...press 2\n");
        int p=sc.nextInt();
        if(p==2){
        System.out.println("Enter your name: ");
        String customerName= sc.nextLine();
        sc.nextLine();
            System.out.println("Enter your customerId(3 to 4 digits): ");
            int customerId= sc.nextInt();
            if(customerId < 100 || customerId > 9999){
                System.out.println("Invalid customerId. Please recheck Your id.");
            }
            else{
                BankingDetails details = new BankingDetails();
                System.out.println("Welcome "+customerName);
                details.show();
            }
        
    }else if(p==1)
        {
            NewUser newuser = new NewUser();
            newuser.newUserDetails();
            BankingDetails details = new BankingDetails();
            details.show();

        }
        sc.close();

    }

}
/**
 * InnerBankingSystem
 */
 
     
class InnerBankingSystem {
    int balance=0;
    int previousTransaction=0;
    void getWithdrawn(int amount){
        if(balance>=amount){
            if(amount!=0){
                balance= balance-amount;
                previousTransaction= -amount;
                System.out.println("Withdrawn: "+amount);
            }
            else if(amount==0){
                System.out.println("Withdrawal amount is zero.");
            }    
        }
        else{
            
            System.out.println("You have insufficient amount balance. Can't process withdrawal operation.");
        }
    }
    void getDeposited(int amount2){
        if(amount2!=0){
            balance= balance + amount2;
            previousTransaction= amount2;
            System.out.println("Deposited: "+amount2);
        }else{
            System.out.println("Deposited amount is zero.");
        }

    }
    void getPreviousTransaction(){
        if(previousTransaction<0){
            System.out.println("Withdrawn: "+Math.abs(previousTransaction));
        }
        else if(previousTransaction>0){
            System.out.println("Deposited: "+previousTransaction);
        }
        else{
            System.out.println("No transaction occured yet.");
        }

    }


    
 }

