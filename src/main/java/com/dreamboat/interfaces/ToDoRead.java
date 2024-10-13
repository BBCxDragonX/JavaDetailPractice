package com.dreamboat.interfaces;
import com.dreamboat.practiceModel.Task;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;


public class ToDoRead {

    public Task deserializer() throws IOException {
        String status = "";
        ObjectMapper objectMapper = new ObjectMapper();
        Task task = objectMapper.readValue(new File("D:\\CodeDump\\JavaDetailPractice\\data\\Task.json"), Task.class);
        if(task.getCompleted()){
            status = "completed";
        }
        else{
            status = "not completed";
        }
            System.out.println("task id " + task.getId() + " which has " + task.getDescription() + " is " + status);
            return task;
    }

    public String serializer() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Task task = new Task("1", "Completehomework", false);
        String jsonString = objectMapper.writeValueAsString(task);
        System.out.println(jsonString);
        return jsonString;
    }
}
