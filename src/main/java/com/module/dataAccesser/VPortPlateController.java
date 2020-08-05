package com.module.dataAccesser;

import com.module.dataAccesser.pojo.VPortPlate;
import com.module.dataAccesser.postgreSQL.plate.VPortPlateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("port")
public class VPortPlateController {
    @Autowired
    private VPortPlateService vPortPlateService;

    @GetMapping("plate/{id}")
    public ResponseEntity<VPortPlate> getArticleById(@PathVariable("id") Integer id) {
        VPortPlate plate = vPortPlateService.getVPortPlateById(id);
        return new ResponseEntity<VPortPlate>(plate, HttpStatus.OK);
    }
}
