package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Search {
    static Scanner sc = new Scanner(System.in);
    public static ArrayList<Contacts> searchByCity(HashMap<String, ArrayList<Contacts>> addressBookList){
        System.out.println("Enter city name for contact search: ");
        String cityName = sc.next();
        for (Map.Entry<String, ArrayList<Contacts>> contactDetails:addressBookList.entrySet()) {
            for (Contacts contact: contactDetails.getValue()) {
                boolean checkCityName = cityName.equalsIgnoreCase(contact.getCity());
                if (checkCityName){
                    System.out.println("-------------------------");
                    System.out.println(contactDetails.getKey());
                    System.out.println(contact);
                }
            }
        }
        return null;
    }
    public static ArrayList<Contacts> searchByState(HashMap<String, ArrayList<Contacts>> addressBookList){
        System.out.println("Enter state name for contact search: ");
        String stateName = sc.next();
        for (Map.Entry<String, ArrayList<Contacts>> contactDetails:addressBookList.entrySet()) {
            for (Contacts contact: contactDetails.getValue()) {
                boolean checkStateName = stateName.equalsIgnoreCase(contact.getState());
                if (checkStateName){
                    System.out.println("-------------------------");
                    System.out.println(contactDetails.getKey());
                    System.out.println(contact);
                }
            }
        }
        return null;
    }
}