package com.infopulse.dao;

import org.junit.Test;


public class StudentsCallableStatementDAOTest {

    @Test
    public void testCallableStatement() {

        StudentsCallableStatementDAO scs = new StudentsCallableStatementDAO();
        scs.createTable();

    }
}
