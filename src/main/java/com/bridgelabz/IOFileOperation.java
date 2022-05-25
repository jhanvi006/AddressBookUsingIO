package com.bridgelabz;

import java.io.*;
import java.util.ArrayList;

public class IOFileOperation {
    private static File file = new File("C:\\Users\\Admin\\Documents\\BridgelabzRFP\\AddressBookSystem\\src\\AddressBook.txt");
    public static void createFile() {
        try {
            if (file.createNewFile()){
                System.out.println(file.getName()+" file created.");
            }
            else {
                System.out.println(file.getName()+" already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error: "+e);
            throw new RuntimeException(e);
        }
    }
    public static void writeInFile(ArrayList<Contacts> contact) {
        StringBuffer buffer = new StringBuffer();
        contact.forEach(contactInfo -> {
            String contactOutput = contactInfo.toString().concat("\n");
            buffer.append(contactOutput);
        });
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.write(buffer.toString());
            bufferedWriter.close();
            System.out.println(file.getName()+" updated successfully.");
        } catch (IOException e) {
            System.out.println("Error: "+e);
            throw new RuntimeException(e);
        }
    }

    public static void readFile() {
        try {
            System.out.println("-----------Reading from file----------");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("ERROR: unable to read file " + file.getName());
//            e.printStackTrace();
        }
        return;
    }
}
