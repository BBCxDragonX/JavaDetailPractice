package com.dreamboat;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FlattenJSON {
    public static void main(String[] args) throws IOException {
        JsonFactory factory = new JsonFactory();
        FileReader jsonfile = new FileReader("D:\\CodeDump\\JavaDetailPractice\\data\\SampleJson.json");
        JsonParser parser = factory.createParser(jsonfile);


        Map<String, String> flattenedMap = new HashMap<>();
        flatten("", parser, flattenedMap);

        // Convert the flattened map to a string
        StringBuilder flattenedString = new StringBuilder();
        flattenedMap.forEach((key, value) -> {
            flattenedString.append(key).append(":").append(value).append(",");
        });

        System.out.println(flattenedString.toString().trim());
    }

    private static void flatten(String currentPath, JsonParser parser, Map<String, String> flattenedMap) throws IOException {
        while (!parser.isClosed()) {
            JsonToken token = parser.nextToken();

            if (JsonToken.FIELD_NAME.equals(token)) {
                String fieldName = parser.getCurrentName();
                String fullPath = currentPath.isEmpty() ? fieldName : currentPath + "." + fieldName;

                token = parser.nextToken();
                if (JsonToken.START_OBJECT.equals(token)) {
                    flatten(fullPath, parser, flattenedMap);
                } else {
                    String value = parser.getValueAsString();
                    flattenedMap.put(fullPath, value);
                }
            } else if (JsonToken.END_OBJECT.equals(token)) {
                break;
            }
        }
    }
}
