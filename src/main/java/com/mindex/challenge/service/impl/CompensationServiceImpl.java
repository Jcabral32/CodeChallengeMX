package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CompensationServiceImpl {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private CompensationRepository compensationRepository;
    private EmployeeRepository employeeRepository;

    public Compensation create(Employee employee) {
        LOG.debug("Creating employee [{}]", employee);



        return employee;
    }
    public Compensation read(String id) {
        LOG.debug("Reading compensation with id [{}]", id);
        Employee employee = employeeRepository.findByEmployeeId(id);
        Compensation comp = compensationRepository.findByEmployeeId(id);
        if (comp == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }
        return comp;
    }


}
