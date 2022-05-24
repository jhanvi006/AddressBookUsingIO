package com.bridgelabz;

import java.util.ArrayList;

interface AddressBookInterface{
    void createAddressBook(AddressBookSystem addressDetails);
    void displayActionMenu(AddressBookSystem addressDetails, ArrayList<Contacts> contactDetails);
    ArrayList<Contacts> addDetails(ArrayList<Contacts> contactDetails);
    void editDetails(ArrayList<Contacts> contactDetails);
    void deleteContact(ArrayList<Contacts> contactDetails);
    ArrayList<Contacts> displayContacts();
    void searchContact();
    void dictionary();
    void countContact();
    void sortContactsByName(ArrayList<Contacts> contactDetails);
    void sortContacts(ArrayList<Contacts> contactDetails);
}