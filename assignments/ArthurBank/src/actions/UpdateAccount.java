package actions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateAccount {
	public static void update() throws IOException {

		// handles the updating of accountList.txt for any accounts that needs updating
		// in transactions

		FileWriter updaccount = new FileWriter("accountList.txt");
		BufferedWriter bw = new BufferedWriter(updaccount);

		// account id, user id, balance, type

		for (int i = 0; i < Login.accountData.size(); i++) {
			bw.write(Login.accountData.get(i).getaccID() + "," + Login.accountData.get(i).getUserID() + ","
					+ Login.accountData.get(i).getBalance() + "," + Login.accountData.get(i).getType() + "\n");
		}
		bw.close();
	}
}
