package com.infopulse.dao;

import com.infopulse.students.Student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

import static com.infopulse.connection.ConnectionFactory.getConnection;


public class StudentsCallableStatementDAO implements StudentsDAO {

    @Override
    public Student getStudent(int i) {
        return null;
    }

    @Override
    public Set<Student> getAllStudents() {
        return null;
    }

    @Override
    public void insertStudent(Long id, String name, int age, int groups) {

    }

    @Override
    public void updateStudent() {

    }

    @Override
    public void deleteUser() {

    }
    public void createTable() {
        try (Connection con = getConnection();
             CallableStatement cs = con.prepareCall("{call add_student2()}");) {
            cs.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}