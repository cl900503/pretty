package com.dragon.pretty.elastisearch.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class JsonUtil {

	public static void main(String[] args) throws IOException {

		String jsonStr = "{\"name\":{\"yi\":\"chen\",\"er\":\"long\"},\"age\":18}";
		JsonFactory factory = new JsonFactory();
		try (JsonParser jsonParser = factory.createParser(jsonStr)) {

			// 只要还没结束"}"，就一直读
			while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
				System.out.println(jsonParser.getCurrentName()+":"+jsonParser.getText());
				System.out.println("-");
			}
		}
	}

}
