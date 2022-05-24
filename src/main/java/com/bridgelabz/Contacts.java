package com.bridgelabz;

class Contacts{
    private String firstName, lastName, address, city, state, zipCode, contactNo, email;
    /*
     *  Getter Methods
     */
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getAddress(){
        return address;
    }
    public String getCity(){
        return city;
    }
    public String getState(){
        return state;
    }
    public String getZipCode(){
        return zipCode;
    }
    public String getContactNo(){
        return contactNo;
    }
    public String getEmail(){
        return email;
    }
    /*
     * Setter Methods
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setCity(String city){
        this.city = city;
    }
    public void setState(String state){
        this.state = state;
    }
    public void setZipCode(String zipCode){
        this.zipCode = zipCode;
    }
    public void setContactNo(String contactNo){
        this.contactNo = contactNo;
    }
    public void setEmail(String email){
        this.email = email;
    }
    /*
     *   Object to String Conversion
     */
    public String toString(){
        return ("First Name: " + firstName +"\nLast Name: "+ lastName +"\nAddress: " + address +
                "\nCity: " + city + "\nState: " + state + "\nZip Code: " + zipCode +
                "\nContact No: " + contactNo + "\nEmail: "+email);
    }
}
