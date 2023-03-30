package com.mindex.challenge;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataBootstrapTest {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompensationRepository compensationRepository;

    @Test
    public void test() {
        Employee employee = employeeRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");
        assertNotNull(employee);
        assertEquals("John", employee.getFirstName());
        assertEquals("Lennon", employee.getLastName());
        assertEquals("Development Manager", employee.getPosition());
        assertEquals("Engineering", employee.getDepartment());

        Compensation comp = compensationRepository.findByEmployee_employeeId("37934cac-4f10-4153-9202-6b5db4c203d2");
        assertNotNull(comp);
        assertEquals("Joseph", comp.getEmployee().getFirstName());
        assertEquals("Black", comp.getEmployee().getLastName());
        assertEquals("Development Manager", comp.getEmployee().getPosition());
        assertEquals("Engineering", comp.getEmployee().getDepartment());
        assertEquals(1200090.3, comp.getSalary(), 1);
        assertEquals("2007-12-03", comp.getEffectiveDate());

    }
}