package com.infopulse.dao;

import com.infopulse.connection.MainConnect;
import com.infopulse.students.Student;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;


public class StudentsCallableStatementDAO implements StudentsDAO {

    private static final Logger logger = Logger.getLogger(StudentsCallableStatementDAO.class);
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
        Connection connection = null;
        CallableStatement callableStatement = null;
        try {
            connection = MainConnect.getConnect();
            callableStatement = connection.prepareCall("{call add_student2()}");
            callableStatement.execute();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            try {
                callableStatement.close();
            } catch (SQLException e) {
                logger.error(e);
            }
            MainConnect.putConn(connection);
        }
    }
}