package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompensationServiceImpl implements CompensationService {
    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);
    @Autowired
    private CompensationRepository compensationRepository;
    @Override
    public Compensation create(Compensation comp) {
        LOG.debug("Creating compensation with Employee Id  [{}]", comp.getEmployee().getEmployeeId());

        compensationRepository.insert(comp);
        return comp;
    }
    @Override
    public Compensation read(String id) {
        LOG.debug("Reading compensation with id [{}]", id);

        Compensation comp = compensationRepository.findByEmployee_employeeId(id);
        if (comp == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }
        return comp;
    }

}
