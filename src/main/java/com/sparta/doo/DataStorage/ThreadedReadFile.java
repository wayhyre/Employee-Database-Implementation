package com.sparta.doo.DataStorage;

import com.sparta.doo.EmployeeManager.ThreadManager;
import com.sparta.doo.Employees.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class ThreadedReadFile {

    private int count = 0;
    private ThreadManager threadManager = new ThreadManager();
    private long start;
    private static final String EmployeeRecords = "resources/EmployeeRecordsLarge.csv";

    public HashMap<Integer, Employee> setEmployees() {
        HashMap<Integer, Employee> dataStore = new HashMap<>();
         start = System.nanoTime();
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(EmployeeRecords));
            csvReader.readLine(); // removes header
            String line;
            while ((line = csvReader.readLine()) != null) {
                String[] data = line.trim().split(","); // this where i create an employee data
                // puts separated dates into positions
                Employee employee = new Employee(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9]);
                dataStore.put(Integer.valueOf(employee.getEmpID()), employee);
                if (count == 1500) {
                    Collection<Employee> employees = new HashSet<>(dataStore.values());
                    PersistEmployees(employees);
                    dataStore.clear();
                    count = 0;
                }
                count++;
            }
            PersistEmployees(dataStore.values());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataStore;
    }


    private void PersistEmployees(Collection<Employee> employeeCollection) {
        Runnable runnable = () -> {
            EmployeeDAO employeeDAO = new EmployeeDAO();
            employeeDAO.plugEmployees(employeeCollection);
            long end = System.nanoTime();
            System.out.println((end - start) / 1_000_000_000);
        };
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("Thread started");
    }
}

//public void formatNano(long timeGrab){
//    DecimalFormat decimalFormat = new DecimalFormat("###,###.###");
//    System.out.println(decimalFormat.format(timeGrab) + " nano seconds");
//}