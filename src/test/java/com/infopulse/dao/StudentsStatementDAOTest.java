package com.infopulse.dao;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class StudentsStatementDAOTest {


    @Test
    public void testStudentsCallableStatement() {

        StudentsStatementDAO student = new StudentsStatementDAO();
        assertEquals("Olya",student.getStudent(1).getName() );

    }
}
