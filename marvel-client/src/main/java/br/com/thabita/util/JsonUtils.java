package br.com.thabita.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	public static String fromObjectToJson(Object arg0) {
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		try {
			result = mapper.writeValueAsString(arg0);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static Object fromJsonToObject(String arg0, Class<?> clazz) {
		ObjectMapper mapper = new ObjectMapper();
		Object result = null;
		try {
			result = mapper.readValue(arg0, clazz.getClass());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
