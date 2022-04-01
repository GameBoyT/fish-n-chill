package com.tim23.fishnchill.user.controller;

import com.tim23.fishnchill.user.dto.ClientDto;
import com.tim23.fishnchill.user.dto.ClientProfileDto;
import com.tim23.fishnchill.user.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/clients", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    private ClientService clientService;

    @GetMapping()
    public List<ClientDto> findAll() {
        return this.clientService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ClientProfileDto findById(@PathVariable("id") Long id) {
        return clientService.findById(id);
    }
}
