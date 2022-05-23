package com.tim23.fishnchill.adventure;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/adventures", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdventureController {

    private AdventureService adventureService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<AdventureDto> findAll() {
        return adventureService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public AdventureDto findById(@PathVariable("id") Long id) {
        return adventureService.findById(id);
    }

    @GetMapping(value = "/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<AdventureDto> findByNameContaining(@PathVariable("name") String name) {
        return adventureService.findByNameContaining(name);
    }

    @GetMapping(value = "/description/{description}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<AdventureDto> findByDescriptionContaining(@PathVariable("description") String description) {
        return adventureService.findByDescriptionContaining(description);
    }

    @GetMapping(value = "/anything/{anything}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<AdventureDto> findByAnything(@PathVariable("anything") String anything) {
        return adventureService.findByAnything(anything, anything);
    }
}
