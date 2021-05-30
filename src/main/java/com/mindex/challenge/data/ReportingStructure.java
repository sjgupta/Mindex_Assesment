package com.mindex.challenge.data;

public class ReportingStructure {

    private Employee employee;
    private int numberOfReports;
    public ReportingStructure()
    {

    }
    // Getter and Setter are defined below for employee and number of reports
    public Employee getEmployee() {
        return employee;
    }
    public void setEmployee(Employee emp) {
        this.employee = emp;
    }
    public int getNumberOfReports() {
        return numberOfReports;
    }
    public void setNumberOfReports(int number_Of_Reports) {
        this.numberOfReports = number_Of_Reports;
    }
}
