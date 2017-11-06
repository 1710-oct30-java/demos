package com.revature.banklauncher;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

import com.revature.account.User;

public class WriteObject implements Serializable {
	
	/* First we delete all contents of the file */
	public static void emptyFile() throws IOException {
	    OutputStream os = null;
	    try {
	      os = new FileOutputStream("C:\\Users\\iaust\\eclipse-workspace\\Tampa-BankingProject\\src\\com\\revature\\banklauncher\\accountinfo.txt");
	    } finally {
	      if (os != null) {
	        os.close();
	      }
	    }
	  }
	
	public static void writeFile (User user) {
		
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(
					"C:\\Users\\iaust\\eclipse-workspace\\Tampa-BankingProject\\src\\com\\revature\\banklauncher\\accountinfo.txt");

		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(user);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	

}
