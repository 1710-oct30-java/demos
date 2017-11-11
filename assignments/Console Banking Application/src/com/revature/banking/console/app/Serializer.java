package com.revature.banking.console.app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer<E> {
public boolean writeObject(E o, String filename) {
		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename))) {
			os.writeObject(o);
			os.flush();
		}

		catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@SuppressWarnings("unchecked")

	public E readObject(String filename) {
		try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename))) {
			return (E)is.readObject();
		}

		catch (IOException | ClassNotFoundException e) {
			System.err.println("File \"" + filename + "\" not found. Printing stack trace.");
			e.printStackTrace();
			return null;
		}
	}
}
