package com.arun;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
	int index;
	String date;
	String info;
	String previousHash, hash;

	public Block(int index, String date, String info, String previousHash) {
		this.index = index;
		this.date = date;
		this.info = info;
		this.previousHash = previousHash;
		this.hash = createNewHash();
	}

	public Block(int index, String date, String info) {
		this.index = index;
		this.date = date;
		this.info = info;
		this.hash = createNewHash();
	}

	String createNewHash() {
		String sum = index + date + info + previousHash;
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] hash = digest.digest(sum.getBytes(StandardCharsets.UTF_8));
		return bytesToHex(hash);
	}

	private static String bytesToHex(byte[] hash) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}
}
