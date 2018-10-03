package com.infopulse.students;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Long id;
    private String name;
    private Integer age;
    private Integer groups;

    public Student(String name, Integer age, Integer groups) {
        this.name = name;
        this.age = age;
        this.groups = groups;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", groups=" + groups +
                '}';
    }
}
