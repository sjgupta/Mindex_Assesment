package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        LOG.debug("Creating employee [{}]", employee);

        employee.setEmployeeId(UUID.randomUUID().toString());
        employeeRepository.insert(employee);

        return employee;
    }

    @Override
    public Employee read(String id) {
        LOG.debug("Creating employee with id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return employee;
    }
    // method to return the employee structure of employees working under a particular employee
    @Override
    public Employee readEmployeeId(String id)
    {
        Employee employee = employeeRepository.findByEmployeeId(id);
        // If the given Employee Id is not valid
        if (employee == null)
        {
            throw new RuntimeException("Invalid employeeId: " + id);
        }
        /* This is a list of Employees working under a particular Employee */
        List<Employee> directReports = new ArrayList<>();
        List<Employee> employeesList = employee.getDirectReports();
        if(employeesList==null)
        {
            return employee;
        }
        for(Employee currentEmployee : employeesList)
        {
            // recursively calling "readEmployeeId()" to get the reporting structure of direct reporting employees
            Employee subEmployee = readEmployeeId(currentEmployee.getEmployeeId());
            directReports.add(subEmployee);
        }
        employee.setDirectReports(directReports);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        LOG.debug("Updating employee [{}]", employee);
        return employeeRepository.save(employee);
    }
}
