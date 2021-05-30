package com.mindex.challenge.service.impl;
import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompensationServiceImpl implements CompensationService{

    @Autowired
    private CompensationRepository compensationRepo;
    @Autowired
    private EmployeeService employeeService;

    @Override
    public Compensation create(Compensation comp)
    {
        //inserting the compensation data in compensation repository
        return compensationRepo.insert(comp);
    }

    @Override
    public Compensation read(String Id)
    {
        /* "findCompByEmployeeEmployeeId()" is defined in the compensation repository */
        return compensationRepo.findCompByEmployeeEmployeeId(Id);
    }
}
