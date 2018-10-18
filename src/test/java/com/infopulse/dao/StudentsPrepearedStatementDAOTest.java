package com.infopulse.dao;

import com.infopulse.students.Student;
import org.junit.Test;

import java.util.Set;

import static junit.framework.TestCase.assertEquals;

public class StudentsPrepearedStatementDAOTest {

    @Test
    public void testPrepearedStatement() {


        StudentsDAO statementDAO = new StudentsPrepearedStatementDAO();

        statementDAO.insertStudent((long) 65,"Loli11",24,7);

        Set<Student> students = statementDAO.getAllStudents();

        Student studentResult = students.stream().filter(student -> student.getName().equals("Loli11"))
                                                 .findFirst()
                                                 .get();
        assertEquals("Loli11", studentResult.getName());

    }
}
