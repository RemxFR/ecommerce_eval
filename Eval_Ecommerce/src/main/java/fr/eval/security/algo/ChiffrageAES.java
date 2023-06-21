package fr.eval.security.algo;

import java.security.Key;

import javax.crypto.Cipher;

public final class ChiffrageAES {

	private static final String AES = "AES";

	private ChiffrageAES() {
	}

	public final static byte[] chiffrage(String infoPourChiffrage, Key key) throws Exception {

		Cipher cipher = Cipher.getInstance(AES);
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] infoInByte = infoPourChiffrage.getBytes("UTF-8");
		byte[] infoChiffre = cipher.doFinal(infoInByte);

		return infoChiffre;
	}

	public final static String dechiffrage(byte[] bytePourDechiffrage, Key key) throws Exception {

		Cipher cipher = Cipher.getInstance(AES);
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] infoDechiffreByte = cipher.doFinal(bytePourDechiffrage);
		String infoDechiffreString = new String(infoDechiffreByte, "UTF-8");

		return infoDechiffreString;
	}

}
