package banking;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import users.Member;

public class Tester
{
	
	public static void main(String[] args)
	{
		Serialize();
		Deserialize();
	}
	
	public static void Deserialize()
	{
		try
		{
			FileInputStream door = new FileInputStream("MyObject.ser");
			ObjectInputStream ois = new ObjectInputStream(door);
			
			Member x = (Member) ois.readObject();
			System.out.println(x);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void Serialize()
	{
		Member m = new Member("MyUsername", "MyPassword", "Tom", "Doodle");
		
		try
		{
			// Serialize data object to a file
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("MyObject.ser"));
			oos.writeObject(m);
			oos.close();
			
			// Serialize data object to a byte array
			// ByteArrayOutputStream bos = new ByteArrayOutputStream();
			// oos = new ObjectOutputStream(bos);
			// oos.writeObject(m);
			// oos.close();
			
			// Get the bytes of the serialized object
			// byte[] buf = bos.toByteArray();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
