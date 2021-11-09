package com.tim23.fishnchill.cottage;

import com.tim23.fishnchill.cottage.model.Cottage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cottages", produces = MediaType.APPLICATION_JSON_VALUE)
public class CottageController {
    @Autowired
    private CottageService cottageService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Cottage> findAll () {
        return cottageService.findAll();
    }

}
