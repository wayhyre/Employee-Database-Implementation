package com.sparta.doo.DataStorage;

import com.sparta.doo.Employees.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReadManager {

    private static final String EmployeeRecords = "resources/EmployeeRecords.csv";
    HashMap<Integer, Employee> dataStore = new HashMap<>();

    public HashMap<Integer, Employee> getDataStore() {
        return dataStore;
    }

    public void createEmployee() {
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(EmployeeRecords));
            csvReader.readLine(); // removes header
            String line;
            while ((line = csvReader.readLine()) != null) {
                String[] data = line.split(","); // this where i create an employee data
                // puts separated dates into positions
                Employee employee = new Employee
                        (Integer.parseInt
                                (data[0]), data[1], data[2], data[3],
                                data[4], data[5], data[6], data[7], data[8], data[9]);

                dataStore.put(Integer.valueOf(employee.getEmpID()), employee);

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

