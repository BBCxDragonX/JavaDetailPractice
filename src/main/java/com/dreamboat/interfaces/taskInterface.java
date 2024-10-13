package com.dreamboat.interfaces;


import com.dreamboat.practiceModel.Task;
import com.dreamboat.serviceNmain.TaskManager;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.exit;

public class taskInterface {
    Task tk = new Task();
    boolean flag = true;
    TaskManager tm = new TaskManager();
    String option = "";

    ToDoRead tr = new ToDoRead();

    public static void main(String[] args) throws IOException {
        taskInterface TI = new taskInterface();

    }
    taskInterface() throws IOException {
        Map< String,LocalDateTime> timeline = new LinkedHashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Add Task\n" +
                "2.Mark task as completed\n" +
                "3.View all tasks\n" +
                "4.View completed tasks\n" +
                "5.View incomplete tasks\n" +
                "6.Exit\n");
        while(flag) {

            option = sc.nextLine();
            if (Objects.equals(option, "1")) {
                tm.addTask(tr.deserializer());
                timeline.put("A task is added", LocalDateTime.now());
                System.out.println("A task is added"+" at "+timeline.get("A task is added"));
                System.out.println("if you would like to continue press any no '1-5' then Enter or else press 6");
            }
            if (Objects.equals(option, "2")) {
                tm.markTaskAsCompleted(tr.deserializer());
            }
            if (Objects.equals(option, "3")) {
                tm.getAlltasks();
            }
            if (Objects.equals(option, "4")) {
                tm.getCompletedTasks();
            }
            if (Objects.equals(option, "5")) {
                tm.getIncompleteTasks();
            }
            if (Objects.equals(option, "6")) {
                flag = false;
                sc.close();
            }


        }
    }
}
