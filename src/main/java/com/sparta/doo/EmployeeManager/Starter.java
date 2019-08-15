package com.sparta.doo.EmployeeManager;

import com.sparta.doo.DataStorage.EmployeeDAO;
import com.sparta.doo.DataStorage.ReadManager;

/**
 * Hello world!
 *
 */
public class Starter
{
    public static void main( String[] args )
    {
        ReadManager readManager = new ReadManager();
        readManager.createEmployee();

        EmployeeDAO employeeDAO = new EmployeeDAO();
        employeeDAO.plugEmployees(readManager.getDataStore().values());

    }
}
