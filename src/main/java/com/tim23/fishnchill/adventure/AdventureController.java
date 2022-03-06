package com.tim23.fishnchill.adventure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/adventures", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdventureController {
    @Autowired
    private AdventureService adventureService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<AdventureDto> findAll() {
        return adventureService.findAll();
    }
}
