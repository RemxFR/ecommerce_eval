package fr.eval.security.keys;

import java.security.Key;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class GenerateKey {

	private GenerateKey() {
	}

	public final static Key getKey(String algo, int keysize) throws Exception {

		KeyGenerator keyGenerator = null;

		if (algo == "AES" && keysize == 256) {
			keyGenerator = KeyGenerator.getInstance(algo);
			keyGenerator.init(keysize);
		} else {
			throw new IllegalArgumentException("L'algorythme doit être AES et la keysize doit être de 256 bits !");
		}

		SecretKey secretKey = keyGenerator.generateKey();
		return new SecretKeySpec(secretKey.getEncoded(), algo);
	}

}
