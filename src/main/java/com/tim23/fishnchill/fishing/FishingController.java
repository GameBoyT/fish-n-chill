package com.tim23.fishnchill.fishing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/fishing", produces = MediaType.APPLICATION_JSON_VALUE)
public class FishingController {
    @Autowired
    private FishingService fishingService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<FishingDto> findAll() {
        return fishingService.findAll();
    }
}
