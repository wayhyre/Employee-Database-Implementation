package com.sparta.doo.Employees;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Employee {

    private Integer empID;
    private String namePrefix;
    private String firstName;
    private String midInitial;
    private String lastName;
    private String gender;
    private String email;
    private LocalDate dateOfBirth;
    private LocalDate dateOfJoining;
    private String salary;





    public Employee(Integer empID, String namePrefix, String firstName, String midInitial, String lastName, String gender, String email, String dateOfBirth, String dateOfJoining, String salary) {

        this.empID = empID;
        this.namePrefix = namePrefix;
        this.firstName = firstName;
        this.midInitial = midInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dateOfBirth = formattedDate(dateOfBirth);
        this.dateOfJoining =formattedDate(dateOfJoining);
        this.salary = salary;
    }

    private LocalDate formattedDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[M/d/yyyy]");
        return LocalDate.parse(date, formatter);
    }


    public Integer getEmpID() {
        return empID;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMidInitial() {
        return midInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public String getSalary() {
        return salary;
    }
}
