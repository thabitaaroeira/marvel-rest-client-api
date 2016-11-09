package br.com.thabita;

import org.springframework.util.DigestUtils;

import com.google.gson.Gson;

public class Test {

	public static void main(String[] args) {
		String publicKey = args[0];
		String privateKey = args[1];
		long timeStamp = System.currentTimeMillis();
		int limit = 5;

		String stringToHash = timeStamp + privateKey + publicKey;
		String hash = DigestUtils.md5DigestAsHex(stringToHash.getBytes());

		String url = String.format("http://gateway.marvel.com/v1/public/characters?ts=%d&apikey=%s&hash=%s&limit=%d",
				timeStamp, publicKey, hash, limit);
		String output = new Gson().toJson(url).toString();
		System.out.println(output);
	}

}
