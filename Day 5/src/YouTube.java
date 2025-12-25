/*
    We are using Collection, ArrayList
    Creating a Data for the customer for the customer who subscribes our channel,
    a Notification will be given to them, and if he unsubscribes no notification will be provided

*/

import java.util.*;

class Channel{

    List<CustomerSubscriber> c = new ArrayList();
    String title;

    void subscriber(CustomerSubscriber sub){
        c.add(sub);
    }
    void unSubscribe(CustomerSubscriber sub){
        c.remove(sub);
    }
    void upload(String title){
        this.title = title;
        notifySubscriber();
    }
    void notifySubscriber(){
        for (CustomerSubscriber sub : c) {
            sub.update();
        }
    }
}

class CustomerSubscriber{
    String name;
    Channel worldAffairs = new Channel();

    CustomerSubscriber(String name){
        this.name = name;
    }
    void subSubscribeChannel(Channel ch){
        worldAffairs = ch;
    }
    void update(){
        System.out.println("Hello: "+name+", Video Uploaded "+worldAffairs.title);
    }
}
public class YouTube {
    public static void main(String[] args) {

        Channel op = new Channel();

        CustomerSubscriber cs1 = new CustomerSubscriber("Soham");
        CustomerSubscriber cs2 = new CustomerSubscriber("Rohit");
        CustomerSubscriber cs3 = new CustomerSubscriber("Priyanshu");
        CustomerSubscriber cs4 = new CustomerSubscriber("Rohit");
        CustomerSubscriber cs5 = new CustomerSubscriber("Yash");

        op.subscriber(cs1);
        op.subscriber(cs2);
        op.subscriber(cs3);
        op.subscriber(cs4);
        op.subscriber(cs5);

        op.unSubscribe(cs2);

        cs1.subSubscribeChannel(op);
        cs2.subSubscribeChannel(op);
        cs3.subSubscribeChannel(op);
        cs4.subSubscribeChannel(op);
        cs5.subSubscribeChannel(op);

        op.upload("INDIA-CHINA RELATION");

    }
}
