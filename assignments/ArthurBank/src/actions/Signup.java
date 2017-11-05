package actions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import GUI.Home;
import objects.User;

public class Signup {
	public static void sup() throws IOException {

		// Prompts user for first name, last name, desired username, and desired
		// password and creates a new user object and adds it to userList.txt

		Scanner in = new Scanner(System.in);
		System.out.println("Enter First Name: ");
		String fname = in.nextLine();
		System.out.println("Enter Last Name: ");
		String lname = in.nextLine();
		System.out.println("Enter Username: ");
		String username = in.nextLine();
		System.out.println("Enter Password: ");
		String password = in.nextLine();

		Home.userData.add(new User(fname, lname, Integer.toString(Home.userData.size()), username, password));

		// System.out.println(Home.userData.toString());
		FileWriter newuser = new FileWriter("userList.txt");
		BufferedWriter bw = new BufferedWriter(newuser);

		for (int i = 0; i < Home.userData.size(); i++) {
			// System.out.println(Home.userData.get(i).getFname());
			bw.write(Home.userData.get(i).getFname() + "," + Home.userData.get(i).getLname() + ","
					+ Home.userData.get(i).getUserID() + "," + Home.userData.get(i).getUsername() + ","
					+ Home.userData.get(i).getPassword() + "\n");
		}
		bw.close();
		Home.main(null);
	}
}
