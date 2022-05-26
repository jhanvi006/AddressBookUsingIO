package com.bridgelabz;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVFileOperation {
    public static String CSV_FILE_PATH = "C:\\Users\\Admin\\Documents\\BridgelabzRFP\\AddressBookSystem\\src\\AddressBook.csv";
    public static void writeCSVFile(ArrayList<Contacts> contact) {
        try (
                CSVWriter writer = new CSVWriter(new FileWriter(CSV_FILE_PATH, true));
        ) {
            String[] headerList = {"First Name", "Last Name", "Address", "City", "State",
                    "Zip Code", "Mobile No", "Email"};
            StringBuilder stringBuilder = new StringBuilder();
            for (Contacts info : contact) {
                /*  Append list followed by comma   */
                stringBuilder.append(info).append(",");
            }
            /*  StringBuffer to String Conversion */
            String commaSeparatedList = stringBuilder.toString();
            // Condition check to remove the last comma
            if (commaSeparatedList.length() > 0)
                commaSeparatedList = commaSeparatedList.substring(0, commaSeparatedList.length() - 1);
//            writer.writeNext(headerList);
            writer.writeNext(new String[]{commaSeparatedList});
            System.out.println("Data entered.");
        } catch (IOException e) {
            System.out.println("Error: "+e);
            throw new RuntimeException(e);
        }
    }
    public static void readCSVFile(){
        try (
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader);
        ){
            String[] nextRecord;
            while ((nextRecord= csvReader.readNext()) != null){
                for (String record: nextRecord) {
                    System.out.println(record);
                }
                System.out.println("==============================");
            }
        }catch (Exception e){
            System.out.println("Error: "+e);
            e.printStackTrace();
        }
    }
}
