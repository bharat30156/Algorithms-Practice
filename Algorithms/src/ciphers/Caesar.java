package ciphers;

import java.util.Scanner;

/**
 * 
 * @author Bharat
 *
 */
/**
 * 
 * A java implemnentation of Caesar cipher. It is a type of substitution cipher in which letter 
 * in the plain text is replaced by a letter some fixed number of positions down the alphabet 
 *
 */
public class Caesar {
	
	/**
	 * Encrypt text by shifting every Latn char by add number shift for ASCII Example : A + 1 -> B
	 * 
	 * @param message 
	 * @param shift
	 * @return Encryoted message 
	 */
	public static String encode(String message, int shift)
	{
		String encoded = "";
		
		shift %= 26;
		
		final int length = message.length();
		for(int i = 0; i < length; i++)
		{
			// int current = message.chatAt(i); // using char to shift character because ascii 
			// is in-order latin alphabet
			char current = message.charAt(i); // Java law : char + int = char
			
			if(IsCapitalLatinLetter(current))
			{
				current += shift;
				encoded += (char) (current > 'Z' ? current - 26 : current); // 26 = number of latin letters
			}
			else if (IsSmallLatinLetter(current))
			{
				current += shift;
				encoded += (char) (current > 'z' ? current - 26 : current); // 26 = number of latin letters
			}
			else
			{
				encoded += current;
			}
		}
		return encoded;
	}
	
	/**
	 * Decrypt message by shifting back every latin char to previous the ASCII Example B - 1 -> A
	 * 
	 * @param encryotedMessage
	 * @param shift
	 * @return message
	 */
	
	public static String decode (String encryptedMessage, int shift)
	{
		String decoded = "";
		
		shift %= 26;
		
		final int length = encryptedMessage.length();
		for(int i = 0; i < length; i++)
		{
			char current = encryptedMessage.charAt(i);
			if(IsCapitalLatinLetter(current))
			{
				current -= shift;
				decoded += (char) (current < 'A' ? current + 26 : current); // 26 = number of the latin letters 
			}
			else if(IsSmallLatinLetter(current))
			{
				current -= shift;
				decoded += (char) (current < 'a' ? current + 26 : current); // 26 = number of latin letters
			}
			else
			{
				decoded += current;
			}
		}
		return decoded;
	}
	
	/**
	 * @param c
	 * @return true if character is capital latin letter or false for others
	 */
	private static boolean IsCapitalLatinLetter(char c)
	{
		return c >= 'A' && c <= 'Z';
	}
	
	/**
	 * @param c 
	 * @return true if charcater is small ltin Letter or false 
	 */
	private static boolean IsSmallLatinLetter(char c)
	{
		return c >= 'a' && c <= 'z';
	}
	
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the message (Latin Alphabet)");
		String message = input.nextLine();
		System.out.println(message);
		System.out.println("please Enter the shift number ");
		int shift = input.nextInt() % 26;
		System.out.println("(E)ncode or (D)ecode ? ");
		char choice = input.next().charAt(0);
		switch(choice)
		{
		case 'E' :
		case 'e' :
			System.out.println(
					"ENCODED MESSAGE IS \n" + encode(message, shift));
			break;
		case 'D' :
		case 'd' :
			System.out.println("DECODED MESSAGE IS \n" + decode(message, shift));
			default :
				System.out.println("default case");
		}
		input.close();

	}
	
	

}
