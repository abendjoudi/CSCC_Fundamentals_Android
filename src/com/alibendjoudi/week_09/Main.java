package com.alibendjoudi.week_09;

import java.util.ArrayList;
import java.util.List;


abstract class Contact{
        private String name;

    Contact (String name){

        this.name=name;


    }
    abstract public void contact();

}

class Emailcontact extends Contact{
    private String email;

    Emailcontact(String name,String email){
        super(name);
        this.email=email;

    }

    @Override
    public void contact() {
        System.out.println("Emailing "+email);
    }
}

class Phonecontact extends Contact{
    private String phonenumber;

    Phonecontact(String name,String phonenumber){

        super(name);
        this.phonenumber=phonenumber;

    }
    @Override
    public void contact() {
        System.out.println("Calling "+phonenumber);
    }

}

public class Main {
    public static void main (String[] args){

        Phonecontact bob =new Phonecontact("bob","123-145-2220");
        Emailcontact sue=new Emailcontact("sue","sue@email.com");

         List<Contact> contacts = new ArrayList<>();

        contacts.add(bob);
        contacts.add(sue);

        for (Contact c: contacts) {
            c.contact();
        }




    }

}
