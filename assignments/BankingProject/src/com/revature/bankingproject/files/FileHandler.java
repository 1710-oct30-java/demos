package com.revature.bankingproject.files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.bankingproject.user.User;

public class FileHandler{
	private static Logger log = Logger.getRootLogger();

	//Method to Load Serialized File
	@SuppressWarnings("unchecked")
	public static List<User> loadSerializedFile() throws IOException {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serializedFile.txt"))) {
			return (List<User>) ois.readObject();

		} catch (ClassNotFoundException e) {
			log.fatal("Class User not found.  Program is going to crash");
			log.fatal(e);
		}
		return null;
	}
	//Method to Save Serialized File
	public static void saveSerializedFile(List<User> users) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serializedFile.txt"))) {
			oos.writeObject(users);
		} catch (IOException e) {
			log.warn("Unable to Save to file");
			log.warn(e);
		}
	}
}
