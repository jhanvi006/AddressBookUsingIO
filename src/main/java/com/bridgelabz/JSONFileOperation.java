package com.bridgelabz;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class JSONFileOperation {
    public static String JSON_FILE_PATH = "C:\\Users\\Admin\\Documents\\BridgelabzRFP\\AddressBookSystem\\src\\AddressBook.json";
    public static void jsonWriteFile(ArrayList<Contacts> contact){
        Gson gson = new Gson();
        try {
            String jsonString = gson.toJson(contact);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(JSON_FILE_PATH, true));
            bufferedWriter.write(jsonString);
            bufferedWriter.close();
            System.out.println("JSON file updated successfully.");
        } catch (Exception e) {
            System.out.println("Error: "+e);
            throw new RuntimeException(e);
        }
    }
    public static void jsonReadFile(){
        try {
            System.out.println("-----------Reading from file----------");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(JSON_FILE_PATH)));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("ERROR: unable to read file.");
            e.printStackTrace();
        }
    }
}
