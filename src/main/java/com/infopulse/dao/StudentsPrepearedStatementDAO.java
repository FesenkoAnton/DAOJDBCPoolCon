package com.infopulse.dao;

import com.infopulse.connection.MainConnect;
import com.infopulse.students.Student;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StudentsPrepearedStatementDAO implements StudentsDAO {

    private static final Logger logger = Logger.getLogger(StudentsPrepearedStatementDAO.class);

    @Override
    public Student getStudent(int i) {
        return null;
    }

    @Override
    public Set<Student> getAllStudents() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = MainConnect.getConnect();
            preparedStatement = connection.prepareStatement(SQLStudent.SELECT.QUERY);

            Set<Student> students = new HashSet<>();

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setGroups(resultSet.getInt("groups"));
                students.add(student);
            }
            return students;
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error(e);
            }
            MainConnect.putConn(connection);
        }
        return Collections.emptySet();
    }

    @Override
    public void insertStudent(Long id, String name, int age, int groups) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = MainConnect.getConnect();
            preparedStatement = connection.prepareStatement(SQLStudent.INSERT.QUERY);
            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);
            preparedStatement.setInt(4, groups);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            logger.error(e);
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                logger.error(e);
            }
            MainConnect.putConn(connection);
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

        INSERT("INSERT INTO students (id, name, age, groups) VALUES (?,?,?,?)"),

        SELECT("SELECT * FROM students");

        String QUERY;

        SQLStudent(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}
