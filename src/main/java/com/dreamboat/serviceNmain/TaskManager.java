package com.dreamboat.serviceNmain;

import com.dreamboat.practiceModel.Task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskManager {

    List<Task> tasks = new ArrayList<>();
    List<Task> completeTasks = new ArrayList<>();
    public void addTask(Task task) {
        tasks.add(task);
    }
    public void markTaskAsCompleted(Task task){
        task.setCompleted(true);
    }
    public List<Task> getAlltasks(){
        return tasks;
    }
    public List<Task> getCompletedTasks(){
        List<Task> CompletedTasks = new ArrayList<>();
        for(Task i : tasks){
            if(i.getCompleted()){
                CompletedTasks.add(i);
            }
        }
        return CompletedTasks;
    }
    public List<Task> getIncompleteTasks(){
        List<Task> IncompleteTasks = new ArrayList<>();
        for(Task i : tasks){
            if(!i.getCompleted()){
                IncompleteTasks.add(i);
            }
        }
        return IncompleteTasks;
    }
}

