package com.revature.utility;

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
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("failed to write object");
			return false;
		}
	}

	public E readObject(String filename) {
		try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename))) {
			return (E) is.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
