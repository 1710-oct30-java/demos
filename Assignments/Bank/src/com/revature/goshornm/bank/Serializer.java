package com.revature.goshornm.bank;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer<E> {
	public boolean writeObject(Object o, String filename) {
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename))) {
			os.writeObject(o);
			os.flush();
			return true;
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("Failed to write object");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public E readObject(String filename) {
		try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename))) {
			return (E) is.readObject();
		} catch (ClassNotFoundException|IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public boolean objectExists(String filename) {
		try(ObjectInputStream is = new ObjectInputStream(new FileInputStream(filename))) {
			E object = (E) is.readObject();
			if(object != null) {
				return true;
			}
		} catch (ClassNotFoundException|IOException e) {
			return false;
		}
		return false;
	}
}
