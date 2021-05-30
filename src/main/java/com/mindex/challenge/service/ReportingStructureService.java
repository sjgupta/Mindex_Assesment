package com.mindex.challenge.service;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;

public interface ReportingStructureService {
    public ReportingStructure readEmpId(String id); // Provides the reporting structure of a particular employee
    public int totalNumberOfReports(Employee employee); // Provides the total number of reports of an employee
}
