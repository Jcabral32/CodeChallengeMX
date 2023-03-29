package com.mindex.challenge.data;

import java.util.List;

public class ReportingStructure {

    private Employee employee;
    private int numberOfReports;

    public ReportingStructure(){

    }

    public ReportingStructure(Employee employee){
        this.employee = employee;
        setNumberOfReports(employee);
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setNumberOfReports(Employee employee){
        if(employee.getDirectReports() == null){
            this.numberOfReports = 0;
        } else{
           this.numberOfReports = calculateNumberOfReports(employee);
        }
    }

    public int getNumberOfReports() {
        return numberOfReports;
    }

    public Employee getEmployee() {
        return employee;
    }

    public int calculateNumberOfReports(Employee employee) {
        int numberOfReports = 0;
        List<Employee> directReports = employee.getDirectReports();
        if (directReports != null) {
            numberOfReports += directReports.size();
            for (Employee directReport : directReports) {
                numberOfReports += calculateNumberOfReports(directReport);
            }
        }
        return numberOfReports;
    }

}
