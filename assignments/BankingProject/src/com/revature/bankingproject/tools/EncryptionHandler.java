package com.revature.bankingproject.tools;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

public class EncryptionHandler {
	/*
	 * From StackOverFlow:
	 * By default Java supports only 128-bit encryption
		128bits == 16Bytes == 16 Chars.
		So cryptKey cannot exceed 16 characters.
	 */
	private static String key = "Iamsixteencharac";
	private static Logger log = Logger.getRootLogger();

	public static String Encrypt(String encryptThis)
	{
		String output = "";
		try
		{
			SecretKeySpec sKeySpec = new SecretKeySpec(key.getBytes(), "Blowfish");
			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.ENCRYPT_MODE, sKeySpec);
			byte[] encryptedByteArray = cipher.doFinal(encryptThis.getBytes());
			output = new String(encryptedByteArray);
		}catch(IllegalArgumentException e)
		{
			log.warn("Issue with instantiating SecretKeySpec");
			log.warn(e);
			return null;
		}catch(NoSuchAlgorithmException | NoSuchPaddingException e)
		{
			log.warn("Issue with Cipher.getInstance");
			log.warn(e);
			return null;
		}catch(InvalidKeyException e)
		{
			log.warn("Issue with cipher.init");
			log.warn(e);
		}catch(IllegalBlockSizeException | BadPaddingException e)
		{
			log.warn("Issue with cipher.doFinal");
			log.warn(e);
			return null;
		}
		return output;
	}
	public static String Decrypt(String decryptThis)
	{
		String output = "";
		try
		{
			SecretKeySpec sKeySpec = new SecretKeySpec(key.getBytes(), "Blowfish");
			Cipher cipher = Cipher.getInstance("Blowfish");
			cipher.init(Cipher.DECRYPT_MODE, sKeySpec);
			byte[] decryptedByteArray = cipher.doFinal(decryptThis.getBytes());
			output = new String(decryptedByteArray);
		}catch(IllegalArgumentException e)
		{
			log.warn("Issue with instantiating SecretKeySpec");
			log.warn(e);
			return null;
		}catch(NoSuchAlgorithmException | NoSuchPaddingException e)
		{
			log.warn("Issue with Cipher.getInstance");
			log.warn(e);
			return null;
		}catch(InvalidKeyException e)
		{
			log.warn("Issue with cipher.init");
			log.warn(e);
		}catch(IllegalBlockSizeException | BadPaddingException e)
		{
			log.warn("Issue with cipher.doFinal");
			log.warn(e);
			return null;
		}
		return output;
	}
}