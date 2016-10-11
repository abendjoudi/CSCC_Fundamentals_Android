package com.alibendjoudi.Week_05;

import java.util.List;
import java.util.ArrayList;


class Contact
{
    String name;
    String email;

    Contact(String name, String email)
    {
        this.name = name;
        this.email = email;
    }
}

class AddressBook
{
     List<Contact> contacts = new ArrayList<>();

    void add(Contact contact)
    {
        contacts.add(contact);
    }

    String searchByName(String name)
    {
        for(Contact entry: contacts)
        {
            if (entry.name.equals(name))
            {
                return entry.email;
            }
        }
        return null;
    }
}

public class Main
{
    public static void main(String[] args)
    {
        AddressBook addressBook = new AddressBook();
        Contact Paul = new Contact("Paul", "Paul@Hotmail.com");
        Contact Peter = new Contact("Peter", "PeterP@Gmail.com");
        Contact Ali = new Contact("Ali", "AliA@Gmail.com");

        addressBook.add(Paul);
        addressBook.add(Peter);
        addressBook.add(Ali);

        System.out.println("Paul email address is: " + addressBook.searchByName("Paul"));

    }
}