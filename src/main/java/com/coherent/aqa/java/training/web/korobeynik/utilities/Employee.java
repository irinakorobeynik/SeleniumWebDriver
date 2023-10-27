package com.coherent.aqa.java.training.web.korobeynik.utilities;

public class Employee {

    private String name;
    private String position;
    private String office;
    private int age;
    private double salary;

    public Employee(String name, String position, String office, int age, double salary) {
        this.name = name;
        this.position = position;
        this.office = office;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getOffice() {
        return office;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Name = "+ name + " Position = " + position + " Office = "+ office+ " age = "+ age + " salary = " + salary;
    }
}
