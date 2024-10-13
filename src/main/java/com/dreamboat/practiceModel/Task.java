package com.dreamboat.practiceModel;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Task {

    private String id;

    private String description;

    private Boolean completed;

    public Task(){}

    public Task(String id,String description,boolean completed) {

    }
}
