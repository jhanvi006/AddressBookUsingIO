package com.bridgelabz;

import java.util.*;

public class Operations implements AddressBookInterface {
    static Scanner sc = new Scanner(System.in);
    public ArrayList<Contacts> addDetails(ArrayList<Contacts> contactDetails){
        Contacts info = new Contacts();
        System.out.println("Enter first name: ");
        String firstName = sc.next();
        Contacts searchFirstName = contactDetails.stream()
                .filter(name -> firstName.equals(name.getFirstName()))
                .findAny().orElse(null);
        if (searchFirstName == null) {
            info.setFirstName(firstName);
            System.out.println("Enter last name: ");
            info.setLastName(sc.next());
            System.out.println("Enter address: ");
            info.setAddress(sc.next());
            System.out.println("Enter city name: ");
            info.setCity(sc.next());
            System.out.println("Enter state name: ");
            info.setState(sc.next());
            System.out.println("Enter zip code: ");
            info.setZipCode(sc.next());
            System.out.println("Enter contact no.: ");
            info.setContactNo(sc.next());
            System.out.println("Enter email: ");
            info.setEmail(sc.next());
            contactDetails.add(info);
            System.out.println("Contact details added!");
        }else {
            System.out.println("Contact details for "+firstName+" already exists.");
        }
        return contactDetails;
    }
    public void editDetails(ArrayList<Contacts> contactDetails){
        System.out.println("Enter First Name for which you want to modify info: ");
        String searchFirstName = sc.next();
        /*  Iterate to search for first name */
        for (Contacts contact : contactDetails) {
            /*  compare first name
             *   if matches display menu for edit
             *   else display no record found message
             */
            if (contact.getFirstName().equals(searchFirstName)){
                System.out.println("Enter the number to edit respective info: ");
                System.out.println("1. First Name \n2. Last Name \n3. Address \n4. City " +
                        "\n5. State \n6. Zip Code \n7. Contact No \n8. Email");
                int index = sc.nextInt();
                System.out.println("Enter value to update: ");
                switch (index){
                    case 1:
                        String updatedFirstName = sc.next();
                        contact.setFirstName(updatedFirstName);
                        break;
                    case 2:
                        String updatedLastName = sc.next();
                        contact.setLastName(updatedLastName);
                        break;
                    case 3:
                        String updatedAddress = sc.next();
                        contact.setAddress(updatedAddress);
                        break;
                    case 4:
                        String updatedCity = sc.next();
                        contact.setCity(updatedCity);
                        break;
                    case 5:
                        String updatedState = sc.next();
                        contact.setState(updatedState);
                        break;
                    case 6:
                        String updatedZipCode = sc.next();
                        contact.setZipCode(updatedZipCode);
                        break;
                    case 7:
                        String updatedContact = sc.next();
                        contact.setContactNo(updatedContact);
                        break;
                    case 8:
                        String updatedEmail = sc.next();
                        contact.setEmail(updatedEmail);
                        break;
                    default:
                        System.out.println("Invalid number!");
                }
                /*  Display updated contact */
                System.out.println("Details updated");
                return;
            }
        }
        System.out.println("No record found!");
    }
    public void deleteContact(ArrayList<Contacts> contactDetails){
        System.out.println("Enter email for which you want to delete contact: ");
        String searchEmail = sc.next();
        Iterator<Contacts> removeContact = contactDetails.iterator();
        /*  Checking the next element where
         *   condition holds true till there is single element
         *   in the List using hasNext() method
         */
        while (removeContact.hasNext()){
            /*  Move cursor to next element */
            Contacts nextElement = removeContact.next();
            if (nextElement.getEmail().equals(searchEmail)) {
                removeContact.remove();
                System.out.println("Contact is removed!");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
    public void displayContactsOfAddressBook(ArrayList<Contacts> contactDetails){
        for (Contacts contactDetailsValue : contactDetails){
            System.out.println(contactDetailsValue);
        }
    }
    public ArrayList<Contacts> displayContacts(){
        System.out.println(Arrays.asList(addressBookList));
        return null;
    }
    public void searchContact() {
        System.out.println("Enter a number for : \n1. Search by city \n2. Search by state");
        int selectOption = sc.nextInt();
        switch (selectOption) {
            case 1:
                Search.searchByCity(addressBookList);
                break;
            case 2:
                Search.searchByState(addressBookList);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }
    public void dictionary(){
        System.out.println("Select option to get dictionary : \n1. City & Person Dictionary" +
                " \n2. State & Person Dictionary");
        int selectOption = sc.nextInt();
        switch (selectOption) {
            case 1:
                Dictionary.cityPersonDictionary(addressBookList);
                break;
            case 2:
                Dictionary.statePersonDictionary(addressBookList);
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }
    public void countContact() {
        HashMap<String, Integer> countContactByCity = new HashMap<>();
        HashMap<String, Integer> countContactByState = new HashMap<>();
        for (Map.Entry<String, ArrayList<Contacts>> contactDetails:addressBookList.entrySet()) {
            for (Contacts contact: contactDetails.getValue()) {
                Integer cityCount = countContactByCity.get(contact.getCity());
                Integer stateCount = countContactByState.get(contact.getState());
                if (cityCount == null)
                    countContactByCity.put(contact.getCity(), 1);
                else
                    countContactByCity.put(contact.getCity(), cityCount + 1);
                if (stateCount == null)
                    countContactByState.put(contact.getState(), 1);
                else
                    countContactByState.put(contact.getState(), stateCount + 1);
            }
        }
        System.out.println("No. of contacts from different cities are ");
        System.out.println(countContactByCity);
        System.out.println("No. of contacts from different states are ");
        System.out.println(countContactByState);
    }
    public void sortContactsByName(ArrayList<Contacts> contactDetails){
        System.out.println("Contacts sorted by First Name:");
        contactDetails.stream()
                .sorted(Comparator.comparing(Contacts::getFirstName))
                .forEach(System.out::println);
    }
    public void sortContacts(ArrayList<Contacts> contactDetails){
        System.out.println("Enter choice: \n1. Sort by City \n2. Sort by State \n3. Sort by Zip Code");
        int select = sc.nextInt();

        switch (select){
            case 1:
                System.out.println("Contacts sorted by City: ");
                contactDetails.stream()
                        .sorted(Comparator.comparing(Contacts::getCity))
                        .forEach(System.out::println);
                break;
            case 2:
                System.out.println("Contacts sorted by State: ");
                contactDetails.stream()
                        .sorted(Comparator.comparing(Contacts::getState))
                        .forEach(System.out::println);
                break;
            case 3:
                System.out.println("Contacts sorted by Zip Code: ");
                contactDetails.stream()
                        .sorted(Comparator.comparing(Contacts::getZipCode))
                        .forEach(System.out::println);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
    public void displayActionMenu(AddressBookSystem addressDetails, ArrayList<Contacts> contactDetails){
        int selectMenuOption;
        do {
            System.out.println("Enter a number to perform action: \n1. Add contact details " +
                    "\n2. Edit contact details \n3. Delete contact details " +
                    "\n4. Display contact details \n5. Search contact by city or state" +
                    "\n6. View Dictionary \n7. Count Contact \n8. Sort contact details by First Name" +
                    "\n9. Sort by City, State or Zip \n10. Write contacts to file" +
                    "\n11. Display contacts from file \n0. Exit");
            selectMenuOption = sc.nextInt();

            switch (selectMenuOption) {
                case 1:
                    /*  Add contact details in address book */
                    addressDetails.addDetails(contactDetails);
                    break;
                case 2:
                    /*  Edit contact details in address book */
                    addressDetails.editDetails(contactDetails);
                    break;
                case 3:
                    /*  Delete contact details */
                    addressDetails.deleteContact(contactDetails);
                    break;
                case 4:
                    /*  Display contact details */
                    addressDetails.displayContactsOfAddressBook(contactDetails);
                    break;
                case 5:
                    /*  Display contact details of a specific city  */
                    addressDetails.searchContact();
                    break;
                case 6:
                    /*  View Dictionary */
                    addressDetails.dictionary();
                    break;
                case 7:
                    /*  Count contacts based on city and state  */
                    addressDetails.countContact();
                    break;
                case 8:
                    /*  Sort contacts  */
                    addressDetails.sortContactsByName(contactDetails);
                    break;
                case 9:
                    /*  Sort by City, State or Zip  */
                    addressDetails.sortContacts(contactDetails);
                    break;
                case 10:
                    /*  Write in file   */
                    IOFileOperation.writeInFile(contactDetails);
                    break;
                case 11:
                    /*  Display contacts from file  */
                    IOFileOperation.readFile();
                    break;
                case 0:
                    System.out.println("Exit!");
                    break;
                default:
                    System.out.println("Invalid option selected.");
                    break;
            }
        }while (selectMenuOption != 0);
    }
    static HashMap<String, ArrayList<Contacts>> addressBookList = new HashMap<>();
    public void createAddressBook(AddressBookSystem addressDetails){
        char choice = 'Y';
        String addressBookName;
        do {
            System.out.println("Enter name of Address Book: ");
            addressBookName = sc.next();
            if (addressBookList.containsKey(addressBookName)) {
                System.out.println("Address Book with " + addressBookName + " name already exists.");
                displayContacts();
            }
            else {
                ArrayList<Contacts> contactDetails = new ArrayList<>();
                IOFileOperation.createFile();
                addressBookList.put(addressBookName, addDetails(contactDetails));
                displayActionMenu(addressDetails, contactDetails);
            }
            System.out.println("To continue press Y otherwise press N");
            choice = sc.next().charAt(0);
        }while (choice != 'n' && choice != 'N');
    }
}