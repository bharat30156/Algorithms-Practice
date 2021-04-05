package ciphers;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 * 
 * @author Bharat
 *
 */
/**
 * 
 * This example program shows how AES encryption and secryption can be done in java 
 * that secret key and encrypted text is unreadable binary and hence n the following 
 * display it in hexadecimal  format of underlying bytes 
 */
public class AESEncryption {
	
	private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
	
	/**
	 * 1. Generate a plain text for encryption 2. Get a secret key (printed in hexadecimal form). In
	 * actual use this must by encrypted and kept safe. The same key is required decryption
	 */
	public static void main(String[] args) throws Exception
	{
		String plainText = "Hello World";
		SecretKey seckey = getSecretEncryption();
		byte[] cipherText = encryptText(plainText, seckey);
		String decryptedText = decryptText(cipherText, seckey);
		
		System.out.println("Original text : " + plainText);
		System.out.println("AES key (HEX form) : " + bytesToHex(seckey.getEncoded()));
		System.out.println("Encypted Text (Hex Form) : " + bytesToHex(cipherText));
		System.out.println("decrypted text : " + decryptedText);
	}
	
	/**
	 * gets the AES encryption key. in your actual programs, this should be safely stored 
	 * 
	 * @return seckey (Secret key that we encrypt usng it)
	 * @throws noSuchAlgorithmException (from keyGenerator)
	 */
	public static SecretKey getSecretEncryption() throws NoSuchAlgorithmException
	{
		KeyGenerator aesKeyGenerator = KeyGenerator.getInstance("AES");
		aesKeyGenerator.init(128); // The AES key size in the number of bits 
		SecretKey secKey = aesKeyGenerator.generateKey();
		return secKey;
	}
	
	/**
	 * Encrypts PlainText in AES the secret key 
	 * 
	 * @param plainText
	 * @param secKey
	 * @return bytecipherText (The Encrypted Text)
	 * @throws NoSuchPaddingException (from Cipher)
	 * @throws InvalidKeyException (from cipher)
	 * @throws BAdPaddingException (from cipher)
	 * @throws IllegalBlockSIzeException (From cipher)
	 */
	public static byte[] encryptText(String plainText, SecretKey secKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		//AES defaults to AES/ECb/PKCSSPadding n java 7
		Cipher aesCipher = Cipher.getInstance("AES");
		aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
		byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());
		return byteCipherText;
	}
	
	/**
	 * Decrypts encryopted byte array using the key used for encryption
	 * @param byteCipherText
	 * @param secKey
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InavlidKeyException
	 * @throws badpaddingException
	 * @throws IllegalBlockSizeException
	 */
	
	public static String decryptText(byte[] byteCipherText, SecretKey secKey) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException
	{
		Cipher aesCipher = Cipher.getInstance("AES");
		aesCipher.init(Cipher.DECRYPT_MODE, secKey);
		byte[] bytePlainText = aesCipher.doFinal(byteCipherText);
		return new String(bytePlainText);
	}
	
	/**
	 * Convert a binary byte array into redable hex from old library is decrypted on OpenJDK 11 and 
	 * this is faster regarding other solution is using StrngBuilder 
	 * 
	 * @param hash(in binary)
	 * @return hexHash
	 */
	public static String bytesToHex(byte[] bytes)
	{
		char[] hexChars = new char[bytes.length * 2];
		for(int j = 0; j < bytes.length; j++)
		{
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = HEX_ARRAY[v >>> 4];
			hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
		}
		return new String(hexChars);
	}
	

}
