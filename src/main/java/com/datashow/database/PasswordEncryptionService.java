package main.java.com.datashow.database;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;
import sun.misc.CharacterEncoder;

public final class PasswordEncryptionService 
{
	private static PasswordEncryptionService passWordEncryptionInstance;
	
	private PasswordEncryptionService(){}
	
	@SuppressWarnings("restriction")
	public synchronized String encrypt(String password)
	{
		String hashedPassword = "";
		
		MessageDigest md = null;
		
		try 
		{
			md = MessageDigest.getInstance("SHA");
		} 
		catch (NoSuchAlgorithmException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try 
		{
			md.update(password.getBytes("UTF-8"));
		} 
		catch (UnsupportedEncodingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte raw[] = md.digest();
		
		hashedPassword = (new BASE64Encoder()).encode(raw);
		
		return hashedPassword;
	}
	
	public static PasswordEncryptionService getInstance()
	{
		if(passWordEncryptionInstance == null)
	    {
			passWordEncryptionInstance = new PasswordEncryptionService(); 
	    } 
	    return passWordEncryptionInstance;
	}
	
}
