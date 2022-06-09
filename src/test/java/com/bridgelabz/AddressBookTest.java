package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class AddressBookTest {
    private AddressBookDB addressBookDB;
    @Test
    public void givenContactDetailsInDB_WhenRetrieved_ShouldMatchContactCount(){
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
    @Test
    public void givenDates_WhenRetrieved_ShouldMatchContactCount(){
        addressBookDB = new AddressBookDB();
        List<Contacts> contactsList = addressBookDB.retrieveDataByDate("2020-01-01");
        System.out.println(contactsList);
        Assertions.assertEquals(1, contactsList.size());
    }
    @Test
    public void givenCityAndState_WhenRetrieved_ShouldMatchContactCount(){
        addressBookDB = new AddressBookDB();
        List<Contacts> contactsList = addressBookDB.retrieveDataByCityOrState("Ahmedabad", "Maharashtra");
        System.out.println(contactsList);
        Assertions.assertEquals(3, contactsList.size());
    }
    @Test
    public void addNewContact_ShouldMatchContactCount(){
        addressBookDB = new AddressBookDB();
        addressBookDB.addContact();
        List<Contacts> contactsList = addressBookDB.readData();
        System.out.println(contactsList);
        Assertions.assertEquals(6, contactsList.size());
    }
}
