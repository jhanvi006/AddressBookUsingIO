package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddressBookTest {
    private AddressBookDB addressBookDB;
    @Test
    public void givenContactDetailsInDB_WhenRetrieved_ShouldMatchEmployeeCount(){
        addressBookDB = new AddressBookDB();
        List<Contacts> contactsList = addressBookDB.readData();
        System.out.println(contactsList);
        Assertions.assertEquals(4, contactsList.size());
    }
    @Test
    public void givenEmail_WhenUpdated_ShouldMatch(){
        addressBookDB = new AddressBookDB();
        addressBookDB.updateContact("pooja@gmail.com", "Patel");
        boolean result = addressBookDB.checkEmployeePayrollInSyncWithDB("pooja@gmail.com");
        Assertions.assertTrue(result);
    }
}
