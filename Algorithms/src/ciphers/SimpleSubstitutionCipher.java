package ciphers;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Bharat
 *
 */

/**
 * 
 * the simple substitutuion cipher is a cipher that has been in use for many hundereds of year (an
 * excellent history is given in simon singhs 'the code book'). It is basically consists of substituting every plaintext
 * character for a differnt cipherText character. it differs form the Caesar cipher alphabet
 * is not simply the alphabet shifted it is completely jumbled
 *
 */

public class SimpleSubstitutionCipher {
	/**
	 * Encrypt text by replacing each elememnt woth its opposite character
	 * 
	 * @param message 
	 * @param cipherSmall
	 * @return Encrypted message
	 */
	
	public static String encode(String message, String cipherSmall)
	{
		String encoded= "";
		
		//This map is used to encode 
		Map<Character, Character> cipherMap = new HashMap<Character, Character>();
		
		char beginSmallLetter = 'a';
		char beginCapitalLetter = 'A';
		
		cipherSmall = cipherSmall.toLowerCase();
		String cipherCapital = cipherSmall.toUpperCase();
		
		//to handle small and Capital Letters 
		for(int i = 0; i < cipherSmall.length(); i++)
		{
			cipherMap.put(beginSmallLetter++, cipherSmall.charAt(i));
			cipherMap.put(beginCapitalLetter++, cipherCapital.charAt(i));
		}
		
		for(int i = 0; i < message.length(); i++)
		{
			if(Character.isAlphabetic(message.charAt(i))) encoded += cipherMap.get(message.charAt(i));
			else encoded += message.charAt(i);
		}
		
		return encoded;
	}
	
	/**
	 * Decrypts message by replacing each element with its opposite charater in cipher
	 * 
	 * @param encryptedMessage
	 * @param cipherSmall
	 * @return message 
	 */
	public static String decode(String encryptedMessage, String cipherSmall)
	{
		String decoded = "";
		
		Map<Character, Character> cipherMap = new HashMap<Character, Character>();
		
		char beginSmallLetter = 'a';
		char beginCapitalLetter = 'A';
		
		cipherSmall = cipherSmall.toLowerCase();
		String cipherCapital = cipherSmall.toUpperCase();
		
		for(int i = 0 ; i < cipherSmall.length(); i++)
		{
			cipherMap.put(cipherSmall.charAt(i), beginSmallLetter++);
			cipherMap.put(cipherCapital.charAt(i), beginCapitalLetter++);
		}
		
		for(int i = 0; i < encryptedMessage.length(); i++)
		{
			if(Character.isAlphabetic(encryptedMessage.charAt(i)))
			decoded += cipherMap.get(encryptedMessage.charAt(i));
			else decoded += encryptedMessage.charAt(i);
		}
		
		return decoded;
	}
	
	public static void main(String[] args)
	{
		String a = encode ("defend the east wall of the castle", "phqgiumeaylnofdxjkrcvstzwb");
		String b = decode(a, "phqgiumeaylnofdxjkrcvstzwb");
		System.out.println(b);
	}
	

}
