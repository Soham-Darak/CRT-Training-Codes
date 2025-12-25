class SuperSuperClass{
    SuperSuperClass(String name,int rno){
        System.out.println(name+ " : "+ rno);
        System.out.println("**********************************************************");
    }
}
class superClass extends SuperSuperClass{
    superClass(int a, double b,int c){
        super("Soham", 44);
        System.out.println("--------------------------------------------------------");
        System.out.println("Super Class Constructor");
        System.out.println(a*b*c);
    }
    void print(){
        System.out.println("Super Class");
    }
}
class subClass extends superClass{
    subClass(int a,int b){
        super(10,20,30);


        System.out.println("Sub Class Constructor");
        System.out.println(a+b);
    }
    void show(){
        System.out.println("Sub Class");
    }
}
public class inheritance {
    public static void main(String[] args) {
        subClass op = new subClass(10,20);
        op.print();
        op.show();
    }
}
