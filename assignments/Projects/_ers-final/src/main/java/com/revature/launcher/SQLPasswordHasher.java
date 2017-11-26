package com.revature.launcher;

import java.util.Scanner;

import com.revature.util.PasswordUtil;

public class SQLPasswordHasher {
	final static String INPUT_DATA = "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('mwest13', 'password', 'Micah', 'West', 'micahwest13@gmail.com', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('mwest13-m', 'password', 'Micah', 'West', 'micahwest13@gmail.com', 2, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('cbrastead0', 'DempLEF', 'Cindy', 'Brastead', 'cbrastead0@twitpic.com', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('atalboy1', 'YQZnZZj', 'Annette', 'Talboy', 'atalboy1@nih.gov', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('zallsopp2', 'SzhFbF1li', 'Zilvia', 'Allsopp', 'zallsopp2@usa.gov', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('nspenclay3', 'oB9qR6wvUsp', 'Nickola', 'Spenclay', 'nspenclay3@vinaora.com', 2, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('eeddie4', 'lsUVpBVQ', 'Elbert', 'Eddie', 'eeddie4@istockphoto.com', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('ngorthy5', 'XnxclfNNOMTZ', 'Nobie', 'Gorthy', 'ngorthy5@sogou.com', 2, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('ricke6', 'lbXyW7Oaz', 'Rosanne', 'Icke', 'ricke6@reference.com', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('lflexman7', 'mH4TILkVW9', 'Loise', 'Flexman', 'lflexman7@epa.gov', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('hsinton8', 'VuOWyYhyCDtt', 'Hedvig', 'Sinton', 'hsinton8@sun.com', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('daddlestone9', 'w5eSJZm', 'Dani', 'Addlestone', 'daddlestone9@hud.gov', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('esloboma', 'HsDRaq', 'Elissa', 'Slobom', 'esloboma@java.com', 2, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('dgofordb', 'sahc5sztGWx', 'Damita', 'Goford', 'dgofordb@ebay.com', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('alinningc', 'GciQK1WIgDJH', 'Artemas', 'Linning', 'alinningc@pinterest.com', 1, 1);\r\n"
			+ "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('rscimonid', '6dEW49GlW', 'Rheba', 'Scimoni', 'rscimonid@yandex.ru', 2, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('lpassye', 'xskfkVA', 'Ludovika', 'Passy', 'lpassye@diigo.com', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('dbangf', 'X4oOqTfjHw0', 'Dione', 'Bang', 'dbangf@xrea.com', 2, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('ipopescug', 'RmdLTPFs', 'Isabel', 'Popescu', 'ipopescug@networksolutions.com', 2, 1);\r\n"
			+ "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('rspinkeh', 'Ocl4NtnJRi0', 'Rozelle', 'Spinke', 'rspinkeh@blog.com', 2, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('ghornigi', 'ly1tOIgaHP', 'Glenine', 'Hornig', 'ghornigi@gizmodo.com', 2, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('bclousleyj', 'pLOkqnZg9b', 'Barny', 'Clousley', 'bclousleyj@alexa.com', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('bdunkleyk', 'r4DduoxEA23', 'Barnett', 'Dunkley', 'bdunkleyk@1und1.de', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('ehuleattl', 'c4fkmBMLEqD', 'Elvira', 'Huleatt', 'ehuleattl@so-net.ne.jp', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('wclougherm', 'ZYE0v2qCVciw', 'Wilek', 'Clougher', 'wclougherm@aboutads.info', 2, 1);\r\n"
			+ "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('rhardmann', '3y2dqovhRvIn', 'Renelle', 'Hardman', 'rhardmann@yahoo.com', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('hhuntleyo', 'jxADhUOL2J', 'Hazlett', 'Huntley', 'hhuntleyo@biglobe.ne.jp', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('swesternp', '2AhSsRgx3M1', 'Sterne', 'Western', 'swesternp@homestead.com', 2, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('rdrysdaleq', '4dQxJU', 'Reamonn', 'Drysdale', 'rdrysdaleq@deviantart.com', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('vjaskiewiczr', 'pefAXp', 'Vidovic', 'Jaskiewicz', 'vjaskiewiczr@timesonline.co.uk', 1, 1);\r\n"
			+ "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('edossettors', 'GbJod15UM', 'Emogene', 'Dossettor', 'edossettors@freewebs.com', 1, 1);\r\n"
			+ "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('dwheildont', 'qEMBPaz', 'Derick', 'Wheildon', 'dwheildont@macromedia.com', 2, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('tseeviouru', 'xdDx7edPVw', 'Teresina', 'Seeviour', 'tseeviouru@irs.gov', 2, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('zsuttonv', 'mIMZJyN', 'Zahara', 'Sutton', 'zsuttonv@ihg.com', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('klelliottw', 'RtdH0g', 'Katleen', 'Lelliott', 'klelliottw@auda.org.au', 2, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('chartlex', 'cx3IjNgJQIAs', 'Carling', 'Hartle', 'chartlex@narod.ru', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('sraselly', 'uf3BhO8kwZ', 'Shandy', 'Rasell', 'sraselly@zimbio.com', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('llaycockz', 'zF19vmJ8EH', 'Lillian', 'Laycock', 'llaycockz@sourceforge.net', 2, 1);\r\n"
			+ "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('kridgley10', 'fe3BpUof6ukA', 'Kristina', 'Ridgley', 'kridgley10@npr.org', 2, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('pgronowe11', 'np4cCtVeGo', 'Peter', 'Gronowe', 'pgronowe11@canalblog.com', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('tfarbrace12', 'ZAfVvD', 'Terrel', 'Farbrace', 'tfarbrace12@diigo.com', 2, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('hsilverman13', 'lBLfel', 'Hew', 'Silverman', 'hsilverman13@sun.com', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('itruce14', 'vz7awkH1Gs9', 'Inesita', 'Truce', 'itruce14@wufoo.com', 2, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('tlegallo15', 'Hu3fB0', 'Thorvald', 'Le Gallo', 'tlegallo15@princeton.edu', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('bseczyk16', 'sAM2tayZk8hu', 'Brande', 'Seczyk', 'bseczyk16@utexas.edu', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('lbestar17', 'rUmQ75', 'Loretta', 'Bestar', 'lbestar17@cloudflare.com', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('rappleton18', '5K4uRovjW', 'Rakel', 'Appleton', 'rappleton18@gravatar.com', 2, 1);\r\n"
			+ "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('spollie19', 'P0v6OZZsel0', 'Scot', 'Pollie', 'spollie19@chicagotribune.com', 1, 1);\r\n"
			+ "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('ddufoure1a', 'utA0N18GzsM7', 'Dieter', 'Dufoure', 'ddufoure1a@seattletimes.com', 1, 1);\r\n"
			+ "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('tsybry1b', 'CSsvPUs07A', 'Terese', 'Sybry', 'tsybry1b@tinyurl.com', 1, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('khan1c', 'VoF4rK', 'Kim', 'Han', 'khan1c@boston.com', 2, 1);\r\n" + "\r\n"
			+ "INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id, user_status_id) \r\n"
			+ "	VALUES ('fbielefeld1d', '92M987Twx2', 'Fitzgerald', 'Bielefeld', 'fbielefeld1d@woothemes.com', 1, 1);";

	public static void main(String[] args) {
		Scanner strScan = new Scanner(INPUT_DATA);

		while (strScan.hasNext()) {
			String line = strScan.nextLine();

			if (line.contains("VALUES")) {
				StringBuilder bdrLine = new StringBuilder(line);
				String password = bdrLine.substring(bdrLine.indexOf("', '") + 4, bdrLine.length() - 1);
				password = password.substring(0, password.indexOf("'"));
				String hashPassword = PasswordUtil.hashPassword(password);
				bdrLine.replace(bdrLine.indexOf("', '") + 4, bdrLine.indexOf("', '") + 4 + password.length(),
						hashPassword);
				System.out.println(bdrLine.toString());
			} else {
				System.out.println(line);
			}
		}

		strScan.close();
	}
}
