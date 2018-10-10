package com.infopulse.dao;

import com.infopulse.connection.Connect;
import com.infopulse.students.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StudentsPrepearedStatementDAO implements StudentsDAO {
    @Override
    public Student getStudent(int i) {
        return null;
    }

    @Override
    public Set<Student> getAllStudents() {
        Connection con = null;
        PreparedStatement ps = null;
        try {
                con = Connect.getConn();
             ps = con.prepareStatement(SQLStudent.SELECT.QUERY);

            Set<Student> students = new HashSet<>();

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setGroups(rs.getInt("groups"));
                students.add(student);
            }

            return students;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            Connect.putConn(con);
        }
        return Collections.emptySet();
    }

    @Override
    public void insertStudent(Long id, String name, int age, int groups) {
//        try (Connection con = getConnection();
//             PreparedStatement ps = con.prepareStatement(SQLStudent.INSERT.QUERY);) {

        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Connect.getConn();
            ps = con.prepareStatement(SQLStudent.INSERT.QUERY);
//            ps.setLong(1, id);
//            ps.setString(2, name);
//            ps.setInt(3, age);
//            ps.setInt(4, groups);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setInt(3, groups);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            Connect.putConn(con);
        }

    }

    @Override
    public void updateStudent() {

    }

    @Override
    public void deleteUser() {

    }

    @Override
    public void createTable() {

    }


    enum SQLStudent {
//        INSERT("INSERT INTO students (id, name, age, groups) VALUES (?,?,?,?)"),

        INSERT("INSERT INTO students (id, name, age, groups) VALUES (?,?,?)"),

        SELECT("SELECT * FROM students");

        String QUERY;

        SQLStudent(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
