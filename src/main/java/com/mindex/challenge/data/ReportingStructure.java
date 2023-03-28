package com.mindex.challenge.data;

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
        if(employee.getDirectReports().isEmpty()){
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

    private int calculateNumberOfReports(Employee employee) {
        int numberOfReports = 0;
        if (employee.getDirectReports() != null) {
            numberOfReports += employee.getDirectReports().size();
            for (Employee directReport : employee.getDirectReports()) {
                numberOfReports += calculateNumberOfReports(directReport);
            }
        }
        return numberOfReports;
    }

}
