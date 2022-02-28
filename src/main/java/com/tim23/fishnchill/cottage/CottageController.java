package com.tim23.fishnchill.cottage;

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
    public List<CottageDTO> findAll() {
        return cottageService.findAll();
    }

    @GetMapping(value = "/{id}")
//    @PreAuthorize("hasRole('BUSINESS')")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CottageDTO findOne(@PathVariable("id") Long id) {
        return cottageService.findOne(id);
    }

    @GetMapping(value = "/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CottageDTO> findByNameContaining(@PathVariable("name") String name) {
        return cottageService.findByNameContaining(name);
    }
}
