package utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Utility class for encoding and decoding data using AES encryption.
 *
 * <p>
 * This class provides methods for encrypting and decrypting data using the AES
 * algorithm with ECB mode and PKCS5 padding.
 * </p>
 *
 * <p>
 * This class is final and cannot be extended.
 * </p>
 *
 * @version 1.0
 * @since 2022
 */
public final class DecodeUtils {
	// Private constructor to prevent instantiation
	private DecodeUtils() {
		super();
	}

	// Constants for AES encryption

	private static final String key1 = "AES";
	private static final String key2 = "AES/ECB/PKCS5Padding";
	// Encryption key
	private static String encryptionKeyString = "autotestselenium";
	private static final byte[] encryptionKeyBytes = encryptionKeyString.getBytes();

	/**
	 * Generates a SecretKey for AES encryption.
	 *
	 * @return a SecretKey for AES encryption
	 */
	private static SecretKey generateKey() {
		SecretKey key = new SecretKeySpec(encryptionKeyBytes, key1);
		return key;
	}

	/**
	 * Encrypts the given data using AES encryption.
	 *
	 * @param data the data to encrypt
	 * @return the encrypted data as a Base64 encoded string
	 */
	public static String encrypt(String Data) {
		String encryptedValue = null;
		try {
			SecretKey key = generateKey();
			Cipher c = Cipher.getInstance(key2);
			c.init(Cipher.ENCRYPT_MODE, key);
			byte[] encVal = c.doFinal(Data.getBytes());
			encryptedValue = Base64.encodeBase64String(encVal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encryptedValue;
	}

	/**
	 * Decrypts the given encrypted data using AES decryption.
	 *
	 * @param encryptedData the data to decrypt (Base64 encoded string)
	 * @return the decrypted data as a string
	 */
	public static String decrypt(String encryptedData) {
		String decryptedValue = null;
		try {
			SecretKey key = generateKey();
			Cipher c = Cipher.getInstance(key2);
			c.init(Cipher.DECRYPT_MODE, key);
			byte[] decordedValue = Base64.decodeBase64(encryptedData);
			byte[] decValue = c.doFinal(decordedValue);
			decryptedValue = new String(decValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return decryptedValue;
	}
}
