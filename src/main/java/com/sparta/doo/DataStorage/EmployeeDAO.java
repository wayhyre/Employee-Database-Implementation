package com.sparta.doo.DataStorage;

import com.sparta.doo.Employees.Employee;

import java.sql.*;
import java.util.Collection;


public class EmployeeDAO {

    private PreparedStatement preparedStatement = null;

    public void plugEmployees(Collection<Employee> employeeCollection) {

//        long startTime = System.nanoTime();
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime);

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sparta_employee?user=root&password=Ruksana12")) {

            preparedStatement = connection.prepareStatement("INSERT INTO sparta_employees (EmpID, Name_Prefix, First_Name, Middle_Initial, Last_Name, Gender, Email, Date_of_Birth, Date_of_Joining, Salary)" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");


            for (Employee employee : employeeCollection) {
                preparedStatement.setString(1, String.valueOf(employee.getEmpID()));
                preparedStatement.setString(2, employee.getNamePrefix());
                preparedStatement.setString(3, employee.getFirstName());
                preparedStatement.setString(4, employee.getMidInitial());
                preparedStatement.setString(5, employee.getLastName());
                preparedStatement.setString(6, employee.getGender());
                preparedStatement.setString(7, employee.getEmail());
                preparedStatement.setDate(8, Date.valueOf(employee.getDateOfBirth()));
                preparedStatement.setDate(9, Date.valueOf(employee.getDateOfJoining()));
                preparedStatement.setInt(10, Integer.valueOf(employee.getSalary()));

                preparedStatement.executeUpdate();

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
//        System.out.println("Time Taken :" + duration / 1_000_000_000.0);

    }
}
