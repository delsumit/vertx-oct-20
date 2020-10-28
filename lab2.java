package com.ibm.reactive.core.lab3;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.List;

class Employee{
    private long id;
    private String name;

    public Employee() {
    }

    public Employee(long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class EmployeeService {

    List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        this.employees.add(new Employee(1001,"Ram"));
        this.employees.add(new Employee(1002,"Sham"));
        this.employees.add(new Employee(1003,"Krishna"));
        this.employees.add(new Employee(1004,"SHIV"));
        this.employees.add(new Employee(1005,"Vishnu"));

    }

    Observable<Employee> findAllEmployeesInUpperCase(){
        return Observable.fromIterable(employees).filter(emp->emp.getName().toUpperCase().equals(emp.getName()));
    }

    public static void main(String[] args) {
        Observable<Employee> empName = new EmployeeService().findAllEmployeesInUpperCase();
        empName.subscribe((emp)->System.err.println(emp),(emp)->System.err.println(emp));
    }
}
