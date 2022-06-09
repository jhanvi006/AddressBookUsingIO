package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddressBookTest {
    private AddressBookDB addressBookDB;
    @Test
    public void givenEmployeePayrollInDB_WhenRetrieved_ShouldMatchEmployeeCount(){
        addressBookDB = new AddressBookDB();
        List<Contacts> contactsList = addressBookDB.readData();
        System.out.println(contactsList);
        Assertions.assertEquals(4, contactsList.size());
    }
}
