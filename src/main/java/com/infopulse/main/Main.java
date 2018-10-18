package com.infopulse.main;


import com.infopulse.dao.StudentsStatementDAO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        StudentsStatementDAO student = new StudentsStatementDAO();
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
            executor.submit(new Runnable() {
                @Override
                public void run() {

                    StudentsStatementDAO student = new StudentsStatementDAO();
                    System.out.println(student.getStudent(1));
                }
            });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();

    }
}