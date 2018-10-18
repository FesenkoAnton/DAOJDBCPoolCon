package com.infopulse.dao;

import com.infopulse.connection.MainConnect;
import com.infopulse.students.Student;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;


public class StudentsStatementDAO implements StudentsDAO {

    private static final Logger logger = Logger.getLogger(StudentsStatementDAO.class);

    @Override
    public Student getStudent(int id) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = MainConnect.getConnect();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQLStudent.SELECT.QUERY + id);

            if (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getInt("age"));
                student.setGroups(resultSet.getInt("groups"));
                return student;
            }

        } catch (SQLException e) {
            logger.error(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                logger.error(e);
            }
            MainConnect.putConn(connection);
        }

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

    @Override
    public void createTable() {

    }


    enum SQLStudent {
        SELECT("SELECT * FROM students WHERE id=");

        String QUERY;

        SQLStudent(String QUERY) {
            this.QUERY = QUERY;
        }
    }
}

