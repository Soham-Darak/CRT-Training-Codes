import java.util.*;
import java.text.*;

/*
    Types of Access Modifiers:
    1. Public
    2. Default
    3. Protected
    4. Private-Protected: Only SubClasses
    5. Private

    While Loop is for Entry Controller
    Do-While Loop is for Exit Controller
    Lang Package Handel the Exception Handling
    Lang Package is the Brain of Java
    Lang -> Thread -> Sleep (to delay the message)
    lang -> Throwable (Super super sub class) -> Exception (Sub Class)

    Check Exception: Throw and Throws


    UnCheck Exception: Try and Catch
    Always write type of exception in catch block.
*/

class Account{
    /*
        Methods That will be created here are:
        6. SETCustomerNumber();
        7. SETPINNumber();
        8. GETCustomerNumber();
        9. GETPINNumber()
        10. GETCurrentBalance();
        11. GETSavingBalance();
        12. GETCurrentWithDrawInput();
        13. GETSavingWithDrawInput();
        14. GETCurrentDepositInput();
        15. GETSavingDepositInput();
        16. CalcCurrentWithDraw();
        17. CalcSavingWithDraw();
        18. CalcCurrentDeposit();
        19. CalcSavingDeposit();
    */

    private int CN;
    private int pn;
    Scanner sc = new Scanner(System.in); // Global Variable because we are going to use it multiple time.
    double CB = 2000; // Current Balance
    double SB = 1000; // Saving Balance

    DecimalFormat df1 = new DecimalFormat("###,##0.00' Rupee'"); // For Current Account
    DecimalFormat df2 = new DecimalFormat("###,##0.00' Dollar'"); // For Saving Account

    void SETCustomerNumber(int cn){ // setter
        CN = cn;
        // Applet and Sublet
    }

    void SETPINNumber(int pn){ // setter
        this.pn = pn;
    }

    // When we RETURN it becomes getter, so we are using int
    int GETCustomerNumber() { // Getter
        return CN;
    }

    int GETPINNumber(){ // Getter
        return pn;
    }

    void GETCurrentBalance(){
        System.out.println("\nCurrent Account Balance: "+df1.format(CB)+ "\n");
    }

    void GETSavingBalance(){
        System.out.println("\nSaving Account Balance: "+df2.format(SB)+ "\n");
    }

    void GETCurrentWithdrawInput(){
        System.out.println("\nCurrent Account Balance: "+df1.format(CB)+ "\n");
        System.out.print("Enter the Withdraw Amount: ");

        double amount = sc.nextDouble();

        if((CB-amount) >= 0){ // CB>=amount
            System.out.println("\nTransaction Successful.");
            CalcCurrentWithdraw(amount);
            System.out.println("\nNew Current Account Balance: "+df1.format(CB)+ "\n");

        }
        else{
            System.err.println("\n Insufficient Balance\n");
        }
    }

    void GETSavingWithdrawInput(){
        System.out.println("\nSaving Account Balance: "+df2.format(SB)+ "\n");
        System.out.print("Enter the Withdraw Amount: ");

        double amount = sc.nextDouble();

        if((CB-amount) >= 0){ // CB>=amount
            System.out.println("\nTransaction Successful.");
            CalcSavingWithdraw(amount);
            System.out.println("\nNew Current Account Balance: "+df2.format(SB)+ "\n");

        }
        else{
            System.err.println("\n Insufficient Balance\n");
        }
    }

    double CalcCurrentWithdraw(double amount){
        CB = CB - amount;
        return CB;
    }

    double CalcSavingWithdraw(double amount){
        SB = SB - amount;
        return SB;
    }



    void SETCustomerNumber(){

    }

    void SETPINNumber(){

    }

}

class OptionMenu extends Account{
    /*
        Methods That will be created here are:
            2. GETLogin();
            3. GETAccountType();
            4. GETCurrent();
            5. GETSaving();
    */


    Scanner sc = new Scanner(System.in); // Global Variable because we are going to use it multiple time.
    HashMap<Integer,Integer> data = new HashMap();

    void GETLogin() {
        do{
            try { // Using Exception Handling.
                System.out.println("\nWelcome to the ATM");

                // Enter Customer Number
                System.out.print("\nEnter Customer Number: ");
                SETCustomerNumber(sc.nextInt()); // Exception will occur mostly on this line

                // Enter PIN Number
                System.out.print("Enter PIN Number: ");
                SETPINNumber(sc.nextInt()); // Exception will occur mostly on this line

                // Input the Data
                data.put(11111,111);
                data.put(11112,222);
                data.put(11113,333);
                data.put(11114,444);
                data.put(11115,111);

                int P = GETCustomerNumber();
                int Q = GETPINNumber();

                // We have used encapsulation So Far
                // Login as Customer with Valid Pin.
                if(data.containsKey(P) && data.get(P) == Q){
                    GETAccountType();
                }
                else{
                    System.out.println("\nInvalid Customer Number or PIN Number\n");
                }
            }
            catch (InputMismatchException ime){
                System.err.println("\nPlease Input Only Numbers, Characters and Symbols are not allowed \n");
                System.out.println("Enter the Valid Customer Number or PIN Number");
                sc.next(); // talkes next line as an input
                GETLogin();
            }
        } while(true);
    }

    //Getting Account Details
    void GETAccountType(){
        System.out.println("\nACCOUNT TYPE");
        System.out.println("\nType 1: Current Account");
        System.out.println("Type 2: Saving Account");
        System.out.println("Type 3: Exit");
        System.out.print("\nChoice: ");

        int ch = sc.nextInt();

        switch (ch){
            case 1: // Current Account GETCurrent()
                GETCurrent();
                break;
            case 2: // Saving Account GETSaving()
                GETSaving();
                break;
            case 3:
                System.out.println("\nThank You for VISITING.");
                System.out.println("VISIT AGAIN... \n");
                System.out.println("-----------------------------------------------------------------------------");
                //We won't call the GETLogin Function for the Security purpose.
                // We will put the entire block in the Do-While Loop
                break;
            default:
                System.out.println("\nInvalid Choice");
                System.out.println("Enter the VALID CHOICE \n"); // We will use Recursion to call the initial Method
                GETAccountType(); // Recursion
                break;
        }
    }

    void GETCurrent(){
        System.out.println("\nCURRENT ACCOUNT");
        System.out.println("\nType 1: Balance Enquiry");
        System.out.println("Type 2: Withdraw Money");
        System.out.println("Type 3: Deposit Money");
        System.out.println("Type 4: Exit");
        System.out.print("\nChoice: ");

        int ch = sc.nextInt();

        switch (ch){
            case 1:
                GETCurrentBalance();
                GETAccountType();
                break;
            case 2:
                GETCurrentWithdrawInput();
                GETAccountType();
                break;
            case 3:
                break;
            case 4:
                System.out.println("\nThank You for VISITING.");
                System.out.println("VISIT AGAIN... \n");
                System.out.println("-----------------------------------------------------------------------------");
                break;
            default:
                System.out.println("\nInvalid Choice");
                System.out.println("Enter the VALID CHOICE \n"); // We will use Recursion to call the initial Method
                GETCurrent(); // Recursion
                break;
        }
    }

    void GETSaving(){
        System.out.println("\nSAVING ACCOUNT");
        System.out.println("\nType 1: Balance Enquiry");
        System.out.println("Type 2: Withdraw Money");
        System.out.println("Type 3: Deposit Money");
        System.out.println("Type 4: Exit");
        System.out.print("\nChoice: ");

        int ch = sc.nextInt();

        switch (ch){
            case 1:
                GETSavingBalance();
                GETAccountType();
                break;
            case 2:
                GETSavingWithdrawInput();
                GETAccountType();
                break;
            case 3:
                break;
            case 4:
                System.out.println("\nThank You for VISITING.");
                System.out.println("VISIT AGAIN... \n");
                System.out.println("-----------------------------------------------------------------------------");
                break;
            default:
                System.out.println("\nInvalid Choice");
                System.out.println("Enter the VALID CHOICE \n"); // We will use Recursion to call the initial Method
                GETSaving(); // Recursion
                break;
        }
    }

}

public class ATM extends OptionMenu {
    // 1. Main Method
    Scanner sc = new Scanner(System.in); // Global Variable because we are going to use it multiple time.
    public static void main(String[] args) {
        OptionMenu op = new OptionMenu();
        // op.GETLogin();
        op.GETAccountType();
    }
}
