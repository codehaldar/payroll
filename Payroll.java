package com.company;

import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;
    public Employee(String name, int id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    abstract public double calculateSalary();
    @Override
    public String toString(){
        return "Employee [name: "+name+", id: "+id+", salary: "+calculateSalary()+"]";
    }
};
class FullTimeEmployee extends Employee{
    public double monthySalary;
    public FullTimeEmployee(String name, int id, double monthySalary){
        super(name,id);
        this.monthySalary=monthySalary;
    }
    @Override
    public double calculateSalary(){
        return monthySalary;
    }
}
class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double ratePerHour;
    public PartTimeEmployee(String name, int id, int hoursWorked, double ratePerHour){
        super(name,id);
        this.hoursWorked=hoursWorked;
        this.ratePerHour=ratePerHour;
    }
    @Override
    public double calculateSalary(){
        return hoursWorked*ratePerHour;
    }
}
class Payroll{
    private ArrayList<Employee> empList;
    public Payroll(){
        empList=new ArrayList<>();
    }
    public void addEmp(Employee emp){
        empList.add(emp);
    }
    public void removeEmp(int id){
        Employee empToRmv=null;
        for(Employee emp: empList){
            if(emp.getId()==id){
                empToRmv=emp;
                break;
            }
        }
        if(empToRmv!=null){
            empList.remove(empToRmv);
        }
    }
    public void displayEmployee(){
        for(Employee emp: empList){
            System.out.println(emp);
        }
    }
}
public class Main {

    public static void main(String[] args) {
        Payroll payr=new Payroll();
        PartTimeEmployee emp1=new PartTimeEmployee("Aditya",123,26,600);
        FullTimeEmployee emp2=new FullTimeEmployee("Ravi",221,64000);
        FullTimeEmployee emp3=new FullTimeEmployee("Aniket",115,45000);
        System.out.println("Adding Employee1 and Employee2 to Payroll System");
        payr.addEmp(emp1);
        payr.addEmp(emp2);
        payr.addEmp(emp3);
        System.out.println("Current Employee List to Payroll System");
        payr.displayEmployee();
        System.out.println("Removing Employee1 from Payroll System");
        payr.removeEmp(123);
        System.out.println("Current Employee List to Payroll System");
        payr.displayEmployee();

    }
}