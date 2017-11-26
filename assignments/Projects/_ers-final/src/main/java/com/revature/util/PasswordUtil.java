package com.revature.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {
	
	// TODO
	public static String hashPassword(String input)
	{
		// Simple SHA-256 implementation nicked from http://www.baeldung.com/sha-256-hashing-java
		try
		{
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
			input = bytesToHex(encodedhash);
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
			return null;
		}
		
		return input;
	}
	
	private static String bytesToHex(byte[] hash)
	{
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++)
	    {
		    String hex = Integer.toHexString(0xff & hash[i]);
		    
		    if(hex.length() == 1)
		    	hexString.append('0');
		    
		    hexString.append(hex);
	    }
	    return hexString.toString();
	}
	
}
