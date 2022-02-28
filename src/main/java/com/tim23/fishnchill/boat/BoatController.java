package com.tim23.fishnchill.boat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/boats", produces = MediaType.APPLICATION_JSON_VALUE)
public class BoatController {
    @Autowired
    private BoatService boatService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<BoatDTO> findAll() {
        return boatService.findAll();
    }
}
