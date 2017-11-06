package com.revature.banksoftware;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Passwords {
	
	public static String hashPassword(String input)
	{
		// simple MD5 implementation found at
		// https://howtodoinjava.com/security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/
		// This is generally insecure but the password is still hashed in some way.
		try {
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			byte[] digest = md.digest();
			StringBuilder sbr = new StringBuilder();
			md.update(input.getBytes());
			
			for(byte b: digest)
			{
				sbr.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
			}
			
			input = sbr.toString();
		}
		catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
			return null;
		}
		
		return input;
	}
	
}
