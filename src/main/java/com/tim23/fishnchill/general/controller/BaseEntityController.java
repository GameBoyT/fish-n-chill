package com.tim23.fishnchill.general.controller;

import com.tim23.fishnchill.general.model.BaseEntity;
import com.tim23.fishnchill.general.service.BaseEntityService;
import com.tim23.fishnchill.cottage.model.Cottage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/entities", produces = MediaType.APPLICATION_JSON_VALUE)
public class BaseEntityController {
    @Autowired
    private BaseEntityService baseEntityService;

//    @GetMapping("/entity")
//    public ResponseEntity<String> findEntityById () {
//        System.out.println(baseEntityService.findById(1L));
//        return new ResponseEntity<>("keke", HttpStatus.OK);
//    }

//    @GetMapping("/entities")
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public BaseEntity findEntityById () {
//        return baseEntityService.findById(1L);
//    }

}
