package com.tim23.fishnchill.cottage.controller;

import com.tim23.fishnchill.cottage.CottageDto;
import com.tim23.fishnchill.cottage.CottageDtoNoOwner;
import com.tim23.fishnchill.cottage.model.Cottage;
import com.tim23.fishnchill.cottage.service.CottageService;
import com.tim23.fishnchill.security.TokenUtils;
import com.tim23.fishnchill.user.controller.UserController;
import com.tim23.fishnchill.user.dto.ClientDto;
import com.tim23.fishnchill.user.dto.UserDto;
import com.tim23.fishnchill.user.model.CottageOwner;
import com.tim23.fishnchill.user.model.User;
import com.tim23.fishnchill.user.repository.CottageOwnerRepository;
import com.tim23.fishnchill.user.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/api/cottages", produces = MediaType.APPLICATION_JSON_VALUE)
public class CottageController {

    private CottageService cottageService;
    private UserController userController;
    private ModelMapper modelMapper;
    private TokenUtils tokenUtils;
    private CottageOwnerRepository cottageOwnerRepository;


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CottageDto> findAll() {
        return cottageService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public CottageDto findById(@PathVariable("id") Long id) {
        return cottageService.findById(id);
    }

    @GetMapping(value = "/name/{name}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CottageDto> findByNameContaining(@PathVariable("name") String name) {
        return cottageService.findByNameContaining(name);
    }

    @GetMapping(value = "/description/{description}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CottageDto> findByDescriptionContaining(@PathVariable("description") String description) {
        return cottageService.findByDescriptionContaining(description);
    }

    @GetMapping(value = "/address/{address}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CottageDto> findByAddressContaining(@PathVariable("address") String address) {
        return cottageService.findByAddressContaining(address);
    }

    @GetMapping(value = "/anything/{anything}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CottageDto> findByAnything(@PathVariable("anything") String anything) {
        return cottageService.findByAnything(anything, anything, anything);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody CottageDto newCottageDto) throws Exception {
        cottageService.update(newCottageDto);
        Map<String, String> result = new HashMap<>();
        result.put("result", "success");
        return ResponseEntity.accepted().body(result);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@RequestBody CottageDto newCottageDto) throws Exception {
        cottageService.add(newCottageDto);
        Map<String, String> result = new HashMap<>();
        result.put("result", "success");
        return ResponseEntity.accepted().body(result);
    }
    @PostMapping(value = "/add-for-owner")
    public ResponseEntity<?> addForOwner(@RequestBody CottageDto newCottageDto, HttpServletRequest request) throws Exception {
        Long id = userController.getUserFromRequest(request).getId();
        System.out.println(id);
        CottageOwner cottageOwner = cottageOwnerRepository.getById(id);
        newCottageDto.setCottageOwner(cottageOwner);
        cottageService.add(newCottageDto);
        Map<String, String> result = new HashMap<>();
        result.put("result", "success");
        return ResponseEntity.accepted().body(result);
    }

    @GetMapping(value = "/owner")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<CottageDtoNoOwner> getAllForOwner(HttpServletRequest request){
        Long ownerId  = Long.parseLong(tokenUtils.getIdFromToken(tokenUtils.getToken(request)));
//        List<CottageDto>cottageDtos = cottageService.getAllForOwner(ownerId);
//        return new ResponseEntity<>(cottageDtos, HttpStatus.FOUND);
        CottageOwner cottageOwner = cottageOwnerRepository.getById(ownerId);
        List<Cottage> cottages = new ArrayList<>(cottageOwner.getEntities());
        TypeToken<List<CottageDtoNoOwner>> typeToken = new TypeToken<>(){};
        //System.out.println(cottages);

        return modelMapper.map(cottages, typeToken.getType());

    }
}
