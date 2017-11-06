package com.revature.banking;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer<E> {
	public boolean writeObject(E o, String filename) throws FileNotFoundException, IOException {
		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename))) {			
			os.writeObject(o);
			os.flush();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("failed");
			return false;
		}

	}
	
	public E readObject(String filename) throws IOException, ClassNotFoundException{
		ObjectInputStream is =  new ObjectInputStream(new FileInputStream(filename));
		return (E)is.readObject();
	
	}
}
