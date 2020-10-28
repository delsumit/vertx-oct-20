package com.ibm.reactive.core.lab3;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;

class Employee{
    private long id;
    private String name;
    private double salary;

    public Employee() {
    }

    public Employee(long id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

public class EmployeeService {

    List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        this.employees.add(new Employee(1001,"Ram",10100));
        this.employees.add(new Employee(1002,"Sham",1200));
        this.employees.add(new Employee(1003,"Krishna",30100));
        this.employees.add(new Employee(1004,"SHIV",11000));
        this.employees.add(new Employee(1005,"Vishnu",1500));

    }

    Observable<Employee> findAllEmployeesInUpperCase(){
       return Observable.fromIterable(employees).filter(emp->emp.getName().toUpperCase().equals(emp.getName()));
    }

    Observable<Employee> findAllEmployeesSalaryMoreThan10K(){
        return Observable.fromIterable(employees).filter(emp->emp.getSalary()>10000);
    }

    public static void main(String[] args) {
        //Observable<Employee> empName = new EmployeeService().findAllEmployeesInUpperCase();
        //empName.subscribe((emp)->System.err.println(emp),(emp)->System.err.println(emp));
        Observable<Employee> empName = new EmployeeService().findAllEmployeesSalaryMoreThan10K();
        empName.subscribe((emp)->System.err.println(emp),(emp)->System.err.println(emp));
    }
}
