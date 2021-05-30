package com.mindex.challenge.service;
import com.mindex.challenge.data.Compensation;

public interface CompensationService {
    Compensation create(Compensation empComp); //Method to create the compensation for an employee
    Compensation read(String empId); //Method to read the compensation of an employee by the employeeID
}