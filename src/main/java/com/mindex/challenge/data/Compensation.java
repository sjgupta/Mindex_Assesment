package com.mindex.challenge.data;

public class Compensation {
    private Employee employee;
    private int salary;
    private String effectiveDate;

    public Compensation()
    {

    }
    // Below are the Getter and Setter methods
    public Employee getEmployee()
    {
        return employee;
    }
    public void setEmployee(Employee emp)
    {
        this.employee = emp;
    }
    public int getSalary()
    {
        return salary;
    }
    public void setSalary(int sal)
    {
        this.salary = sal;
    }
    public String getEffectiveDate()
    {
        return effectiveDate;
    }
    public void setEffectiveDate(String effectDate)
    {
        this.effectiveDate = effectDate;
    }
}
