/*

*/
/* Paramaterised Constructor
class constructor{
    String name;
    int a;
    constructor(String name, int a){
        this.name = name;
        this.a = a;
        System.out.println();

    }
}
 */


//Copy Constructor
class Copyconstructor{
    constructor obj1;
    Copyconstructor(constructor obj1){
        this.obj1 = obj1;
    }
}
class constructor{
    String name;
    int a;
    constructor(String name, int a){
        this.name = name;
        this.a = a;
        System.out.println();

    }
}
public class CopyConstructor {
    public static void main(String[] args) {
        constructor op = new constructor("Soham", 12345);
        Copyconstructor op1 = new Copyconstructor(op); // When we pass object as a reference it is said to be copy constructor
      //  constructor op = new constructor("Soham", 12345); -> Paramaterised Constructor
    }
}
