package com.tim23.fishnchill.general.controller;

import com.tim23.fishnchill.general.model.BaseEntity;
import com.tim23.fishnchill.general.service.BaseEntityService;
import com.tim23.fishnchill.cottage.model.Cottage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class BaseEntityController {
    @Autowired
    private BaseEntityService baseEntityService;

//    @GetMapping("/entity")
//    public ResponseEntity<String> findEntityById () {
//        System.out.println(baseEntityService.findById(1L));
//        return new ResponseEntity<>("keke", HttpStatus.OK);
//    }

    @GetMapping("/entity")
    public ResponseEntity<BaseEntity> findEntityById () {
//        System.out.println(baseEntityService.findById(1L));
        return new ResponseEntity<>(baseEntityService.findById(1L), HttpStatus.OK);
    }

    @GetMapping("/cottages")
    public ResponseEntity<List<Cottage>> findHousesByName (){
        System.out.println(baseEntityService.findCottagesByName("ime"));
        return new ResponseEntity<>(baseEntityService.findCottagesByName("ime"), HttpStatus.OK);
    }
}
