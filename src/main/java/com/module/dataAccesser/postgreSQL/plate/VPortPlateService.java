package com.module.dataAccesser.postgreSQL.plate;

import com.module.dataAccesser.pojo.VPortPlate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VPortPlateService {
    @Autowired
    private VPortPlateRepository vPortPlateRepository;

    public VPortPlate getVPortPlateById(long plateId){
        VPortPlate obj = vPortPlateRepository.findById(plateId).get();
        return obj;
    }
}
