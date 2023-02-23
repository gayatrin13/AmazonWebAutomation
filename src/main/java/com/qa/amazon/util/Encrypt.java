package com.qa.amazon.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {

	public static byte[] getSHA(String input) throws NoSuchAlgorithmException {

		MessageDigest md = MessageDigest.getInstance("SHA-256");
		return md.digest(input.getBytes(StandardCharsets.UTF_8));
	}

	public static String toHexString(byte[] hash) {
		BigInteger i = new BigInteger(1, hash);
		StringBuilder sb = new StringBuilder(i.toString());
		while (sb.length() < 32) {
			sb.insert(0, '0');
		}
		return sb.toString();
	}

	public static String encryptedString(String pass) throws NoSuchAlgorithmException {
		return toHexString(getSHA(pass));

	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		String pass = System.getenv("AMZ_PWD");
		toHexString(getSHA(pass));

	}
}
