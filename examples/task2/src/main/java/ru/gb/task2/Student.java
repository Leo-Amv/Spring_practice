package ru.gb.task2;

import lombok.Data;

@Data
public class Student {
    private static long idCounter = 1L;
    private long id;
    private String name;
    private String groupName;

    public Student(String name, String groupName) {
        this.id = idCounter++;
        this.name = name;
        this.groupName = groupName;
    }
}
