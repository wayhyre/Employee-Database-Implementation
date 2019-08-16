package com.sparta.doo.EmployeeManager;

/**
 * Hello world!
 *
 */
public class Starter
{
    public static void main( String[] args )
    {

//        long startTime = System.nanoTime();
//
//
//        ReadFile readManager = new ReadFile();
//        readManager.createEmployee();
//
//        EmployeeDAO employeeDAO = new EmployeeDAO();
//        employeeDAO.plugEmployees(readManager.setEmployees().values());
//
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime);
//
//
//        System.out.println("Time Taken: " + duration / 1_000_000_000.0);


        ThreadManager threadManager = new ThreadManager();
        threadManager.run();


    }
}
