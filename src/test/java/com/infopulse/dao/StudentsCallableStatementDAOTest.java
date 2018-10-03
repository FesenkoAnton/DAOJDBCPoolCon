package com.infopulse.dao;

import org.junit.Test;


public class StudentsCallableStatementDAOTest {

    @Test
    public void testCallableStatement() {
//
//        ConnectionFactory.setPASSWORD("anton1!");

        StudentsCallableStatementDAO scs = new StudentsCallableStatementDAO();
        scs.createTable();

    }
}
