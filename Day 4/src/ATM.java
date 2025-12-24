import java.util.*;
/*
    Types of Access Modifiers:
    1. Public
    2. Default
    3. Protected
    4. Private-Protected : Only SubClasses
    5. Private
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
    void SETCustomerNumber(int cn){
        CN = cn;
        // Applet and Sublet
    }

    void SETPINNumber(int pn){
        this.pn = pn;
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
    void GETLogin(){
        System.out.println("Welcome to the ATM");

        // Enter Customer Number
        System.out.print("\nEnter Customer Number: ");
        SETCustomerNumber(sc.nextInt());

        // Enter PIN Number
        System.out.println("Enter PIN Number: ");
        SETPINNumber(sc.nextInt());

    }
}

public class ATM extends OptionMenu {
    // 1. Main Method
    Scanner sc = new Scanner(System.in); // Global Variable because we are going to use it multiple time.
    public static void main(String[] args) {
        OptionMenu op = new OptionMenu();
        op.GETLogin();
        // We have used encapsulation So Far
    }
}
