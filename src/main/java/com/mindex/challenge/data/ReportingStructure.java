package com.mindex.challenge.data;

import java.util.List;

public class ReportingStructure {

    private Employee employee;
    private int numberOfReports;

    public ReportingStructure(){
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setNumberOfReports(int numberOfReports){
        this.numberOfReports = numberOfReports;
//        if(employee.getDirectReports() == null){
//            this.numberOfReports = 0;
//        } else{
//           this.numberOfReports = calculateNumberOfReports(employee);
//        }
    }

    public int getNumberOfReports() {
        return numberOfReports;
    }

    public Employee getEmployee() {
        return employee;
    }

//    public int calculateNumberOfReports(Employee employee) {
//        int numberOfReports = 0;
//        List<Employee> directReports = employee.getDirectReports();
//        if (directReports != null) {
//            numberOfReports += directReports.size();
//            for (Employee directReport : directReports) {
//                numberOfReports += calculateNumberOfReports(directReport);
//            }
//        }
//        return numberOfReports;
//    }

}
