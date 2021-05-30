package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ReportingStructureService reportingStructureService;
    @Autowired
    CompensationService compService;

    @PostMapping("/employee")
    public Employee create(@RequestBody Employee employee) {
        LOG.debug("Received employee create request for [{}]", employee);
        return employeeService.create(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee read(@PathVariable String id) {
        LOG.debug("Received employee create request for id [{}]", id);
        return employeeService.read(id);
    }

    @PutMapping("/employee/{id}")
    public Employee update(@PathVariable String id, @RequestBody Employee employee) {
        LOG.debug("Received employee create request for id [{}] and employee [{}]", id, employee);
        employee.setEmployeeId(id);
        return employeeService.update(employee);
    }

    @GetMapping("/reportingStructure/{id}")
    public ReportingStructure getstructure(@PathVariable String id) {
        return reportingStructureService.readEmpId(id);
    }

    @PostMapping("/compensation")
    public Compensation creatingComp(@RequestBody Compensation comp)
    {
        return compService.create(comp);
    }

    @GetMapping("/compensation/{empId}")
    public Compensation readingComp(@PathVariable String empId)
    {
        return compService.read(empId);
    }
}
