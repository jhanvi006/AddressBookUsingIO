package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Dictionary {
    public static void cityPersonDictionary(HashMap<String, ArrayList<Contacts>> addressBookList) {
        Hashtable<String, String> cityPersonDict = new Hashtable();
        for (Map.Entry<String, ArrayList<Contacts>> contactDetails:addressBookList.entrySet()) {
            for (Contacts contact: contactDetails.getValue()) {
                String person = contact.getFirstName()+" "+contact.getLastName();
                cityPersonDict.put(person, contact.getCity());
            }
        }
        System.out.println(cityPersonDict);
    }

    public static void statePersonDictionary(HashMap<String, ArrayList<Contacts>> addressBookList) {
        Hashtable<String, String> statePersonDict = new Hashtable();
        for (Map.Entry<String, ArrayList<Contacts>> contactDetails:addressBookList.entrySet()) {
            for (Contacts contact: contactDetails.getValue()) {
                String person = contact.getFirstName()+" "+contact.getLastName();
                statePersonDict.put(person, contact.getState());
            }
        }
        System.out.println(statePersonDict);
    }
}