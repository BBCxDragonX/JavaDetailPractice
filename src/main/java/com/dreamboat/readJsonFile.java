package com.dreamboat;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class readJsonFile {
    public static void main(String[]args) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        FileReader jsonfile = new FileReader("D:\\CodeDump\\JavaDetailPractice\\data\\TestJson.json");
        JSONObject obj = (JSONObject)parser.parse(jsonfile); //convert json file to java object
        JSONObject quiz = (JSONObject) obj.get("quiz");
        JSONObject maths = (JSONObject) quiz.get("maths");
        /*System.out.println(quiz);
        System.out.println(maths);
        System.out.println(obj.toJSONString());*/
        String jsonString = obj.toJSONString();
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode rootNode = (ObjectNode) mapper.readTree(jsonString);

        // Flatten the JSON
        ObjectNode flattenedNode = mapper.convertValue(rootNode, ObjectNode.class);
        System.out.println(flattenedNode.toString());

    }
}
