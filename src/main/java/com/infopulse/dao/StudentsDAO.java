package com.infopulse.dao;



import com.infopulse.students.Student;

import java.util.Set;

public interface StudentsDAO {
    Student getStudent(int i);
    Set<Student> getAllStudents();
    //    Student getStudentsByGroup();
    void insertStudent(Long id,String name,int age,int groups);
    void updateStudent();
    void deleteUser();
    public void createTable();

}