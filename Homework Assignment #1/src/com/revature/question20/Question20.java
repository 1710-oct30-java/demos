package com.revature.question20;

import java.io.*;
import java.io.File;

public class Question20 {

	public static void main(String [] args) {
		
        String fileName = "Data.txt";
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Use Buffered Reader to read the file 
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null) {
       			
                System.out.println("Name: " + line); 
                System.out.println("Age: " + line);
                System.out.println("State: " + line);
            }   
            
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
       
        }
    }
}