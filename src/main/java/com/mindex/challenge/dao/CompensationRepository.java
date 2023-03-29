package com.mindex.challenge.dao;

import com.mindex.challenge.data.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.mindex.challenge.data.Compensation;
@Repository
public interface CompensationRepository extends MongoRepository<Compensation, String> {
    Compensation findByEmployee_employeeId(String employeeId);//Spring Magic in the Underscores
}
