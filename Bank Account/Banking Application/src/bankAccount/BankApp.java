package bankAccount;
import java.io.FileOutputStream;
import java.util.*;
//Robert Choboy
//Revature Banking Application
//This program runs a bank account application.
//The requirements are as follows:
//1) Users can log in
//2) Users can view their existing accounts
//3) Users can deposit and withdraw from their accounts
//4) Users can create/delete account
//5) Users can sign out
//6) Accounts and user information are stored in text files

class UserAccount{
	
    String name,password,acctype;
    int Accnum,AccBalance;
    UserAccount(){
      }
        UserAccount(String n, String p, int acc_num,int b,String acctyp){
            name=n;
            password=p;
            Accnum=acc_num;
            AccBalance=b;
            acctype=acctyp;
        }
} 
//Extend Account class to create a new Account
class new_account extends UserAccount{
    new_account(String n, String p, int acc_num,int b,String type){ 
            name=n;
            password=p;
            Accnum=acc_num;
            AccBalance=b;
            acctype=type;
    }
    new_account(){
        super();
    }
    
    void insert(String n, String p, int acc_num,String type){  
        name=n;
        password=p;
        acctype=type;
        Accnum=acc_num; // generate random number 
        AccBalance=0;
    }
    //Display the details the user has entered into the system after they have selected an option
    void display_details(){
        System.out.println("Name of Person on Account : " +name);
        System.out.println("Password: " +password);
        System.out.println("Current Account Number : "+Accnum);
        System.out.println("Current Account Balance : "+AccBalance);
        System.out.println("Current Account Type : "+acctype);
    }
 
        void deposit(int acc_num,int dollarAmt){                 
                AccBalance=dollarAmt;    
        }
        
        int withdraw(int withd){
                AccBalance=AccBalance-withd;
                return AccBalance;
        }
		public Object get(int i) {
			// TODO Auto-generated method stub
			return null;
		}
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}
  
} 

   //Create a class to keep track of the interaction of the application   
   public class BankApp {
    public static void main(String args[]) {
        String user_name=null,type;
        String user_pass=null,type1;
        type1 = null;
        int balance=0, val=0;		
        int withd=0, currbal=0;
        	// generate random account number
        int randNumber = 0; 
        randNumber = (int)((Math.random() * 9000)+1000); 

       new_account user = new new_account("user", "pass",0,0,"savings"); 
    
       Scanner in = new Scanner(System.in);
       Scanner string=new Scanner(System.in);
       int choice;
       boolean exit = false;

            do {
            	  System.out.println("Welcome to Rob's Banking Application! ");
                  System.out.println("1. Create a new Account");
                  System.out.println("2. Deposit");
                  System.out.println("3. Withdraw");
                  System.out.println("4. Check balance");
                  System.out.println("5. Account Details");
                  System.out.println("6. Exit The Application  \n");
                  System.out.print("Enter Your Choice : ");
                  choice = in.nextInt();
                  switch (choice) {
                      
                  case 1:
                        System.out.print("Enter an Account Name you would like to use : ");
                        user_name=string.nextLine(); 
                        System.out.println(("Enter a unique Password : "));
                        user_pass=string.nextLine();
                        System.out.print("Enter Account Type : ");
                        type1=in.next();
                        user.insert(user_name, user_pass, randNumber, type1);  
                        System.out.println("\nYour Account has been Created:");
                        //Print what the User has typed in 
                        user.display_details();
                       
                   break;
                              
                case 2: // This will be used to keep track of deposits 
                    System.out.print("Enter your account Name : ");
                    user_name=string.nextLine(); 
                 if(user_name == user_name) 
                    System.out.println("Enter your account Password: ");
                    user_pass=string.nextLine();
                 if(user_pass == user_pass)
                 {
                	 System.out.print("Enter Amount Of Money You Would like To Deposit : ");
                 balance=in.nextInt();
                 user.AccBalance=balance;
                 System.out.println(" Successful Deposit ");
              }                
                else 
                    System.out.println("Wrong Account Name, Please try again ");          
                   break;
                
                  case 3: // This will be used to keep track of withdrawals                      
                     System.out.print("Enter your account Number : ");
                      val=in.nextInt();
                      
                          if(val==user.Accnum){                         
                             if(user.AccBalance==0)
                             System.out.print("The account is 0.");
                             
                             else{
                             System.out.print("Enter Amount: ");   
                             withd=in.nextInt();  
                             
                             if(withd>user.AccBalance){
                             System.out.print("Enter Amount: ");
                             withd=in.nextInt();
                             }
                             else
                             currbal= user.withdraw(withd);
                             System.out.println("Your Current Balance is : "+currbal);   
                             }
                          }
                             else
                             System.out.println("Invalid Accoount Number.");  
                        break;
     
                  case 4: 
                      System.out.print("Enter your Account Number : ");
                      val=in.nextInt();
                             if(val==user.Accnum){
                             System.out.println("Your Current Balance : "+user.AccBalance);
                             }
                             else
                             System.out.println("Wrong Accoount Number.");                         
                      break;
                      
                  case 5:
                      System.out.print("Enter your Account Number :");
                      val=in.nextInt();             
                      
                             if(val==user.Accnum){                               
                             user.display_details();                             
                        }else
                             System.out.println("Wrong Accoount Number.");
                             
                      break;
                  case 6:
                        exit = true;
                        break;
                  default:
                        System.out.println("Wrong Choice.");
                        break;
                  }
                  System.out.println("\n");
            } while (!exit);
    
            try {
          	   FileOutputStream fos = new FileOutputStream("C:\\Users\\Alyss Choboy\\eclipse-workspace\\Banking Application\\src\\UserInfo");
         	   
         			   for (int i = 0; i<user.size(); i++)
          				   
          			   {
          				   String s = user.get(i).toString() + "\n";
          				   byte[] b = s.getBytes();
          				   fos.write(b);
          				   
         			   }
          				   fos.close();
             }catch (Exception e) {System.out.println(e);}
        
            
            
    }
   }
           
    
    




         
           








