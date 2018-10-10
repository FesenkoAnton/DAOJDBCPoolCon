package com.infopulse.dao;

import com.infopulse.connection.Connect;
import com.infopulse.students.Student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;


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
        Connection con = null;
        CallableStatement cs = null;
        try {
            con = Connect.getConn();
            try {
                cs = con.prepareCall("{call add_student2()}");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            cs.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Connect.putConn(con);
        }

    }
}