package com.module.dataAccesser.controller;

import com.module.dataAccesser.pojo.VPortDock;
import com.module.dataAccesser.pojo.VPortPlate;
import com.module.dataAccesser.postgreSQL.dock.VPortDockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("port")
public class VPortDockController {
    @Autowired
    private VPortDockService vPortDockService;

    @GetMapping("dock/{id}")
    public ResponseEntity<VPortDock> getArticleById(@PathVariable("id") Integer id) {
        VPortDock plate = vPortDockService.getVPortDockById(id);
        return new ResponseEntity<VPortDock>(plate, HttpStatus.OK);
    }
}
