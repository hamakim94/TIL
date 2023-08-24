package com.hamakim94.board.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
	public String getHash(String msg) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(msg.getBytes());
		// 바이트 배열로 만들어준다.
		return byteToHex(md.digest());
	}
	
	// 바이트 배열으로 나오는데, 너무 많아 -> 16진수로
	private String byteToHex(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for(byte b : bytes) {
			sb.append(String.format("%02x", b));
			
		}
		return sb.toString();
	}
}
