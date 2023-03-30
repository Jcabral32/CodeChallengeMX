package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import com.mindex.challenge.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public ReportingStructure report(String employeeId) {
        LOG.debug("Showed the ReportingStructure for employee [{}]", employeeId);

        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        if(employee == null){
            throw new RuntimeException("Invalid employeeId: " + employeeId);
        }

        ReportingStructure report = new ReportingStructure();
        report.setEmployee(employee);
        report.setNumberOfReports(calculateNumberOfReports(employee));

        return report;
    }
    private int calculateNumberOfReports(Employee employee) {
        int numberOfReports = 0;

        List<Employee> directReports = employeeRepository.findByEmployeeId(employee.getEmployeeId()).getDirectReports();
        //List<Employee> temp = new List<Employee>();

        if (directReports != null) {

            numberOfReports += directReports.size();

            for (Employee directReport : directReports) {
                numberOfReports += calculateNumberOfReports(directReport);
            }
        }
        return numberOfReports;
    }
}
