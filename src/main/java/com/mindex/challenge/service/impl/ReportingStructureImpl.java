package com.mindex.challenge.service.impl;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
@Service
public class ReportingStructureImpl implements ReportingStructureService{
    @Autowired
    private EmployeeService empService;

    @Autowired
    private EmployeeRepository employeeRepository;

    public ReportingStructureImpl(EmployeeService employeeService)
    {
        empService = employeeService;
    }

    public ReportingStructure readEmpId(String id)
    {
        Employee employeeData = empService.readEmployeeId(id); //"readEmployeeId()" is defined in EmployeeServiceImp
        ReportingStructure repStructObj = new ReportingStructure();
        repStructObj.setEmployee(employeeData);
        repStructObj.setNumberOfReports(totalNumberOfReports(employeeData));
        return repStructObj;
    }

    public int totalNumberOfReports(Employee employee)
    {
        int reportCount = 0;
        //In case there does not exist a reporting employee under an employee
        if(employee.getDirectReports() == null) { return reportCount; }
        else
        {
            reportCount += employee.getDirectReports().size();
            for(Employee directEmp : employee.getDirectReports())
            {
                //Recursively calling totalNumberOfReports() to get the total number of reports of the sub-employees
                reportCount += totalNumberOfReports(directEmp);
            }
            return reportCount;
        }
    }
}
